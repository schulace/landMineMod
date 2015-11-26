package com.schulace.landminemod.blocks;

import java.util.Random;

import com.schulace.landminemod.LandMineMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeColorHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class LandMine extends Block
{
	public float intensity;

	public LandMine(Material materialIn, String name)
	{
		super(materialIn);
		setUnlocalizedName(name);
		setCreativeTab(LandMineMod.tabMines);
		intensity = 1;
	}
	
	/*
	 * @param materialIn the material used for the block.
	 * @param name passes to the unlocalized name of the block.
	 * @param intensity controls the size of the explosion caused when this block is activated. defaults to 1.
	 * @return null
	 */
	public LandMine(Material materialIn, String name, float intensity)
	{
		super(materialIn);
		setUnlocalizedName(name);
		setCreativeTab(LandMineMod.tabMines);
		this.intensity = intensity;
	}
	
	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, Entity entityIn)
	{
		worldIn.setBlockToAir(pos);
		explode(worldIn, pos, entityIn, intensity);
		super.onEntityCollidedWithBlock(worldIn, pos, entityIn);
		

	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(this);
	}
	
	@Override
	public void onBlockDestroyedByExplosion(World worldIn, BlockPos pos, Explosion explosionIn)
    {
		this.explode(worldIn, pos, null, intensity);
    }
    
	
	public void explode(World worldIn, BlockPos pos, Entity entityIn, float intensity)
    {
        if (!worldIn.isRemote)
        {
        	worldIn.createExplosion(null, pos.getX(), pos.getY()+1, pos.getZ(), intensity, true);  
//                EntityTNTPrimed entitytntprimed = new EntityTNTPrimed(worldIn, (double)((float)pos.getX() + 0.5F), (double)((float)pos.getY() + 1F), (double)((float)pos.getZ() + 0.5F), (EntityLivingBase)null);
//                entitytntprimed.fuse = 0;
//                worldIn.spawnEntityInWorld(entitytntprimed);
//                worldIn.playSoundAtEntity(entitytntprimed, "game.tnt.primed", 1.0F, 1.0F);
                
        }
    }
	
	//rendering
	@SideOnly(Side.CLIENT)
	public EnumWorldBlockLayer getBlockLayer()
	{
		return EnumWorldBlockLayer.CUTOUT_MIPPED;
	}
	
	
	//only use if block is gonna be transparent
//    @SideOnly(Side.CLIENT)
//    public boolean shouldSideBeRendered(IBlockAccess worldIn, BlockPos pos, EnumFacing side)
//    {
//        IBlockState iblockstate = worldIn.getBlockState(pos);
//        Block block = iblockstate.getBlock();
//
//        if (this == LandMineModBlocks.land_mine)
//        {
//            if (worldIn.getBlockState(pos.offset(side.getOpposite())) != iblockstate)
//            {
//                return true;
//            }
//
//            if (block == this)
//            {
//                return false;
//            }
//        }
//
//        return true;
//    }
    
    @SideOnly(Side.CLIENT)
    public int getBlockColor()
    {
        return ColorizerGrass.getGrassColor(0.5D, 1.0D);
    }

    @SideOnly(Side.CLIENT)
    public int getRenderColor(IBlockState state)
    {
        return this.getBlockColor();
    }

    @SideOnly(Side.CLIENT)
    public int colorMultiplier(IBlockAccess worldIn, BlockPos pos, int renderPass)
    {
        return BiomeColorHelper.getGrassColorAtPos(worldIn, pos);
    }
    
	@Override
	public boolean isOpaqueCube()
	{
		//change to false if going back to transparent
		return true;
	}
	@Override
	public boolean isFullCube()
	{
		return true;
	}


}

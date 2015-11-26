package com.schulace.landminemod.blocks;

import com.schulace.landminemod.LandMineMod;
import com.schulace.landminemod.init.LandMineModBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeColorHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class landMinePlacer extends Block{

	public landMinePlacer(Material materialIn, String name)
	{
		super(materialIn);
		setUnlocalizedName(name);
		setCreativeTab(LandMineMod.tabMines);
	}
	
	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
	{
		super.onBlockAdded(worldIn, pos, state);
		worldIn.setBlockState(new BlockPos(pos.getX()+1, pos.getY(), pos.getZ()+1), LandMineModBlocks.land_mine.getDefaultState());
		worldIn.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ()+1), LandMineModBlocks.land_mine.getDefaultState());
		worldIn.setBlockState(new BlockPos(pos.getX()-1, pos.getY(), pos.getZ()+1), LandMineModBlocks.land_mine.getDefaultState());
		worldIn.setBlockState(new BlockPos(pos.getX()+1, pos.getY(), pos.getZ()), LandMineModBlocks.land_mine.getDefaultState());
		worldIn.setBlockState(new BlockPos(pos.getX()-1, pos.getY(), pos.getZ()), LandMineModBlocks.land_mine.getDefaultState());
		worldIn.setBlockState(new BlockPos(pos.getX()+1, pos.getY(), pos.getZ()-1), LandMineModBlocks.land_mine.getDefaultState());
		worldIn.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ()-1), LandMineModBlocks.land_mine.getDefaultState());
		worldIn.setBlockState(new BlockPos(pos.getX()-1, pos.getY(), pos.getZ()-1), LandMineModBlocks.land_mine.getDefaultState());
		worldIn.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ()), LandMineModBlocks.land_mine.getDefaultState());
	}

	//rendering
		@SideOnly(Side.CLIENT)
		public EnumWorldBlockLayer getBlockLayer()
		{
			return EnumWorldBlockLayer.CUTOUT;
		}
		
	    @SideOnly(Side.CLIENT)
	    public boolean shouldSideBeRendered(IBlockAccess worldIn, BlockPos pos, EnumFacing side)
	    {
	        IBlockState iblockstate = worldIn.getBlockState(pos);
	        Block block = iblockstate.getBlock();

	        if (this == LandMineModBlocks.land_mine)
	        {
	            if (worldIn.getBlockState(pos.offset(side.getOpposite())) != iblockstate)
	            {
	                return true;
	            }

	            if (block == this)
	            {
	                return false;
	            }
	        }

	        return true;
	    }
	    
	    
		@Override
		public boolean isOpaqueCube() {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public boolean isFullCube() {
			// TODO Auto-generated method stub
			return true;
		}
}

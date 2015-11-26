package com.schulace.landminemod.blocks;

import com.schulace.landminemod.LandMineMod;
import com.schulace.landminemod.init.LandMineModItems;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class potionBlockThing extends Block
{

	public potionBlockThing(String name)
	{
		super(Material.rock);
		setUnlocalizedName(name);
		setCreativeTab(LandMineMod.tabMines);
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		try
		{
			ItemStack hold = playerIn.inventory.getCurrentItem();
			if(hold.getUnlocalizedName().substring(5).equals("coordinate_tag"))
			{
				System.out.println("it's a coord tag!");
				if(hold.getTagCompound() != null)
				{
					System.out.println("It's not null!");
					ItemStack newStack = new ItemStack(LandMineModItems.tp_potion, 1);
					NBTTagCompound tag = new NBTTagCompound();
					System.out.println("x of hold is : " + hold.getTagCompound().getInteger("x"));
					tag.setInteger("x", hold.getTagCompound().getInteger("x"));
					tag.setInteger("y", hold.getTagCompound().getInteger("y"));
					tag.setInteger("z", hold.getTagCompound().getInteger("z"));
					tag.setInteger("usesLeft", 50);
					newStack.setTagCompound(tag);
					
					//copied from block class
					if (!worldIn.isRemote && !worldIn.restoringBlockSnapshots) // do not drop items while restoring blockstates, prevents item dupe
			        {
			            if (captureDrops.get())
			            {
			                capturedDrops.get().add(newStack);
			            }
			            
			            EntityItem entityitem = new EntityItem(worldIn, (double)pos.getX(), (double)pos.getY(), (double)pos.getZ(), newStack);
			            entityitem.setPickupDelay(100);;
			            worldIn.spawnEntityInWorld(entityitem);
			        }
					worldIn.setBlockToAir(pos);
//					playerIn.inventory.setInventorySlotContents(playerIn.inventory.currentItem, newStack);
				}
			}
		}
		catch (Exception e)
		{
			System.out.println("click with a full hand");
		}
		return false;
	}
	
	

}

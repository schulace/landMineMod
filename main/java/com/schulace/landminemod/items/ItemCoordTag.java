package com.schulace.landminemod.items;

import java.util.List;

import com.schulace.landminemod.LandMineMod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ItemCoordTag extends Item
{
	public ItemCoordTag(String name)
	{
		setUnlocalizedName(name);
		setCreativeTab(LandMineMod.tabMines);
		setMaxStackSize(1);
	}
	
	//this doesn't work yet
	@Override
	public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn)
	{
		super.onCreated(stack, worldIn, playerIn);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
	{
		NBTTagCompound tag = new NBTTagCompound();
		tag.setInteger("x", playerIn.getPosition().getX());
		tag.setInteger("y", playerIn.getPosition().getY());
		tag.setInteger("z", playerIn.getPosition().getZ());
		itemStackIn.setTagCompound(tag);
		return itemStackIn;
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced)
	{
		if(stack.getTagCompound() != null)
		{
			tooltip.add("x coordinate: "+ stack.getTagCompound().getInteger("x"));
			tooltip.add("y coordinate: "+ stack.getTagCompound().getInteger("y"));
			tooltip.add("z coordinate: "+ stack.getTagCompound().getInteger("z"));
		}
	}	
}

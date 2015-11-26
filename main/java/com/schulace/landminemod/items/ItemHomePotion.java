package com.schulace.landminemod.items;

import java.util.List;

import com.schulace.landminemod.LandMineMod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class ItemHomePotion extends Item
{
	public ItemHomePotion(String name)
	{
		super();
		setUnlocalizedName(name);
		setMaxStackSize(1);
		setCreativeTab(LandMineMod.tabMines);
	}
	
	@Override
	public ItemStack onItemUseFinish(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
	{
		try
		{
			String StackName = itemStackIn.getDisplayName();
			playerIn.setPositionAndUpdate((double)itemStackIn.getTagCompound().getInteger("x") + 0.5, (double)itemStackIn.getTagCompound().getInteger("y"), (double)itemStackIn.getTagCompound().getInteger("z") + 0.5);
			if(itemStackIn.getTagCompound().getInteger("usesLeft") > 0)
			{
				NBTTagCompound tempTag = new NBTTagCompound();
				tempTag.setInteger("x", itemStackIn.getTagCompound().getInteger("x"));
				tempTag.setInteger("y", itemStackIn.getTagCompound().getInteger("y"));
				tempTag.setInteger("z", itemStackIn.getTagCompound().getInteger("z"));
				String s1 = "" + itemStackIn.getTagCompound().getInteger("usesLeft");
				int newUsesLeft = Integer.parseInt(s1) - 1;
				tempTag.setInteger("usesLeft", newUsesLeft);
				playerIn.addChatMessage(new ChatComponentText(s1 + "Uses left"));
				itemStackIn.setTagCompound(tempTag);
				itemStackIn.setStackDisplayName(StackName);
			}
			else
			{
				itemStackIn.stackSize --;
			}
		}
		catch(Exception e)
		{
			System.out.println("there's no NBT data here");
			playerIn.addChatMessage(new ChatComponentText("couldn't find any NBT data associated with the potion."));
		}
		return itemStackIn;
	}
	
	@Override
	public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn)
	{
		NBTTagCompound tag = new NBTTagCompound();
		tag.setInteger("x", playerIn.getPosition().getX());
		tag.setInteger("y", playerIn.getPosition().getY());
		tag.setInteger("z", playerIn.getPosition().getZ());
		tag.setInteger("usesLeft", 50);
		stack.setTagCompound(tag);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced)
	{
		if(stack.getTagCompound() != null)
		{
			tooltip.add("x Coordinate: " + stack.getTagCompound().getInteger("x"));
			tooltip.add("y Coordinate: " + stack.getTagCompound().getInteger("y"));
			tooltip.add("x Coordinate: " + stack.getTagCompound().getInteger("z"));
			tooltip.add("Uses left: " + stack.getTagCompound().getInteger("usesLeft"));
		}
	}
	
	//copying itemFood
	@Override
	public int getMaxItemUseDuration(ItemStack stack)
    {
        return 32;
    }
	
	@Override
    public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.EAT;
    }
	@Override
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
    {
        playerIn.setItemInUse(itemStackIn, this.getMaxItemUseDuration(itemStackIn));

        return itemStackIn;
    }
}

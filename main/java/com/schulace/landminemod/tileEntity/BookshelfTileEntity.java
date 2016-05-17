package com.schulace.landminemod.tileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;

public class BookshelfTileEntity extends TileEntity implements IInventory
{
	private ItemStack[] inventory = new ItemStack[54];
	

	@Override
	public String getName() {
		return "TEbookshelf";
	}

	@Override
	public boolean hasCustomName()
	{
		return false;
	}

	@Override
	public IChatComponent getDisplayName()
	{
		return new ChatComponentText("Bookshelf");
	}

	@Override
	public int getSizeInventory()
	{
		return 54;
	}

	@Override
	public ItemStack getStackInSlot(int index)
	{
		return inventory[index];
	}

	@Override
	public ItemStack decrStackSize(int index, int count)
	{
		ItemStack stack = getStackInSlot(index);
		if(stack != null)
		{
			if(stack.stackSize <= count)
			{
				return stack.splitStack(count);
			}
			return removeStackFromSlot(index);
		}
		return stack;
	}

	@Override
	public ItemStack removeStackFromSlot(int index)
	{
		ItemStack stack = getStackInSlot(index);
		setInventorySlotContents(index, null);
		return stack;
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		inventory[index] = stack;
		
	}

	@Override
	public int getInventoryStackLimit()
	{
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		// TODO come back if shit breaks
		return true;
	}

	@Override
	public void openInventory(EntityPlayer player) {

		
	}

	@Override
	public void closeInventory(EntityPlayer player) {
		
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack)
	{
		Item itm = stack.getItem();
		if(itm instanceof net.minecraft.item.ItemBook || itm instanceof net.minecraft.item.ItemWritableBook || itm instanceof net.minecraft.item.ItemEnchantedBook || itm instanceof net.minecraft.item.ItemEditableBook)
		{
			return true;
		}
		return false;
	}

	@Override
	public int getField(int id) {
		return 0;
	}

	@Override
	public void setField(int id, int value) {
		
	}

	@Override
	public int getFieldCount() {
		return 0;
	}

	@Override
	public void clear() {
		for(ItemStack stack : inventory)
		{
			stack = null;
		}
		
	}
}

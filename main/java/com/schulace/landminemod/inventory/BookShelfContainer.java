package com.schulace.landminemod.inventory;
import com.schulace.landminemod.tileEntity.BookshelfTileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

public class BookShelfContainer extends Container
{
	
	private BookshelfTileEntity shelf;

	public BookShelfContainer(InventoryPlayer playerInv, BookshelfTileEntity ent)
	{
		this.shelf = ent;
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer playerIn)
	{
		return shelf.isUseableByPlayer(playerIn);
	}

}

package com.schulace.landminemod.items;

import com.schulace.landminemod.LandMineMod;

import net.minecraft.item.Item;

public class ItemTestGlobal extends Item
{
	public ItemTestGlobal(String name)
	{
		super();
		this.setUnlocalizedName(name);
		this.setCreativeTab(LandMineMod.tabMines);
	}
}

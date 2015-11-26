package com.schulace.landminemod.items;

import com.schulace.landminemod.LandMineMod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemGlassDust extends Item
{
	public ItemGlassDust(String name)
	{
		super();
		setUnlocalizedName(name);
		setCreativeTab(LandMineMod.tabMines);
	}
}

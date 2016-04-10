package com.schulace.landminemod.init;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabMines extends CreativeTabs{

	public CreativeTabMines(String label) {
		super(label);
	}

	@Override
	public Item getTabIconItem() {
		return LandMineModItems.glass_dust;
	}
	
}

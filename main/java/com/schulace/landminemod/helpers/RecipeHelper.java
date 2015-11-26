package com.schulace.landminemod.helpers;

import com.schulace.landminemod.init.LandMineModBlocks;
import com.schulace.landminemod.init.LandMineModItems;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipeHelper
{
	public static void registerRecipes()
	{
		//land mine
		GameRegistry.addRecipe(new ItemStack(LandMineModBlocks.land_mine), new Object[]{
				"ppp",
				"pgp",
				"ggg",
				'p', Item.getItemFromBlock(Blocks.planks),
				'g', Items.gunpowder
					
			});
		
		//potion block
		GameRegistry.addRecipe(new ItemStack(LandMineModBlocks.tp_potion_block), new Object[]{
			" e ",
			"ebe",
			" e ",
			'b', Items.glass_bottle,
			'e', Items.ender_pearl
		});
		
		//mine placer
		GameRegistry.addRecipe(new ItemStack(LandMineModBlocks.land_mine_placer), new Object[]{
			"mmm",
			"mmm",
			"mmm",
			'm', Item.getItemFromBlock(LandMineModBlocks.land_mine)		
		});
		
		//jump pad
		GameRegistry.addRecipe(new ItemStack(LandMineModBlocks.jump_pad), new Object[]{
				"igi",
				"prp",
				"igi",
				'i', Items.iron_ingot,
				'g', Items.gold_ingot,
				'p', Item.getItemFromBlock(Blocks.piston),
				'r', Items.redstone	
		});
		
		//coordinate tag
		GameRegistry.addRecipe(new ItemStack(LandMineModItems.coordinate_tag), new Object[]{
				"ppp",
				"pgp",
				"ppp",
				'p', Items.paper,
				'g', Item.getItemFromBlock(Blocks.glass_pane)
				
		});
	}

}

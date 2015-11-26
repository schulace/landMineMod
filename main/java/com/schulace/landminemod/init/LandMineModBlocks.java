package com.schulace.landminemod.init;

import com.schulace.landminemod.blocks.ExplodingJumpPad;
import com.schulace.landminemod.blocks.LandMine;
import com.schulace.landminemod.blocks.NuclearLandMine;
import com.schulace.landminemod.blocks.landMinePlacer;
import com.schulace.landminemod.blocks.potionBlockThing;
import com.schulace.landminemod.helpers.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class LandMineModBlocks
{
	public static Block land_mine;
	public static Block nuclear_land_mine;
	public static Block land_mine_placer;
	public static Block jump_pad;
	public static Block tp_potion_block;
	
	public static void initBlocks()
	{
		land_mine = new LandMine(Material.wood, "land_mine");
		nuclear_land_mine = new NuclearLandMine(Material.grass, "nuclear_land_mine");
		land_mine_placer = new landMinePlacer(Material.wood, "land_mine_placer");
		jump_pad = new ExplodingJumpPad(Material.rock, "jump_pad");
		tp_potion_block = new potionBlockThing("potion_block");
		
	}
	
	public static void registerBlocks()
	{
		GameRegistry.registerBlock(land_mine, land_mine.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(nuclear_land_mine, nuclear_land_mine.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(land_mine_placer, land_mine_placer.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(jump_pad, jump_pad.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(tp_potion_block, tp_potion_block.getUnlocalizedName().substring(5));
	}
	
	public static void registerRenders()
	{
		registerRender(land_mine);
		registerRender(nuclear_land_mine);
		registerRender(land_mine_placer);
		registerRender(jump_pad);
		registerRender(tp_potion_block);
	}
	
	public static void registerRender(Block block)
	{
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}

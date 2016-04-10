package com.schulace.landminemod;

import com.schulace.landminemod.helpers.RecipeHelper;
import com.schulace.landminemod.helpers.Reference;
import com.schulace.landminemod.init.CreativeTabMines;
import com.schulace.landminemod.init.LandMineModBlocks;
import com.schulace.landminemod.init.LandMineModItems;
import com.schulace.landminemod.proxy.CommonProxy;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.RecipeRepairItem;
import net.minecraft.item.crafting.RecipesBanners.RecipeAddPattern;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MODID, version = Reference.VERSION, name = Reference.NAME)
public class LandMineMod
{
	
	@Mod.Instance(Reference.MODID)
	public static LandMineMod instance;
	@SidedProxy(clientSide="com.schulace.landminemod.proxy.ClientProxy", serverSide="com.schulace.landminemod.proxy.ServerProxy")
	public static CommonProxy proxy;
	public static CreativeTabs tabMines = new CreativeTabMines("Mines");
	@EventHandler
	public void PreInit(FMLPreInitializationEvent event)
	{
		LandMineModBlocks.initBlocks();
		LandMineModBlocks.registerBlocks();
		LandMineModItems.initItems();
		LandMineModItems.registerItems();
	}
	@EventHandler
	public void Init (FMLInitializationEvent event)
	{
		proxy.registerRenders();
		RecipeHelper.registerRecipes();
	}
	@EventHandler
	public void PostInit(FMLPostInitializationEvent event)
	{
		
	}
}
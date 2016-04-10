package com.schulace.landminemod.init;

import com.schulace.landminemod.helpers.Reference;
import com.schulace.landminemod.items.ItemCoordTag;
import com.schulace.landminemod.items.ItemGlassDust;
import com.schulace.landminemod.items.ItemHomePotion;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class LandMineModItems {
	
	public static Item glass_dust;
	public static Item coordinate_tag;
	public static Item tp_potion;
	
	public static void initItems()
	{
		glass_dust = new ItemGlassDust("glass_dust");
		coordinate_tag = new ItemCoordTag("coordinate_tag");
		tp_potion = new ItemHomePotion("tp_potion");
	}
	public static void registerItems()
	{
		GameRegistry.registerItem(glass_dust, glass_dust.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(coordinate_tag, coordinate_tag.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(tp_potion, tp_potion.getUnlocalizedName().substring(5));
	}
	public static void registerRenders()
	{
		registerRender(glass_dust);
		registerRender(coordinate_tag);
		registerRender(tp_potion);
	}
	public static void registerRender(Item item)
	{
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}

}

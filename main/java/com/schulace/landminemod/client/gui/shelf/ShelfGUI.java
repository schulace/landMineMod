package com.schulace.landminemod.client.gui.shelf;

import com.schulace.landminemod.helpers.Reference;
import com.schulace.landminemod.helpers.Textures;
import com.schulace.landminemod.inventory.BookShelfContainer;
import com.schulace.landminemod.tileEntity.BookshelfTileEntity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import static org.lwjgl.opengl.GL11.*;

@SideOnly(Side.CLIENT)
public class ShelfGUI extends GuiContainer
{
	
	public static final ResourceLocation BookShelfGUI = new ResourceLocation(Reference.MODID.toLowerCase(), Textures.SHELFGUI);
	private int xSize, ySize;

	public ShelfGUI(InventoryPlayer playerInv, BookshelfTileEntity ent)
	{
		super(new BookShelfContainer(playerInv, ent));
		this.xSize = 176;
		this.ySize = 222;
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
	{
		glColor4f(1,1,1,1);
		Minecraft.getMinecraft().getTextureManager().bindTexture(BookShelfGUI);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}

}

package com.schulace.landminemod.blocks;

import com.schulace.landminemod.LandMineMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.command.ICommandManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ExplodingJumpPad extends Block
{
	public float intensity = 10;
	public ExplodingJumpPad(Material materialIn, String name)
	{
		super(materialIn);
		setUnlocalizedName(name);
		setCreativeTab(LandMineMod.tabMines);
		setResistance(20);
	}
	
	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, Entity entityIn)
	{
		this.launch(entityIn, intensity, worldIn);
		super.onEntityCollidedWithBlock(worldIn, pos, entityIn);
	}
	public void launch(Entity entity, Float intensity, World worldIn)
	{
		float xVel = -1* MathHelper.sin(entity.rotationYaw * (float)Math.PI / 180.0F);
        float zVel = MathHelper.cos(entity.rotationYaw * (float)Math.PI / 180.0F);
		ICommandManager manager = MinecraftServer.getServer().getCommandManager();
		manager.executeCommand(new EntityBoat(worldIn), "/effect @p 11 6 5");
		manager.executeCommand(new EntityBoat(worldIn), "/effect @p 12 6 5");
		entity.setVelocity(intensity* xVel, intensity/3, intensity*zVel);
		entity.setFire(3);
//		int counter = 0;
//		while(entity.isAirBorne)
//		{
//			counter += 1;
//		}
		entity.addChatMessage(new ChatComponentText("launch successful"));

	}
	
}

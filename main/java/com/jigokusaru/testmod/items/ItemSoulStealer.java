package com.jigokusaru.testmod.items;

import java.util.List;
import java.util.Set;

import com.google.common.collect.Sets;
import com.jigokusaru.testmod.Reference;
import com.jigokusaru.testmod.util.Utils;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.util.EnumHelper;

public class ItemSoulStealer extends ItemTool{
	
	private static final Set<Block> EFFECTIVE_BLOCKS = Sets.newHashSet(new Block[] {});

	public ItemSoulStealer(String unlocalizedName) {
		super(EnumHelper.addToolMaterial(Reference.MODID + ":soul_stealer",0 , 100, 0, 1 , 0), EFFECTIVE_BLOCKS);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MODID,unlocalizedName));
	
	}
	
	@Override
	public void addInformation(ItemStack stack,EntityPlayer player,List<String> tooltip, boolean advanced ){
		
		super.addInformation(stack, player, tooltip, advanced);
		tooltip.add(TextFormatting.BLACK + Utils.getLang().localize("soul_stealer.tooltip"));
	}

}

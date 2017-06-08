package com.jigokusaru.testmod.creativetabs;

import com.jigokusaru.testmod.init.ModBlocks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TabJtmBlocks extends CreativeTabs {
	
	public TabJtmBlocks() {
		super("jtmblocks");
	}
	
	@Override 
	public ItemStack getTabIconItem() {
		return new ItemStack(ModBlocks.tin_ore);
	}
	

}

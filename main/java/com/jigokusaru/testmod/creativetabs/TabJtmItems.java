package com.jigokusaru.testmod.creativetabs;

import com.jigokusaru.testmod.init.ModBlocks;
import com.jigokusaru.testmod.init.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class TabJtmItems extends CreativeTabs{

	public TabJtmItems() {
		super("jtmitems");
	}
	
	@Override 
	public ItemStack getTabIconItem() {
		return new ItemStack(ModItems.tiningot);
	}
	
	

}

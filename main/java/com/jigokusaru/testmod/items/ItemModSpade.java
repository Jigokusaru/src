package com.jigokusaru.testmod.items;

import com.jigokusaru.testmod.Reference;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemSpade;
import net.minecraft.util.ResourceLocation;

public class ItemModSpade extends ItemSpade{

	public ItemModSpade(ToolMaterial material, String unlocalizedName) {
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MODID,unlocalizedName));
	}

}

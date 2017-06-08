package com.jigokusaru.testmod.proxy;

import com.jigokusaru.testmod.Reference;
import com.jigokusaru.testmod.init.ModArmour;
import com.jigokusaru.testmod.init.ModBlocks;
import com.jigokusaru.testmod.init.ModItems;
import com.jigokusaru.testmod.init.ModTools;

import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class ClientProxy extends CommonProxy{

	@Override
	public void registerRenders(){
		
		ModItems.registerRenders();
		ModTools.registerRenders();
		ModArmour.registerRenders();
		ModBlocks.registerRenders();
		
	}
	
	@Override
	public void registerModelBackeryVariants() {
		ModelBakery.registerItemVariants(ModItems.chip, new ResourceLocation(Reference.MODID,"chip_basic"), new ResourceLocation(Reference.MODID,"chip_advanced"));
		ModelBakery.registerItemVariants(Item.getItemFromBlock(ModBlocks.breaker), new ResourceLocation(Reference.MODID,"block_breaker_basic"), new ResourceLocation(Reference.MODID,"block_breaker_basic"));
	}
}

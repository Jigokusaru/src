package com.jigokusaru.testmod.init;

import com.jigokusaru.testmod.Reference;
import com.jigokusaru.testmod.Utils;
import com.jigokusaru.testmod.blocks.BlockTinOre;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks{
	
	public static Block tin_ore;
	
	public static void init(){
		tin_ore = new BlockTinOre("Tin_ore","Tin_ore");
		
	}
	
	public static void register(){
		
		registerBlock(tin_ore);
		
	}
	
	public static void registerRenders(){
		registerRender(tin_ore);
		
	}
	
	public static void registerBlock(Block block){
		GameRegistry.register(block);
		GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
		Utils.getLogger().info("Registered block "+block.getUnlocalizedName().substring(5));
	}
	
	public static void registerRender(Block block){
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block),0, new ModelResourceLocation(new ResourceLocation(Reference.MODID, block.getUnlocalizedName().substring(5)),"inventory"));

		Utils.getLogger().info("Registered rendered for "+block.getUnlocalizedName().substring(5));
	}

}

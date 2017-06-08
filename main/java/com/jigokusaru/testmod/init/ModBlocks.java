package com.jigokusaru.testmod.init;

import com.jigokusaru.testmod.Reference;
import com.jigokusaru.testmod.TestMod;
import com.jigokusaru.testmod.blocks.BlockBreaker;
import com.jigokusaru.testmod.blocks.BlockTinOre;
import com.jigokusaru.testmod.blocks.item.ItemBlockBreaker;
import com.jigokusaru.testmod.handlers.EnumHandler;
import com.jigokusaru.testmod.util.Utils;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks{
	
	public static Block tin_ore;
	public static Block breaker;
	
	public static void init(){
		tin_ore = new BlockTinOre("Tin_Ore","Tin_Ore");
		breaker = new BlockBreaker("block_breaker");
		
	}
	
	public static void register(){
		
		registerBlock(tin_ore);
		registerBlock(breaker, new ItemBlockBreaker(breaker));
		
	}
	
	public static void registerRenders(){
		registerRender(tin_ore);
		for(int i = 0; i < EnumHandler.ChipTypes.values().length;i++){
			registerRender(breaker,i,"block_breaker_" + EnumHandler.ChipTypes.values()[i].getName());
		}
		
	}
	
	public static void registerBlock(Block block){
		block.setCreativeTab(TestMod.blocks);
		GameRegistry.register(block);
		GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
		Utils.getLogger().info("Registered block "+block.getUnlocalizedName().substring(5));
	}
	
	public static void registerBlock(Block block, ItemBlock itemblock){
		block.setCreativeTab(TestMod.blocks);
		GameRegistry.register(block);
		GameRegistry.register(itemblock.setRegistryName(block.getRegistryName()));
		Utils.getLogger().info("Registered block "+block.getUnlocalizedName().substring(5));
	}
	
	
	
	public static void registerRender(Block block){
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block),0, new ModelResourceLocation(new ResourceLocation(Reference.MODID, block.getUnlocalizedName().substring(5)),"inventory"));

		Utils.getLogger().info("Registered rendered for "+block.getUnlocalizedName().substring(5));
	}
	
	public static void registerRender(Block block, int meta, String fileName){
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta, new ModelResourceLocation(new ResourceLocation(Reference.MODID, fileName),"inventory"));
		Utils.getLogger().info("Register Render for" + block.getUnlocalizedName().substring(5));
	
	}

}
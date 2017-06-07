package com.jigokusaru.testmod.init;

import com.jigokusaru.testmod.Reference;
import com.jigokusaru.testmod.items.ItemTinIngot;
import com.jigokusaru.testmod.util.Utils;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {
	
	public static Item tiningot;
	public static Item heart;
	
	public static void init(){
		
		tiningot = new ItemTinIngot("Tin_Ingot" , "Tin_Ingot");
		heart = new ItemTinIngot("heart" , "heart");
		
	}
	
	public static void register(){
		
		registerItem(tiningot);
		registerItem(heart);
	}
	
	public static void registerRenders(){
		registerRender(tiningot);
		registerRender(heart);
	}
	
	public static void registerItem(Item item){
		GameRegistry.register(item);
		Utils.getLogger().info("Registered Item "+ item.getUnlocalizedName().substring(5));
	}
	
	public static void registerRender(Item item){
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(new ResourceLocation(Reference.MODID, item.getUnlocalizedName().substring(5)),"inventory"));
		Utils.getLogger().info("Register Render for" + item.getUnlocalizedName().substring(5));
	
	}

}

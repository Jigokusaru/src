package com.jigokusaru.testmod.init;

import com.jigokusaru.testmod.Reference;
import com.jigokusaru.testmod.Utils;
import com.jigokusaru.testmod.items.ItemTinIngot;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {
	
	public static Item tiningot;
	
	public static void init(){
		
		tiningot = new ItemTinIngot("Tin_Ingot" , "Tin_Ingot");
		
	}
	
	public static void register(){
		
		registerItem(tiningot);
	}
	
	public static void registerRenders(){
		registerRender(tiningot);
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

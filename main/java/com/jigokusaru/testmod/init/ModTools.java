package com.jigokusaru.testmod.init;

import com.jigokusaru.testmod.Reference;
import com.jigokusaru.testmod.TestMod;
import com.jigokusaru.testmod.items.ItemModAxe;
import com.jigokusaru.testmod.items.ItemModHoe;
import com.jigokusaru.testmod.items.ItemModPickaxe;
import com.jigokusaru.testmod.items.ItemModSpade;
import com.jigokusaru.testmod.items.ItemModSword;
import com.jigokusaru.testmod.items.ItemSoulStealer;
import com.jigokusaru.testmod.util.Utils;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModTools {
	
	public static final ToolMaterial tinMatirial = EnumHelper.addToolMaterial(Reference.MODID + ":tin", 2 , 350, 5.F, 2.0F, 12);
	
	public static ItemPickaxe tinPickaxe;
	public static ItemModAxe tinAxe;
	public static ItemHoe tinHoe;
	public static ItemSpade tinSpade;
	public static ItemSword tinSword;
	public static ItemSoulStealer soulstealer;
	
	public static void init(){
		tinPickaxe = new ItemModPickaxe(tinMatirial, "tin_pickaxe");
		tinAxe = new ItemModAxe(tinMatirial, "tin_axe");
		tinHoe = new ItemModHoe(tinMatirial, "tin_hoe");
		tinSpade = new ItemModSpade(tinMatirial, "tin_spade");
		tinSword = new ItemModSword(tinMatirial, "tin_sword");
		
		soulstealer = new ItemSoulStealer("soul_stealer");
		
	}
	
	public static void register(){
		registerItem(tinPickaxe);
		registerItem(tinAxe);
		registerItem(tinHoe);
		registerItem(tinSpade);
		registerItem(tinSword);
		
		registerItem(soulstealer);
		
	}

	public static void registerRenders(){
		registerRender(tinPickaxe);
		registerRender(tinAxe);
		registerRender(tinHoe);
		registerRender(tinSpade);
		registerRender(tinSword);
		
		registerRender(soulstealer);
	}
	
	private static void registerItem(Item item) {
		item.setCreativeTab(TestMod.items);
		GameRegistry.register(item);
		Utils.getLogger().info("Registered Item "+ item.getUnlocalizedName().substring(5));


	}

	public static void registerRender(Item item){
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(new ResourceLocation(Reference.MODID, item.getUnlocalizedName().substring(5)),"inventory"));
		Utils.getLogger().info("Register Render for" + item.getUnlocalizedName().substring(5));
	
	}

}

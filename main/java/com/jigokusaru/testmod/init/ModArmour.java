package com.jigokusaru.testmod.init;

import com.jigokusaru.testmod.Reference;
import com.jigokusaru.testmod.TestMod;
import com.jigokusaru.testmod.items.ItemModIArmour;
import com.jigokusaru.testmod.util.Utils;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModArmour {
	
	public static ArmorMaterial tinMaterial = EnumHelper.addArmorMaterial("tin", Reference.MODID + ":tin", 15, new int[] {2,6,5,2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 2.0F);
	
	public static ItemArmor tinHelm;
	public static ItemArmor tinChest;
	public static ItemArmor tinLegs;
	public static ItemArmor tinBoots;
	
	
	public static void init(){
		tinHelm = new ItemModIArmour(tinMaterial, 1, EntityEquipmentSlot.HEAD, "tin_helmet");
		tinChest = new ItemModIArmour(tinMaterial, 1, EntityEquipmentSlot.CHEST, "tin_chestplate");
		tinLegs = new ItemModIArmour(tinMaterial, 2, EntityEquipmentSlot.LEGS, "tin_leggings");
		tinBoots = new ItemModIArmour(tinMaterial, 1, EntityEquipmentSlot.FEET, "tin_boots");
		
		
		
	}
	
	public static void register(){
		registerItem(tinHelm);
		registerItem(tinChest);
		registerItem(tinLegs);
		registerItem(tinBoots);
		
	}
	
	public static void registerRenders(){
		registerRender(tinHelm);
		registerRender(tinChest);
		registerRender(tinLegs);
		registerRender(tinBoots);
		
	}
	
	public static void registerItem(Item item){
		item.setCreativeTab(TestMod.items);
		GameRegistry.register(item);
		Utils.getLogger().info("Registered Item "+ item.getUnlocalizedName().substring(5));
	}
	
	public static void registerRender(Item item){
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(new ResourceLocation(Reference.MODID, item.getUnlocalizedName().substring(5)),"inventory"));
		Utils.getLogger().info("Register Render for" + item.getUnlocalizedName().substring(5));
	
	}

}

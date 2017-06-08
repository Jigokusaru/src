package com.jigokusaru.testmod.handlers;

import com.jigokusaru.testmod.init.ModArmour;
import com.jigokusaru.testmod.init.ModBlocks;
import com.jigokusaru.testmod.init.ModItems;
import com.jigokusaru.testmod.init.ModTools;
import com.jigokusaru.testmod.util.Utils;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipeHandler {
	
	public static void registerCraftingRecipes(){
		GameRegistry.addRecipe(new ItemStack(ModTools.soulstealer), new Object[] {"SAS", "ADA", "SAS", 'S',Items.STICK, 'A', Items.STRING, 'D', Items.DIAMOND });
		registerTools(ModTools.tinPickaxe, ModTools.tinAxe, ModTools.tinHoe, ModTools.tinSpade, ModTools.tinSword, ModItems.tiningot);
		registerArmourRecipe(ModArmour.tinHelm,ModArmour.tinChest , ModArmour.tinLegs, ModArmour.tinBoots, ModItems.tiningot);
		Utils.getLogger().info("Registered Crafting Recipes!");
	}
	
	public static void registerSmeltingRecipes(){
		GameRegistry.addSmelting(ModBlocks.tin_ore, new ItemStack(ModItems.tiningot), 0.7f);
		Utils.getLogger().info("Registered Smelting Recipes!");
	}
	
	public static void registerTools(Item pickaxe, Item axe, Item hoe, Item shovel, Item sword, Item ingot) {
		GameRegistry.addRecipe(new ItemStack(pickaxe), new Object[] {"III"," S "," S ", 'I', ingot, 'S', Items.STICK });
		GameRegistry.addRecipe(new ItemStack(axe), new Object[] {" II"," SI"," S ", 'I', ingot, 'S', Items.STICK });
		GameRegistry.addRecipe(new ItemStack(axe), new Object[] {"II ","IS "," S ", 'I', ingot, 'S', Items.STICK });
		GameRegistry.addRecipe(new ItemStack(hoe), new Object[] {"II "," S "," S ", 'I', ingot, 'S', Items.STICK });
		GameRegistry.addRecipe(new ItemStack(hoe), new Object[] {" II"," S "," S ", 'I', ingot, 'S', Items.STICK });
		GameRegistry.addRecipe(new ItemStack(shovel), new Object[] {" I "," S "," S ", 'I', ingot, 'S', Items.STICK });
		GameRegistry.addRecipe(new ItemStack(shovel), new Object[] {"I  ","S  ","S  ", 'I', ingot, 'S', Items.STICK });
		GameRegistry.addRecipe(new ItemStack(shovel), new Object[] {"  I","  S","  S", 'I', ingot, 'S', Items.STICK });
		GameRegistry.addRecipe(new ItemStack(sword), new Object[] {" I "," I "," S ", 'I', ingot, 'S', Items.STICK });
		GameRegistry.addRecipe(new ItemStack(sword), new Object[] {"I  ","I  ","S  ", 'I', ingot, 'S', Items.STICK });
		GameRegistry.addRecipe(new ItemStack(sword), new Object[] {"  I","  I","  S", 'I', ingot, 'S', Items.STICK });
	}
	
	public static void registerArmourRecipe(Item helmet, Item chestplate, Item leggings, Item boots, Item ingot) {
		GameRegistry.addRecipe(new ItemStack(helmet), new Object[] { "III","I I","   ",'I',ingot});
		GameRegistry.addRecipe(new ItemStack(helmet), new Object[] { "   ","III","I I",'I',ingot});
		GameRegistry.addRecipe(new ItemStack(chestplate), new Object[] { "I I","III","III",'I',ingot});
		GameRegistry.addRecipe(new ItemStack(leggings), new Object[] { "III","I I","I I",'I',ingot});
		GameRegistry.addRecipe(new ItemStack(boots), new Object[] { "I I","I I","   ",'I',ingot});
		GameRegistry.addRecipe(new ItemStack(boots), new Object[] { "   ","I I","I I",'I',ingot});
	}

}

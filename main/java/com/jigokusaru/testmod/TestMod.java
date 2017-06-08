package com.jigokusaru.testmod;

import com.jigokusaru.testmod.creativetabs.TabJtmBlocks;
import com.jigokusaru.testmod.creativetabs.TabJtmItems;
import com.jigokusaru.testmod.handlers.AchievementHandler;
import com.jigokusaru.testmod.handlers.RecipeHandler;
import com.jigokusaru.testmod.init.ModArmour;
import com.jigokusaru.testmod.init.ModBlocks;
import com.jigokusaru.testmod.init.ModItems;
import com.jigokusaru.testmod.init.ModTools;
import com.jigokusaru.testmod.proxy.CommonProxy;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class TestMod {
	
	public static CreativeTabs blocks = new TabJtmBlocks();
	public static CreativeTabs items = new TabJtmItems();
	
	com.jigokusaru.testmod.handlers.EventHandler eventHandler = new com.jigokusaru.testmod.handlers.EventHandler();
	
	@Mod.Instance(Reference.MODID)
	public static TestMod instance;
	
	@SidedProxy(serverSide = Reference.Server_Proxy_CLASS, clientSide = Reference.CLIENT_Proxy_CLASS)
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e){
		ModItems.init();
		ModTools.init();
		ModArmour.init();
		ModBlocks.init();
		ModItems.register();
		ModTools.register();
		ModArmour.register();
		ModBlocks.register();
		
		proxy.registerRenders();
		
		AchievementHandler.registerAchievements();
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent e){
		proxy.registerModelBackeryVariants();
		
		eventHandler.registerEvents();
		RecipeHandler.registerCraftingRecipes();
		RecipeHandler.registerSmeltingRecipes();
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e){
		
	}
}

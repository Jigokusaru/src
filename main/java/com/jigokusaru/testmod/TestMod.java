package com.jigokusaru.testmod;

import com.jigokusaru.testmod.init.ModBlocks;
import com.jigokusaru.testmod.init.ModItems;
import com.jigokusaru.testmod.proxy.CommonProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class TestMod {
	
	@Mod.Instance(Reference.MODID)
	public static TestMod instance;
	
	@SidedProxy(serverSide = Reference.Server_Proxy_CLASS, clientSide = Reference.CLIENT_Proxy_CLASS)
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e){
		ModItems.init();
		ModBlocks.init();
		ModItems.register();
		ModBlocks.register();
		
		proxy.registerRenders();
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent e){
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e){
		
	}
}

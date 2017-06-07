package com.jigokusaru.testmod.handlers;

import com.jigokusaru.testmod.events.SoulStealerEvent;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;

public class EventHandler {
	
	public void registerEvents(){
		MinecraftForge.EVENT_BUS.register(new SoulStealerEvent());
	}

}

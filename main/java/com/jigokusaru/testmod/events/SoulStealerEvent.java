package com.jigokusaru.testmod.events;

import com.jigokusaru.testmod.init.ModItems;
import com.jigokusaru.testmod.init.ModTools;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class SoulStealerEvent {
	
	@SubscribeEvent
	public void onEvent(LivingHurtEvent e){
		if(e.getSource().getEntity() instanceof EntityPlayer){
			EntityPlayer p = (EntityPlayer) e.getSource().getEntity();
			if(p.getHeldItemMainhand().getItem() == ModTools.soulstealer){
				BlockPos pos = e.getEntity().getPosition();
				EntityItem item = new EntityItem(p.getEntityWorld(),pos.getX(),pos.getY(),pos.getZ(), new ItemStack(ModItems.heart));
				p.getEntityWorld().spawnEntity(item);
			}
		}
		
	}

}

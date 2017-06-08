package com.jigokusaru.testmod.items;

import java.util.Iterator;

import com.jigokusaru.testmod.Reference;
import com.jigokusaru.testmod.handlers.AchievementHandler;
import com.jigokusaru.testmod.init.ModArmour;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class ItemModIArmour extends ItemArmor{

	public ItemModIArmour(ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn, String unlocalizedName) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MODID, unlocalizedName));
	}
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
		int tinArmourPeices = 0;
		if(player.getArmorInventoryList() != null) {
			Iterator<ItemStack> iterator = player.getArmorInventoryList().iterator();
			while(iterator.hasNext()) {
				ItemStack stack = iterator.next();
				if(stack != null) {
					if(stack.getItem() instanceof ItemModIArmour) {
						ItemModIArmour item = (ItemModIArmour) stack.getItem();
						if(item.getArmorMaterial() == ModArmour.tinMaterial) {
							tinArmourPeices++;
							continue;
						}
					}
				}
			}
		}
		if(tinArmourPeices == 4) {
			if(!player.hasAchievement(AchievementHandler.achievementTinMan)) {
				player.addStat(AchievementHandler.achievementTinMan);
			}
		}
	}

}

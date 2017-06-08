package com.jigokusaru.testmod.handlers;

import java.util.ArrayList;
import java.util.List;

import com.jigokusaru.testmod.Reference;
import com.jigokusaru.testmod.init.ModArmour;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class AchievementHandler {
	
	public static List<Achievement> achievements = new ArrayList<Achievement>();
	
	public static Achievement achievementTinMan = createAchievement("tinman", 0, 0, ModArmour.tinHelm);
	
	public static void registerAchievements(){
		Achievement[] achievementArray = new Achievement[achievements.size()];
		for(Achievement achievement : achievements){
			achievement.registerStat();
			achievementArray[achievements.indexOf(achievement)] = achievement;
		}
		AchievementPage.registerAchievementPage(new AchievementPage(Reference.NAME, achievementArray));
	}
	
	private static Achievement createAchievement(String name, int column, int row, Item item){
		
		Achievement achievement = new Achievement("achievement." + name, name,column,row, item, (Achievement) null);
		achievements.add(achievement);
		return achievement;
		
	}
	
	private static Achievement createAchievement(String name, int column, int row, Block block){
		Achievement achievement = new Achievement("achievement." + name, name,column,row, block, (Achievement) null);
		achievements.add(achievement);
		return achievement;
	}

	private static Achievement createAchievement(String name, int column, int row, ItemStack itemstack){
		Achievement achievement = new Achievement("achievement." + name, name,column,row, itemstack, (Achievement) null);
		achievements.add(achievement);
		return achievement;
	}

}

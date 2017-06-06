package com.jigokusaru.testmod.blocks;

import java.util.Random;

import com.jigokusaru.testmod.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class BlockTinOre extends Block{

	public BlockTinOre(String unlocolizedName, String registryName) {
		super(Material.ROCK);
		this.setUnlocalizedName(unlocolizedName);
		this.setRegistryName(new ResourceLocation(Reference.MODID,registryName));
		this.setHardness(2F);
		this.setResistance(2F);
		
	}
		
		@Override
		public Item getItemDropped(IBlockState state,Random rand, int fortune){
			return Item.getItemFromBlock(this);
		}

}

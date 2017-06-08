package com.jigokusaru.testmod.blocks;

import com.jigokusaru.testmod.Reference;
import com.jigokusaru.testmod.blocks.item.IMetaBlockName;
import com.jigokusaru.testmod.handlers.EnumHandler.ChipTypes;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class BlockBreaker extends Block implements IMetaBlockName{
	
	public static final PropertyEnum TYPE = PropertyEnum.create("type", ChipTypes.class);
	public static final PropertyDirection FACING = PropertyDirection.create("facing");

	public BlockBreaker(String unlocolizedName) {
		super(Material.IRON);
		this.setUnlocalizedName(unlocolizedName);
		this.setRegistryName(new ResourceLocation(Reference.MODID,unlocolizedName));
		this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, ChipTypes.BASIC));
		
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		
		return new BlockStateContainer(this, new IProperty[] {TYPE});
	}
	
	@Override
	public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY,
			float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
		return this.getDefaultState().withProperty(FACING, EnumFacing.getDirectionFromEntityLiving(pos, placer)).withProperty(TYPE, getStateFromMeta(meta * EnumFacing.values().length).getValue(TYPE));
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		ChipTypes type = (ChipTypes) state.getValue(TYPE);
		return type.getID();
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(TYPE, ChipTypes.values()[meta] );
	}
	
	@Override
	public void getSubBlocks(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> list) {
		for(int i = 0; i < ChipTypes.values().length; i++){
			list.add(new ItemStack(itemIn, 1, i));
		}
	}

	@Override
	public String getSpecialName(ItemStack stack) {
		return ChipTypes.values()[stack.getItemDamage()].getName();
	}
	
	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos,
			EntityPlayer player) {
		
		return new ItemStack(Item.getItemFromBlock(this),1,getMetaFromState(world.getBlockState(pos)));
	}
	
	@Override
	public int damageDropped(IBlockState state) {
		
		return getMetaFromState(state);
	}
}

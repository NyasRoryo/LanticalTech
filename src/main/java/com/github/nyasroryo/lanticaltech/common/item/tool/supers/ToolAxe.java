package com.github.nyasroryo.lanticaltech.common.item.tool.supers;

import com.github.nyasroryo.lanticaltech.client.creativetab.CreativeTab;
import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;

import javax.annotation.Nullable;
import java.util.Set;

public abstract class ToolAxe extends ItemAxe {
  public static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(Blocks.PLANKS, Blocks.BOOKSHELF, Blocks.LOG, Blocks.LOG2, Blocks.CHEST, Blocks.PUMPKIN, Blocks.LIT_PUMPKIN, Blocks.MELON_BLOCK, Blocks.LADDER, Blocks.WOODEN_BUTTON, Blocks.WOODEN_PRESSURE_PLATE);
  public static final Set<Block> EFFECTIVE_ON_CUSTOM = Sets.newHashSet();

  private Item.ToolMaterial material;

  public static final String toolClass = "axe";

  public ToolAxe(Item.ToolMaterial material, int durability, float damage, float attackSpeed, String name) {
    super(material, damage, attackSpeed);
    this.material = material;
    setMaxDamage(durability - 1);
    setMaxStackSize(1);
    this.setCreativeTab(CreativeTab.TAB_ITEMS);
    this.setTranslationKey(name);
    this.setRegistryName(name);

  }

  public ToolAxe(Item.ToolMaterial material, float damage, String name) {
    this(material, material.getMaxUses(), damage, -3.2F, name);
  }

  public ToolAxe(Item.ToolMaterial material, String name) {
    this(material, material.getAttackDamage(), name);
  }

  @Override
  public int getItemEnchantability(ItemStack stack) {
    return material.getEnchantability();
  }

  @Override
  public int getHarvestLevel(ItemStack stack, String toolClass, @Nullable EntityPlayer player, @Nullable IBlockState blockState) {
    return material.getHarvestLevel();
  }


  @Override
  public boolean canHarvestBlock(IBlockState block) {
    return super.canHarvestBlock(block) || (EFFECTIVE_ON.contains(block.getBlock()) || EFFECTIVE_ON_CUSTOM.contains(block.getBlock()));
  }

  @Override
  public int getMaxDamage(ItemStack stack) {
    return material.getMaxUses();
  }


  @Override
  public float getDestroySpeed(ItemStack stack, IBlockState state) {
    return ((EFFECTIVE_ON.contains(state.getBlock())) || (EFFECTIVE_ON_CUSTOM.contains(state.getBlock())))
        ? material.getEfficiency()
        : material.getEfficiency() * 1.6F;
  }
}

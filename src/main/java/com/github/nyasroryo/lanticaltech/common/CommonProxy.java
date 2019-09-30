package com.github.nyasroryo.lanticaltech.common;

import com.github.nyasroryo.lanticaltech.loader.BlockLoader;
import com.github.nyasroryo.lanticaltech.loader.ItemLoader;
import com.github.nyasroryo.lanticaltech.loader.OreDictionaryLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


public class CommonProxy {
  public void preInit(FMLPreInitializationEvent event) {
    BlockLoader.BlockReg(event);
    ItemLoader.ItemReg(event);
    OreDictionaryLoader.regOreDict();

  }

  public void init(FMLInitializationEvent event) {

  }

  public void postInit(FMLPostInitializationEvent event) {

  }
}
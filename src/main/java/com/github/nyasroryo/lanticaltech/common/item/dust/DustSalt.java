package com.github.nyasroryo.lanticaltech.common.item.dust;

import com.github.nyasroryo.lanticaltech.common.item.ItemBase;
import net.minecraft.item.Item;

public class DustSalt extends ItemBase {

  public static final String MyName = "dustSalt";

  public DustSalt() {
    super(MyName);
  }

  public static final Item THIS_ITEM = new DustSalt();
}
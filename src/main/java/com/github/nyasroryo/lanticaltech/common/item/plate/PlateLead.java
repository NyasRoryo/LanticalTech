package com.github.nyasroryo.lanticaltech.common.item.plate;

import com.github.nyasroryo.lanticaltech.common.item.ItemBase;
import net.minecraft.item.Item;

public class PlateLead extends ItemBase {

    public static final String MyName = "plateLead";

    public PlateLead() {
        super(MyName);
    }


    public static final Item ME = new PlateLead();
}
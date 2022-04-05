package com.RkoGOD.testmod.item;

import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RegisterItem {
    static Item WheatAndSteel = new ItemGen(50, 64, CreativeTabs.tabTools, "wheat_and_steel");

    public static void RegisterItem() {
        GameRegistry.registerItem(WheatAndSteel, "wheat_and_steel");
    }

    public static void RegisterItemModel(){
        ModelLoader.setCustomModelResourceLocation(WheatAndSteel, 0, new ModelResourceLocation(WheatAndSteel.getRegistryName()));
    }
}

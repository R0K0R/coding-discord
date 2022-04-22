package com.RkoGOD.testmod.Block;

import com.RkoGOD.testmod.util.Reference;
import net.minecraft.block.material.Material;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RegisterBlock {
    public static void RegisterBlocks(){
        testBlock test = new testBlock(Material.ground, "rko", CreativeTabs.tabBlock);
        GameRegistry.registerBlock(test, "rko");

        testBlock chibo = new testBlock(Material.ground, "chibo", CreativeTabs.tabMisc);
        GameRegistry.registerBlock(chibo, "chibo");
    }

    public static void RegisterItemModels(){
        Item testItem = GameRegistry.findItem(Reference.MODID, "rko");
        ModelLoader.setCustomModelResourceLocation(testItem, 0, new ModelResourceLocation(testItem.getRegistryName()));

        Item chiboItem = GameRegistry.findItem(Reference.MODID, "chibo");
        ModelLoader.setCustomModelResourceLocation(chiboItem, 0, new ModelResourceLocation(chiboItem.getRegistryName()));
    }
}
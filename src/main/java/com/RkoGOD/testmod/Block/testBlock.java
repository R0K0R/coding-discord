package com.RkoGOD.testmod.Block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class testBlock extends Block {
    public testBlock(Material Materialn, String name, CreativeTabs tabs) {
        super(Materialn);
        setUnlocalizedName(name);
        setCreativeTab(tabs);
    }
}
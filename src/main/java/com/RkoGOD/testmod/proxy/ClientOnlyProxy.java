package com.RkoGOD.testmod.proxy;

import com.RkoGOD.testmod.Block.RegisterBlock;
import com.RkoGOD.testmod.item.RegisterItem;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientOnlyProxy extends CommonProxy{
    @Override
    public void preInit(){
        super.preInit();
        RegisterBlock.RegisterItemModels();
        RegisterItem.RegisterItemModel();
    }
}

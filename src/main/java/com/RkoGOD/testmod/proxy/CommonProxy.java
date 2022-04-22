package com.RkoGOD.testmod.proxy;

import com.RkoGOD.testmod.Block.RegisterBlock;
import com.RkoGOD.testmod.item.RegisterItem;

public class CommonProxy{
     public void preInit(){
          RegisterBlock.RegisterBlocks();
          RegisterItem.RegisterItem();
     }
}

package com.RkoGOD.testmod.item;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemGen extends Item {
    public ItemGen(int MaxDamage, int MaxStack, CreativeTabs tab, String name){
        super();
        this.setMaxDamage(MaxDamage);
        this.setMaxStackSize(MaxStack);
        this.setCreativeTab(tab);
        this.setUnlocalizedName(name);
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {
        Item wheat_seed = GameRegistry.findItem("minecraft", "wheat_seeds");
        Block block = worldIn.getBlockState(pos).getBlock();
        Boolean canGrow = block.canSustainPlant(worldIn, pos, EnumFacing.UP, (IPlantable) wheat_seed);

        if (playerIn.canPlayerEdit(pos.offset(side), side, stack)) {
            int hook = net.minecraftforge.event.ForgeEventFactory.onHoeUse(stack, playerIn, worldIn, pos);
            if (hook != 0) return hook > 0;

            IBlockState iblockstate = worldIn.getBlockState(pos);
            Block blockHoe = iblockstate.getBlock();

            if (side != EnumFacing.DOWN && worldIn.isAirBlock(pos.up())) {
                if (blockHoe == Blocks.grass) {
                    return useHoe.useHoe(stack, playerIn, worldIn, pos, Blocks.farmland.getDefaultState());
                }

                if (blockHoe == Blocks.dirt) {
                    switch ((BlockDirt.DirtType) iblockstate.getValue(BlockDirt.VARIANT)) {
                        case DIRT:
                            return useHoe.useHoe(stack, playerIn, worldIn, pos, Blocks.farmland.getDefaultState());
                        case COARSE_DIRT:
                            return useHoe.useHoe(stack, playerIn, worldIn, pos, Blocks.dirt.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.DIRT));
                    }
                }
            }

            if (side == EnumFacing.UP) {
                if (worldIn.isAirBlock(pos.up())) {
                    if (canGrow) {
                        worldIn.setBlockState(pos.up(), ((IPlantable) wheat_seed).getPlant(worldIn, pos));
                        stack.damageItem(1, playerIn);
                        return true;
                    }
                }

            }
        }
        return false;
    }


}
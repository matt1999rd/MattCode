package fr.mattmouss.SwitchRail.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ObserverBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class Switch extends Block {


    public Switch() {
        super(Properties.create(Material.IRON)
                .sound(SoundType.METAL)
                .hardnessAndResistance(2.0f)
                .lightValue(14)
                .doesNotBlockMovement()
        );

        setRegistryName("switch");
    }
    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, BlockState  state, @Nullable LivingEntity entity, ItemStack stack){
        if (entity !=null){
            world.setBlockState(pos,state.with(BlockStateProperties.FACING,getFacingFromEntity(pos,entity)),2);
        }

    }


    public static Direction getFacingFromEntity(BlockPos pos, LivingEntity placer) {
        return Direction.getFacingFromVector((float) (placer.posX-pos.getX()),(float) (placer.posY-pos.getY()),(float) (placer.posZ-pos.getZ()));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder ){
        builder.add(BlockStateProperties.FACING);
    }




}

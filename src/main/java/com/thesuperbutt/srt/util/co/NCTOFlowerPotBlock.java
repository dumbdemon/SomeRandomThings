package com.thesuperbutt.srt.util.co;

import com.thesuperbutt.srt.util.NonCreativeTabObject;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerPotBlock;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class NCTOFlowerPotBlock extends FlowerPotBlock implements NonCreativeTabObject {
    public NCTOFlowerPotBlock(@Nullable Supplier<FlowerPotBlock> emptyPot, Supplier<? extends Block> pContent, Properties properties) {
        super(emptyPot, pContent, properties);
    }
}

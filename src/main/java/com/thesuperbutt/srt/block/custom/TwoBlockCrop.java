package com.thesuperbutt.srt.block.custom;

import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.jetbrains.annotations.NotNull;

public class TwoBlockCrop extends CropBlock {
    public TwoBlockCrop(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public @NotNull IntegerProperty getAgeProperty() {
        return super.getAgeProperty();
    }
}

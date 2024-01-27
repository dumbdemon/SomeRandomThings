package com.thesuperbutt.srt.block.entities;

import com.thesuperbutt.srt.SomeRandomThings;
import com.thesuperbutt.srt.block.SomeRandomBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
        DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, SomeRandomThings.MOD_ID);

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }    public static final RegistryObject<BlockEntityType<GemPolishingStationBlockEntity>> GEM_POLISHING_BE =
        BLOCK_ENTITIES.register("gem_polishing_be", () ->
            BlockEntityType.Builder.of(GemPolishingStationBlockEntity::new,
                SomeRandomBlocks.GEM_POLISHING_STATION.get()).build(null));


}

package com.thesuperbutt.srt.villager;

import com.google.common.collect.ImmutableSet;
import com.thesuperbutt.srt.SomeRandomThings;
import com.thesuperbutt.srt.block.SomeRandomBlocks;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Predicate;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
        DeferredRegister.create(ForgeRegistries.POI_TYPES, SomeRandomThings.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
        DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, SomeRandomThings.MOD_ID);

    public static final RegistryObject<PoiType> SOUND_POI = POI_TYPES.register("sound_poi",
        () -> new PoiType(ImmutableSet.copyOf(SomeRandomBlocks.SOUND_BLOCK.get().getStateDefinition().getPossibleStates()),
            1, 1));

    static Predicate<Holder<PoiType>> soundEngineer = holder -> holder.get() == SOUND_POI.get();
    public static final RegistryObject<VillagerProfession> SOUND_ENGINEER = VILLAGER_PROFESSIONS.register("soundengineer",
        () -> new VillagerProfession("soundengineer", soundEngineer, soundEngineer, ImmutableSet.of(), ImmutableSet.of(),
            SoundEvents.VILLAGER_WORK_ARMORER));

    public static void register(IEventBus event) {
        POI_TYPES.register(event);
        VILLAGER_PROFESSIONS.register(event);
    }
}

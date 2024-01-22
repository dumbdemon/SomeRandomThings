package com.thesuperbutt.srt.entity;

import com.thesuperbutt.srt.SomeRandomThings;
import com.thesuperbutt.srt.entity.custom.RhinoEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPE =
        DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, SomeRandomThings.MOD_ID);

    public static final RegistryObject<EntityType<RhinoEntity>> RHINO =
        ENTITY_TYPE.register("rhino", () -> EntityType.Builder.of(RhinoEntity::new, MobCategory.CREATURE)
            .sized(2.5f, 2.5f).build("rhino"));

    public static void register(IEventBus event) {
        ENTITY_TYPE.register(event);
    }
}

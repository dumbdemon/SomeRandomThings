package com.thesuperbutt.srt.event;

import com.thesuperbutt.srt.SomeRandomThings;
import com.thesuperbutt.srt.entity.ModEntities;
import com.thesuperbutt.srt.entity.custom.RhinoEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

@Mod.EventBusSubscriber(modid = SomeRandomThings.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MobEventBusEvents {

    @SubscribeEvent
    public static void registerAttributes(@NotNull EntityAttributeCreationEvent event) {
        event.put(ModEntities.RHINO.get(), RhinoEntity.createAttributes().build());
    }
}

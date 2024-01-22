package com.thesuperbutt.srt.event;

import com.thesuperbutt.srt.SomeRandomThings;
import com.thesuperbutt.srt.entity.client.ModModelLayers;
import com.thesuperbutt.srt.entity.client.RhinoModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

@Mod.EventBusSubscriber(modid = SomeRandomThings.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class MobEventBusClientEvents {

    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.@NotNull RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.RHINO_LAYER, RhinoModel::createBodyLayer);
    }
}

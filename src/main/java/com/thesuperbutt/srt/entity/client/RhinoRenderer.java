package com.thesuperbutt.srt.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.thesuperbutt.srt.SomeRandomThings;
import com.thesuperbutt.srt.entity.custom.RhinoEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class RhinoRenderer extends MobRenderer<RhinoEntity, RhinoModel<RhinoEntity>> {
    public RhinoRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new RhinoModel<>(pContext.bakeLayer(ModModelLayers.RHINO_LAYER)), 2f);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull RhinoEntity rhinoEntity) {
        return new ResourceLocation(SomeRandomThings.MOD_ID, "textures/entity/rhino.png");
    }

    @Override
    public void render(@NotNull RhinoEntity pEntity, float pEntityYaw, float pPartialTicks, @NotNull PoseStack pPoseStack,
                       @NotNull MultiBufferSource pBuffer, int pPackedLight) {
        if (pEntity.isBaby()) {
            pPoseStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}

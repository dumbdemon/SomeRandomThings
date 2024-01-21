package com.thesuperbutt.srt.item;

import com.thesuperbutt.srt.SomeRandomThings;
import com.thesuperbutt.srt.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolsTiers {
    public static final Tier SAPPHIRE = TierSortingRegistry.registerTier(
        new ForgeTier(5, 1500, 5f, 4f, 25,
            ModTags.Blocks.NEEDS_SAPPHIRE_TOOL, () -> Ingredient.of(ModItems.SAPPHIRE.get())),
        new ResourceLocation(SomeRandomThings.MOD_ID, "sapphire"), List.of(Tiers.NETHERITE), List.of());
}

package com.thesuperbutt.srt.datagen;

import com.thesuperbutt.srt.SomeRandomThings;
import com.thesuperbutt.srt.item.SomeRandomItems;
import com.thesuperbutt.srt.loot.AddItemModifier;
import com.thesuperbutt.srt.loot.AddSusSandItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output) {
        super(output, SomeRandomThings.MOD_ID);
    }

    @Override
    protected void start() {
        add("pine_cone_from_grass", new AddItemModifier(new LootItemCondition[]{
            LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GRASS).build(),
            LootItemRandomChanceCondition.randomChance(0.27f).build()
        }, SomeRandomItems.PINE_CONE.get()));

        add("pine_cone_from_creeper", new AddItemModifier(new LootItemCondition[]{
            new LootTableIdCondition.Builder(new ResourceLocation("entities/creeper")).build()
        }, SomeRandomItems.PINE_CONE.get()));

        add("metal_detector_from_jungle_temples", new AddItemModifier(new LootItemCondition[]{
            new LootTableIdCondition.Builder(new ResourceLocation("chests/jungle_temple")).build()
        }, SomeRandomItems.METAL_DETECTOR.get()));

        add("metal_detector_from_suspicious_sand", new AddSusSandItemModifier(new LootItemCondition[]{
            new LootTableIdCondition.Builder(new ResourceLocation("archeology/desert_pyramid")).build()
        }, SomeRandomItems.METAL_DETECTOR.get()));
    }
}

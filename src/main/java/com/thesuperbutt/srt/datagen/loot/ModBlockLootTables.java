package com.thesuperbutt.srt.datagen.loot;

import com.thesuperbutt.srt.block.SomeRandomBlocks;
import com.thesuperbutt.srt.block.custom.CornCropBlock;
import com.thesuperbutt.srt.block.custom.StrawberryCropBlock;
import com.thesuperbutt.srt.item.SomeRandomItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(SomeRandomBlocks.SAPPHIRE_BLOCK.get());
        this.dropSelf(SomeRandomBlocks.RAW_SAPPHIRE_BLOCK.get());
        this.dropSelf(SomeRandomBlocks.SOUND_BLOCK.get());

        this.add(SomeRandomBlocks.SAPPHIRE_ORE.get(),
            block -> createCopperLikeOreDrops(SomeRandomBlocks.SAPPHIRE_ORE.get(), SomeRandomItems.RAW_SAPPHIRE.get()));
        this.add(SomeRandomBlocks.DEEPSLATE_SAPPHIRE_ORE.get(),
            block -> createCopperLikeOreDrops(SomeRandomBlocks.DEEPSLATE_SAPPHIRE_ORE.get(), SomeRandomItems.RAW_SAPPHIRE.get()));
        this.add(SomeRandomBlocks.NETHER_SAPPHIRE_ORE.get(),
            block -> createCopperLikeOreDrops(SomeRandomBlocks.NETHER_SAPPHIRE_ORE.get(), SomeRandomItems.RAW_SAPPHIRE.get()));
        this.add(SomeRandomBlocks.END_STONE_SAPPHIRE_ORE.get(),
            block -> createCopperLikeOreDrops(SomeRandomBlocks.END_STONE_SAPPHIRE_ORE.get(), SomeRandomItems.RAW_SAPPHIRE.get()));

        this.dropSelf(SomeRandomBlocks.SAPPHIRE_STAIRS.get());
        this.dropSelf(SomeRandomBlocks.SAPPHIRE_BUTTON.get());
        this.dropSelf(SomeRandomBlocks.SAPPHIRE_PRESSURE_PLATE.get());
        this.dropSelf(SomeRandomBlocks.SAPPHIRE_TRAPDOOR.get());
        this.dropSelf(SomeRandomBlocks.SAPPHIRE_FENCE.get());
        this.dropSelf(SomeRandomBlocks.SAPPHIRE_FENCE_GATE.get());
        this.dropSelf(SomeRandomBlocks.SAPPHIRE_WALL.get());

        this.add(SomeRandomBlocks.SAPPHIRE_SLAB.get(),
            block -> createSlabItemTable(SomeRandomBlocks.SAPPHIRE_SLAB.get()));
        this.add(SomeRandomBlocks.SAPPHIRE_DOOR.get(),
            block -> createDoorTable(SomeRandomBlocks.SAPPHIRE_DOOR.get()));

        LootItemCondition.Builder toDropSeedOrCropStrawberry = LootItemBlockStatePropertyCondition
            .hasBlockStateProperties(SomeRandomBlocks.STRAWBERRY_CROP.get())
            .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(StrawberryCropBlock.AGE, 5));

        this.add(SomeRandomBlocks.STRAWBERRY_CROP.get(), createCropDrops(SomeRandomBlocks.STRAWBERRY_CROP.get(), SomeRandomItems.STRAWBERRY.get(),
            SomeRandomItems.STRAWBERRY_SEEDS.get(), toDropSeedOrCropStrawberry));

        LootItemCondition.Builder toDropSeedOrCropCorn = LootItemBlockStatePropertyCondition
            .hasBlockStateProperties(SomeRandomBlocks.CORN_CROP.get())
            .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornCropBlock.AGE, 7))
            .or(LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(SomeRandomBlocks.CORN_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornCropBlock.AGE, 8)));

        this.add(SomeRandomBlocks.CORN_CROP.get(), createCropDrops(SomeRandomBlocks.CORN_CROP.get(), SomeRandomItems.CORN.get(),
            SomeRandomItems.CORN_SEEDS.get(), toDropSeedOrCropCorn));

        this.dropSelf(SomeRandomBlocks.CATMINT.get());
        this.add(SomeRandomBlocks.POTTED_CATMINT.get(), createPotFlowerItemTable(SomeRandomBlocks.CATMINT.get()));
        this.dropSelf(SomeRandomBlocks.GEM_POLISHING_STATION.get());
    }

    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
            this.applyExplosionDecay(pBlock,
                LootItem.lootTableItem(item)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                    .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return SomeRandomBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}

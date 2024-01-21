package com.thesuperbutt.srt.datagen;

import com.thesuperbutt.srt.SomeRandomThings;
import com.thesuperbutt.srt.block.ModBlocks;
import com.thesuperbutt.srt.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                                @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, SomeRandomThings.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        this.tag(ModTags.Blocks.METAL_DETECTOR_VALUABLES)
        .add(ModBlocks.SAPPHIRE_ORE.get()).addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.MINEABLE_WITH_AXE);

        this.tag(BlockTags.MINEABLE_WITH_SHOVEL);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .add(
                ModBlocks.SAPPHIRE_BLOCK.get(),
                ModBlocks.RAW_SAPPHIRE_BLOCK.get(),
                ModBlocks.SAPPHIRE_ORE.get(),
                ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(),
                ModBlocks.NETHER_SAPPHIRE_ORE.get(),
                ModBlocks.END_STONE_SAPPHIRE_ORE.get(),
                ModBlocks.SAPPHIRE_STAIRS.get(),
                ModBlocks.SAPPHIRE_DOOR.get(),
                ModBlocks.SAPPHIRE_SLAB.get(),
                ModBlocks.SAPPHIRE_BUTTON.get(),
                ModBlocks.SAPPHIRE_FENCE_GATE.get(),
                ModBlocks.SAPPHIRE_FENCE.get(),
                ModBlocks.SAPPHIRE_TRAPDOOR.get(),
                ModBlocks.SAPPHIRE_PRESSURE_PLATE.get(),
                ModBlocks.SAPPHIRE_WALL.get()
            );

        this.tag(BlockTags.NEEDS_IRON_TOOL)
            .add(
                ModBlocks.SAPPHIRE_ORE.get(),
                ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(),
                ModBlocks.NETHER_SAPPHIRE_ORE.get(),
                ModBlocks.END_STONE_SAPPHIRE_ORE.get()
            );

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL);

        this.tag(BlockTags.NEEDS_STONE_TOOL)
            .add(
                ModBlocks.SAPPHIRE_BLOCK.get(),
                ModBlocks.RAW_SAPPHIRE_BLOCK.get()
            );

        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL);

        this.tag(BlockTags.FENCES)
            .add(ModBlocks.SAPPHIRE_FENCE.get());

        this.tag(BlockTags.FENCE_GATES)
            .add(ModBlocks.SAPPHIRE_FENCE_GATE.get());

        this.tag(BlockTags.DOORS)
            .add(ModBlocks.SAPPHIRE_DOOR.get());

        this.tag(BlockTags.WALLS)
            .add(ModBlocks.SAPPHIRE_WALL.get());

        this.tag(BlockTags.SLABS)
            .add(ModBlocks.SAPPHIRE_SLAB.get());

        this.tag(BlockTags.BUTTONS)
            .add(ModBlocks.SAPPHIRE_BUTTON.get());

        this.tag(BlockTags.TRAPDOORS)
            .add(ModBlocks.SAPPHIRE_TRAPDOOR.get());

        this.tag(BlockTags.STAIRS)
            .add(ModBlocks.SAPPHIRE_STAIRS.get());
    }
}
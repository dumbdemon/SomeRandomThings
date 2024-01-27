package com.thesuperbutt.srt.datagen;

import com.thesuperbutt.srt.SomeRandomThings;
import com.thesuperbutt.srt.block.SomeRandomBlocks;
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
            .add(SomeRandomBlocks.SAPPHIRE_ORE.get()).addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.MINEABLE_WITH_AXE);

        this.tag(BlockTags.MINEABLE_WITH_SHOVEL);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .add(
                SomeRandomBlocks.SAPPHIRE_BLOCK.get(),
                SomeRandomBlocks.RAW_SAPPHIRE_BLOCK.get(),
                SomeRandomBlocks.SAPPHIRE_ORE.get(),
                SomeRandomBlocks.DEEPSLATE_SAPPHIRE_ORE.get(),
                SomeRandomBlocks.NETHER_SAPPHIRE_ORE.get(),
                SomeRandomBlocks.END_STONE_SAPPHIRE_ORE.get(),
                SomeRandomBlocks.SAPPHIRE_STAIRS.get(),
                SomeRandomBlocks.SAPPHIRE_DOOR.get(),
                SomeRandomBlocks.SAPPHIRE_SLAB.get(),
                SomeRandomBlocks.SAPPHIRE_BUTTON.get(),
                SomeRandomBlocks.SAPPHIRE_FENCE_GATE.get(),
                SomeRandomBlocks.SAPPHIRE_FENCE.get(),
                SomeRandomBlocks.SAPPHIRE_TRAPDOOR.get(),
                SomeRandomBlocks.SAPPHIRE_PRESSURE_PLATE.get(),
                SomeRandomBlocks.SAPPHIRE_WALL.get()
            );

        this.tag(BlockTags.NEEDS_IRON_TOOL)
            .add(
                SomeRandomBlocks.SAPPHIRE_ORE.get(),
                SomeRandomBlocks.DEEPSLATE_SAPPHIRE_ORE.get(),
                SomeRandomBlocks.NETHER_SAPPHIRE_ORE.get(),
                SomeRandomBlocks.END_STONE_SAPPHIRE_ORE.get()
            );

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL);

        this.tag(BlockTags.NEEDS_STONE_TOOL)
            .add(
                SomeRandomBlocks.SAPPHIRE_BLOCK.get(),
                SomeRandomBlocks.RAW_SAPPHIRE_BLOCK.get()
            );

        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL);

        this.tag(ModTags.Blocks.NEEDS_SAPPHIRE_TOOL)
            .add(SomeRandomBlocks.SOUND_BLOCK.get());

        this.tag(BlockTags.FENCES)
            .add(SomeRandomBlocks.SAPPHIRE_FENCE.get());

        this.tag(BlockTags.FENCE_GATES)
            .add(SomeRandomBlocks.SAPPHIRE_FENCE_GATE.get());

        this.tag(BlockTags.DOORS)
            .add(SomeRandomBlocks.SAPPHIRE_DOOR.get());

        this.tag(BlockTags.WALLS)
            .add(SomeRandomBlocks.SAPPHIRE_WALL.get());

        this.tag(BlockTags.SLABS)
            .add(SomeRandomBlocks.SAPPHIRE_SLAB.get());

        this.tag(BlockTags.BUTTONS)
            .add(SomeRandomBlocks.SAPPHIRE_BUTTON.get());

        this.tag(BlockTags.TRAPDOORS)
            .add(SomeRandomBlocks.SAPPHIRE_TRAPDOOR.get());

        this.tag(BlockTags.STAIRS)
            .add(SomeRandomBlocks.SAPPHIRE_STAIRS.get());
    }
}

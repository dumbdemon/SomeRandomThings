package com.thesuperbutt.srt.datagen;

import com.thesuperbutt.srt.SomeRandomThings;
import com.thesuperbutt.srt.item.SomeRandomItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_,
                               CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, SomeRandomThings.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        this.tag(ItemTags.TRIMMABLE_ARMOR)
            .add(
                SomeRandomItems.SAPPHIRE_HELMET.get(),
                SomeRandomItems.SAPPHIRE_CHESTPLATE.get(),
                SomeRandomItems.SAPPHIRE_LEGGINGS.get(),
                SomeRandomItems.SAPPHIRE_BOOTS.get()
            );

        this.tag(ItemTags.MUSIC_DISCS)
            .add(SomeRandomItems.BAR_BRAWL_MUSIC_DISC.get());

        this.tag(ItemTags.CREEPER_DROP_MUSIC_DISCS)
            .add(SomeRandomItems.BAR_BRAWL_MUSIC_DISC.get());
    }
}

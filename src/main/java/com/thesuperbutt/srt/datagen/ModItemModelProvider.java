package com.thesuperbutt.srt.datagen;

import com.thesuperbutt.srt.SomeRandomThings;
import com.thesuperbutt.srt.block.ModBlocks;
import com.thesuperbutt.srt.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, SomeRandomThings.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        List<Item> blockItems = ModBlocks.BLOCKS.getEntries().stream().map(block -> block.get().asItem()).toList();
        ModItems.ITEMS.getEntries().stream().filter(item -> !blockItems.contains(item.get()))
            .forEach(this::simpleItem);
    }

    private ItemModelBuilder simpleItem(@NotNull RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
            new ResourceLocation("item/generated")).texture("layer0",
            new ResourceLocation(SomeRandomThings.MOD_ID,"item/" + item.getId().getPath()));
    }
}

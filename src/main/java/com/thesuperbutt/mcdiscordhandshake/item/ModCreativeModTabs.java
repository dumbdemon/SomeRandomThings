package com.thesuperbutt.mcdiscordhandshake.item;

import com.thesuperbutt.mcdiscordhandshake.SomeRandomThings;
import com.thesuperbutt.mcdiscordhandshake.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SomeRandomThings.MOD_ID);

    @SuppressWarnings("unused")
    public static final RegistryObject<CreativeModeTab> SMR_TAB = CREATIVE_MODE_TABS.register("somerandomsthings_tab",
        () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.SAPPHIRE.get()))
            .title(Component.translatable("creativetab.somerandomsthings_tab"))
            .displayItems(((itemDisplayParameters, output) -> {
                ModItems.ITEMS.getEntries().forEach(item -> output.accept(item.get()));
                ModBlocks.BLOCKS.getEntries().forEach(block -> output.accept(block.get()));
            }))
            .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}

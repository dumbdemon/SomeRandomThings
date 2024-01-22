package com.thesuperbutt.srt.event;

import com.thesuperbutt.srt.SomeRandomThings;
import com.thesuperbutt.srt.item.ModItems;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@Mod.EventBusSubscriber(modid = SomeRandomThings.MOD_ID)
public class ModEvents {

    @SubscribeEvent
    public static void addCustomTrades(@NotNull VillagerTradesEvent event) {
        if (event.getType() == VillagerProfession.FARMER) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 2),
                new ItemStack(ModItems.STRAWBERRY.get(), 12),
                10, 8, 0.02f
            ));
        }
    }

    @SubscribeEvent
    public static void addCustomWanderingTrades(@NotNull WandererTradesEvent event) {
        List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();
        List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();

        //
    }
}

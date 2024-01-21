package com.thesuperbutt.srt.datagen;

import com.thesuperbutt.srt.SomeRandomThings;
import com.thesuperbutt.srt.block.ModBlocks;
import com.thesuperbutt.srt.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> SAPPHIRE_SMELTABLES = List.of(
        ModItems.RAW_SAPPHIRE.get(),
        ModBlocks.SAPPHIRE_ORE.get(),
        ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(),
        ModBlocks.NETHER_SAPPHIRE_ORE.get(),
        ModBlocks.END_STONE_SAPPHIRE_ORE.get()
    );

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> recipeOutput) {
        oreSmelting(recipeOutput, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ModItems.SAPPHIRE.get(), 0.25f, 200, "sapphire");
        oreBlasting(recipeOutput, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ModItems.SAPPHIRE.get(), 0.25f, 100, "sapphire");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SAPPHIRE_BLOCK.get())
            .pattern("SSS")
            .pattern("SSS")
            .pattern("SSS")
            .define('S', ModItems.SAPPHIRE.get())
            .unlockedBy(getHasName(ModItems.SAPPHIRE.get()), has(ModItems.SAPPHIRE.get()))
            .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RAW_SAPPHIRE_BLOCK.get())
            .pattern("SSS")
            .pattern("SSS")
            .pattern("SSS")
            .define('S', ModItems.RAW_SAPPHIRE.get())
            .unlockedBy(getHasName(ModItems.RAW_SAPPHIRE.get()), has(ModItems.RAW_SAPPHIRE.get()))
            .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SAPPHIRE.get(), 9)
            .requires(ModBlocks.SAPPHIRE_BLOCK.get())
            .unlockedBy(getHasName(ModBlocks.SAPPHIRE_BLOCK.get()), has(ModBlocks.SAPPHIRE_BLOCK.get()))
            .save(recipeOutput);
    }

    protected static void oreSmelting(@NotNull Consumer<FinishedRecipe> pRecipeOutput, List<ItemLike> pIngredients,
                                      @NotNull RecipeCategory pCategory, @NotNull ItemLike pResult, float pExperience,
                                      int pCookingTime, @NotNull String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(@NotNull Consumer<FinishedRecipe> pRecipeOutput, List<ItemLike> pIngredients,
                                      @NotNull RecipeCategory pCategory, @NotNull ItemLike pResult, float pExperience,
                                      int pCookingTime, @NotNull String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(@NotNull Consumer<FinishedRecipe> pRecipeOutput, @NotNull RecipeSerializer<? extends AbstractCookingRecipe> pSerializer,
                                     @NotNull List<ItemLike> pIngredients, @NotNull RecipeCategory pCategory, @NotNull ItemLike pResult, float pExperience,
                                     int pCookingTime, @NotNull String pGroup, String pSuffix) {
        for (ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pSerializer)
                .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                .save(pRecipeOutput, SomeRandomThings.MOD_ID + ":" + getItemName(pResult) + pSuffix + "_" + getItemName(itemlike));
        }

    }
}
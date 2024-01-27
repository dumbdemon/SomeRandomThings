package com.thesuperbutt.srt.datagen;

import com.thesuperbutt.srt.SomeRandomThings;
import com.thesuperbutt.srt.block.SomeRandomBlocks;
import com.thesuperbutt.srt.item.SomeRandomItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
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
        SomeRandomItems.RAW_SAPPHIRE.get(),
        SomeRandomBlocks.SAPPHIRE_ORE.get(),
        SomeRandomBlocks.DEEPSLATE_SAPPHIRE_ORE.get(),
        SomeRandomBlocks.NETHER_SAPPHIRE_ORE.get(),
        SomeRandomBlocks.END_STONE_SAPPHIRE_ORE.get()
    );

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
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

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> recipeOutput) {
        oreSmelting(recipeOutput, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, SomeRandomItems.SAPPHIRE.get(), 0.25f, 200, "sapphire");
        oreBlasting(recipeOutput, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, SomeRandomItems.SAPPHIRE.get(), 0.25f, 100, "sapphire");

        //Sapphire Items
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, SomeRandomBlocks.SAPPHIRE_BLOCK.get())
            .pattern("SSS")
            .pattern("SSS")
            .pattern("SSS")
            .define('S', SomeRandomItems.SAPPHIRE.get())
            .unlockedBy(getHasName(SomeRandomItems.SAPPHIRE.get()), has(SomeRandomItems.SAPPHIRE.get()))
            .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, SomeRandomBlocks.RAW_SAPPHIRE_BLOCK.get())
            .pattern("SSS")
            .pattern("SSS")
            .pattern("SSS")
            .define('S', SomeRandomItems.RAW_SAPPHIRE.get())
            .unlockedBy(getHasName(SomeRandomItems.RAW_SAPPHIRE.get()), has(SomeRandomItems.RAW_SAPPHIRE.get()))
            .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, SomeRandomItems.SAPPHIRE.get(), 9)
            .requires(SomeRandomBlocks.SAPPHIRE_BLOCK.get())
            .unlockedBy(getHasName(SomeRandomBlocks.SAPPHIRE_BLOCK.get()), has(SomeRandomBlocks.SAPPHIRE_BLOCK.get()))
            .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, SomeRandomBlocks.SAPPHIRE_STAIRS.get(), 4)
            .pattern("S  ")
            .pattern("SS ")
            .pattern("SSS")
            .define('S', SomeRandomItems.SAPPHIRE.get())
            .unlockedBy(getHasName(SomeRandomItems.SAPPHIRE.get()), has(SomeRandomItems.SAPPHIRE.get()))
            .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, SomeRandomBlocks.SAPPHIRE_BUTTON.get())
            .requires(SomeRandomItems.SAPPHIRE.get())
            .unlockedBy(getHasName(SomeRandomItems.SAPPHIRE.get()), has(SomeRandomItems.SAPPHIRE.get()))
            .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, SomeRandomBlocks.SAPPHIRE_DOOR.get(), 3)
            .pattern("SS")
            .pattern("SS")
            .pattern("SS")
            .define('S', SomeRandomItems.SAPPHIRE.get())
            .unlockedBy(getHasName(SomeRandomItems.SAPPHIRE.get()), has(SomeRandomItems.SAPPHIRE.get()))
            .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, SomeRandomBlocks.SAPPHIRE_SLAB.get(), 6)
            .pattern("SSS")
            .define('S', SomeRandomItems.SAPPHIRE.get())
            .unlockedBy(getHasName(SomeRandomItems.SAPPHIRE.get()), has(SomeRandomItems.SAPPHIRE.get()))
            .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, SomeRandomBlocks.SAPPHIRE_TRAPDOOR.get(), 2)
            .pattern("SSS")
            .pattern("SSS")
            .define('S', SomeRandomItems.SAPPHIRE.get())
            .unlockedBy(getHasName(SomeRandomItems.SAPPHIRE.get()), has(SomeRandomItems.SAPPHIRE.get()))
            .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, SomeRandomBlocks.SAPPHIRE_PRESSURE_PLATE.get())
            .pattern("SS")
            .define('S', SomeRandomItems.SAPPHIRE.get())
            .unlockedBy(getHasName(SomeRandomItems.SAPPHIRE.get()), has(SomeRandomItems.SAPPHIRE.get()))
            .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, SomeRandomBlocks.SAPPHIRE_FENCE_GATE.get())
            .pattern("sSs")
            .pattern("sSs")
            .define('S', SomeRandomItems.SAPPHIRE.get())
            .define('s', Items.STICK)
            .unlockedBy(getHasName(SomeRandomItems.SAPPHIRE.get()), has(SomeRandomItems.SAPPHIRE.get()))
            .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, SomeRandomBlocks.SAPPHIRE_FENCE.get(), 3)
            .pattern("SsS")
            .pattern("SsS")
            .define('S', SomeRandomItems.SAPPHIRE.get())
            .define('s', Items.STICK)
            .unlockedBy(getHasName(SomeRandomItems.SAPPHIRE.get()), has(SomeRandomItems.SAPPHIRE.get()))
            .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, SomeRandomBlocks.SAPPHIRE_WALL.get(), 6)
            .pattern("SSS")
            .pattern("SSS")
            .define('S', SomeRandomBlocks.SAPPHIRE_BLOCK.get())
            .unlockedBy(getHasName(SomeRandomBlocks.SAPPHIRE_BLOCK.get()), has(SomeRandomBlocks.SAPPHIRE_BLOCK.get()))
            .save(recipeOutput);

        //Sapphire Tools
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SomeRandomItems.SAPPHIRE_AXE.get())
            .pattern("SS ")
            .pattern("Ss ")
            .pattern(" s ")
            .define('S', SomeRandomItems.SAPPHIRE.get())
            .define('s', Items.STICK)
            .unlockedBy(getHasName(SomeRandomItems.SAPPHIRE.get()), has(SomeRandomItems.SAPPHIRE.get()))
            .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SomeRandomItems.SAPPHIRE_SWORD.get())
            .pattern(" S ")
            .pattern(" S ")
            .pattern(" s ")
            .define('S', SomeRandomItems.SAPPHIRE.get())
            .define('s', Items.STICK)
            .unlockedBy(getHasName(SomeRandomItems.SAPPHIRE.get()), has(SomeRandomItems.SAPPHIRE.get()))
            .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SomeRandomItems.SAPPHIRE_SHOVEL.get())
            .pattern(" S ")
            .pattern(" s ")
            .pattern(" s ")
            .define('S', SomeRandomItems.SAPPHIRE.get())
            .define('s', Items.STICK)
            .unlockedBy(getHasName(SomeRandomItems.SAPPHIRE.get()), has(SomeRandomItems.SAPPHIRE.get()))
            .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SomeRandomItems.SAPPHIRE_HOE.get())
            .pattern("SS ")
            .pattern(" s ")
            .pattern(" s ")
            .define('S', SomeRandomItems.SAPPHIRE.get())
            .define('s', Items.STICK)
            .unlockedBy(getHasName(SomeRandomItems.SAPPHIRE.get()), has(SomeRandomItems.SAPPHIRE.get()))
            .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SomeRandomItems.SAPPHIRE_PICKAXE.get())
            .pattern("SSS")
            .pattern(" s ")
            .pattern(" s ")
            .define('S', SomeRandomItems.SAPPHIRE.get())
            .define('s', Items.STICK)
            .unlockedBy(getHasName(SomeRandomItems.SAPPHIRE.get()), has(SomeRandomItems.SAPPHIRE.get()))
            .save(recipeOutput);

        //Sapphire Gear
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SomeRandomItems.SAPPHIRE_HELMET.get())
            .pattern("SSS")
            .pattern("S S")
            .define('S', SomeRandomItems.SAPPHIRE.get())
            .unlockedBy(getHasName(SomeRandomItems.SAPPHIRE.get()), has(SomeRandomItems.SAPPHIRE.get()))
            .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SomeRandomItems.SAPPHIRE_CHESTPLATE.get())
            .pattern("S S")
            .pattern("SSS")
            .pattern("SSS")
            .define('S', SomeRandomItems.SAPPHIRE.get())
            .unlockedBy(getHasName(SomeRandomItems.SAPPHIRE.get()), has(SomeRandomItems.SAPPHIRE.get()))
            .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SomeRandomItems.SAPPHIRE_LEGGINGS.get())
            .pattern("SSS")
            .pattern("S S")
            .pattern("S S")
            .define('S', SomeRandomItems.SAPPHIRE.get())
            .unlockedBy(getHasName(SomeRandomItems.SAPPHIRE.get()), has(SomeRandomItems.SAPPHIRE.get()))
            .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SomeRandomItems.SAPPHIRE_BOOTS.get())
            .pattern("S S")
            .pattern("S S")
            .define('S', SomeRandomItems.SAPPHIRE.get())
            .unlockedBy(getHasName(SomeRandomItems.SAPPHIRE.get()), has(SomeRandomItems.SAPPHIRE.get()))
            .save(recipeOutput);
    }
}

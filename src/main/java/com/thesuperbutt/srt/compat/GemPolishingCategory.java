package com.thesuperbutt.srt.compat;

import com.thesuperbutt.srt.SomeRandomThings;
import com.thesuperbutt.srt.block.ModBlocks;
import com.thesuperbutt.srt.recipe.GemPolishingRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class GemPolishingCategory implements IRecipeCategory<GemPolishingRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(SomeRandomThings.MOD_ID, "gem_polishing");
    public static final ResourceLocation TEXTURE = new ResourceLocation(SomeRandomThings.MOD_ID,
        "textures/gui/gem_polishing_station_gui.png");

    public static final RecipeType<GemPolishingRecipe> GEM_POLISHING_TYPE =
        new RecipeType<>(UID, GemPolishingRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public GemPolishingCategory(@NotNull IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.GEM_POLISHING_STATION.get()));
    }

    @Override
    public @NotNull RecipeType<GemPolishingRecipe> getRecipeType() {
        return GEM_POLISHING_TYPE;
    }

    @Override
    public @NotNull Component getTitle() {
        return Component.translatable("block.srt.gem_polishing_station");
    }

    @Override
    public @NotNull IDrawable getBackground() {
        return this.background;
    }

    @Override
    public @NotNull IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(@NotNull IRecipeLayoutBuilder iRecipeLayoutBuilder, @NotNull GemPolishingRecipe gemPolishingRecipe,
                          @NotNull IFocusGroup iFocusGroup) {
        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 80, 11).addIngredients(gemPolishingRecipe.getIngredients().get(0));

        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.OUTPUT, 80, 59).addItemStack(gemPolishingRecipe.getResultItem(null));

    }
}

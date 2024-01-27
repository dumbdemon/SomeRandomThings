package com.thesuperbutt.srt.datagen;

import com.thesuperbutt.srt.SomeRandomThings;
import com.thesuperbutt.srt.block.SomeRandomBlocks;
import com.thesuperbutt.srt.item.SomeRandomItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedHashMap;
import java.util.Objects;

public class ModItemModelProvider extends ItemModelProvider {
    private static final LinkedHashMap<ResourceKey<TrimMaterial>, Float> TRIM_MATERIALS = new LinkedHashMap<>();

    static {
        TRIM_MATERIALS.put(TrimMaterials.QUARTZ, 0.1F);
        TRIM_MATERIALS.put(TrimMaterials.IRON, 0.2F);
        TRIM_MATERIALS.put(TrimMaterials.NETHERITE, 0.3F);
        TRIM_MATERIALS.put(TrimMaterials.REDSTONE, 0.4F);
        TRIM_MATERIALS.put(TrimMaterials.COPPER, 0.5F);
        TRIM_MATERIALS.put(TrimMaterials.GOLD, 0.6F);
        TRIM_MATERIALS.put(TrimMaterials.EMERALD, 0.7F);
        TRIM_MATERIALS.put(TrimMaterials.DIAMOND, 0.8F);
        TRIM_MATERIALS.put(TrimMaterials.LAPIS, 0.9F);
        TRIM_MATERIALS.put(TrimMaterials.AMETHYST, 1.0F);
    }

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, SomeRandomThings.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(SomeRandomItems.SAPPHIRE);
        simpleItem(SomeRandomItems.RAW_SAPPHIRE);

        simpleItem(SomeRandomItems.METAL_DETECTOR);
        simpleItem(SomeRandomItems.PINE_CONE);
        simpleItem(SomeRandomItems.STRAWBERRY);
        simpleItem(SomeRandomItems.STRAWBERRY_SEEDS);

        simpleItem(SomeRandomItems.CORN);
        simpleItem(SomeRandomItems.CORN_SEEDS);

        simpleItem(SomeRandomItems.BAR_BRAWL_MUSIC_DISC);

        simpleBlockItem(SomeRandomBlocks.SAPPHIRE_DOOR);

        fenceItem(SomeRandomBlocks.SAPPHIRE_FENCE, SomeRandomBlocks.SAPPHIRE_BLOCK);
        wallItem(SomeRandomBlocks.SAPPHIRE_WALL, SomeRandomBlocks.SAPPHIRE_BLOCK);
        buttonItem(SomeRandomBlocks.SAPPHIRE_BUTTON, SomeRandomBlocks.SAPPHIRE_BLOCK);

        evenSimplerBlockItem(SomeRandomBlocks.SAPPHIRE_STAIRS);
        evenSimplerBlockItem(SomeRandomBlocks.SAPPHIRE_SLAB);
        evenSimplerBlockItem(SomeRandomBlocks.SAPPHIRE_PRESSURE_PLATE);
        evenSimplerBlockItem(SomeRandomBlocks.SAPPHIRE_FENCE_GATE);

        trapdoorItem(SomeRandomBlocks.SAPPHIRE_TRAPDOOR);

        handheldItem(SomeRandomItems.SAPPHIRE_AXE);
        handheldItem(SomeRandomItems.SAPPHIRE_SHOVEL);
        handheldItem(SomeRandomItems.SAPPHIRE_PICKAXE);
        handheldItem(SomeRandomItems.SAPPHIRE_HOE);
        handheldItem(SomeRandomItems.SAPPHIRE_SWORD);

        trimmedArmorItem(SomeRandomItems.SAPPHIRE_HELMET);
        trimmedArmorItem(SomeRandomItems.SAPPHIRE_CHESTPLATE);
        trimmedArmorItem(SomeRandomItems.SAPPHIRE_LEGGINGS);
        trimmedArmorItem(SomeRandomItems.SAPPHIRE_BOOTS);

        simpleBlockItemBlockTexture(SomeRandomBlocks.CATMINT);

        withExistingParent(SomeRandomItems.RHINO_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
    }

    private void trimmedArmorItem(@NotNull RegistryObject<Item> itemRegistryObject) {
        final String MOD_ID = SomeRandomThings.MOD_ID;

        if (itemRegistryObject.get() instanceof ArmorItem armorItem) {
            TRIM_MATERIALS.forEach((trimMaterial, trimValue) -> {

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = "item/" + armorItem;
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = new ResourceLocation(MOD_ID, armorItemPath);
                ResourceLocation trimResLoc = new ResourceLocation(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = new ResourceLocation(MOD_ID, currentTrimName);

                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
                getBuilder(currentTrimName)
                    .parent(new ModelFile.UncheckedModelFile("item/generated"))
                    .texture("layer0", armorItemResLoc)
                    .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemRegistryObject.getId().getPath(),
                        mcLoc("item/generated"))
                    .override()
                    .model(new ModelFile.UncheckedModelFile(trimNameResLoc))
                    .predicate(mcLoc("trim_type"), trimValue).end()
                    .texture("layer0",
                        new ResourceLocation(MOD_ID,
                            "item/" + itemRegistryObject.getId().getPath()));
            });
        }
    }

    private ItemModelBuilder simpleItem(@NotNull RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
            new ResourceLocation("item/generated")).texture("layer0",
            new ResourceLocation(SomeRandomThings.MOD_ID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItem(@NotNull RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
            new ResourceLocation("item/generated")).texture("layer0",
            new ResourceLocation(SomeRandomThings.MOD_ID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItemBlockTexture(@NotNull RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
            new ResourceLocation("item/generated")).texture("layer0",
            new ResourceLocation(SomeRandomThings.MOD_ID, "block/" + item.getId().getPath()));
    }

    private void evenSimplerBlockItem(@NotNull RegistryObject<Block> block) {
        this.withExistingParent(SomeRandomThings.MOD_ID + ":" + Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block.get())).getPath(),
            modLoc("block/" + Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block.get())).getPath()));
    }

    private ItemModelBuilder handheldItem(@NotNull RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
            new ResourceLocation("item/handheld")).texture("layer0",
            new ResourceLocation(SomeRandomThings.MOD_ID, "item/" + item.getId().getPath()));
    }

    private void fenceItem(@NotNull RegistryObject<Block> block, @NotNull RegistryObject<Block> baseBlock) {
        this.withExistingParent(Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block.get())).getPath(), mcLoc("block/fence_inventory"))
            .texture("texture", new ResourceLocation(SomeRandomThings.MOD_ID, "block/" +
                Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(baseBlock.get())).getPath()));
    }

    private void trapdoorItem(@NotNull RegistryObject<Block> block) {
        this.withExistingParent(Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block.get())).getPath(),
            modLoc("block/" + Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block.get())).getPath() + "_bottom"));
    }

    private void buttonItem(@NotNull RegistryObject<Block> block, @NotNull RegistryObject<Block> baseBlock) {
        this.withExistingParent(Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block.get())).getPath(), mcLoc("block/button_inventory"))
            .texture("texture", new ResourceLocation(SomeRandomThings.MOD_ID, "block/" +
                Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(baseBlock.get())).getPath()));
    }

    private void wallItem(@NotNull RegistryObject<Block> block, @NotNull RegistryObject<Block> baseBlock) {
        this.withExistingParent(Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block.get())).getPath(), mcLoc("block/wall_inventory"))
            .texture("wall", new ResourceLocation(SomeRandomThings.MOD_ID, "block/" +
                Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(baseBlock.get())).getPath()));
    }
}

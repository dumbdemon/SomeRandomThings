package com.thesuperbutt.srt.datagen;

import com.thesuperbutt.srt.SomeRandomThings;
import com.thesuperbutt.srt.block.ModBlocks;
import com.thesuperbutt.srt.block.custom.TwoBlockCrop;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, SomeRandomThings.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.SAPPHIRE_BLOCK);
        blockWithItem(ModBlocks.RAW_SAPPHIRE_BLOCK);
        blockWithItem(ModBlocks.SOUND_BLOCK);

        blockWithItem(ModBlocks.SAPPHIRE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_SAPPHIRE_ORE);
        blockWithItem(ModBlocks.NETHER_SAPPHIRE_ORE);
        blockWithItem(ModBlocks.END_STONE_SAPPHIRE_ORE);

        stairsBlock((StairBlock) ModBlocks.SAPPHIRE_STAIRS.get(), blockTexture(ModBlocks.SAPPHIRE_BLOCK.get()));
        slabBlock((SlabBlock) ModBlocks.SAPPHIRE_SLAB.get(), blockTexture(ModBlocks.SAPPHIRE_BLOCK.get()), blockTexture(ModBlocks.SAPPHIRE_BLOCK.get()));

        buttonBlock((ButtonBlock) ModBlocks.SAPPHIRE_BUTTON.get(), blockTexture(ModBlocks.SAPPHIRE_BLOCK.get()));
        pressurePlateBlock((PressurePlateBlock) ModBlocks.SAPPHIRE_PRESSURE_PLATE.get(), blockTexture(ModBlocks.SAPPHIRE_BLOCK.get()));

        fenceBlock((FenceBlock) ModBlocks.SAPPHIRE_FENCE.get(), blockTexture(ModBlocks.SAPPHIRE_BLOCK.get()));
        fenceGateBlock((FenceGateBlock) ModBlocks.SAPPHIRE_FENCE_GATE.get(), blockTexture(ModBlocks.SAPPHIRE_BLOCK.get()));
        wallBlock((WallBlock) ModBlocks.SAPPHIRE_WALL.get(), blockTexture(ModBlocks.SAPPHIRE_BLOCK.get()));

        doorBlockWithRenderType((DoorBlock) ModBlocks.SAPPHIRE_DOOR.get(), modLoc("block/sapphire_door_bottom"), modLoc("block/sapphire_door_top"), "cutout");
        trapdoorBlockWithRenderType((TrapDoorBlock) ModBlocks.SAPPHIRE_TRAPDOOR.get(), modLoc("block/sapphire_trapdoor"), true, "cutout");

        make2BlockCrop((TwoBlockCrop) ModBlocks.STRAWBERRY_CROP.get(), "strawberry_stage", "strawberry_stage");
        make2BlockCrop((TwoBlockCrop) ModBlocks.CORN_CROP.get(), "corn_stage_", "corn_stage_");

        simpleBlockWithItem(ModBlocks.CATMINT.get(), models().cross(blockTexture(ModBlocks.CATMINT.get()).getPath(),
            blockTexture(ModBlocks.CATMINT.get())).renderType("cutout"));
        simpleBlockWithItem(ModBlocks.POTTED_CATMINT.get(), models().singleTexture("potted_catmint", new ResourceLocation("flower_pot_cross"), "plant",
            blockTexture(ModBlocks.CATMINT.get())).renderType("cutout"));

        simpleBlockWithItem(ModBlocks.GEM_POLISHING_STATION.get(),
            new ModelFile.UncheckedModelFile(modLoc("block/gem_polishing_station")));
    }

    public void make2BlockCrop(TwoBlockCrop block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> twoBlockCropStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel @NotNull [] twoBlockCropStates(@NotNull BlockState state, @NotNull TwoBlockCrop block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(block.getAgeProperty()),
            new ResourceLocation(SomeRandomThings.MOD_ID, "block/" + textureName + state.getValue(block.getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private void blockWithItem(@NotNull RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}

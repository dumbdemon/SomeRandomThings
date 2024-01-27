package com.thesuperbutt.srt.datagen;

import com.thesuperbutt.srt.SomeRandomThings;
import com.thesuperbutt.srt.block.SomeRandomBlocks;
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
        blockWithItem(SomeRandomBlocks.SAPPHIRE_BLOCK);
        blockWithItem(SomeRandomBlocks.RAW_SAPPHIRE_BLOCK);
        blockWithItem(SomeRandomBlocks.SOUND_BLOCK);

        blockWithItem(SomeRandomBlocks.SAPPHIRE_ORE);
        blockWithItem(SomeRandomBlocks.DEEPSLATE_SAPPHIRE_ORE);
        blockWithItem(SomeRandomBlocks.NETHER_SAPPHIRE_ORE);
        blockWithItem(SomeRandomBlocks.END_STONE_SAPPHIRE_ORE);

        stairsBlock((StairBlock) SomeRandomBlocks.SAPPHIRE_STAIRS.get(), blockTexture(SomeRandomBlocks.SAPPHIRE_BLOCK.get()));
        slabBlock((SlabBlock) SomeRandomBlocks.SAPPHIRE_SLAB.get(), blockTexture(SomeRandomBlocks.SAPPHIRE_BLOCK.get()), blockTexture(SomeRandomBlocks.SAPPHIRE_BLOCK.get()));

        buttonBlock((ButtonBlock) SomeRandomBlocks.SAPPHIRE_BUTTON.get(), blockTexture(SomeRandomBlocks.SAPPHIRE_BLOCK.get()));
        pressurePlateBlock((PressurePlateBlock) SomeRandomBlocks.SAPPHIRE_PRESSURE_PLATE.get(), blockTexture(SomeRandomBlocks.SAPPHIRE_BLOCK.get()));

        fenceBlock((FenceBlock) SomeRandomBlocks.SAPPHIRE_FENCE.get(), blockTexture(SomeRandomBlocks.SAPPHIRE_BLOCK.get()));
        fenceGateBlock((FenceGateBlock) SomeRandomBlocks.SAPPHIRE_FENCE_GATE.get(), blockTexture(SomeRandomBlocks.SAPPHIRE_BLOCK.get()));
        wallBlock((WallBlock) SomeRandomBlocks.SAPPHIRE_WALL.get(), blockTexture(SomeRandomBlocks.SAPPHIRE_BLOCK.get()));

        doorBlockWithRenderType((DoorBlock) SomeRandomBlocks.SAPPHIRE_DOOR.get(), modLoc("block/sapphire_door_bottom"), modLoc("block/sapphire_door_top"), "cutout");
        trapdoorBlockWithRenderType((TrapDoorBlock) SomeRandomBlocks.SAPPHIRE_TRAPDOOR.get(), modLoc("block/sapphire_trapdoor"), true, "cutout");

        make2BlockCrop((TwoBlockCrop) SomeRandomBlocks.STRAWBERRY_CROP.get(), "strawberry_stage", "strawberry_stage");
        make2BlockCrop((TwoBlockCrop) SomeRandomBlocks.CORN_CROP.get(), "corn_stage_", "corn_stage_");

        simpleBlockWithItem(SomeRandomBlocks.CATMINT.get(), models().cross(blockTexture(SomeRandomBlocks.CATMINT.get()).getPath(),
            blockTexture(SomeRandomBlocks.CATMINT.get())).renderType("cutout"));
        simpleBlockWithItem(SomeRandomBlocks.POTTED_CATMINT.get(), models().singleTexture("potted_catmint", new ResourceLocation("flower_pot_cross"), "plant",
            blockTexture(SomeRandomBlocks.CATMINT.get())).renderType("cutout"));

        simpleBlockWithItem(SomeRandomBlocks.GEM_POLISHING_STATION.get(),
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

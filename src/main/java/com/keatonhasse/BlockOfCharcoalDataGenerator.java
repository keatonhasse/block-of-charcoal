package com.keatonhasse;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.*;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.item.Items;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.registry.Registry;

import java.util.function.Consumer;

public class BlockOfCharcoalDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		fabricDataGenerator.addProvider(LanguageProvider::new);
		fabricDataGenerator.addProvider(LootTableProvider::new);
		fabricDataGenerator.addProvider(ModelProvider::new);
		fabricDataGenerator.addProvider(RecipeProvider::new);
		fabricDataGenerator.addProvider(TagProvider::new);
	}

	private static class LanguageProvider extends FabricLanguageProvider {
		private LanguageProvider(FabricDataGenerator dataGenerator) {
			super(dataGenerator, "en_us");
		}

		@Override
		public void generateTranslations(TranslationBuilder translationBuilder) {
			translationBuilder.add(BlockOfCharcoal.CHARCOAL_BLOCK, "Block of Charcoal");
		}
	}

	private static class LootTableProvider extends FabricBlockLootTableProvider {

		protected LootTableProvider(FabricDataGenerator dataGenerator) {
			super(dataGenerator);
		}

		@Override
		protected void generateBlockLootTables() {
			addDrop(BlockOfCharcoal.CHARCOAL_BLOCK, drops(BlockOfCharcoal.CHARCOAL_BLOCK));
		}
	}

	private static class ModelProvider extends FabricModelProvider {
		private ModelProvider(FabricDataGenerator dataGenerator) {
			super(dataGenerator);
		}

		@Override
		public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
			blockStateModelGenerator.registerSimpleCubeAll(BlockOfCharcoal.CHARCOAL_BLOCK);
		}

		@Override
		public void generateItemModels(ItemModelGenerator itemModelGenerator) { }
	}

	private static class RecipeProvider extends FabricRecipeProvider {
		private RecipeProvider(FabricDataGenerator dataGenerator) {
			super(dataGenerator);
		}

		@Override
		protected void generateRecipes(Consumer<RecipeJsonProvider> exporter) {
			offerReversibleCompactingRecipes(exporter, Items.CHARCOAL, BlockOfCharcoal.CHARCOAL_BLOCK);
		}
	}

	private static class TagProvider extends FabricTagProvider<Block> {
		private TagProvider(FabricDataGenerator  dataGenerator) {
			super(dataGenerator, Registry.BLOCK);
		}

		@Override
		protected void generateTags() {
			getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
					.add(BlockOfCharcoal.CHARCOAL_BLOCK);
		}
	}
}

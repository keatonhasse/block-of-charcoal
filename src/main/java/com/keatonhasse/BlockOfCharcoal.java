package com.keatonhasse;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockOfCharcoal implements ModInitializer {
	public static final Block CHARCOAL_BLOCK = new Block(FabricBlockSettings.copyOf(Blocks.COAL_BLOCK));
	public static final Identifier IDENTIFIER = new Identifier("block-of-charcoal", "charcoal_block");

	@Override
	public void onInitialize() {
		Registry.register(Registry.BLOCK, IDENTIFIER, CHARCOAL_BLOCK);
		Registry.register(Registry.ITEM, IDENTIFIER, new BlockItem(CHARCOAL_BLOCK, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
		FuelRegistry.INSTANCE.add(CHARCOAL_BLOCK, 16000);
		FlammableBlockRegistry.getDefaultInstance().add(CHARCOAL_BLOCK, 5, 5);
	}
}

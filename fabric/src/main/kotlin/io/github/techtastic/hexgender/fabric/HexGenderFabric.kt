package io.github.techtastic.hexgender.fabric

import at.petrak.hexcasting.common.lib.hex.HexActions
import io.github.techtastic.hexgender.HexGender.init
import io.github.techtastic.hexgender.casting.PatternRegistry
import net.fabricmc.api.ModInitializer
import net.minecraft.core.Registry

object HexGenderFabric: ModInitializer {
    override fun onInitialize() {
        init()

        PatternRegistry.registerCallback { key, entry ->
            Registry.register(HexActions.REGISTRY, key, entry.get())
        }
    }
}
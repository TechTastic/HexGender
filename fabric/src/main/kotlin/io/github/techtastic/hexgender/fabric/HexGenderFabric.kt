package io.github.techtastic.hexgender.fabric

import io.github.techtastic.hexgender.HexGender.init
import net.fabricmc.api.ModInitializer

object HexGenderFabric: ModInitializer {
    override fun onInitialize() {
        init()
    }
}
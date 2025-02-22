package io.github.techtastic.hexgender

import net.minecraft.resources.ResourceLocation

object HexGender {
    const val MOD_ID = "hexgender"

    fun init() {
    }

    fun id(path: String) = ResourceLocation(MOD_ID, path)
}
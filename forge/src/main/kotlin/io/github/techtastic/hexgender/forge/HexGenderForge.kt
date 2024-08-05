package io.github.techtastic.hexgender.forge

import dev.architectury.platform.forge.EventBuses
import io.github.techtastic.hexgender.HexGender.MOD_ID
import io.github.techtastic.hexgender.HexGender.init
import net.minecraftforge.fml.common.Mod
import thedarkcolour.kotlinforforge.KotlinModLoadingContext

@Mod(MOD_ID)
object HexGenderForge {
    init {
        EventBuses.registerModEventBus(MOD_ID, KotlinModLoadingContext.get().getKEventBus())

        init()
    }
}
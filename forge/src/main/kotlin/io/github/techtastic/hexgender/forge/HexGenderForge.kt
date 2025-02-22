package io.github.techtastic.hexgender.forge

import at.petrak.hexcasting.common.lib.HexRegistries
import dev.architectury.platform.forge.EventBuses
import io.github.techtastic.hexgender.HexGender.MOD_ID
import io.github.techtastic.hexgender.HexGender.init
import io.github.techtastic.hexgender.casting.PatternRegistry
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.registries.RegisterEvent
import thedarkcolour.kotlinforforge.KotlinModLoadingContext

@Mod(MOD_ID)
object HexGenderForge {
    init {
        val bus = KotlinModLoadingContext.get().getKEventBus()
        EventBuses.registerModEventBus(MOD_ID, bus)

        bus.addListener(this::registerPatterns)

        init()
    }

    private fun registerPatterns(event: RegisterEvent) {
        PatternRegistry.registerCallback { key, entry -> event.register(HexRegistries.ACTION, key, entry) }
    }
}
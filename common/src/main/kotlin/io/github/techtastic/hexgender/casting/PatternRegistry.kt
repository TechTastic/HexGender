package io.github.techtastic.hexgender.casting

import at.petrak.hexcasting.api.casting.ActionRegistryEntry
import at.petrak.hexcasting.api.casting.math.HexDir
import at.petrak.hexcasting.api.casting.math.HexPattern
import at.petrak.hexcasting.common.lib.HexRegistries
import com.wildfire.main.GenderPlayer
import dev.architectury.registry.registries.DeferredRegister
import io.github.techtastic.hexgender.HexGender.MOD_ID
import io.github.techtastic.hexgender.casting.spells.OpGenderTransition

object PatternRegistry {
    private val REGISTRY = DeferredRegister.create(MOD_ID, HexRegistries.ACTION)

    val FEMALE_TRANSITION = REGISTRY.register("female_transition") { ActionRegistryEntry(
        HexPattern.fromAngles("qqqqqewdedw", HexDir.EAST),
        OpGenderTransition(GenderPlayer.Gender.FEMALE)
    )}

    val MALE_TRANSITION = REGISTRY.register("male_transition") { ActionRegistryEntry(
        HexPattern.fromAngles("eeeeeqwaqaeaq", HexDir.SOUTH_EAST),
        OpGenderTransition(GenderPlayer.Gender.MALE)
    )}

    val OTHER_TRANSITION = REGISTRY.register("other_transition") { ActionRegistryEntry(
        HexPattern.fromAngles("eeeeeqqedqde", HexDir.NORTH_EAST),
        OpGenderTransition(GenderPlayer.Gender.OTHER)
    )}

    fun register() {
        REGISTRY.register()
    }
}
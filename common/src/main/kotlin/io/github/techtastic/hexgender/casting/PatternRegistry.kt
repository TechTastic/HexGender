package io.github.techtastic.hexgender.casting

import at.petrak.hexcasting.api.casting.ActionRegistryEntry
import at.petrak.hexcasting.api.casting.math.HexDir
import at.petrak.hexcasting.api.casting.math.HexPattern
import at.petrak.hexcasting.common.lib.HexRegistries
import com.wildfire.main.GenderPlayer
import dev.architectury.registry.registries.DeferredRegister
import io.github.techtastic.hexgender.HexGender.MOD_ID
import io.github.techtastic.hexgender.casting.spells.*
import javax.swing.Action

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
    val GET_GENDER = REGISTRY.register("get_gender") { ActionRegistryEntry(
        HexPattern.fromAngles("qqqqqeeqqqq", HexDir.EAST),
        OpGetGender
    )}



    val GET_BUST_SIZE = REGISTRY.register("get_bust_size") { ActionRegistryEntry(
        HexPattern.fromAngles("wqqqdqqqw", HexDir.SOUTH_WEST),
        OpGetBustSize
    )}
    val SET_BUST_SIZE = REGISTRY.register("set_bust_size") { ActionRegistryEntry(
        HexPattern.fromAngles("wqqqdqqqwqaedea", HexDir.SOUTH_WEST),
        OpSetBustSize
    )}



    val GET_BOUNCINESS = REGISTRY.register("get_bounciness") { ActionRegistryEntry(
        HexPattern.fromAngles("awewaawew", HexDir.EAST),
        OpGetBounciness
    )}
    val SET_BOUNCINESS = REGISTRY.register("set_bounciness") { ActionRegistryEntry(
        HexPattern.fromAngles("dwqwddwqw", HexDir.WEST),
        OpSetBounciness
    )}



    val GET_FLOPINESS = REGISTRY.register("get_floppiness") { ActionRegistryEntry(
        HexPattern.fromAngles("qeqqqdqqqeqaqdwwdq", HexDir.SOUTH_WEST),
        OpGetBounciness
    )}
    val SET_FLOPINESS = REGISTRY.register("set_floppiness") { ActionRegistryEntry(
        HexPattern.fromAngles("eawwaedeqeeeaeeeqe", HexDir.SOUTH_EAST),
        OpSetBounciness
    )}



    val GET_PHYSICS = REGISTRY.register("get_physics") { ActionRegistryEntry(
        HexPattern.fromAngles("wqqqwaawqqqw", HexDir.SOUTH_WEST),
        OpGetPhysics
    )}
    val SET_PHYSICS = REGISTRY.register("set_physics") { ActionRegistryEntry(
        HexPattern.fromAngles("wqqqqddqqqqw", HexDir.SOUTH_WEST),
        OpSetPhysics
    )}



    val GET_CLEAVAGE = REGISTRY.register("get_cleavage") { ActionRegistryEntry(
        HexPattern.fromAngles("wqqqeeqqqw", HexDir.SOUTH_WEST),
        OpGetCleavage
    )}
    val SET_CLEAVAGE = REGISTRY.register("set_cleavage") { ActionRegistryEntry(
        HexPattern.fromAngles("weeeqqeeew", HexDir.SOUTH_EAST),
        OpSetCleavage
    )}



    val GET_BREAST_OFFSETS = REGISTRY.register("get_breast_offsets") { ActionRegistryEntry(
        HexPattern.fromAngles("wawqqqeqdqqqwaw", HexDir.NORTH_WEST),
        OpGetBreastOffset
    )}
    val SET_BREAST_OFFSETS = REGISTRY.register("set_breast_offsets") { ActionRegistryEntry(
        HexPattern.fromAngles("eeewdwqqwwdweee", HexDir.SOUTH_WEST),
        OpSetBreastOffset
    )}



    val GET_UNIBOOB = REGISTRY.register("get_uniboob") { ActionRegistryEntry(
        HexPattern.fromAngles("wqqwwqqw", HexDir.SOUTH_WEST),
        OpGetUniboob
    )}
    val SET_UNIBOOB = REGISTRY.register("set_uniboob") { ActionRegistryEntry(
        HexPattern.fromAngles("weewweew", HexDir.SOUTH_EAST),
        OpSetUniboob
    )}

    fun register() {
        REGISTRY.register()
    }
}
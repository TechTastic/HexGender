package io.github.techtastic.hexgender.casting

import at.petrak.hexcasting.api.casting.ActionRegistryEntry
import at.petrak.hexcasting.api.casting.math.HexDir
import at.petrak.hexcasting.api.casting.math.HexPattern
import com.wildfire.main.GenderPlayer
import io.github.techtastic.hexgender.HexGender.id
import io.github.techtastic.hexgender.casting.spells.*
import net.minecraft.resources.ResourceLocation
import java.util.function.BiConsumer
import java.util.function.Supplier

object PatternRegistry {
    private val ACTIONS = mutableMapOf<ResourceLocation, Supplier<ActionRegistryEntry>>()

    val FEMALE_TRANSITION = register("female_transition") { ActionRegistryEntry(
        HexPattern.fromAngles("qqqqqewdedw", HexDir.EAST),
        OpGenderTransition(GenderPlayer.Gender.FEMALE)
    )}
    val MALE_TRANSITION = register("male_transition") { ActionRegistryEntry(
        HexPattern.fromAngles("eeeeeqwaqaeaq", HexDir.SOUTH_EAST),
        OpGenderTransition(GenderPlayer.Gender.MALE)
    )}
    val OTHER_TRANSITION = register("other_transition") { ActionRegistryEntry(
        HexPattern.fromAngles("eeeeeqqedqde", HexDir.NORTH_EAST),
        OpGenderTransition(GenderPlayer.Gender.OTHER)
    )}
    val GET_GENDER = register("get_gender") { ActionRegistryEntry(
        HexPattern.fromAngles("qqqqqeeqqqq", HexDir.EAST),
        OpGetGender
    )}



    val GET_BUST_SIZE = register("get_bust_size") { ActionRegistryEntry(
        HexPattern.fromAngles("wqqqdqqqw", HexDir.SOUTH_WEST),
        OpGetBustSize
    )}
    val SET_BUST_SIZE = register("set_bust_size") { ActionRegistryEntry(
        HexPattern.fromAngles("wqqqdqqqwqaedea", HexDir.SOUTH_WEST),
        OpSetBustSize
    )}



    val GET_BOUNCINESS = register("get_bounciness") { ActionRegistryEntry(
        HexPattern.fromAngles("awewaawew", HexDir.EAST),
        OpGetBounciness
    )}
    val SET_BOUNCINESS = register("set_bounciness") { ActionRegistryEntry(
        HexPattern.fromAngles("dwqwddwqw", HexDir.WEST),
        OpSetBounciness
    )}



    val GET_FLOPINESS = register("get_floppiness") { ActionRegistryEntry(
        HexPattern.fromAngles("qeqqqdqqqeqaqdwwdq", HexDir.SOUTH_WEST),
        OpGetBounciness
    )}
    val SET_FLOPINESS = register("set_floppiness") { ActionRegistryEntry(
        HexPattern.fromAngles("eawwaedeqeeeaeeeqe", HexDir.SOUTH_EAST),
        OpSetBounciness
    )}



    val GET_PHYSICS = register("get_physics") { ActionRegistryEntry(
        HexPattern.fromAngles("wqqqwaawqqqw", HexDir.SOUTH_WEST),
        OpGetPhysics
    )}
    val SET_PHYSICS = register("set_physics") { ActionRegistryEntry(
        HexPattern.fromAngles("wqqqqddqqqqw", HexDir.SOUTH_WEST),
        OpSetPhysics
    )}



    val GET_CLEAVAGE = register("get_cleavage") { ActionRegistryEntry(
        HexPattern.fromAngles("wqqqeeqqqw", HexDir.SOUTH_WEST),
        OpGetCleavage
    )}
    val SET_CLEAVAGE = register("set_cleavage") { ActionRegistryEntry(
        HexPattern.fromAngles("weeeqqeeew", HexDir.SOUTH_EAST),
        OpSetCleavage
    )}



    val GET_BREAST_OFFSETS = register("get_breast_offsets") { ActionRegistryEntry(
        HexPattern.fromAngles("wawqqqeqdqqqwaw", HexDir.NORTH_WEST),
        OpGetBreastOffset
    )}
    val SET_BREAST_OFFSETS = register("set_breast_offsets") { ActionRegistryEntry(
        HexPattern.fromAngles("eeewdwqqwwdweee", HexDir.SOUTH_WEST),
        OpSetBreastOffset
    )}



    val GET_UNIBOOB = register("get_uniboob") { ActionRegistryEntry(
        HexPattern.fromAngles("wqqwwqqw", HexDir.SOUTH_WEST),
        OpGetUniboob
    )}
    val SET_UNIBOOB = register("set_uniboob") { ActionRegistryEntry(
        HexPattern.fromAngles("weewweew", HexDir.SOUTH_EAST),
        OpSetUniboob
    )}

    fun register(name: String, action: Supplier<ActionRegistryEntry>): Supplier<ActionRegistryEntry> {
        ACTIONS[id(name)] = action
        return action
    }

    fun registerCallback(callback: BiConsumer<ResourceLocation, Supplier<ActionRegistryEntry>>) {
        ACTIONS.forEach(callback::accept)
    }
}
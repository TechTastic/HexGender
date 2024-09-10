package io.github.techtastic.hexgender.casting.spells

import at.petrak.hexcasting.api.casting.*
import at.petrak.hexcasting.api.casting.castables.ConstMediaAction
import at.petrak.hexcasting.api.casting.castables.SpellAction
import at.petrak.hexcasting.api.casting.eval.CastingEnvironment
import at.petrak.hexcasting.api.casting.iota.DoubleIota
import at.petrak.hexcasting.api.casting.iota.Iota
import at.petrak.hexcasting.api.casting.mishaps.MishapImmuneEntity
import com.wildfire.main.GenderPlayer
import com.wildfire.main.WildfireGender
import net.minecraft.server.level.ServerPlayer
import net.minecraft.world.entity.Entity
import kotlin.math.abs

object OpSetFloppiness: SpellAction {
    override val argc: Int
        get() = 1

    override fun execute(args: List<Iota>, env: CastingEnvironment): SpellAction.Result {
        val floppiness = args.getPositiveDoubleUnderInclusive(0, 1.0, argc)
        val player = env.castingEntity as? ServerPlayer ?: throw MishapImmuneEntity(env.castingEntity as Entity)
        val genderPlayer = WildfireGender.getOrAddPlayerById(player.uuid)

        return SpellAction.Result(Spell(genderPlayer, floppiness), abs(genderPlayer.floppiness - floppiness).toLong(), listOf(ParticleSpray.burst(player.eyePosition, 2.0)))
    }

    class Spell(val player: GenderPlayer, val floppiness: Double): RenderedSpell {
        override fun cast(env: CastingEnvironment) {
            player.updateFloppiness(floppiness.toFloat())
            GenderPlayer.saveGenderInfo(player)
        }
    }
}
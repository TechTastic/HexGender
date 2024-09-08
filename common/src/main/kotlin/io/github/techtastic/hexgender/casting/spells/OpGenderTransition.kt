package io.github.techtastic.hexgender.casting.spells

import at.petrak.hexcasting.api.casting.ParticleSpray
import at.petrak.hexcasting.api.casting.RenderedSpell
import at.petrak.hexcasting.api.casting.castables.SpellAction
import at.petrak.hexcasting.api.casting.eval.CastingEnvironment
import at.petrak.hexcasting.api.casting.iota.Iota
import at.petrak.hexcasting.api.casting.mishaps.MishapImmuneEntity
import com.wildfire.main.GenderPlayer
import com.wildfire.main.WildfireGender
import net.minecraft.server.level.ServerPlayer
import net.minecraft.world.entity.Entity

class OpGenderTransition(val gender: GenderPlayer.Gender): SpellAction {
    override val argc: Int
        get() = 0

    override fun execute(args: List<Iota>, env: CastingEnvironment): SpellAction.Result {
        val player = env.castingEntity as? ServerPlayer ?: throw MishapImmuneEntity(env.castingEntity as Entity)
        val genderPlayer = WildfireGender.getOrAddPlayerById(player.uuid)

        return SpellAction.Result(Spell(genderPlayer, gender), 0L, listOf(ParticleSpray.cloud(player.position().add(0.0, player.eyeHeight / 2.0, 0.0), 1.0)))
    }

    private class Spell(val player: GenderPlayer, val gender: GenderPlayer.Gender): RenderedSpell {
        override fun cast(env: CastingEnvironment) {
            player.updateGender(gender)
        }
    }
}
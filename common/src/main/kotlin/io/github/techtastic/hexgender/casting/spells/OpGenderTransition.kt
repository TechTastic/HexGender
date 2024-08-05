package io.github.techtastic.hexgender.casting.spells

import at.petrak.hexcasting.api.casting.RenderedSpell
import at.petrak.hexcasting.api.casting.castables.SpellAction
import at.petrak.hexcasting.api.casting.eval.CastingEnvironment
import at.petrak.hexcasting.api.casting.getPlayer
import at.petrak.hexcasting.api.casting.iota.Iota
import at.petrak.hexcasting.api.casting.mishaps.MishapOthersName
import at.petrak.hexcasting.api.misc.MediaConstants
import com.wildfire.main.GenderPlayer
import com.wildfire.main.WildfireGender

class OpGenderTransition(val gender: GenderPlayer.Gender): SpellAction {
    override val argc: Int
        get() = 1

    override fun execute(args: List<Iota>, env: CastingEnvironment): SpellAction.Result {
        val player = args.getPlayer(0, argc)
        if (player.uuid != env.castingEntity?.uuid) throw MishapOthersName(player)
        val genderPlayer = WildfireGender.getOrAddPlayerById(player.uuid)
        return SpellAction.Result(Spell(genderPlayer, gender), MediaConstants.DUST_UNIT, listOf())
    }

    private class Spell(val player: GenderPlayer, val gender: GenderPlayer.Gender): RenderedSpell {
        override fun cast(env: CastingEnvironment) {
            player.updateGender(gender)
        }
    }
}
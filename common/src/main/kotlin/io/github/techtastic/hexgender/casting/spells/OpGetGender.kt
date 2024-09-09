package io.github.techtastic.hexgender.casting.spells

import at.petrak.hexcasting.api.casting.castables.ConstMediaAction
import at.petrak.hexcasting.api.casting.eval.CastingEnvironment
import at.petrak.hexcasting.api.casting.getPlayer
import at.petrak.hexcasting.api.casting.iota.DoubleIota
import at.petrak.hexcasting.api.casting.iota.Iota
import com.wildfire.main.WildfireGender

object OpGetGender : ConstMediaAction {
    override val argc: Int
        get() = 1

    override fun execute(args: List<Iota>, env: CastingEnvironment): List<Iota> {
        val player = args.getPlayer(0, argc)
        val gender = WildfireGender.getOrAddPlayerById(player.uuid).gender
        return listOf(DoubleIota(gender.ordinal.toDouble()))
    }
}
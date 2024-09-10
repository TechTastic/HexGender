package io.github.techtastic.hexgender.casting.spells

import at.petrak.hexcasting.api.casting.castables.ConstMediaAction
import at.petrak.hexcasting.api.casting.eval.CastingEnvironment
import at.petrak.hexcasting.api.casting.getPlayer
import at.petrak.hexcasting.api.casting.iota.DoubleIota
import at.petrak.hexcasting.api.casting.iota.Iota
import com.wildfire.main.WildfireGender

object OpGetFloppiness: ConstMediaAction {
    override val argc: Int
        get() = 1

    override fun execute(args: List<Iota>, env: CastingEnvironment): List<Iota> {
        val player = args.getPlayer(0, OpGetGender.argc)
        val size = WildfireGender.getOrAddPlayerById(player.uuid).floppiness
        return listOf(DoubleIota(size.toDouble()))
    }
}
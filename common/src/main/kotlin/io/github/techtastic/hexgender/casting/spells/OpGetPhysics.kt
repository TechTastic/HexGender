package io.github.techtastic.hexgender.casting.spells

import at.petrak.hexcasting.api.casting.castables.ConstMediaAction
import at.petrak.hexcasting.api.casting.eval.CastingEnvironment
import at.petrak.hexcasting.api.casting.getPlayer
import at.petrak.hexcasting.api.casting.iota.BooleanIota
import at.petrak.hexcasting.api.casting.iota.Iota
import com.wildfire.main.WildfireGender

object OpGetPhysics: ConstMediaAction {
    override val argc: Int
        get() = 1

    override fun execute(args: List<Iota>, env: CastingEnvironment): List<Iota> {
        val player = args.getPlayer(0, OpGetGender.argc)
        val physics = WildfireGender.getOrAddPlayerById(player.uuid).hasBreastPhysics()
        return listOf(BooleanIota(physics))
    }
}
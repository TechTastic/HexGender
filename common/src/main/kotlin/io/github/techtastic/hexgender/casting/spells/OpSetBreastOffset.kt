package io.github.techtastic.hexgender.casting.spells

import at.petrak.hexcasting.api.casting.*
import at.petrak.hexcasting.api.casting.castables.ConstMediaAction
import at.petrak.hexcasting.api.casting.castables.SpellAction
import at.petrak.hexcasting.api.casting.eval.CastingEnvironment
import at.petrak.hexcasting.api.casting.iota.DoubleIota
import at.petrak.hexcasting.api.casting.iota.Iota
import at.petrak.hexcasting.api.casting.iota.Vec3Iota
import at.petrak.hexcasting.api.casting.mishaps.MishapImmuneEntity
import at.petrak.hexcasting.api.casting.mishaps.MishapInvalidIota
import com.wildfire.main.GenderPlayer
import com.wildfire.main.WildfireGender
import net.minecraft.server.level.ServerPlayer
import net.minecraft.world.entity.Entity
import net.minecraft.world.phys.AABB
import net.minecraft.world.phys.Vec3
import kotlin.math.abs

object OpSetBreastOffset: SpellAction {
    override val argc: Int
        get() = 1

    override fun execute(args: List<Iota>, env: CastingEnvironment): SpellAction.Result {
        val offsets = args.getVec3(0, argc)
        val limits = AABB(Vec3(-1.0, -1.0, -1.0), Vec3(1.0, 1.0, 0.0))
        if (!limits.contains(offsets)) throw MishapInvalidIota.ofType(Vec3Iota(offsets), 0, "vector")

        val player = env.castingEntity as? ServerPlayer ?: throw MishapImmuneEntity(env.castingEntity as Entity)
        val genderPlayer = WildfireGender.getOrAddPlayerById(player.uuid)
        val breasts = genderPlayer.breasts
        val currentOffset = Vec3(breasts.xOffset.toDouble(), breasts.yOffset.toDouble(), breasts.zOffset.toDouble())

        return SpellAction.Result(Spell(genderPlayer, offsets), currentOffset.distanceToSqr(offsets).toLong(), listOf(ParticleSpray.burst(player.eyePosition, 2.0)))
    }

    class Spell(val player: GenderPlayer, val offsets: Vec3): RenderedSpell {
        override fun cast(env: CastingEnvironment) {
            player.breasts.updateXOffset(offsets.x.toFloat())
            player.breasts.updateYOffset(offsets.y.toFloat())
            player.breasts.updateZOffset(offsets.z.toFloat())
            GenderPlayer.saveGenderInfo(player)
        }
    }
}
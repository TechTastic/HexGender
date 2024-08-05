package io.github.techtastic.hexgender.mixin;

import at.petrak.hexcasting.api.casting.iota.IotaType;
import at.petrak.hexcasting.common.lib.hex.HexActions;
import io.github.techtastic.hexgender.casting.PatternRegistry;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.BiConsumer;

@Mixin(HexActions.class)
public class MixinInjectPatternRegistration {
    @Inject(method = "register", at = @At("RETURN"), remap = false)
    private static void injectRegistration(BiConsumer<IotaType<?>, ResourceLocation> r, CallbackInfo ci) {
        PatternRegistry.INSTANCE.register();
    }
}

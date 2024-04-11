package me.tryfle.togglesprint.mixin;

import me.tryfle.togglesprint.Main;
import me.tryfle.togglesprint.event.TickEvent;
import me.tryfle.togglesprint.listener.TickListener;
import net.minecraft.client.Minecraft;
import net.weavemc.api.event.EventBus;
import org.lwjgl.input.Keyboard;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MinecraftMixin {

    @Unique
    private TickListener toggleSprint$tickListener = new TickListener();

    @Inject(method = "dispatchKeypresses", at = @At("HEAD"))
    public void onKey(CallbackInfo ci) {
        if (Keyboard.getEventKey() == Keyboard.KEY_I && Keyboard.isKeyDown(Keyboard.KEY_I)) {
            Main.Companion.setToggled(!Main.Companion.getToggled());
            if (Main.Companion.getToggled()) {
               EventBus.subscribe(toggleSprint$tickListener);
            } else {
                EventBus.unsubscribe(toggleSprint$tickListener);
            }
        }
    }

    @Inject(method = "runTick", at = @At("HEAD"))
    public void onTick(CallbackInfo ci) {
        if (Main.Companion.getToggled()) {
            EventBus.postEvent(new TickEvent());
        }
    }
}

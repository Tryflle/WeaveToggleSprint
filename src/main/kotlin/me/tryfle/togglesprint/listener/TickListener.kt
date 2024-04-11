package me.tryfle.togglesprint.listener

import me.tryfle.togglesprint.event.TickEvent
import net.minecraft.client.Minecraft
import net.minecraft.client.settings.KeyBinding
import net.weavemc.api.event.SubscribeEvent

class TickListener {

    @SubscribeEvent
    fun onTick(e: TickEvent) {
        assert (Minecraft.getMinecraft().thePlayer != null)
        KeyBinding.setKeyBindState(Minecraft.getMinecraft().gameSettings.keyBindSprint.keyCode, true)
    }
}
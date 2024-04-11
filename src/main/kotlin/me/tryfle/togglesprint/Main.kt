package me.tryfle.togglesprint

import net.weavemc.api.ModInitializer
import java.lang.instrument.Instrumentation

class Main : ModInitializer {

    override fun preInit(inst: Instrumentation) {
        println("[ToggleSprint] Loaded.")
    }

    companion object {
        var toggled = false
    }
}
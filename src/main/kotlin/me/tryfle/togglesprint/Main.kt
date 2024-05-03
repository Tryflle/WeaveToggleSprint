package me.tryfle.togglesprint

import net.weavemc.api.ModInitializer
import java.lang.instrument.Instrumentation

class Main : ModInitializer {
    override fun init() {
        println("[ToggleSprint] Loaded.")
    }

    override fun preInit(inst: Instrumentation) {}

    companion object {
        var toggled = false
    }
}

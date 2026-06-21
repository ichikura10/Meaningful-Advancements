package io.github.ichikura10.meaningfulAdvancements

import io.github.ichikura10.meaningfulAdvancements.attachment.ModAttachments
import io.github.ichikura10.meaningfulAdvancements.event.ModEvents
import io.github.ichikura10.meaningfulAdvancements.item.ModItems
import net.minecraft.client.Minecraft
import net.neoforged.fml.common.Mod
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent
import net.neoforged.fml.event.lifecycle.FMLDedicatedServerSetupEvent
import net.neoforged.neoforge.common.NeoForge
import thedarkcolour.kotlinforforge.neoforge.forge.MOD_BUS
import thedarkcolour.kotlinforforge.neoforge.forge.runForDist

@Mod(MeaningfulAdvancements.ID)
object MeaningfulAdvancements {
    const val ID = "meaningful_advancements"

    init {
        ModAttachments.register(MOD_BUS)
        ModItems.register(MOD_BUS)

        MOD_BUS.addListener(::onCommonSetup)

        NeoForge.EVENT_BUS.register(ModEvents)

        val obj = runForDist(clientTarget = {
            MOD_BUS.addListener(::onClientSetup)
            Minecraft.getInstance()
        }, serverTarget = {
            MOD_BUS.addListener(::onServerSetup)
            "test"
        })

        println(obj)
    }

    private fun onClientSetup(event: FMLClientSetupEvent) {
    }

    private fun onServerSetup(event: FMLDedicatedServerSetupEvent) {
    }

    fun onCommonSetup(event: FMLCommonSetupEvent) {
    }
}

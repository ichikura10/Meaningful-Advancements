package io.github.ichikura10.meaningfulAdvancements.event

import io.github.ichikura10.meaningfulAdvancements.attachment.ModAttachments
import net.minecraft.world.entity.player.Player
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.neoforge.event.entity.player.AdvancementEvent

object ModEvents {

    @SubscribeEvent
    fun onAdvancementEarn(event: AdvancementEvent.AdvancementEarnEvent) {
        val player: Player = event.entity
        println(player.name.string + "earned" + event.advancement.id)

        val current = player.getData(ModAttachments.ADVANCEMENT_POINT.get())
        player.setData(ModAttachments.ADVANCEMENT_POINT.get(), current + 1)

        println("${player.name.string}: ${current + 1}")
    }
}
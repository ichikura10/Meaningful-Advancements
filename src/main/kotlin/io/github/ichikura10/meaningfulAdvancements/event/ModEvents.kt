package io.github.ichikura10.meaningfulAdvancements.event

import io.github.ichikura10.meaningfulAdvancements.MeaningfulAdvancements
import net.minecraft.world.entity.player.Player
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.neoforge.event.entity.player.AdvancementEvent

@EventBusSubscriber(modid = MeaningfulAdvancements.ID, bus = EventBusSubscriber.Bus.GAME)
class ModEvents {
    fun onAdvancementEarn(event: AdvancementEvent.AdvancementEarnEvent) {
        val player: Player = event.entity
        println(player.name.string + "earned" + event.advancement.id)
    }
}
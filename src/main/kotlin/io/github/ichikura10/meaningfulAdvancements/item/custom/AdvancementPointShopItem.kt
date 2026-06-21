package io.github.ichikura10.meaningfulAdvancements.item.custom

import io.github.ichikura10.meaningfulAdvancements.attachment.ModAttachments
import net.minecraft.network.chat.Component
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResultHolder
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.Level

class AdvancementPointShopItem(properties: Properties) : Item(properties) {
    override fun use(level: Level, player: Player, hand: InteractionHand): InteractionResultHolder<ItemStack> {
        if (!level.isClientSide) {
            val point = player.getData(ModAttachments.ADVANCEMENT_POINT.get())

            player.sendSystemMessage(
                Component.literal("現在のポイント: $point")
            )
        }

        return InteractionResultHolder.success(player.getItemInHand(hand))
    }
}
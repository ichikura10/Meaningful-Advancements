package io.github.ichikura10.meaningfulAdvancements.item

import io.github.ichikura10.meaningfulAdvancements.MeaningfulAdvancements
import io.github.ichikura10.meaningfulAdvancements.item.custom.AdvancementPointShopItem
import net.minecraft.world.item.Item
import net.neoforged.bus.api.IEventBus
import net.neoforged.neoforge.registries.DeferredItem
import net.neoforged.neoforge.registries.DeferredRegister
import java.util.function.Supplier


object ModItems {
    private val ITEMS: DeferredRegister.Items = DeferredRegister.createItems(MeaningfulAdvancements.ID)

    val ADVANCEMENT_POINT_SHOP: DeferredItem<Item> = ITEMS.register<Item>("advancement_point_shop",
        Supplier<Item> { AdvancementPointShopItem(Item.Properties()) })

    fun register(modBus: IEventBus) {
        ITEMS.register(modBus)
    }

}
package io.github.ichikura10.meaningfulAdvancements.attachment

import com.mojang.serialization.Codec
import io.github.ichikura10.meaningfulAdvancements.MeaningfulAdvancements
import net.minecraft.resources.ResourceLocation
import net.neoforged.bus.api.IEventBus
import net.neoforged.neoforge.attachment.AttachmentType
import net.neoforged.neoforge.attachment.IAttachmentHolder
import net.neoforged.neoforge.registries.DeferredRegister
import net.neoforged.neoforge.registries.NeoForgeRegistries


object ModAttachments {
    private val ATTACHMENT_TYPES: DeferredRegister<AttachmentType<*>> =
        DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, MeaningfulAdvancements.ID)

    val ADVANCEMENT_POINT = ATTACHMENT_TYPES.register("points") { _: ResourceLocation ->
        AttachmentType.builder {_: IAttachmentHolder -> 0}
            .serialize(Codec.INT)
            .build()
    }

    fun register(modBus: IEventBus) {
        ATTACHMENT_TYPES.register(modBus)
    }
}
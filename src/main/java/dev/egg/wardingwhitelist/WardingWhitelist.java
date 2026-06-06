package dev.egg.wardingwhitelist;

import com.mojang.logging.LogUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

@Mod(WardingWhitelist.MODID)
public class WardingWhitelist {
    public static final String MODID = "wardingwhitelist";
    private static final Logger LOGGER = LogUtils.getLogger();

    public static final TagKey<EntityType<?>> WARD_REPELLED_WHITELIST = TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(MODID, "ward_repelled_whitelist.json"));

    public WardingWhitelist(IEventBus modEventBus, ModContainer modContainer) {
    }
}

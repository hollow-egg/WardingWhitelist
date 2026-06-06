package dev.egg.wardingwhitelist.mixin;

import com.farcr.nomansland.common.event.MiscellaneousEvents;
import com.farcr.nomansland.common.world.saved_data.WardedSpacesData;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.server.level.ServerLevel;
import net.neoforged.neoforge.event.entity.living.FinalizeSpawnEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static dev.egg.wardingwhitelist.WardingWhitelist.WARD_REPELLED_WHITELIST;

@Mixin(MiscellaneousEvents.class)
public class MiscellaneousEventsMixin {
    @Inject(method = "onFinalizeMobSpawn", at = @At("HEAD"))
    private static void onFinalizeMobSpawn(CallbackInfo ci, @Local(argsOnly = true) FinalizeSpawnEvent event) {
        if (event.getLevel() instanceof ServerLevel serverLevel && event.getEntity().getType().is(WARD_REPELLED_WHITELIST))
        {
            WardedSpacesData wardedSpacesData = WardedSpacesData.get((ServerLevel) event.getLevel());
            event.setSpawnCancelled(wardedSpacesData.isWarded(serverLevel, event.getEntity().blockPosition()));
        }
    }
}

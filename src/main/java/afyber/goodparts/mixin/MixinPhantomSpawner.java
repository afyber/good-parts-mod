package afyber.goodparts.mixin;

import afyber.goodparts.GoodPartsMod;
import net.minecraft.world.level.levelgen.PhantomSpawner;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(PhantomSpawner.class)
public class MixinPhantomSpawner {

	@ModifyVariable(method = "Lnet/minecraft/world/level/levelgen/PhantomSpawner;tick(Lnet/minecraft/server/level/ServerLevel;ZZ)I", at = @At("STORE"), name = "l")
	public int lowerPhantomSpawns(int l) {
		if (GoodPartsMod.CONFIG.reducePhantomSpawns()) {
			return 1;
		}
		else {
			return l;
		}
	}

}

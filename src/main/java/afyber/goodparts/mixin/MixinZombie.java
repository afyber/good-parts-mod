package afyber.goodparts.mixin;

import afyber.goodparts.GoodPartsMod;
import net.minecraft.world.entity.monster.Zombie;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(Zombie.class)
public class MixinZombie {

	@Overwrite
	protected boolean convertsInWater() {
		return !GoodPartsMod.CONFIG.removeDrowned();
	}
}

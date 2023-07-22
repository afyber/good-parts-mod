package afyber.goodparts;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.Drowned;
import net.minecraft.world.entity.monster.Husk;
import net.minecraft.world.entity.monster.Stray;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class GPSpawnHandler {
	private GPSpawnHandler() {}

	@SubscribeEvent
	public static void entityJoinLevel(net.minecraftforge.event.entity.EntityJoinLevelEvent event) {
		if (event.getLevel().isClientSide()) {
			return;
		}

		// NOTE: Preventing mob spawns in this way causes the data from any mobs that were riding on the removed mob to be sent to the client anyway (skeleton jockeys I'm looking at you)
		// However, this probably doesn't cause any problems, as it just seems to emit a warning message and do nothing
		Entity entity = event.getEntity();
		if ((entity instanceof Husk && GoodPartsMod.CONFIG.removeHusks()) ||
				(entity instanceof Stray && GoodPartsMod.CONFIG.removeStrays()) ||
				(entity instanceof Drowned && GoodPartsMod.CONFIG.removeDrowned())) {
			event.setCanceled(true);
		}

	}
}

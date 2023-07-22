package afyber.goodparts;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod("goodparts")
public class GoodPartsMod {

	public static GPConfig CONFIG;

	public GoodPartsMod() {
		CONFIG = GPConfig.register();

		MinecraftForge.EVENT_BUS.register(GPSpawnHandler.class);


	}
}

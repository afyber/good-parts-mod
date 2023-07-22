package afyber.goodparts;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;

import java.util.function.Supplier;

public class GPConfig {

	private final Supplier<Boolean> removeHusks;
	private final Supplier<Boolean> removeStrays;
	private final Supplier<Boolean> removeDrowned;

	private final Supplier<Boolean> reducePhantomSpawns;

	private GPConfig(ForgeConfigSpec.Builder builder) {
		builder.push("Mob Removal Settings");

		builder.push("Hostile Mobs");

		builder.comment("Remove Husks");
		removeHusks = builder.define("removeHusks", false);
		builder.comment("Remove Strays");
		removeStrays = builder.define("removeStrays", false);
		builder.comment("Remove Drowned");
		removeDrowned = builder.define("removeDrowned", false);

		builder.pop();

		builder.pop();

		builder.push("Misc");

		builder.comment("Reduce Phantom spawns");
		reducePhantomSpawns = builder.define("reducePhantomSpawns", false);

		builder.pop();
	}

	public static GPConfig register() {
		ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
		GPConfig instance = new GPConfig(builder);
		ForgeConfigSpec config = builder.build();
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, config);
		return instance;
	}

	public boolean removeHusks() {
		return removeHusks.get();
	}

	public boolean removeStrays() {
		return removeStrays.get();
	}

	public boolean removeDrowned() {
		return removeDrowned.get();
	}

	public boolean reducePhantomSpawns() {
		return reducePhantomSpawns.get();
	}
}

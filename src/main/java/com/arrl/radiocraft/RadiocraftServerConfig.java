package com.arrl.radiocraft;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;

public class RadiocraftServerConfig {

	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;

	public static final ConfigValue<Integer> HF_FREQUENCY_STEP;
	public static final ConfigValue<Integer> VHF_FREQUENCY_STEP;
	public static final ConfigValue<Integer> ANTENNA_UPDATE_DELAY;

	static {
		BUILDER.push("Antenna Options ( * = Restart game to take effect)");
		ANTENNA_UPDATE_DELAY = BUILDER.comment("Delay in seconds of an antenna to recalculate it's state after being changed #default 5").define("antenna_update_delay", 5);
		BUILDER.pop();

		BUILDER.push("Band Options ( * = Restart game to take effect)");
		HF_FREQUENCY_STEP = BUILDER.comment("The minimum step size for a HF frequency, in kHz (0.001MHz) #default 1").define("hf_frequency_step", 1);
		VHF_FREQUENCY_STEP = BUILDER.comment("The minimum step size for a VHF frequency, in kHz (0.001MHz) #default 100").define("vhf_frequency_step", 100);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}

package com.arrl.radiocraft.api.capabilities;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;

/**
 * Contains the capability tokens for all capabilities used in Radiocraft.
 */
public class RadiocraftCapabilities {

	public static Capability<ICallsignCapability> CALLSIGNS = CapabilityManager.get(new CapabilityToken<>(){});
	public static Capability<IAntennaWireHolderCapability> ANTENNA_WIRE_HOLDERS = CapabilityManager.get(new CapabilityToken<>(){});
	public static Capability<IAntennaNetworkCapability> ANTENNA_NETWORKS = CapabilityManager.get(new CapabilityToken<>(){});
	public static Capability<IVHFHandheldCapability> VHF_HANDHELDS = CapabilityManager.get(new CapabilityToken<>(){});
	public static Capability<IBENetworks> ENERGY_STORAGES = CapabilityManager.get(new CapabilityToken<>(){});

}

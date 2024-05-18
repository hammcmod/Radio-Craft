package com.arrl.radiocraft.common.init;

import com.arrl.radiocraft.Radiocraft;
import com.arrl.radiocraft.common.blocks.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * Registry class for Radiocraft's blocks
 */
public class RadiocraftBlocks {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Radiocraft.MOD_ID);

	// Copy common properties here to avoid using copy method a ton.
	private static final Properties PROPERTIES_STONE = Properties.copy(Blocks.STONE);
	private static final Properties PROPERTIES_STONE_NO_OCCLUDE = Properties.copy(Blocks.STONE).noCollission();
	private static final Properties PROPERTIES_RADIO = Properties.copy(Blocks.STONE).noOcclusion();
	private static final Properties PROPERTIES_IRON_BARS = Properties.copy(Blocks.IRON_BARS);
	private static final Properties PROPERTIES_WIRES = Properties.of(Material.STONE, MaterialColor.COLOR_LIGHT_GRAY).instabreak().noCollission().noOcclusion();

	// Power related blocks
	public static final RegistryObject<WireBlock> WIRE = BLOCKS.register("wire", () -> new WireBlock(PROPERTIES_WIRES, true));
	public static final RegistryObject<Block> WATERPROOF_WIRE = simpleBlock("waterproof_wire", PROPERTIES_WIRES);
	public static final RegistryObject<SolarPanelBlock> SOLAR_PANEL = BLOCKS.register("solar_panel", () -> new SolarPanelBlock(PROPERTIES_RADIO));
	public static final RegistryObject<LargeBatteryBlock> LARGE_BATTERY = BLOCKS.register("large_battery", () -> new LargeBatteryBlock(PROPERTIES_RADIO));
	public static final RegistryObject<ChargeControllerBlock> CHARGE_CONTROLLER = BLOCKS.register("charge_controller", () -> new ChargeControllerBlock(PROPERTIES_STONE));

	// Radios/receivers/repeaters
	public static final RegistryObject<VHFBaseStationBlock> VHF_BASE_STATION = BLOCKS.register("vhf_base_station", () -> new VHFBaseStationBlock(PROPERTIES_RADIO));
	public static final RegistryObject<VHFReceiverBlock> VHF_RECEIVER = BLOCKS.register("vhf_receiver", () -> new VHFReceiverBlock(PROPERTIES_RADIO));
	public static final RegistryObject<VHFRepeaterBlock> VHF_REPEATER = BLOCKS.register("vhf_repeater", () -> new VHFRepeaterBlock(PROPERTIES_RADIO));

	public static final RegistryObject<HFRadio10mBlock> HF_RADIO_10M = BLOCKS.register("hf_radio_10m", () -> new HFRadio10mBlock(PROPERTIES_RADIO));
	public static final RegistryObject<HFRadio20mBlock> HF_RADIO_20M = BLOCKS.register("hf_radio_20m", () -> new HFRadio20mBlock(PROPERTIES_RADIO));
	public static final RegistryObject<HFRadio40mBlock> HF_RADIO_40M = BLOCKS.register("hf_radio_40m", () -> new HFRadio40mBlock(PROPERTIES_RADIO));
	public static final RegistryObject<HFRadio80mBlock> HF_RADIO_80M = BLOCKS.register("hf_radio_80m", () -> new HFRadio80mBlock(PROPERTIES_RADIO));
	public static final RegistryObject<HFReceiverBlock> HF_RECEIVER = BLOCKS.register("hf_receiver", () -> new HFReceiverBlock(PROPERTIES_RADIO));

	public static final RegistryObject<Block> ALL_BAND_RADIO = simpleBlock("all_band_radio", PROPERTIES_STONE);
	public static final RegistryObject<QRPRadio20mBlock> QRP_RADIO_20M = BLOCKS.register("qrp_radio_20m", () -> new QRPRadio20mBlock(PROPERTIES_RADIO));
	public static final RegistryObject<QRPRadio40mBlock> QRP_RADIO_40M = BLOCKS.register("qrp_radio_40m", () -> new QRPRadio40mBlock(PROPERTIES_RADIO));
	public static final RegistryObject<DigitalInterfaceBlock> DIGITAL_INTERFACE = BLOCKS.register("digital_interface", () -> new DigitalInterfaceBlock(PROPERTIES_STONE));

	// Antenna blocks
	public static final RegistryObject<DuplexerBlock> DUPLEXER = BLOCKS.register("duplexer", () -> new DuplexerBlock(PROPERTIES_STONE_NO_OCCLUDE));
	public static final RegistryObject<AntennaTunerBlock> ANTENNA_TUNER = BLOCKS.register("antenna_tuner", () -> new AntennaTunerBlock(PROPERTIES_STONE));

	public static final RegistryObject<WireBlock> COAX_WIRE = BLOCKS.register("coax_wire", () -> new WireBlock(PROPERTIES_WIRES, false));
	public static final RegistryObject<AntennaPoleBlock> ANTENNA_POLE = BLOCKS.register("antenna_pole", () -> new AntennaPoleBlock(PROPERTIES_IRON_BARS));
	public static final RegistryObject<AntennaConnectorBlock> ANTENNA_CONNECTOR = BLOCKS.register("antenna_connector", () -> new AntennaConnectorBlock(PROPERTIES_STONE_NO_OCCLUDE));
	public static final RegistryObject<BalunBlock> BALUN_ONE_TO_ONE = BLOCKS.register("balun_one_to_one", () -> new BalunBlock(PROPERTIES_STONE_NO_OCCLUDE));
	public static final RegistryObject<BalunBlock> BALUN_TWO_TO_ONE = BLOCKS.register("balun_two_to_one", () -> new BalunBlock(PROPERTIES_STONE_NO_OCCLUDE));
	public static final RegistryObject<DoubleVHFAntennaBlock> J_POLE_ANTENNA = BLOCKS.register("j_pole_antenna", () -> new DoubleVHFAntennaBlock(PROPERTIES_STONE_NO_OCCLUDE));
	public static final RegistryObject<VHFAntennaCenterBlock> SLIM_JIM_ANTENNA = BLOCKS.register("slim_jim_antenna", () -> new VHFAntennaCenterBlock(PROPERTIES_STONE_NO_OCCLUDE));
	public static final RegistryObject<YagiAntennaBlock> YAGI_ANTENNA = BLOCKS.register("yagi_antenna", () -> new YagiAntennaBlock(PROPERTIES_STONE_NO_OCCLUDE));

	public static final RegistryObject<SolarWeatherStationBlock> SOLAR_WEATHER_STATION = BLOCKS.register("solar_weather_station", () -> new SolarWeatherStationBlock(PROPERTIES_STONE));

	public static final RegistryObject<MicrophoneBlock> MICROPHONE = BLOCKS.register("microphone", () -> new MicrophoneBlock(PROPERTIES_STONE));

	public static RegistryObject<Block> simpleBlock(String name, Properties properties) {
		return BLOCKS.register(name, () -> new Block(properties));
	}

}

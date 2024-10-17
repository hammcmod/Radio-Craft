package com.arrl.radiocraft.common.radio;

import com.arrl.radiocraft.Radiocraft;
import com.arrl.radiocraft.common.radio.antenna.AntennaVoicePacket;
import com.arrl.radiocraft.common.radio.voice.RadiocraftVoicePlugin;
import de.maxhenkel.voicechat.api.ServerLevel;
import de.maxhenkel.voicechat.api.audiochannel.AudioChannel;
import de.maxhenkel.voicechat.api.audiochannel.LocationalAudioChannel;

import java.util.UUID;

/**
 * {@link BEVoiceReceiver} is used for interacting with the Simple Voice Chat API to send sound packets being received by a Radio.
 * PCM audio gets re-encoded here and sent on an {@link AudioChannel}.
 */
public class BEVoiceReceiver implements IVoiceReceiver {

	private LocationalAudioChannel receiveChannel = null;
	private final int x;
	private final int y;
	private final int z;

	private boolean isReceiving;

	public BEVoiceReceiver(int x, int y, int z) {
		this(x, y, z, false);
	}

	public BEVoiceReceiver(int x, int y, int z, boolean isReceiving) {
		this.isReceiving = isReceiving;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public void openChannel(ServerLevel level) {
		if(RadiocraftVoicePlugin.API == null)
			Radiocraft.LOGGER.error("Radiocraft VoiceChatServerApi is null.");
		receiveChannel = RadiocraftVoicePlugin.API.createLocationalAudioChannel(UUID.randomUUID(), level, RadiocraftVoicePlugin.API.createPosition(x, y, z));
	}

	public void receive(AntennaVoicePacket antennaPacket) {
		if(isReceiving) {
			if(receiveChannel == null)
				openChannel(RadiocraftVoicePlugin.API.fromServerLevel(antennaPacket.getLevel()));

			short[] rawAudio = antennaPacket.getRawAudio();
			for(int i = 0; i < rawAudio.length; i++)
				rawAudio[i] = (short)Math.round(rawAudio[i] * antennaPacket.getStrength()); // Apply appropriate gain for signal strength

			byte[] opusAudio = RadiocraftVoicePlugin.encodingManager.getOrCreate(antennaPacket.getSourcePlayer()).getEncoder().encode(rawAudio);
			receiveChannel.send(opusAudio);
		}
	}

	public boolean isReceiving() {
		return isReceiving;
	}

	public void setReceiving(boolean value) {
		isReceiving = value;
	}

}

package com.arrl.radiocraft.common.sounds;

import com.arrl.radiocraft.client.RadiocraftClientValues;
import com.arrl.radiocraft.common.blockentities.radio.RadioBlockEntity;
import com.arrl.radiocraft.common.init.RadiocraftSoundEvents;
import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.sounds.SoundSource;

public class RadioStaticSoundInstance extends AbstractTickableSoundInstance {

	private final RadioBlockEntity radio;

	public RadioStaticSoundInstance(RadioBlockEntity radio) {
		super(RadiocraftSoundEvents.STATIC.get(), SoundSource.VOICE, SoundInstance.createUnseededRandom());
		this.radio = radio;
		this.looping = true;
		this.delay = 0;
		this.x = radio.getBlockPos().getX() + 0.5D;
		this.y = radio.getBlockPos().getY() + 0.5D;
		this.z = radio.getBlockPos().getZ() + 0.5D;
		this.volume = 1.0F;
	}

	@Override
	public void tick() {
		if(radio.isRemoved())
			stop();
		else {
			if(radio.wasPowered() && radio.shouldPlayStatic())
				volume = (float)(RadiocraftClientValues.NOISE_VOLUME * radio.getStaticVolume());
			else
				volume = 0.0F;
		}
	}

	@Override
	public boolean canStartSilent() {
		return true;
	}

}

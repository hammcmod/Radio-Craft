package com.arrl.radiocraft.client.screens;

import com.arrl.radiocraft.Radiocraft;
import com.arrl.radiocraft.RadiocraftServerConfig;
import com.arrl.radiocraft.client.screens.widgets.Dial;
import com.arrl.radiocraft.client.screens.widgets.HoldButton;
import com.arrl.radiocraft.client.screens.widgets.ToggleButton;
import com.arrl.radiocraft.client.screens.widgets.ValueButton;
import com.arrl.radiocraft.common.init.RadiocraftData;
import com.arrl.radiocraft.common.menus.AbstractHFRadioMenu;
import com.arrl.radiocraft.common.radio.Band;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class QRPRadio20mScreen extends AbstractHFRadioScreen {

    public QRPRadio20mScreen(AbstractHFRadioMenu container, Inventory playerInventory, Component title) {
        super(container, playerInventory, title, Radiocraft.location("textures/gui/qrp_radio_20m.png"), Radiocraft.location("textures/gui/qrp_radio_20m_widgets.png"));

        this.imageWidth = 252;
        this.imageHeight = 130;
    }

    @Override
    protected void init() {
        super.init();
        addRenderableWidget(new ToggleButton(container.isPowered(), leftPos + 16, topPos + 9, 20, 21, 0, 0, widgetsTexture, 256, 256, this::onPressPower)); // Power button
        addRenderableWidget(new ValueButton(leftPos + 195, topPos + 48, 34, 19, 0, 42, widgetsTexture, 256, 256, container::getCWEnabled, this::onPressCW)); // CW Button
        addRenderableWidget(new ValueButton(leftPos + 195, topPos + 68, 34, 19, 0, 80, widgetsTexture, 256, 256, container::getSSBEnabled, this::onPressSSB)); // SSB button
        addRenderableWidget(new HoldButton(leftPos + 178, topPos + 97, 51, 19, 0, 118, widgetsTexture, 256, 256, this::onPressPTT, this::onReleasePTT)); // PTT button
        addRenderableWidget(new Dial(leftPos + 48, topPos + 47, 42, 42, 121, 0, widgetsTexture, 256, 256, this::onFrequencyDialUp, this::onFrequencyDialDown)); // Frequency dial
        addRenderableWidget(new Dial(leftPos + 31, topPos + 36, 15, 15, 121, 85, widgetsTexture, 256, 256, this::doNothing, this::doNothing)); // Gain dial
        addRenderableWidget(new Dial(leftPos + 31, topPos + 62, 15, 15, 121, 85, widgetsTexture, 256, 256, this::doNothing, this::doNothing)); // Mic gain dial

    }


    @Override
    protected void renderAdditionalTooltips(PoseStack poseStack, int mouseX, int mouseY, float partialTicks) {
        {} //placeholder
    }

    @Override
    protected void renderAdditionalBg(PoseStack poseStack, float partialTicks, int x, int y) {
        float freq = container.getFrequency();
        Band band = RadiocraftData.BANDS.getValue(20);
        int step = RadiocraftServerConfig.FREQUENCY_STEP.get();
        float min = band.minFrequency();
        float max = (band.maxFrequency() - band.minFrequency()) / step * step + min;
        if(container.isPowered()) {
            if(freq >= max || freq <= min) {
                blit(poseStack, leftPos + 92, topPos + 63, 1, 162, 13, 13);
            }
        }
    }

    @Override
    protected void renderLabels(PoseStack poseStack, int x, int y) {}

    protected boolean isHovering(int x, int y, int width, int height, double mouseX, double mouseY) {
        mouseX -= leftPos;
        mouseY -= topPos;
        return mouseX >= (x - 1) && mouseX < (x + width + 1) && mouseY >= (y - 1) && mouseY < (y + height + 1);
    }

}
package com.arrl.radiocraft.common.menus;

import com.arrl.radiocraft.common.blockentities.AbstractRadioBlockEntity;
import com.arrl.radiocraft.common.init.RadiocraftBlocks;
import com.arrl.radiocraft.common.init.RadiocraftMenuTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;

public class QRPRadioMenu40m extends AbstractHFRadioMenu {

    public QRPRadioMenu40m(int id, AbstractRadioBlockEntity blockEntity, ContainerData data) {
        super(RadiocraftMenuTypes.QRP_RADIO_40M.get(), id, blockEntity, data, RadiocraftBlocks.QRP_RADIO_40M.get());
    }

    public QRPRadioMenu40m(final int id, final Inventory playerInventory, final FriendlyByteBuf data) {
        this(id, AbstractHFRadioMenu.getBlockEntity(playerInventory, data), new SimpleContainerData(3));
    }

}
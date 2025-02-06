package com.emmmanue.lobaaddons.Listener;

import com.emmmanue.lobaaddons.Event.InitGuiEvent;
import com.emmmanue.lobaaddons.InventoryButtons.components.InventoryButton;
import com.emmmanue.lobaaddons.InventoryButtons.components.Preset;
import com.emmmanue.lobaaddons.InventoryButtons.components.PresetTypes;
import com.emmmanue.lobaaddons.InventoryButtons.components.Presets;
import com.emmmanue.lobaaddons.Main;
import com.emmmanue.lobaaddons.Utils.SerUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Listener {
    @SubscribeEvent
    public void onInvInit(InitGuiEvent event) {

    }
}

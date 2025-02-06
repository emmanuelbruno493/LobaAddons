package com.emmmanue.lobaaddons.InventoryButtons;

import com.emmmanue.lobaaddons.InventoryButtons.components.InventoryButton;
import com.emmmanue.lobaaddons.InventoryButtons.components.Preset;
import com.emmmanue.lobaaddons.InventoryButtons.components.PresetTypes;
import com.emmmanue.lobaaddons.InventoryButtons.components.Presets;
import com.emmmanue.lobaaddons.Main;
import com.emmmanue.lobaaddons.Utils.SerUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AddInventoryButtonCommand extends CommandBase {
    @Override
    public String getCommandName() {
        return "debugb";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] strings) {
        InventoryButton button = new InventoryButton(
                Integer.parseInt(strings[0]),
                strings[0],
                Integer.parseInt(strings[1]),
                Integer.parseInt(strings[2]),
                Integer.parseInt(strings[3]),
                Integer.parseInt(strings[4]),
                strings[5],
                false);

        Presets presets = SerUtils.getPresets();
        for (Preset preset : presets.presetlist){
            if (preset.presetType == PresetTypes.DEFAULT){
                preset.buttonList.add(button);
            }
        }
        if (presets.presetlist.isEmpty()){
            Preset preset = new Preset();
            preset.buttonList.add(button);
            presets.presetlist.add(preset);
        }
        SerUtils.savePresets(presets);
    }
}

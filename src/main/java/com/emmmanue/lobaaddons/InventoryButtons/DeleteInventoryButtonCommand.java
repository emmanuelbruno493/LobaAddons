package com.emmmanue.lobaaddons.InventoryButtons;

import com.emmmanue.lobaaddons.InventoryButtons.components.InventoryButton;
import com.emmmanue.lobaaddons.InventoryButtons.components.Preset;
import com.emmmanue.lobaaddons.InventoryButtons.components.Presets;
import com.emmmanue.lobaaddons.Utils.SerUtils;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

import java.util.ArrayList;
import java.util.List;

public class DeleteInventoryButtonCommand extends CommandBase {
    @Override
    public String getCommandName() {
        return "debugbdelete";
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
        InventoryButton toRemove = null;
        Presets presets = SerUtils.getPresets();
        for (Preset preset : presets.presetlist){
            for (InventoryButton button : preset.buttonList){
                if (button.id == Integer.parseInt(strings[0])){
                    toRemove = button;
                }
            }
            if(toRemove == null){
                return;
            }
            preset.buttonList.remove(toRemove);
        }
        SerUtils.savePresets(presets);
    }
}

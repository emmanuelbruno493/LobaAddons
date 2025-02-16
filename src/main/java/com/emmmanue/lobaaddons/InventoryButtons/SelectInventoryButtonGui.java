package com.emmmanue.lobaaddons.InventoryButtons;

import com.emmmanue.lobaaddons.InventoryButtons.components.InventoryButton;
import com.emmmanue.lobaaddons.InventoryButtons.components.Preset;
import com.emmmanue.lobaaddons.InventoryButtons.components.PresetTypes;
import com.emmmanue.lobaaddons.InventoryButtons.components.Presets;
import com.emmmanue.lobaaddons.Utils.SerUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

import java.io.IOException;

public class SelectInventoryButtonGui extends GuiScreen {
    @Override
    public void initGui() {
        super.initGui();
        Presets presets = SerUtils.getPresets();
        if (presets.presetlist.isEmpty()){
            return;
        }
        Preset preset = null;
        for (Preset presetI : presets.presetlist){
            if (presetI.presetType == PresetTypes.DEFAULT){
                preset = presetI;
            }
        }
        if (preset.buttonList.isEmpty()){
            return;
        }
        for (InventoryButton inventoryButton : preset.buttonList){
            buttonList.add(new GuiButton(
                    inventoryButton.id,
                    inventoryButton.x,
                    inventoryButton.y,
                    inventoryButton.width,
                    inventoryButton.height,
                    inventoryButton.name
            ));
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        super.actionPerformed(button);
        Minecraft.getMinecraft().displayGuiScreen(new EditInventoryButtonGui(button.id));
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        super.keyTyped(typedChar, keyCode);
    }
}

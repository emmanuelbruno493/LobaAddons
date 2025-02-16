package com.emmmanue.lobaaddons.InventoryButtons;

import com.emmmanue.lobaaddons.InventoryButtons.components.InventoryButton;
import com.emmmanue.lobaaddons.InventoryButtons.components.Preset;
import com.emmmanue.lobaaddons.InventoryButtons.components.PresetTypes;
import com.emmmanue.lobaaddons.InventoryButtons.components.Presets;
import com.emmmanue.lobaaddons.Utils.SerUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import org.lwjgl.input.Keyboard;

import java.io.IOException;

public class EditInventoryButtonGui extends GuiScreen {

    public int id;
    public GuiTextField name;
    public GuiTextField command;
    public GuiButton saveButton;
    public GuiButton deleteButton;

    public EditInventoryButtonGui(int id){
        this.id = id;
    }

    @Override
    public void initGui() {
        super.initGui();
        Keyboard.enableRepeatEvents(true);
        name = new GuiTextField(0, this.fontRendererObj, this.width / 2 - 75, this.height / 2 - 60, 150, 20);
        command = new GuiTextField(1, this.fontRendererObj, this.width / 2 - 75, this.height / 2 - 10, 150, 20);
        saveButton = new GuiButton(2, this.width / 2 - 50, this.height / 2 + 30, 100, 20, "Save");
        deleteButton = new GuiButton(2, this.width / 2 - 50, this.height / 2 + 80, 100, 20, "Delete");
        buttonList.add(saveButton);
        buttonList.add(deleteButton);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);
        name.drawTextBox();
        command.drawTextBox();
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        super.mouseClicked(mouseX, mouseY, mouseButton);
        name.mouseClicked(mouseX, mouseY, mouseButton);
        command.mouseClicked(mouseX, mouseY, mouseButton);
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        super.keyTyped(typedChar, keyCode);
        if(keyCode == Keyboard.KEY_ESCAPE){
            return;
        }
        name.textboxKeyTyped(typedChar, keyCode);
        command.textboxKeyTyped(typedChar, keyCode);
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        super.actionPerformed(button);

        Presets presets = SerUtils.getPresets();
        Preset preset = presets.getPreset(PresetTypes.DEFAULT);
        presets.presetlist.remove(preset);
        InventoryButton inventoryButton = preset.getButtonWithId(id);
        preset.buttonList.remove(inventoryButton);

        if(button == saveButton){
            inventoryButton.enabled = true;
            inventoryButton.command = command.getText();
            inventoryButton.name = name.getText();
        }
        if (button == deleteButton){
            inventoryButton.enabled = false;
            inventoryButton.command = "";
            inventoryButton.name = "Empty";
        }

        preset.buttonList.add(inventoryButton);
        presets.presetlist.add(preset);
        SerUtils.savePresets(presets);
        Minecraft.getMinecraft().displayGuiScreen(null);
    }
}

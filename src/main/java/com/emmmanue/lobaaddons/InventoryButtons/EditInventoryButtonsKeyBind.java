package com.emmmanue.lobaaddons.InventoryButtons;

import com.emmmanue.lobaaddons.Main;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiInventory;

public class EditInventoryButtonsKeyBind implements Runnable{

    @Override
    public void run() {
        Minecraft.getMinecraft().displayGuiScreen(new SelectInventoryButtonGui());
    }
}

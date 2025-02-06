package com.emmmanue.lobaaddons.mixin;

import com.emmmanue.lobaaddons.Event.InitGuiEvent;
import com.emmmanue.lobaaddons.InventoryButtons.components.InventoryButton;
import com.emmmanue.lobaaddons.InventoryButtons.components.Preset;
import com.emmmanue.lobaaddons.InventoryButtons.components.PresetTypes;
import com.emmmanue.lobaaddons.InventoryButtons.components.Presets;
import com.emmmanue.lobaaddons.Utils.SerUtils;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiInventory.class)
public class MixinGuiInventory extends GuiScreen {
    @Inject(
            method = "initGui",
            at = @At("TAIL")
    )
    public void onGuiInit(CallbackInfo callbackInfoReturnable) {
        MinecraftForge.EVENT_BUS.post(new InitGuiEvent());
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
    @Inject(
            method = "actionPerformed",
            at = @At("HEAD")
    )
    public void onActionPerformed(GuiButton button, CallbackInfo ci){
        Presets presets = SerUtils.getPresets();
        for (Preset preset : presets.presetlist){
            for (InventoryButton invbutton : preset.buttonList){
                if (invbutton.id == button.id){
                    sendCommand(invbutton.command);
                }
            }
        }
    }

    private void sendCommand(String command){
        if (command.startsWith("/") && ClientCommandHandler.instance.executeCommand(mc.thePlayer, command) == 0){
            mc.thePlayer.sendChatMessage(command);
        }
    }
}
package com.emmmanue.lobaaddons.Event;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class OnTickEvent {

    public static GuiScreen screenToDisplayNextTick;

    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event){
        if (event.phase == TickEvent.Phase.END){return;}
        if (screenToDisplayNextTick != null){
            Minecraft.getMinecraft().displayGuiScreen(screenToDisplayNextTick);
            screenToDisplayNextTick = null;
        }
    }
}

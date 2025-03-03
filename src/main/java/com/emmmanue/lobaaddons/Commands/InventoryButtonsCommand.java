package com.emmmanue.lobaaddons.Commands;

import com.emmmanue.lobaaddons.Event.OnTickEvent;
import com.emmmanue.lobaaddons.InventoryButtons.SelectInventoryButtonGui;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;

public class InventoryButtonsCommand extends CommandBase {
    @Override
    public String getCommandName() {
        return "buttons";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        OnTickEvent.screenToDisplayNextTick = new SelectInventoryButtonGui();
    }
}

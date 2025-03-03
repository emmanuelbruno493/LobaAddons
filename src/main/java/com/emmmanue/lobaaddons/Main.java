package com.emmmanue.lobaaddons;

import com.emmmanue.lobaaddons.Commands.InventoryButtonsCommand;
import com.emmmanue.lobaaddons.Event.OnTickEvent;
import com.google.gson.Gson;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.*;

@Mod(modid = Main.MODID, version = Main.VERSION)
public class Main
{
    public static final String MODID = "lobaaddons";
    public static final String VERSION = "1.0";
    public static File configFile;
    public static Gson gson = new Gson();

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) throws IOException {
        configFile = new File(event.getModConfigurationDirectory(), "LobaAddons");
        if(!configFile.exists()){
            configFile.mkdir();
        }
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event){
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new OnTickEvent());
        ClientCommandHandler.instance.registerCommand(new InventoryButtonsCommand());
    }
}

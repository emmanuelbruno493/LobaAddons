package com.emmmanue.lobaaddons.Utils;

import com.emmmanue.lobaaddons.InventoryButtons.components.Presets;
import com.emmmanue.lobaaddons.Main;

import java.io.*;

public class SerUtils {
    public static void savePresets(Presets presets) {
        File file = new File(Main.configFile, "presets-v2.json");
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        OutputStreamWriter writer = new OutputStreamWriter(outputStream);
        try {
            writer.write(Main.gson.toJson(presets, Presets.class));
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static Presets getPresets(){
        File file = new File(Main.configFile, "presets-v2.json");
        if (!file.exists()){
            Presets.loadDefault();
        }
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        InputStreamReader reader = new InputStreamReader(inputStream);
        return Main.gson.fromJson(reader, Presets.class);
    }
}

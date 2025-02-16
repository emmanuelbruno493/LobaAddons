package com.emmmanue.lobaaddons.InventoryButtons.components;

import com.emmmanue.lobaaddons.Utils.SerUtils;

import java.util.ArrayList;
import java.util.List;

public class Presets {
    public List<Preset> presetlist = new ArrayList<>();

    public static void loadDefault(){
        Presets presets = new Presets();
        Preset preset = new Preset();
        preset.presetType = PresetTypes.DEFAULT;

        int id = 101;
        for (int i = 0; i < 5; i++) {
            preset.buttonList.add(new InventoryButton(id, "Empty", 300, 185+(i*35), 80, 20, "", false));
            id++;
        }
        for (int i = 0; i < 5; i++) {
            preset.buttonList.add(new InventoryButton(id, "Empty", 395+(i*35), 155, 30, 20, "", false));
            id++;
        }
        for (int i = 0; i < 5; i++) {
            preset.buttonList.add(new InventoryButton(id, "Empty", 580, 185+(i*35), 80, 20, "", false));
            id++;
        }

        presets.presetlist.add(preset);
        SerUtils.savePresets(presets);
    }

    public Preset getPreset(PresetTypes type){
        for(Preset preset : presetlist){
            if (preset.presetType == type){
                return preset;
            }
        }
        return null;
    }
}

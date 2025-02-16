package com.emmmanue.lobaaddons.InventoryButtons.components;

import java.util.ArrayList;
import java.util.List;

public class Preset {
    public PresetTypes presetType = PresetTypes.DEFAULT;
    public List<InventoryButton> buttonList = new ArrayList<>();

    public InventoryButton getButtonWithId(int id){
        for (InventoryButton button : buttonList){
            if (button.id == id){
                return button;
            }
        }
        return null;
    }
}

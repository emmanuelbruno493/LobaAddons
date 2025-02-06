package com.emmmanue.lobaaddons;

import cc.polyfrost.oneconfig.config.annotations.KeyBind;
import cc.polyfrost.oneconfig.config.core.OneKeyBind;
import cc.polyfrost.oneconfig.config.data.Mod;
import cc.polyfrost.oneconfig.config.data.ModType;
import cc.polyfrost.oneconfig.libs.universal.UKeyboard;
import com.emmmanue.lobaaddons.InventoryButtons.EditInventoryButtonsKeyBind;

public class Config extends cc.polyfrost.oneconfig.config.Config {

    public Config() {
        super(new Mod(
                "Loba Addons",
                ModType.SKYBLOCK,
                "C:\\Users\\minec\\OneDrive\\Escritorio\\LobaAddons\\src\\main\\resources\\img.png"
        ), "Config.json");
        initialize();
        registerKeyBind(buttonGuiKeyBind, new EditInventoryButtonsKeyBind());
    }
    @KeyBind(
            name = "Open Buttons Gui",
            category = "Gui",
            subcategory = "Buttons"
    )
    public static OneKeyBind buttonGuiKeyBind = new OneKeyBind(UKeyboard.KEY_NONE);
}

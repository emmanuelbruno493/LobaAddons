package com.emmmanue.lobaaddons.InventoryButtons.components;

public class InventoryButton {
    public int id;
    public int x;
    public int y;
    public int width;
    public int height;
    public String command;
    public String name;
    public boolean enabled;

    public InventoryButton(int id, String name, int x, int y, int width, int height, String command, boolean enabled) {
        this.id = id;
        this.name = name;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.command = command;
        this.enabled = enabled;
    }
}

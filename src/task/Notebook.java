package task;

import java.io.Serializable;

public class Notebook extends Computer implements Serializable {
    transient int weight;
    int buttons;
    public Notebook(String name, String cpu, int ram, int hdd, int weight, int buttons) {
        super(name, cpu, ram, hdd);
        this.weight = weight;
        this.buttons = buttons;
    }
   Touchpad <Integer> touchPad = new Touchpad<>(2);
}

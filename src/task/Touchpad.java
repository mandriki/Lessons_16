package task;

import java.io.Serializable;

public class Touchpad<T> implements Serializable {
    T buttons;
    public Touchpad(T buttons) {
        this.buttons = buttons;
    }
}

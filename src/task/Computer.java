package task;

import java.io.Serializable;
public class Computer implements Serializable {
    String name;
    String cpu;
    int ram;
    int hdd;

    public Computer(String name, String cpu, int ram, int hdd) {
        this.name = name;
        this.cpu = cpu;
        this.ram = ram;
        this.hdd = hdd;
    }
}


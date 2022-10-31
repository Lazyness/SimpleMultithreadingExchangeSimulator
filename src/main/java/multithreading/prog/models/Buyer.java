package multithreading.prog.models;

import java.util.Arrays;

public class Buyer {
    private final String name;
    private final Share[] target;

    public String getName() {
        return name;
    }

    public Share[] getTarget() {
        return target;
    }

    public Buyer(String name, Share[] target) {
        this.name = name;
        this.target = target;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", target=" + Arrays.toString(target) +
                '}';
    }
}

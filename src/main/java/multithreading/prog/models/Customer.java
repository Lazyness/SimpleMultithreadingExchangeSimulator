package multithreading.prog.models;

import java.util.Arrays;

public class Customer {
    private final String name;
    private final Share[] target;

    public String getName() {
        return name;
    }

    public Share[] getTarget() {
        return target;
    }

    public Customer(String name, Share[] target) {
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

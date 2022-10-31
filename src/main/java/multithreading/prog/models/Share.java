package multithreading.prog.models;

public class Share {
    private final String name;
    private double amount;
    private double price;

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Share(String name, double amount, double price) {
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public double getAmount() {
        return amount;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return "Shares{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                ", price=" + price +
                '}';
    }
}

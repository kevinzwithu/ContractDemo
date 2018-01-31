package cn.kevinz.order.models;

public class Consumer {
    private String name, id;
    private int age, amount, desire;

    public Consumer() {}

    public Consumer(String id, int age, String name, int amount, int desire) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.amount = amount;
        this.desire = desire;
    }

    public String getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public int getDesire() {
        return desire;
    }
}

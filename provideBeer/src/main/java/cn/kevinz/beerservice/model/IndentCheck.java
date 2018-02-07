package cn.kevinz.beerservice.model;

public class IndentCheck {
    private String name, id;
    private int age, desire, amount;

    public IndentCheck() {}

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
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

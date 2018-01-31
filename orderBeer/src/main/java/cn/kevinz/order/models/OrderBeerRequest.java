package cn.kevinz.order.models;

public class OrderBeerRequest {
    private int age, amount, desire;
    private String id, name;

    public OrderBeerRequest() {
    }

    public OrderBeerRequest(OrderBeerApplication orderBeerApplication) {
        this.age = orderBeerApplication.getConsumer().getAge();
        this.amount = orderBeerApplication.getConsumer().getAmount();
        this.desire = orderBeerApplication.getConsumer().getDesire();
        this.id = orderBeerApplication.getConsumer().getId();
        this.name = orderBeerApplication.getConsumer().getName();
    }

    public int getAge() {
        return age;
    }

    public int getAmount() {
        return amount;
    }

    public int getDesire() {
        return desire;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

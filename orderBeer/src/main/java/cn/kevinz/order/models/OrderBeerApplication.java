package cn.kevinz.order.models;

public class OrderBeerApplication {
    private Consumer consumer;

    public OrderBeerApplication(Consumer consumer) {
        this.consumer = consumer;
    }

    public Consumer getConsumer() {
        return consumer;
    }
}

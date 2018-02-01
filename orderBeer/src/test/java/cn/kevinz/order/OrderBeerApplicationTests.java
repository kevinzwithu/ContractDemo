package cn.kevinz.order;

import static org.assertj.core.api.Assertions.assertThat;

import cn.kevinz.order.models.Consumer;
import cn.kevinz.order.models.OrderBeerApplication;
import cn.kevinz.order.models.OrderBeerApplicationResult;
import cn.kevinz.order.models.OrderBeerApplicationStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureStubRunner(ids = { "cn.kevinz:provider:+:stubs:8080" }, stubsMode = StubRunnerProperties.StubsMode.LOCAL)
public class OrderBeerApplicationTests {

    @Autowired
    private OrderBeerApplicationService service;

    @Test
    public void shouldBeRejectedDueToAgeLimited() {
        // given:
        OrderBeerApplication application = new OrderBeerApplication(new Consumer("123456", 15, "Greenberg", 1, 3));
        // when:
        OrderBeerApplicationResult orderResult = service.orderApplication(application);
        // then:
        assertThat(orderResult.getOrderBeerApplicationStatus())
                .isEqualTo(OrderBeerApplicationStatus.ORDER_REJECTED);
        assertThat(orderResult.getRejectReason()).isEqualTo("Too young to get beer");
    }

    @Test
    public void shouldBeAllowed() {
        //given:
        OrderBeerApplication application = new OrderBeerApplication(new Consumer("123457", 21, "Kevinz", 1, 2));
        // when:
        OrderBeerApplicationResult orderResult = service.orderApplication(application);
        // then:
        assertThat(orderResult.getOrderBeerApplicationStatus())
                .isEqualTo(OrderBeerApplicationStatus.ORDER_ALLOWED);
    }

}

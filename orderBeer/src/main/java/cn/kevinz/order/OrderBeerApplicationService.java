package cn.kevinz.order;

import cn.kevinz.order.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderBeerApplicationService {
    private final RestTemplate restTemplate;

    private int port = 8080;

    @Autowired
    public OrderBeerApplicationService(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public OrderBeerApplicationResult orderApplication(OrderBeerApplication orderBeerApplication) {
        OrderBeerRequest request = new OrderBeerRequest(orderBeerApplication);
        OrderBeerResponse response = sendRequestToProvideBeerService(request);

        return buildResponseFromResult(response);
    }

    private OrderBeerApplicationResult buildResponseFromResult(OrderBeerResponse response) {
        OrderBeerApplicationStatus orderBeerApplicationStatus = null;
        if (response.getCheckedStatus() == CheckedStatus.OK) {
            orderBeerApplicationStatus = OrderBeerApplicationStatus.ORDER_ALLOWED;
        } else if (response.getCheckedStatus() == CheckedStatus.NOT_OK) {
            orderBeerApplicationStatus = OrderBeerApplicationStatus.ORDER_REJECTED;
        }

        return new OrderBeerApplicationResult(orderBeerApplicationStatus, response.getRejectReason());
    }

    private OrderBeerResponse sendRequestToProvideBeerService(OrderBeerRequest orderBeerRequest) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

        ResponseEntity<OrderBeerResponse> response = restTemplate.exchange(
                "http://localhost:" + port + "/beer", HttpMethod.POST,
                new HttpEntity<>(orderBeerRequest, httpHeaders), OrderBeerResponse.class);

        return response.getBody();
    }
}

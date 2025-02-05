package petstore.steps;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import java.util.HashMap;
import java.util.Map;

public class StoreStep {

    private static final String BASE_URL = "https://petstore.swagger.io/v2/store/order";

    public void createOrder() {

    }

    public Response postOrder() {
        Map<String, Object> orderData = new HashMap<>();
        orderData.put("id", 10);
        orderData.put("petId", 5);
        orderData.put("quantity", 1);
        orderData.put("shipDate", "2025-02-05T00:22:00.022Z");
        orderData.put("status", "placed");
        orderData.put("complete", true);

        return SerenityRest.given()
                .contentType("application/json")
                .body(orderData)
                .post(BASE_URL);
    }

    public int getExistingOrderId() {
        return 10;
    }

    public Response getOrder(int orderId) {
        return RestAssured.given()
                .contentType("application/json")
                .get(BASE_URL + "/" + orderId);
    }
}

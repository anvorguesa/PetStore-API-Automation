package petstore.glue;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import org.junit.Assert;
import petstore.steps.StoreStep;

public class StoreStepDefs {

    private final StoreStep storeStep = new StoreStep();
    private Response response;
    private int orderId;

    @Given("que tengo los datos de la orden")
    public void tengoLosDatosDeLaOrden() {
        storeStep.createOrder();
    }

    @When("realizo una solicitud POST a {string}")
    public void realizoSolicitudPOST(String endpoint) {
        response = storeStep.postOrder();
        orderId = response.jsonPath().getInt("id");
    }

    @Then("valido que el código de respuesta sea {int}")
    public void validoCodigoRespuesta(int statusCode) {
        Assert.assertEquals(statusCode, response.getStatusCode());
    }

    @And("valido que la respuesta contenga el ID de la orden creada")
    public void validoIDOrdenCreada() {
        Assert.assertNotNull(orderId);
    }

    @Given("que tengo el ID de una orden existente")
    public void tengoIDOrdenExistente() {
        orderId = storeStep.getExistingOrderId();
    }

    @When("realizo una solicitud GET a {string}")
    public void realizoSolicitudGET(String endpoint) {
        response = storeStep.getOrder(orderId);
    }

    @And("valido que los datos de la orden sean correctos")
    public void validoDatosOrden() {
        Assert.assertEquals(orderId, response.jsonPath().getInt("id"));
    }
}

Feature: Validación de la API Store en PetStore

  @store
  Scenario: Crear una nueva orden de compra
    Given que tengo los datos de la orden
    When realizo una solicitud POST a "/store/order"
    Then valido que el código de respuesta sea 200
    And valido que la respuesta contenga el ID de la orden creada

  @store
  Scenario: Consultar una orden de compra existente
    Given que tengo el ID de una orden existente
    When realizo una solicitud GET a "/store/order/{orderId}"
    Then valido que el código de respuesta sea 200
    And valido que los datos de la orden sean correctos

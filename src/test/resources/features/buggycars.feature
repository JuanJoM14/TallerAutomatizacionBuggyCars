Feature: Registro, inicio de sesion y comentario sobre un auto en Buggy Cars

  Background:
    Given que el usuario abre Buggy Cars

  @registro
  Scenario: Registro exitoso de un usuario
    When se registra con datos validos
    Then deberia ver un mensaje de registro exitoso

  @registro_negativo
  Scenario Outline: Registro fallido con datos invalidos
    When se registra con "<username>" "<firstName>" "<lastName>" "<password>" "<confirmPassword>"
    Then deberia ver el mensaje de error "<error>"

    Examples:
      | username | firstName | lastName | password     | confirmPassword | error                                          |
      |          | Juan      | Tester   | Password123! | Password123!    | Login is required                              |
      | user1    | Juan      | Tester   | Password123! | Password999!    | Passwords do not match                         |
      | user2    | Juan      | Tester   | 123          | 123             | Password should contain at least 6 characters |

  @login
  Scenario: Inicio de sesion exitoso
    Given que existe un usuario registrado
    When inicia sesion con sus credenciales
    Then deberia ver su nombre de usuario en la sesion

  @comentario
  Scenario: Comentario exitoso sobre un auto
    Given que el usuario esta autenticado
    When selecciona un auto
    And deja un comentario sobre el auto
    Then deberia ver el comentario registrado

  @e2e
  Scenario: Flujo E2E completo de registro, inicio de sesion y comentario
    When se registra con datos validos
    And inicia sesion con sus credenciales
    And selecciona un auto
    And deja un comentario sobre el auto
    Then deberia ver el comentario registrado

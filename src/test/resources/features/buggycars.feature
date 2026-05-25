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

  @login_contrasena_incorrecta
  Scenario: Inicio de sesion fallido con contraseña incorrecta
    Given que existe un usuario registrado
    When inicia sesion con una contraseña incorrecta
    Then deberia ver el mensaje de error de login "Invalid username/password"

  @login_usuario_inexistente
  Scenario: Inicio de sesion fallido con usuario inexistente
    Given que existe un usuario registrado
    When inicia sesion con un usuario inexistente
    Then deberia ver el mensaje de error de login "Invalid username/password"

  @comentario
  Scenario: Comentario exitoso sobre un auto
    Given que el usuario esta autenticado
    When selecciona un auto
    And deja un comentario sobre el auto
    Then deberia ver el comentario registrado

  @comentario_sin_autenticacion
  Scenario: Comentario fallido sobre un auto sin iniciar sesion
    When selecciona un auto
    Then deberia ver que debe iniciar sesion para comentar

  @comentario_sin_auto
  Scenario: Comentario fallido sin seleccionar un auto
    Given que el usuario esta autenticado
    When intenta comentar sin seleccionar un auto
    Then no deberia ver el formulario de comentario

  @e2e
  Scenario: Flujo E2E completo de registro, inicio de sesion y comentario
    When se registra con datos validos
    And inicia sesion con sus credenciales
    And selecciona un auto
    And deja un comentario sobre el auto
    Then deberia ver el comentario registrado

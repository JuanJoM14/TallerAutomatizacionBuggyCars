package co.com.udea.certificacion.taller.buggycars.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class BuggyCarsStepDefinition {

    @Before
    public void config(){
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("usuario");
    }

    @Given("que el usuario abre Buggy Cars")
    public void queElUsuarioAbreBuggyCars() {
    }

    @Given("que existe un usuario registrado")
    public void queExisteUnUsuarioRegistrado() {
    }

    @Given("que el usuario esta autenticado")
    public void queElUsuarioEstaAutenticado() {
    }

    @When("se registra con datos validos")
    public void seRegistraConDatosValidos() {
    }

    @When("inicia sesion con sus credenciales")
    public void iniciaSesionConSusCredenciales() {
    }

    @When("selecciona un auto")
    public void seleccionaUnAuto() {
    }

    @When("deja un comentario sobre el auto")
    public void dejaUnComentarioSobreElAuto() {
    }

    @Then("deberia ver un mensaje de registro exitoso")
    public void deberiaVerUnMensajeDeRegistroExitoso() {
    }

    @Then("deberia ver su nombre de usuario en la sesion")
    public void deberiaVerSuNombreDeUsuarioEnLaSesion() {
    }

    @Then("deberia ver el comentario registrado")
    public void deberiaVerElComentarioRegistrado() {
    }
}

package co.com.udea.certificacion.taller.buggycars.stepdefinitions;

import co.com.udea.certificacion.taller.buggycars.models.BuggyCarsUser;
import co.com.udea.certificacion.taller.buggycars.questions.LoginWasSuccessful;
import co.com.udea.certificacion.taller.buggycars.questions.RegistrationWasSuccessful;
import co.com.udea.certificacion.taller.buggycars.tasks.OpenBuggyCars;
import co.com.udea.certificacion.taller.buggycars.tasks.LoginUser;
import co.com.udea.certificacion.taller.buggycars.tasks.RegisterUser;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

public class BuggyCarsStepDefinition {

    private BuggyCarsUser user;

    @Before
    public void config(){
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("usuario");
        user = BuggyCarsUser.withRandomData();
    }

    @Given("que el usuario abre Buggy Cars")
    public void queElUsuarioAbreBuggyCars() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                OpenBuggyCars.page()
        );
    }

    @Given("que existe un usuario registrado")
    public void queExisteUnUsuarioRegistrado() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                RegisterUser.withValidData(user)
        );
    }

    @Given("que el usuario esta autenticado")
    public void queElUsuarioEstaAutenticado() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                RegisterUser.withValidData(user),
                LoginUser.withValidData(user)
        );
    }

    @When("se registra con datos validos")
    public void seRegistraConDatosValidos() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                RegisterUser.withValidData(user)
        );
    }

    @When("inicia sesion con sus credenciales")
    public void iniciaSesionConSusCredenciales() {
        OnStage.theActorInTheSpotlight().attemptsTo(
            LoginUser.withValidData(user)
        );
    }

    @When("selecciona un auto")
    public void seleccionaUnAuto() {
    }

    @When("deja un comentario sobre el auto")
    public void dejaUnComentarioSobreElAuto() {
    }

    @Then("deberia ver un mensaje de registro exitoso")
    public void deberiaVerUnMensajeDeRegistroExitoso() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(RegistrationWasSuccessful.displayed(), is(true))
        );
    }

    @Then("deberia ver su nombre de usuario en la sesion")
    public void deberiaVerSuNombreDeUsuarioEnLaSesion() {
        OnStage.theActorInTheSpotlight().should(
            seeThat(LoginWasSuccessful.displayedFor(user), is(true))
        );
    }

    @Then("deberia ver el comentario registrado")
    public void deberiaVerElComentarioRegistrado() {
    }
}

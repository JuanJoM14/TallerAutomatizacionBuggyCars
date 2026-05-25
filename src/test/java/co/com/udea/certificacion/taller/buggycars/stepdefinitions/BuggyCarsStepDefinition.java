package co.com.udea.certificacion.taller.buggycars.stepdefinitions;

import co.com.udea.certificacion.taller.buggycars.models.BuggyCarsUser;
import co.com.udea.certificacion.taller.buggycars.questions.AuthenticationRequiredToComment;
import co.com.udea.certificacion.taller.buggycars.questions.CommentFormIsAvailable;
import co.com.udea.certificacion.taller.buggycars.questions.CommentWasRegistered;
import co.com.udea.certificacion.taller.buggycars.questions.LoginErrorMessageDisplayed;
import co.com.udea.certificacion.taller.buggycars.questions.LoginWasSuccessful;
import co.com.udea.certificacion.taller.buggycars.questions.RegistrationErrorMessageDisplayed;
import co.com.udea.certificacion.taller.buggycars.questions.RegistrationWasSuccessful;
import co.com.udea.certificacion.taller.buggycars.tasks.CommentOnSelectedCar;
import co.com.udea.certificacion.taller.buggycars.tasks.OpenBuggyCars;
import co.com.udea.certificacion.taller.buggycars.tasks.LoginUser;
import co.com.udea.certificacion.taller.buggycars.tasks.RegisterUser;
import co.com.udea.certificacion.taller.buggycars.tasks.SelectCar;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.udea.certificacion.taller.buggycars.userinterfaces.UserInterface.LOGOUT_LINK;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

public class BuggyCarsStepDefinition {

    private BuggyCarsUser user;
    private String carComment;

    @Before
    public void config(){
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("usuario");
        OnStage.theActorInTheSpotlight().attemptsTo(
                OpenBuggyCars.page()
        );

        if (LOGOUT_LINK.resolveFor(OnStage.theActorInTheSpotlight()).isVisible()) {
            OnStage.theActorInTheSpotlight().attemptsTo(
                    Click.on(LOGOUT_LINK)
            );
        }
        user = BuggyCarsUser.withRandomData();
        carComment = "Comentario automatizado sobre el auto " + System.currentTimeMillis();
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

    @When("se registra con {string} {string} {string} {string} {string}")
    public void seRegistraConDatosParametrizados(String username, String firstName, String lastName, String password, String confirmPassword) {
        user = BuggyCarsUser.withData(username, firstName, lastName, password, confirmPassword);

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

    @When("inicia sesion con una contrase\u00f1a incorrecta")
    public void iniciaSesionConUnaContrasenaIncorrecta() {
        BuggyCarsUser invalidCredentials = BuggyCarsUser.withData(
                user.getUsername(),
                user.getFirstName(),
                user.getLastName(),
                user.getPassword() + "1",
                user.getPassword() + "1"
        );

        OnStage.theActorInTheSpotlight().attemptsTo(
                LoginUser.withValidData(invalidCredentials)
        );
    }

    @When("inicia sesion con un usuario inexistente")
    public void iniciaSesionConUnUsuarioInexistente() {
        BuggyCarsUser invalidCredentials = BuggyCarsUser.withData(
                "ghost" + System.currentTimeMillis(),
                user.getFirstName(),
                user.getLastName(),
                user.getPassword(),
                user.getPassword()
        );

        OnStage.theActorInTheSpotlight().attemptsTo(
                LoginUser.withValidData(invalidCredentials)
        );
    }

    @When("selecciona un auto")
    public void seleccionaUnAuto() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SelectCar.popularModel()
        );
    }

    @When("deja un comentario sobre el auto")
    public void dejaUnComentarioSobreElAuto() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                CommentOnSelectedCar.with(carComment)
        );
    }

    @When("intenta comentar sin seleccionar un auto")
    public void intentaComentarSinSeleccionarUnAuto() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                OpenBuggyCars.page()
        );
    }

    @Then("deberia ver un mensaje de registro exitoso")
    public void deberiaVerUnMensajeDeRegistroExitoso() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(RegistrationWasSuccessful.displayed(), is(true))
        );
    }

    @Then("deberia ver el mensaje de error {string}")
    public void deberiaVerElMensajeDeError(String expectedMessage) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(RegistrationErrorMessageDisplayed.withText(expectedMessage), is(true))
        );
    }

    @Then("deberia ver su nombre de usuario en la sesion")
    public void deberiaVerSuNombreDeUsuarioEnLaSesion() {
        OnStage.theActorInTheSpotlight().should(
            seeThat(LoginWasSuccessful.displayedFor(user), is(true))
        );
    }

    @Then("deberia ver el mensaje de error de login {string}")
    public void deberiaVerElMensajeDeErrorDeLogin(String expectedMessage) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(LoginErrorMessageDisplayed.withText(expectedMessage), is(true))
        );
    }

    @Then("deberia ver el comentario registrado")
    public void deberiaVerElComentarioRegistrado() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(CommentWasRegistered.withText(carComment), is(true))
        );
    }

    @Then("deberia ver que debe iniciar sesion para comentar")
    public void deberiaVerQueDebeIniciarSesionParaComentar() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(AuthenticationRequiredToComment.displayed(), is(true))
        );
    }

    @Then("no deberia ver el formulario de comentario")
    public void noDeberiaVerElFormularioDeComentario() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(CommentFormIsAvailable.displayed(), is(false))
        );
    }
}


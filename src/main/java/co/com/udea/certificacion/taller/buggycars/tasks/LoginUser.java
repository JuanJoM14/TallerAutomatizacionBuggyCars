package co.com.udea.certificacion.taller.buggycars.tasks;

import co.com.udea.certificacion.taller.buggycars.interactions.FillLoginForm;
import co.com.udea.certificacion.taller.buggycars.interactions.SubmitLogin;
import co.com.udea.certificacion.taller.buggycars.models.BuggyCarsUser;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.udea.certificacion.taller.buggycars.userinterfaces.UserInterface.LOGOUT_LINK;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LoginUser implements Task {

    private final BuggyCarsUser user;

    public LoginUser(BuggyCarsUser user) {
        this.user = user;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                FillLoginForm.with(user),
                SubmitLogin.form(),
                WaitUntil.the(LOGOUT_LINK, isVisible()).forNoMoreThan(15).seconds()
        );
    }

    public static LoginUser withValidData(BuggyCarsUser user) {
        return instrumented(LoginUser.class, user);
    }
}
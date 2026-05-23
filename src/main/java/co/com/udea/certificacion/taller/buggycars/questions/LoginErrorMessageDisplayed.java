package co.com.udea.certificacion.taller.buggycars.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class LoginErrorMessageDisplayed implements Question<Boolean> {

    private final String expectedMessage;

    public LoginErrorMessageDisplayed(String expectedMessage) {
        this.expectedMessage = expectedMessage;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        Target loginError = Target.the("login error message")
                .locatedBy("//*[contains(.,'" + expectedMessage + "')]");

        WaitUntil.the(loginError, isVisible()).forNoMoreThan(10).seconds().performAs(actor);
        return loginError.resolveFor(actor).isVisible();
    }

    public static LoginErrorMessageDisplayed withText(String expectedMessage) {
        return new LoginErrorMessageDisplayed(expectedMessage);
    }
}
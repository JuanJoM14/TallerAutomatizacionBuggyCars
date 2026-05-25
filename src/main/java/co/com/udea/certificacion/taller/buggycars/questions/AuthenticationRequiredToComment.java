package co.com.udea.certificacion.taller.buggycars.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.udea.certificacion.taller.buggycars.userinterfaces.UserInterface.LOGIN_REQUIRED_TO_VOTE_MESSAGE;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AuthenticationRequiredToComment implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        WaitUntil.the(LOGIN_REQUIRED_TO_VOTE_MESSAGE, isVisible()).forNoMoreThan(15).seconds().performAs(actor);
        return LOGIN_REQUIRED_TO_VOTE_MESSAGE.resolveFor(actor).isVisible();
    }

    public static AuthenticationRequiredToComment displayed() {
        return new AuthenticationRequiredToComment();
    }
}

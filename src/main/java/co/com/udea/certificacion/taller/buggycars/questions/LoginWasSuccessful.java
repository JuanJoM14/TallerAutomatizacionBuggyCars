package co.com.udea.certificacion.taller.buggycars.questions;

import co.com.udea.certificacion.taller.buggycars.models.BuggyCarsUser;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.targets.Target;

import static co.com.udea.certificacion.taller.buggycars.userinterfaces.UserInterface.LOGOUT_LINK;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class LoginWasSuccessful implements Question<Boolean> {

    private final BuggyCarsUser user;

    public LoginWasSuccessful(BuggyCarsUser user) {
        this.user = user;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        Target greeting = Target.the("authenticated user greeting")
            .locatedBy("//li[contains(.,'Hi,')]");

        WaitUntil.the(greeting, isVisible()).forNoMoreThan(15).seconds().performAs(actor);
        WaitUntil.the(LOGOUT_LINK, isVisible()).forNoMoreThan(15).seconds().performAs(actor);

        return greeting.resolveFor(actor).getText().contains(user.getFirstName())
            && LOGOUT_LINK.resolveFor(actor).isVisible();
    }

    public static LoginWasSuccessful displayedFor(BuggyCarsUser user) {
        return new LoginWasSuccessful(user);
    }
}
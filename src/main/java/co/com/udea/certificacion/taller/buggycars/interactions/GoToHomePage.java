package co.com.udea.certificacion.taller.buggycars.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.udea.certificacion.taller.buggycars.userinterfaces.UserInterface.HOME_LINK;
import static co.com.udea.certificacion.taller.buggycars.userinterfaces.UserInterface.POPULAR_MODEL_LINK;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class GoToHomePage implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(HOME_LINK, isClickable()).forNoMoreThan(15).seconds(),
                Click.on(HOME_LINK),
                WaitUntil.the(POPULAR_MODEL_LINK, isVisible()).forNoMoreThan(15).seconds()
        );
    }

    public static GoToHomePage inBuggyCars() {
        return instrumented(GoToHomePage.class);
    }
}

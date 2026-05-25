package co.com.udea.certificacion.taller.buggycars.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.udea.certificacion.taller.buggycars.userinterfaces.UserInterface.POPULAR_MODEL_LINK;
import static co.com.udea.certificacion.taller.buggycars.userinterfaces.UserInterface.SELECTED_MODEL_NAME;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class GoToPopularCarDetail implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(POPULAR_MODEL_LINK, isClickable()).forNoMoreThan(15).seconds(),
                Click.on(POPULAR_MODEL_LINK),
                WaitUntil.the(SELECTED_MODEL_NAME, isVisible()).forNoMoreThan(15).seconds()
        );
    }

    public static GoToPopularCarDetail page() {
        return instrumented(GoToPopularCarDetail.class);
    }
}

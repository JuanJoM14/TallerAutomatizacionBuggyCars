package co.com.udea.certificacion.taller.buggycars.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.udea.certificacion.taller.buggycars.userinterfaces.UserInterface.VOTE_BUTTON;
import static co.com.udea.certificacion.taller.buggycars.userinterfaces.UserInterface.VOTE_SUCCESS_MESSAGE;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SubmitCarComment implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(VOTE_BUTTON, isClickable()).forNoMoreThan(15).seconds(),
                Click.on(VOTE_BUTTON),
                WaitUntil.the(VOTE_SUCCESS_MESSAGE, isVisible()).forNoMoreThan(15).seconds()
        );
    }

    public static SubmitCarComment now() {
        return instrumented(SubmitCarComment.class);
    }
}

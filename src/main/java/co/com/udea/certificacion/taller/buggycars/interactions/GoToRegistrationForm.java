package co.com.udea.certificacion.taller.buggycars.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.udea.certificacion.taller.buggycars.userinterfaces.UserInterface.REGISTER_LINK;
import static co.com.udea.certificacion.taller.buggycars.userinterfaces.UserInterface.USERNAME_FIELD;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class GoToRegistrationForm implements net.serenitybdd.screenplay.Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(REGISTER_LINK, isClickable()).forNoMoreThan(15).seconds(),
                Click.on(REGISTER_LINK),
                WaitUntil.the(USERNAME_FIELD, isVisible()).forNoMoreThan(15).seconds()
        );
    }

    public static GoToRegistrationForm page() {
        return instrumented(GoToRegistrationForm.class);
    }
}

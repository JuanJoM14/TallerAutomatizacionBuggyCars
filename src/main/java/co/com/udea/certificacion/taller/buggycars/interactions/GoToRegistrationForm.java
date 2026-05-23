package co.com.udea.certificacion.taller.buggycars.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.udea.certificacion.taller.buggycars.userinterfaces.UserInterface.REGISTER_LINK;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import co.com.udea.certificacion.taller.buggycars.utils.WaitABit;

public class GoToRegistrationForm implements net.serenitybdd.screenplay.Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitABit.forMillis(1500),
                Click.on(REGISTER_LINK)
        );
    }

    public static GoToRegistrationForm page() {
        return instrumented(GoToRegistrationForm.class);
    }
}

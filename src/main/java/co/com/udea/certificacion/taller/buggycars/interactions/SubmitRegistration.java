package co.com.udea.certificacion.taller.buggycars.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.udea.certificacion.taller.buggycars.userinterfaces.UserInterface.REGISTER_BUTTON;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SubmitRegistration implements net.serenitybdd.screenplay.Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(REGISTER_BUTTON)
        );
    }

    public static SubmitRegistration form() {
        return instrumented(SubmitRegistration.class);
    }
}

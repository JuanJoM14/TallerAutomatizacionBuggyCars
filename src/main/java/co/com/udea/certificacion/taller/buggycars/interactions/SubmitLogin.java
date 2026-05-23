package co.com.udea.certificacion.taller.buggycars.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.udea.certificacion.taller.buggycars.userinterfaces.UserInterface.LOGIN_BUTTON;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import co.com.udea.certificacion.taller.buggycars.utils.WaitABit;

public class SubmitLogin implements net.serenitybdd.screenplay.Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitABit.forMillis(1500),
                Click.on(LOGIN_BUTTON)
        );
    }

    public static SubmitLogin form() {
        return instrumented(SubmitLogin.class);
    }
}
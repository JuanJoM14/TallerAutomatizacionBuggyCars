package co.com.udea.certificacion.taller.buggycars.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.udea.certificacion.taller.buggycars.userinterfaces.UserInterface.REGISTRATION_SUCCESS_MESSAGE;

public class RegistrationWasSuccessful implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return REGISTRATION_SUCCESS_MESSAGE.resolveFor(actor).waitUntilVisible().isVisible();
    }

    public static RegistrationWasSuccessful displayed() {
        return new RegistrationWasSuccessful();
    }
}

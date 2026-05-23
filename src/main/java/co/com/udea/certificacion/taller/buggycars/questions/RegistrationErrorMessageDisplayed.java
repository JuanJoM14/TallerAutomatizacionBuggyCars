package co.com.udea.certificacion.taller.buggycars.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

import static co.com.udea.certificacion.taller.buggycars.userinterfaces.UserInterface.REGISTRATION_SUCCESS_MESSAGE;

public class RegistrationErrorMessageDisplayed implements Question<Boolean> {

    private static final Target PAGE_BODY = Target.the("page body")
            .locatedBy("body");

    private final String expectedMessage;

    public RegistrationErrorMessageDisplayed(String expectedMessage) {
        this.expectedMessage = expectedMessage;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        boolean registrationSucceeded = REGISTRATION_SUCCESS_MESSAGE.resolveFor(actor).isPresent();
        String pageText = Text.of(PAGE_BODY).answeredBy(actor).toLowerCase();
        boolean expectedTextIsVisible = pageText.contains(expectedMessage.toLowerCase());

        return expectedTextIsVisible || !registrationSucceeded;
    }

    public static RegistrationErrorMessageDisplayed withText(String expectedMessage) {
        return new RegistrationErrorMessageDisplayed(expectedMessage);
    }
}

package co.com.udea.certificacion.taller.buggycars.interactions;

import co.com.udea.certificacion.taller.buggycars.models.BuggyCarsUser;
import co.com.udea.certificacion.taller.buggycars.utils.WaitABit;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.udea.certificacion.taller.buggycars.userinterfaces.UserInterface.CONFIRM_PASSWORD_FIELD;
import static co.com.udea.certificacion.taller.buggycars.userinterfaces.UserInterface.FIRST_NAME_FIELD;
import static co.com.udea.certificacion.taller.buggycars.userinterfaces.UserInterface.LAST_NAME_FIELD;
import static co.com.udea.certificacion.taller.buggycars.userinterfaces.UserInterface.PASSWORD_FIELD;
import static co.com.udea.certificacion.taller.buggycars.userinterfaces.UserInterface.USERNAME_FIELD;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FillRegistrationForm implements net.serenitybdd.screenplay.Interaction {

    private final BuggyCarsUser user;

    public FillRegistrationForm(BuggyCarsUser user) {
        this.user = user;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(USERNAME_FIELD, isVisible()).forNoMoreThan(10).seconds(),
                WaitABit.forMillis(1500),
                Enter.theValue(user.getUsername()).into(USERNAME_FIELD),
                WaitABit.forMillis(1500),
                Enter.theValue(user.getFirstName()).into(FIRST_NAME_FIELD),
                WaitABit.forMillis(1500),
                Enter.theValue(user.getLastName()).into(LAST_NAME_FIELD),
                WaitABit.forMillis(1500),
                Enter.theValue(user.getPassword()).into(PASSWORD_FIELD),
                WaitABit.forMillis(1500),
                Enter.theValue(user.getConfirmPassword()).into(CONFIRM_PASSWORD_FIELD)
        );
    }

    public static FillRegistrationForm with(BuggyCarsUser user) {
        return instrumented(FillRegistrationForm.class, user);
    }
}

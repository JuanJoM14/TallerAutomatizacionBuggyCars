package co.com.udea.certificacion.taller.buggycars.interactions;

import co.com.udea.certificacion.taller.buggycars.models.BuggyCarsUser;
import co.com.udea.certificacion.taller.buggycars.utils.WaitABit;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.udea.certificacion.taller.buggycars.userinterfaces.UserInterface.LOGIN_FIELD;
import static co.com.udea.certificacion.taller.buggycars.userinterfaces.UserInterface.LOGIN_PASSWORD_FIELD;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FillLoginForm implements net.serenitybdd.screenplay.Interaction {

    private final BuggyCarsUser user;

    public FillLoginForm(BuggyCarsUser user) {
        this.user = user;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LOGIN_FIELD, isVisible()).forNoMoreThan(10).seconds(),

                WaitABit.forMillis(1500),
                Enter.theValue(user.getUsername()).into(LOGIN_FIELD),

                WaitABit.forMillis(1500),
                Enter.theValue(user.getPassword()).into(LOGIN_PASSWORD_FIELD),

                WaitABit.forMillis(1500)
        );
    }

    public static FillLoginForm with(BuggyCarsUser user) {
        return instrumented(FillLoginForm.class, user);
    }
}
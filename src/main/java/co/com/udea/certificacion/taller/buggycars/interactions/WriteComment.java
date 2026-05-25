package co.com.udea.certificacion.taller.buggycars.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.udea.certificacion.taller.buggycars.userinterfaces.UserInterface.COMMENT_FIELD;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class WriteComment implements Interaction {

    private final String comment;

    public WriteComment(String comment) {
        this.comment = comment;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(COMMENT_FIELD, isVisible()).forNoMoreThan(15).seconds(),
                Enter.theValue(comment).into(COMMENT_FIELD)
        );
    }

    public static WriteComment withText(String comment) {
        return instrumented(WriteComment.class, comment);
    }
}

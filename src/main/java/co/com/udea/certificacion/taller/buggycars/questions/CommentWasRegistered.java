package co.com.udea.certificacion.taller.buggycars.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.udea.certificacion.taller.buggycars.userinterfaces.UserInterface.VOTE_SUCCESS_MESSAGE;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CommentWasRegistered implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        WaitUntil.the(VOTE_SUCCESS_MESSAGE, isVisible()).forNoMoreThan(15).seconds().performAs(actor);
        return VOTE_SUCCESS_MESSAGE.resolveFor(actor).isVisible();
    }

    public static CommentWasRegistered withText(String comment) {
        return new CommentWasRegistered();
    }
}

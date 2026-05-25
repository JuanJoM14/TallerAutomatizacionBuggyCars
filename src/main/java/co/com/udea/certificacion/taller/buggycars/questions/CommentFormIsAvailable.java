package co.com.udea.certificacion.taller.buggycars.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.udea.certificacion.taller.buggycars.userinterfaces.UserInterface.COMMENT_FIELD;

public class CommentFormIsAvailable implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return COMMENT_FIELD.resolveAllFor(actor).stream().anyMatch(commentField -> commentField.isVisible());
    }

    public static CommentFormIsAvailable displayed() {
        return new CommentFormIsAvailable();
    }
}

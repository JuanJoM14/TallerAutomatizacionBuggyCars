package co.com.udea.certificacion.taller.buggycars.tasks;

import co.com.udea.certificacion.taller.buggycars.interactions.SubmitCarComment;
import co.com.udea.certificacion.taller.buggycars.interactions.WriteComment;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CommentOnSelectedCar implements Task {

    private final String comment;

    public CommentOnSelectedCar(String comment) {
        this.comment = comment;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WriteComment.withText(comment),
                SubmitCarComment.now()
        );
    }

    public static CommentOnSelectedCar with(String comment) {
        return instrumented(CommentOnSelectedCar.class, comment);
    }
}

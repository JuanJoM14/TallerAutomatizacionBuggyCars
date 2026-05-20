package co.com.udea.certificacion.taller.buggycars.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenBuggyCars implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().thePageNamed("pages.buggyCarsUrl")
        );
    }

    public static OpenBuggyCars page() {
        return instrumented(OpenBuggyCars.class);
    }
}

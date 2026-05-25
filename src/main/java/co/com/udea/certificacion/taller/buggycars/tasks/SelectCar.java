package co.com.udea.certificacion.taller.buggycars.tasks;

import co.com.udea.certificacion.taller.buggycars.interactions.GoToHomePage;
import co.com.udea.certificacion.taller.buggycars.interactions.GoToPopularCarDetail;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectCar implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                GoToHomePage.inBuggyCars(),
                GoToPopularCarDetail.page()
        );
    }

    public static SelectCar popularModel() {
        return instrumented(SelectCar.class);
    }
}

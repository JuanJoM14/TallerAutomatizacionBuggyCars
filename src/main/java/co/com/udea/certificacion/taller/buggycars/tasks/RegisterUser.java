package co.com.udea.certificacion.taller.buggycars.tasks;

import co.com.udea.certificacion.taller.buggycars.interactions.FillRegistrationForm;
import co.com.udea.certificacion.taller.buggycars.interactions.GoToRegistrationForm;
import co.com.udea.certificacion.taller.buggycars.interactions.SubmitRegistration;
import co.com.udea.certificacion.taller.buggycars.models.BuggyCarsUser;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RegisterUser implements Task {

    private final BuggyCarsUser user;

    public RegisterUser(BuggyCarsUser user) {
        this.user = user;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                GoToRegistrationForm.page(),
                FillRegistrationForm.with(user),
                SubmitRegistration.form()
        );
    }

    public static RegisterUser withValidData(BuggyCarsUser user) {
        return instrumented(RegisterUser.class, user);
    }
}

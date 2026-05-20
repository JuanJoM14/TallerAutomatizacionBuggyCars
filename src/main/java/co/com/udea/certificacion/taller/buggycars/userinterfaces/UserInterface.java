package co.com.udea.certificacion.taller.buggycars.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class UserInterface {
    private UserInterface(){}

    public static final Target REGISTER_LINK = Target.the("register link")
            .locatedBy("//a[contains(.,'Register')]");

    public static final Target USERNAME_FIELD = Target.the("username field")
            .locatedBy("#username");

    public static final Target FIRST_NAME_FIELD = Target.the("first name field")
            .locatedBy("#firstName");

    public static final Target LAST_NAME_FIELD = Target.the("last name field")
            .locatedBy("#lastName");

    public static final Target PASSWORD_FIELD = Target.the("password field")
            .locatedBy("#password");

    public static final Target CONFIRM_PASSWORD_FIELD = Target.the("confirm password field")
            .locatedBy("#confirmPassword");

    public static final Target REGISTER_BUTTON = Target.the("register button")
            .locatedBy("//button[contains(.,'Register')]");

    public static final Target REGISTRATION_SUCCESS_MESSAGE = Target.the("registration success message")
            .locatedBy("//*[contains(text(),'Registration is successful')]");
}

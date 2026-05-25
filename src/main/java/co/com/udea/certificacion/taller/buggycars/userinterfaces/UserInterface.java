package co.com.udea.certificacion.taller.buggycars.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class UserInterface {
    private UserInterface(){}

    public static final Target REGISTER_LINK = Target.the("register link")
            .locatedBy("//a[contains(.,'Register')]");

    public static final Target LOGIN_FIELD = Target.the("login field")
            .locatedBy("(//input[@name='login'])[1]");

    public static final Target LOGIN_PASSWORD_FIELD = Target.the("login password field")
            .locatedBy("(//input[@name='password'])[1]");

    public static final Target LOGIN_BUTTON = Target.the("login button")
            .locatedBy("(//button[contains(.,'Login')])[1]");

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
            .locatedBy("/html/body/my-app/div/main/my-register/div/div/form/button");

    public static final Target REGISTRATION_SUCCESS_MESSAGE = Target.the("registration success message")
            .locatedBy("//*[contains(text(),'Registration is successful')]");

    public static final Target LOGOUT_LINK = Target.the("logout link")
            .locatedBy("//a[contains(.,'Logout')]");

    public static final Target HOME_LINK = Target.the("Buggy Rating home link")
            .locatedBy("//a[contains(@class,'navbar-brand') and normalize-space()='Buggy Rating']");

    public static final Target POPULAR_MODEL_LINK = Target.the("popular model link")
            .locatedBy("//h2[normalize-space()='Popular Model']/following-sibling::a[contains(@href,'/model/')]");

    public static final Target SELECTED_MODEL_NAME = Target.the("selected model name")
            .locatedBy("//*[contains(normalize-space(.),'Lamborghini') and contains(normalize-space(.),'Diablo')]");

    public static final Target COMMENT_FIELD = Target.the("comment field")
            .locatedBy("//textarea[@id='comment' or @name='comment']");

    public static final Target VOTE_BUTTON = Target.the("vote button")
            .locatedBy("//button[contains(normalize-space(.),'Vote')]");

    public static final Target VOTE_SUCCESS_MESSAGE = Target.the("vote success message")
            .locatedBy("//*[contains(normalize-space(.),'Thank you for your vote')]");

    public static final Target LOGIN_REQUIRED_TO_VOTE_MESSAGE = Target.the("login required to vote message")
            .locatedBy("//*[contains(normalize-space(.),'You need to be logged in to vote')]");
}


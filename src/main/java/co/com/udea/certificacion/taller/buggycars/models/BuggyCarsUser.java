package co.com.udea.certificacion.taller.buggycars.models;

public class BuggyCarsUser {

    private final String username;
    private final String firstName;
    private final String lastName;
    private final String password;
    private final String confirmPassword;

    private BuggyCarsUser(String username, String firstName, String lastName, String password, String confirmPassword) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public static BuggyCarsUser withRandomData() {
        String suffix = String.valueOf(System.currentTimeMillis());
        String password = "Password123!";

        return new BuggyCarsUser(
                "user" + suffix,
                "Juan",
                "Tester",
                password,
                password
        );
    }

    public static BuggyCarsUser withData(String username, String firstName, String lastName, String password, String confirmPassword) {
        return new BuggyCarsUser(username, firstName, lastName, password, confirmPassword);
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }
}

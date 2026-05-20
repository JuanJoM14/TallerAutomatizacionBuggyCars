package co.com.udea.certificacion.taller.buggycars.models;

public class BuggyCarsUser {

    private final String username;
    private final String firstName;
    private final String lastName;
    private final String password;

    private BuggyCarsUser(String username, String firstName, String lastName, String password) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public static BuggyCarsUser withRandomData() {
        String suffix = String.valueOf(System.currentTimeMillis());
        return new BuggyCarsUser(
                "user" + suffix,
                "Juan",
                "Tester",
                "Password123!"
        );
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
}

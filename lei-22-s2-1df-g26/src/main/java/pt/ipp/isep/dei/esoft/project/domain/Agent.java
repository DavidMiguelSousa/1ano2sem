package pt.ipp.isep.dei.esoft.project.domain;

public class Agent {

    private final String email;

    private String name;

    private String phoneNumber;

    private Passport passport;

    private Location location;

    private String taxNumber;

    public String getName() {
        return name;
    }

    public Agent(String email, String name, String phoneNumber, Passport passport, Location location, String taxNumber) {
        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.passport = passport;
        this.location = location;
        this.taxNumber = taxNumber;
    }

    public Agent(String email) { this.email = email; }

    public Agent clone() {
        return new Agent(this.email);
    }

}


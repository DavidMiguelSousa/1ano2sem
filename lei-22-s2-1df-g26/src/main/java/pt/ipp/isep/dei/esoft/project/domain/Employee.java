package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;

public class Employee {

    private final String email;
    private String name;
    private String phone;
    private Passport passport; // verifies itself
    private Location location;
    private String taxNumber;
    private Role role;
    private Agency agency;

    public Employee(String email) {
        this.email = email;
    }

    public Employee(String email, String name, String phoneNumber, Passport passport, Location location, String taxNumber, Role role, Agency agency) {
        //verifyAgency(agency);
        verifyEmail(email);
        verifyName(name);
        verifyPhone(phoneNumber);
        verifyTaxNumber(taxNumber);
        this.email = email;
        this.name = name;
        this.phone = phoneNumber;
        this.passport = passport;
        this.location = location;
        this.taxNumber = taxNumber;
        this.role = role;
        this.agency = agency;
    }

    private void verifyName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid name.");
        }
    }

    private void verifyPhone(String phoneNumber) {
        String regex = "[2-9][0-8][1-9][2-9][0-9][0-9][0-9][0-9][0-9][0-9]";
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid phone number.");
        }
        if (!phoneNumber.matches(regex)) {
            throw new IllegalArgumentException("Invalid phone number.");
        }
    }

    private void verifyEmail(String email) {
         final String EMAIL_REGEX =
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

         if(email == null || email.isBlank() || email.isEmpty())
             throw new IllegalArgumentException("An email must be provided.\n");

         if(!email.matches(EMAIL_REGEX))
             throw new IllegalArgumentException("Invalid email.\n");

    }

    private void verifyAgency(Agency agency) {
        if(agency == null)
            throw new IllegalArgumentException("Agency must be provided in order to create an employee.\n");
    }

    public boolean hasEmail(String email) {
        return this.email.equals(email);
    }


    /**
     * Clone method.
     *
     * @return A clone of the current instance.
     */
    public Employee clone() {
        return new Employee(this.email);
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public Location getAddress() {
        return location;
    }

    public void setAddress(Location location) {
        this.location = location;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    private static void verifyTaxNumber(String taxNumber) { //regex from this website: https://www.geeksforgeeks.org/how-to-validate-ssn-social-security-number-using-regular-expression/
        String regex = "[0-9]{9}";
        if (taxNumber == null || taxNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid tax number.");
        }
        if(!taxNumber.matches(regex)) {
            throw new IllegalArgumentException("Invalid tax number.");
        }
    }


    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    @Override
    public String toString() {
        return
                "Email: " + this.email + "\n" +
                "Name: " + this.name + "\n" +
                "Phone Number:" + this.phone + "\n" +
                "Tax Number: " + this.taxNumber + "\n" +
                passport.toString() + "\n" +
                //"Agency ID: " +  //agency.getId() + "\n" +
                "Role: " + this.role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(email, employee.email);
    }
    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}

package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test void ensureTwoEmployeesWithSameEmailEquals() {
        Employee employee1 = new Employee("john.doe@this.company.com");
        Employee employee2 = new Employee("john.doe@this.company.com");
        assertEquals(employee1, employee2);
    }

    @Test void ensureEmployeeWithDifferentEmailNotEquals() {
        Employee employee1 = new Employee("john.doe@this.company.com");
        Employee employee2 = new Employee("jane.doe@this.company.com");
        assertNotEquals(employee1, employee2);
    }

    @Test void ensureEmployeeDoesNotEqualNull() {
        Employee employee1 = new Employee("john.doe@this.company.com");
        assertNotEquals(employee1, null);
    }

    @Test void ensureEmployeeDoesNotEqualOtherObject() {
        Employee employee1 = new Employee("john.doe@this.company.com");
        assertNotEquals(employee1, new Object());
    }

    @Test void ensureTheSameObjectIsEqual() {
        Employee employee1 = new Employee("john.doe@this.company.com");
        assertEquals(employee1, employee1);
    }

    @Test void ensureHashCodeIsEqualForEqualObjects() {
        String email = "john.doe@this.company.com";
        Employee employee1 = new Employee(email);
        Employee employee2 = new Employee(email);
        assertEquals(employee1.hashCode(), employee2.hashCode());
    }

    @Test void ensureHashCodeIsNotEqualForDifferentObjects() {

        Employee employee1 = new Employee("john.doe@this.company.com");
        Employee employee2 = new Employee("jane.doe@this.company.com");
        assertNotEquals(employee1.hashCode(), employee2.hashCode());
    }

    @Test void ensureHasEmailWorksForTheSameEmail() {
        String email = "john.doe@this.compay.org";
        Employee employee = new Employee(email);
        assertTrue(employee.hasEmail(email));

    }

    @Test void ensureHasEmailFailsForDifferentEmails() {
        String email = "john.doe@this.company.com";
        Employee employee = new Employee(email);
        assertFalse(employee.hasEmail("jane.doe@this.company.com"));

    }

    @Test
    void ensureCloneWorks(){
        String email = "john.doe@this.company.com";
        Employee employee = new Employee(email);
        Employee clone = employee.clone();
        assertEquals(employee, clone);
    }
    @Test void ensureInvalidPhone() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Employee("test@example.com", "Test Employee", "12345",
                    new Passport("123456789","",""), new Location("State", "City", "District", "123 Main St", "1234-567"),
                    "123456789", Role.STORE_MANAGER, new Agency("123"));
        });
    }
    @Test void ensureTwoEmployeesCanHaveSameTaxNumberButDifferentRolesAndEmail() {
        Employee employee1 = new Employee("test1@example.com", "Test Employee", "12345",
                new Passport("123456789", "", ""), new Location("State", "City", "District", "123 Main St", "1234-567"),
                "123456789", Role.STORE_MANAGER, new Agency("123"));
        Employee employee2 = new Employee("test2@example.com", "Test Employee", "12345",
                new Passport("123456789", "", ""), new Location("State", "City", "District", "123 Main St", "1234-567"),
                "123456789", Role.AGENT, new Agency("123"));
        Employee employee3 = new Employee("test1@example.com", "Test Employee", "12345",
                new Passport("123456789", "", ""), new Location("State", "City", "District", "123 Main St", "1234-567"),
                "123456789", Role.AGENT, new Agency("123"));
        assertEquals(employee1, employee2);
        assertThrows(IllegalArgumentException.class, () -> {
            employee1.equals(employee3);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            employee2.equals(employee3);
        });
    }

}
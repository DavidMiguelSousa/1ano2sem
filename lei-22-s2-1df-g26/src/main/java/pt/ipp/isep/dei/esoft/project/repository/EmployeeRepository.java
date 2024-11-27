package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.*;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    private List<Employee> employees = new ArrayList<>();

    public Employee save(Employee emp){
        if(emp == null)
            throw new IllegalArgumentException("Employee must be provided");

        this.employees.add(emp);

        return emp;
    }

    public Employee create(
            String email,
            String name,
            Role role,
            String phoneNumber,
            String passportNumber,
            String passportDateOfIssue,
            String passportDateOfExpiry,
            String state,
            String city,
            String district,
            String street,
            String zipCode,
            String taxNumber,
            Agency agency,
            boolean storeAddress
    ) {
        Passport employeePassport = new Passport(passportNumber, passportDateOfIssue, passportDateOfExpiry);
        Location employeeLocation;
        if(storeAddress)
            employeeLocation = new Location(state, city, district, street, zipCode);
        else
            employeeLocation = null;

        Employee emp = new Employee(email, name, phoneNumber, employeePassport, employeeLocation, taxNumber, role, agency);

        validateEmployee(emp);

        return emp;

    }

    public void validateEmployee(Employee emp){
        for (Employee employee : this.employees) {
            if(emp.equals(employee)){
                throw new IllegalArgumentException("Employee was already registered.");
            }
        }
    }
}

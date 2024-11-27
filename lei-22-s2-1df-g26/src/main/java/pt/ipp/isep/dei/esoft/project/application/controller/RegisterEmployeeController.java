package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Agency;
import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.domain.Role;
import pt.ipp.isep.dei.esoft.project.repository.AgencyRepository;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.EmployeeRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.PasswordGenerator;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;
import pt.isep.lei.esoft.auth.domain.model.User;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class RegisterEmployeeController {

    private final EmployeeRepository employeeRepo = Repositories.getInstance().getEmployeeRepository();
    private final AgencyRepository agencyRepo = Repositories.getInstance().getAgencyRepository();
    private final AuthenticationRepository authRepo = Repositories.getInstance().getAuthenticationRepository();

    private Employee emp;
    private String passwordGenerated;

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
            ){

        this.emp = employeeRepo.create(
                email,
                name,
                role,
                phoneNumber,sa
                passportNumber,
                passportDateOfIssue,
                passportDateOfExpiry,
                state,
                city,
                district,
                street,
                zipCode,
                taxNumber,
                agency,
                storeAddress
        );

        return emp;
    }

    public Employee saveEmployee(){
        if(emp == null)
            throw new IllegalArgumentException("Employee was not yet created.");

        passwordGenerated = PasswordGenerator.generatePassword();
        if(!authRepo.addUserWithRole(emp.getName(), emp.getEmail(), passwordGenerated, emp.getRole().toString()))
            throw new IllegalArgumentException("Employee could not be registered.");

        employeeRepo.save(emp);

        return emp;
    }

    public List<Agency> getAgencies(){
        return agencyRepo.getAgencies();
    }

    public String generatedPass() {
        return passwordGenerated; // only used since we need to retrieve the pass
    }


    public void writeToFileData(){
        try {
            File file = new File("employee.txt");
            FileWriter writer = new FileWriter(file);
            writer.append("Employee Registered: \n" + this.emp + "\n\nGenerated pass of such employee: " + generatedPass());
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.RegisterEmployeeController;
import pt.ipp.isep.dei.esoft.project.domain.Agency;
import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.domain.Passport;
import pt.ipp.isep.dei.esoft.project.domain.Role;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class RegisterEmployeeUI implements Runnable {

    private final RegisterEmployeeController ctrl;
    List<Role> roles = new ArrayList<>();

    public RegisterEmployeeUI() {
        ctrl = new RegisterEmployeeController();
    }

    @Override
    public void run() {

        try {
            String state = null;
            String city = null;
            String district = null;
            String street = null;
            String zipCode = null;
            boolean saveAddress = false;

            String name = Utils.readLineFromConsole("Name: ");
            String email = Utils.readLineFromConsole("Email: ");
            String phoneNumber = Utils.readLineFromConsole("Phone Number: ");
            String taxNumber = Utils.readLineFromConsole("Tax Number: ");
            String passportNumber = Utils.readLineFromConsole("Passport Number: ");
            String dateOfIssueString = Utils.readLineFromConsole("Passport Date of Issue: ");
            String dateOfExpiryString = Utils.readLineFromConsole("Passport Date of Expiry: ");


            String opt = (String) Utils.showAndSelectOne(List.of("Yes", "No"), "Do you wish to add employee's address?");

            if(opt.equalsIgnoreCase("Yes")){
                saveAddress = true;
                state = Utils.readLineFromConsole("State: ");
                city = Utils.readLineFromConsole("City: ");
                street = Utils.readLineFromConsole("Street: ");
                zipCode = Utils.readLineFromConsole("Zipcode: ");

                opt = (String) Utils.showAndSelectOne(List.of("Yes", "no"), "Do you wish to add employee's district?");

                if(opt.equalsIgnoreCase("Yes")){
                    district = Utils.readLineFromConsole("District: ");
                }
            }

            Agency agency = (Agency) Utils.showAndSelectOne(ctrl.getAgencies(), "Select an agency:");
            bootstrapRoles();
            Role roleChosen = (Role) Utils.showAndSelectOne(roles, "Select your role: ");

            Employee emp = ctrl.create(email, name, roleChosen, phoneNumber, passportNumber,
                    dateOfIssueString, dateOfExpiryString,
                    state, city, district, street, zipCode, taxNumber, agency, saveAddress);

            if(emp == null)
                    throw new IllegalArgumentException("Employee not saved.");

            System.out.println("Created employee: \n" + emp + "\n");
            System.out.println("Generated password for such employee sent by email.");

            String saveOrNot = (String) Utils.showAndSelectOne(List.of("Yes", "No"), "Do you wish to save the created employee?");

            if(saveOrNot.equalsIgnoreCase("Yes")){
                ctrl.saveEmployee();
                ctrl.writeToFileData();
                System.out.println("Employee saved successfully!\nPassword sent via Email.");
            }else if(saveOrNot.equalsIgnoreCase("No")){
                System.out.println("Employee not saved.");
            }
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void bootstrapRoles() {
        if(roles.isEmpty()) {
            roles.add(Role.AGENT);
            roles.add(Role.STORE_MANAGER);
            roles.add(Role.STORE_NETWORK_MANAGER);
        }
    }
}

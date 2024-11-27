package pt.ipp.isep.dei.esoft.project.ui;

import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthenticationController;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;

public class Bootstrap implements Runnable {

    //Add some task categories to the repository as bootstrap
    public void run() {
        addTaskCategories();
        addPropertyCategories();
        addAnnouncementCategories();
        addOrganization();
        addUsers();
        addUserRoles();
    }

    private void addUserRoles() {
        AuthenticationRepository repo = Repositories.getInstance().getAuthenticationRepository();
        repo.addUserRole(Role.AGENT.toString(), "agent role");
        repo.addUserRole(Role.STORE_MANAGER.toString(),"store manager");
        repo.addUserRole(Role.STORE_NETWORK_MANAGER.toString(), "store network manager");
    }

    private void addOrganization() {
        //TODO: add organizations bootstrap here
        //get organization repository
        OrganizationRepository organizationRepository = Repositories.getInstance().getOrganizationRepository();
        Organization organization = new Organization("This Company");
        organization.addEmployee(new Employee("admin@this.app"));
        organization.addEmployee(new Employee("employee@this.app"));
        organizationRepository.add(organization);
    }

    private void addTaskCategories() {
        //TODO: add bootstrap Task Categories here

        //get task category repository
        TaskCategoryRepository taskCategoryRepository = Repositories.getInstance().getTaskCategoryRepository();
        taskCategoryRepository.add(new TaskCategory("Analysis"));
        taskCategoryRepository.add(new TaskCategory("Design"));
        taskCategoryRepository.add(new TaskCategory("Implementation"));
        taskCategoryRepository.add(new TaskCategory("Development"));
        taskCategoryRepository.add(new TaskCategory("Testing"));
        taskCategoryRepository.add(new TaskCategory("Deployment"));
        taskCategoryRepository.add(new TaskCategory("Maintenance"));
    }


    private void addPropertyCategories() {
        PropertyCategoryRepository propertyCategoryRepository = Repositories.getInstance().getPropertyCategoryRepository();

        propertyCategoryRepository.add(new PropertyCategory("Land"));
        propertyCategoryRepository.add(new PropertyCategory("Apartment"));
        propertyCategoryRepository.add(new PropertyCategory("House"));
    }

    private void addAnnouncementCategories() {
        AnnouncementCategoryRepository announcementCategoryRepository = Repositories.getInstance().getAnnouncementCategoryRepository();

        announcementCategoryRepository.add(new AnnouncementCategory("Sale"));
        announcementCategoryRepository.add(new AnnouncementCategory("Rent"));
    }

    private void addUsers() {
        //TODO: add Authentication users here: should be created for each user in the organization
        AuthenticationRepository authenticationRepository = Repositories.getInstance().getAuthenticationRepository();
        authenticationRepository.addUserRole(AuthenticationController.ROLE_ADMIN, AuthenticationController.ROLE_ADMIN);
        authenticationRepository.addUserRole(AuthenticationController.ROLE_AGENT, AuthenticationController.ROLE_AGENT);

        authenticationRepository.addUserWithRole("Main Administrator", "admin@this.app", "admin",
                AuthenticationController.ROLE_ADMIN);

        authenticationRepository.addUserWithRole("Employee", "employee@this.app", "pwd",
                AuthenticationController.ROLE_AGENT);
    }


}

package pt.ipp.isep.dei.esoft.project.repository;

public class Repositories {

    private static final Repositories instance = new Repositories();
    TaskCategoryRepository taskCategoryRepository = new TaskCategoryRepository();

    AnnouncementCategoryRepository announcementCategoryRepository = new AnnouncementCategoryRepository();
    PropertyCategoryRepository propertyCategoryRepository = new PropertyCategoryRepository();
    AgencyRepository agencyRepository = new AgencyRepository();
    OrganizationRepository organizationRepository = new OrganizationRepository();
    AuthenticationRepository authenticationRepository = new AuthenticationRepository();
    EmployeeRepository employeeRepository = new EmployeeRepository();


    private Repositories() {
    }

    public static Repositories getInstance() {
        return instance;
    }

    public AnnouncementCategoryRepository getAnnouncementCategoryRepository() {
        return announcementCategoryRepository;
    }

    public PropertyCategoryRepository getPropertyCategoryRepository() {
        return propertyCategoryRepository;
    }

    public OrganizationRepository getOrganizationRepository() {
        return organizationRepository;
    }

    public TaskCategoryRepository getTaskCategoryRepository() {
        return taskCategoryRepository;
    }

    public AuthenticationRepository getAuthenticationRepository() {
        return authenticationRepository;
    }

    public EmployeeRepository getEmployeeRepository() {
        return employeeRepository;
    }
    public AgencyRepository getAgencyRepository() {
        return agencyRepository;
    }
}

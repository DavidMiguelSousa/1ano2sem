package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;
import pt.isep.lei.esoft.auth.domain.model.Email;

import java.util.List;
import java.util.Optional;

public class PublishAnnouncementController {

    private AgencyRepository agencyRepository = null;
    private PropertyCategoryRepository propertyCategoryRepository = null;
    private AnnouncementCategoryRepository announcementCategoryRepository = null;
    private AuthenticationRepository authenticationRepository = null;

    public PublishAnnouncementController() {
        agencyRepository = getAgencyRepository();
        propertyCategoryRepository = getPropertyCategoryRepository();
        announcementCategoryRepository = getAnnouncementCategoryRepository();
        authenticationRepository = getAuthenticationRepository();
    }

    private AgencyRepository getAgencyRepository() {
        if (agencyRepository == null) {
            Repositories repositories = Repositories.getInstance();
            agencyRepository = repositories.getAgencyRepository();
        }

        return agencyRepository;
    }

    private PropertyCategoryRepository getPropertyCategoryRepository() {
        if (propertyCategoryRepository == null) {
            Repositories repositories = Repositories.getInstance();
            propertyCategoryRepository = repositories.getPropertyCategoryRepository();
        }

        return propertyCategoryRepository;
    }

    private AnnouncementCategoryRepository getAnnouncementCategoryRepository() {
        if (announcementCategoryRepository == null) {
            Repositories repositories = Repositories.getInstance();
            announcementCategoryRepository = repositories.getAnnouncementCategoryRepository();
        }

        return announcementCategoryRepository;
    }

    private AuthenticationRepository getAuthenticationRepository() {
        if (authenticationRepository == null) {
            Repositories repositories = Repositories.getInstance();
            authenticationRepository = repositories.getAuthenticationRepository();
        }

        return authenticationRepository;
    }

    public Optional<Announcement> publishLandSaleAnnouncement(String publicationDate, String stateAbbreviation, String city,
                                                              String street, String district, String zipCode, double area,
                                                              double distanceFromCityCentre, double commission, double price,
                                                              String propertyCategoryDescription, String announcementCategoryDescription) {

        PropertyCategory propertyCategory = getPropertyCategoryByDescription(propertyCategoryDescription);
        AnnouncementCategory announcementCategory = getAnnouncementCategoryByDescription(announcementCategoryDescription);

        Agent agent = getAgentFromSession();
        Optional<Agency> agency = getAgencyRepository().getAgencyByAgent(agent);

        Optional<Announcement> newAnnouncement = Optional.empty();

        if (agency.isPresent()) {
            newAnnouncement = agency.get().publishLandSaleAnnouncement(publicationDate, stateAbbreviation, city, street, district, zipCode,  area, distanceFromCityCentre, commission, price,propertyCategory, announcementCategory, agent);
        }

        return newAnnouncement;
    }

    public Optional<Announcement> publishLandRentAnnouncement(String publicationDate, String stateAbbreviation, String city,
                                                              String street, String district, String zipCode, double area,
                                                              double distanceFromCityCentre, double commission, double monthlyPrice,
                                                              int contractDuration, String propertyCategoryDescription,
                                                              String announcementCategoryDescription) {

        PropertyCategory propertyCategory = getPropertyCategoryByDescription(propertyCategoryDescription);
        AnnouncementCategory announcementCategory = getAnnouncementCategoryByDescription(announcementCategoryDescription);

        Agent agent = getAgentFromSession();
        Optional<Agency> agency = getAgencyRepository().getAgencyByAgent(agent);

        Optional<Announcement> newAnnouncement = Optional.empty();

        if (agency.isPresent()) {
            newAnnouncement = agency.get().publishLandRentAnnouncement(publicationDate, stateAbbreviation, city, street, district, zipCode, area, distanceFromCityCentre, commission, monthlyPrice, contractDuration, propertyCategory, announcementCategory, agent);
        }

        return newAnnouncement;
    }

    public Optional<Announcement> publishApartmentSaleAnnouncement(String publicationDate, String stateAbbreviation, String city,
                                                                   String street, String district, String zipCode, double area,
                                                                   double distanceFromCityCentre, int numberOfBedrooms,
                                                                   int numberOfBathrooms, int numberOfParkingSpaces,
                                                                   boolean hasCentralHeating, boolean hasAirConditioning,
                                                                   double commission, double price, String propertyCategoryDescription,
                                                                   String announcementCategoryDescription) {

        PropertyCategory propertyCategory = getPropertyCategoryByDescription(propertyCategoryDescription);
        AnnouncementCategory announcementCategory = getAnnouncementCategoryByDescription(announcementCategoryDescription);

        Agent agent = getAgentFromSession();
        Optional<Agency> agency = getAgencyRepository().getAgencyByAgent(agent);

        Optional<Announcement> newAnnouncement = Optional.empty();

        if (agency.isPresent()) {
            newAnnouncement = agency.get().publishApartmentSaleAnnouncement(publicationDate, stateAbbreviation, city, street, district, zipCode, area, distanceFromCityCentre, numberOfBedrooms, numberOfBathrooms, numberOfParkingSpaces, hasCentralHeating, hasAirConditioning, commission, price, propertyCategory, announcementCategory, agent);
        }

        return newAnnouncement;
    }

    public Optional<Announcement> publishApartmentRentAnnouncement(String publicationDate, String stateAbbreviation, String city,
                                                                   String street, String district, String zipCode, double area,
                                                                   double distanceFromCityCentre, int numberOfBedrooms,
                                                                   int numberOfBathrooms, int numberOfParkingSpaces,
                                                                   boolean hasCentralHeating, boolean hasAirConditioning,
                                                                   double commission, double monthlyPrice, int contractDuration,
                                                                   String propertyCategoryDescription, String announcementCategoryDescription) {

        PropertyCategory propertyCategory = getPropertyCategoryByDescription(propertyCategoryDescription);
        AnnouncementCategory announcementCategory = getAnnouncementCategoryByDescription(announcementCategoryDescription);

        Agent agent = getAgentFromSession();
        Optional<Agency> agency = getAgencyRepository().getAgencyByAgent(agent);

        Optional<Announcement> newAnnouncement = Optional.empty();

        if (agency.isPresent()) {
            newAnnouncement = agency.get().publishApartmentRentAnnouncement(publicationDate, stateAbbreviation, city, street, district, zipCode, area, distanceFromCityCentre, numberOfBedrooms, numberOfBathrooms, numberOfParkingSpaces, hasCentralHeating, hasAirConditioning, commission, monthlyPrice, contractDuration, propertyCategory, announcementCategory, agent);
        }

        return newAnnouncement;
    }

    public Optional<Announcement> publishHouseSaleAnnouncement(String publicationDate, String stateAbbreviation, String city,
                                                               String street, String district, String zipCode, double area,
                                                               double distanceFromCityCentre, int numberOfBedrooms, int numberOfBathrooms,
                                                               int numberOfParkingSpaces, boolean hasCentralHeating,
                                                               boolean hasAirConditioning, boolean hasBasement, boolean hasInhabitableLoft,
                                                               String sunExposure, double commission, double price,
                                                               String propertyCategoryDescription, String announcementCategoryDescription) {

        PropertyCategory propertyCategory = getPropertyCategoryByDescription(propertyCategoryDescription);
        AnnouncementCategory announcementCategory = getAnnouncementCategoryByDescription(announcementCategoryDescription);

        Agent agent = getAgentFromSession();
        Optional<Agency> agency = getAgencyRepository().getAgencyByAgent(agent);

        Optional<Announcement> newAnnouncement = Optional.empty();

        if (agency.isPresent()) {
            newAnnouncement = agency.get().publishHouseSaleAnnouncement(publicationDate, stateAbbreviation, city, street,
                    district, zipCode, area, distanceFromCityCentre, numberOfBedrooms, numberOfBathrooms, numberOfParkingSpaces,
                    hasCentralHeating, hasAirConditioning, hasBasement, hasInhabitableLoft, sunExposure, commission, price, propertyCategory,
                    announcementCategory, agent);
        }

        return newAnnouncement;
    }

    public Optional<Announcement> publishHouseRentAnnouncement(String publicationDate, String stateAbbreviation, String city,
                                                               String street, String district, String zipCode, double area,
                                                               double distanceFromCityCentre, int numberOfBedrooms, int numberOfBathrooms,
                                                               int numberOfParkingSpaces, boolean hasCentralHeating, boolean hasAirConditioning,
                                                               boolean hasBasement, boolean hasInhabitableLoft, String sunExposure,
                                                               double commission, double monthlyPrice, int contractDuration,
                                                               String propertyCategoryDescription, String announcementCategoryDescription) {

        PropertyCategory propertyCategory = getPropertyCategoryByDescription(propertyCategoryDescription);
        AnnouncementCategory announcementCategory = getAnnouncementCategoryByDescription(announcementCategoryDescription);

        Agent agent = getAgentFromSession();
        Optional<Agency> agency = getAgencyRepository().getAgencyByAgent(agent);

        Optional<Announcement> newAnnouncement = Optional.empty();

        if (agency.isPresent()) {
            newAnnouncement = agency.get().publishHouseRentAnnouncement(publicationDate, stateAbbreviation, city, street, district,
                    zipCode, area, distanceFromCityCentre, numberOfBedrooms, numberOfBathrooms, numberOfParkingSpaces, hasCentralHeating,
                    hasAirConditioning, hasBasement, hasInhabitableLoft, sunExposure, commission, monthlyPrice, contractDuration, propertyCategory,
                    announcementCategory, agent);
        }

        return newAnnouncement;
    }

    public Agent getAgentFromSession() {
        Email email = getAuthenticationRepository().getCurrentUserSession().getUserId();
        return new Agent(email.getEmail());
    }

    public List<PropertyCategory> getPropertyCategoryList() {
        PropertyCategoryRepository propertyCategoryRepository = getPropertyCategoryRepository();

        return propertyCategoryRepository.getPropertyCategoryList();
    }

    public List<AnnouncementCategory> getAnnouncementCategoryList() {
        AnnouncementCategoryRepository announcementCategoryRepository = getAnnouncementCategoryRepository();

        return announcementCategoryRepository.getAnnouncementCategoryList();
    }


    private PropertyCategory getPropertyCategoryByDescription(String propertyCategoryDescription) {

        return getPropertyCategoryRepository().getPropertyCategoryByDescription(propertyCategoryDescription);
    }

    private AnnouncementCategory getAnnouncementCategoryByDescription(String announcementCategoryDescription) {

        return getAnnouncementCategoryRepository().getAnnouncementCategoryByDescription(announcementCategoryDescription);
    }


}

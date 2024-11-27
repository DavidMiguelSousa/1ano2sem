package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;

import java.util.List;
import java.util.Optional;

public class RequestAnnouncementController {


    //falta implementar o agente nos metodos do tipo submit
    // se alguem quiser ajudar agradeço






    private PropertyCategoryRepository propertyCategoryRepository = null;

    private AnnouncementCategoryRepository announcementCategoryRepository = null;

    private AgencyRepository agencyRepository = null;

    public RequestAnnouncementController() {
        propertyCategoryRepository = getPropertyCategoryRepository();
        announcementCategoryRepository =  getAnnouncementCategoryRepository();
        agencyRepository = getAgencyRepository();
    }

    public RequestAnnouncementController(PropertyCategoryRepository propertyCategoryRepository,
                                         AnnouncementCategoryRepository announcementCategoryRepository,
                                         AgencyRepository agencyRepository) {
        this.propertyCategoryRepository = getPropertyCategoryRepository();
        this.announcementCategoryRepository = getAnnouncementCategoryRepository();
        this.agencyRepository = getAgencyRepository();
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

    private AgencyRepository getAgencyRepository() {
        if (agencyRepository == null) {
            Repositories repositories = Repositories.getInstance();
            agencyRepository = repositories.getAgencyRepository();
        }
        return agencyRepository;
    }

    public Optional<SaleRequest> submitLandSaleRequest(String stateAbbreviation, String city, String district, String street, String zipCode,
                                                        double price, String photographsURI, double area, double distanceFromCityCentre,
                                                        String propertyCategoryDescription, String announcementCategoryDescription, Agent agent) {

        PropertyCategory propertyCategory = getPropertyCategoryByDescription(propertyCategoryDescription);
        AnnouncementCategory announcementCategory = getAnnouncementCategoryByDescription(announcementCategoryDescription);

        Optional<Agency> agency = getAgencyRepository().getAgencyByAgent(agent);

        Optional<SaleRequest> newRequest = Optional.empty();

        if (agency.isPresent()) {
            newRequest = agency.get().submitLandSaleRequest(stateAbbreviation, city, street, district, zipCode, photographsURI, area, distanceFromCityCentre, price,propertyCategory, announcementCategory, agent);
        }

        return newRequest;



    }

    public Optional<RentRequest> submitLandRentRequest(String stateAbbreviation, String city, String street, String district, String zipCode, String photographsURI,
                                                        double area, int contractDuration, double monthlyRent, double distanceFromCityCentre,
                                                        String propertyCategoryDescription, String announcementCategoryDescription, Agent agent) {

        PropertyCategory propertyCategory = getPropertyCategoryByDescription(propertyCategoryDescription);
        AnnouncementCategory announcementCategory = getAnnouncementCategoryByDescription(announcementCategoryDescription);

        Optional<Agency> agency = getAgencyRepository().getAgencyByAgent(agent);

        Optional<RentRequest> newRequest = Optional.empty();

        if (agency.isPresent()) {
            newRequest = agency.get().submitLandRentRequest(stateAbbreviation, city, street, district, zipCode, photographsURI, area, distanceFromCityCentre, monthlyRent, contractDuration, propertyCategory, announcementCategory, agent);
        }

        return newRequest;

    }

    public Optional<SaleRequest> submitApartmentSaleRequest(String stateAbbreviation, String city, String street, String district, String zipCode, String photographsURI,
                                                            double area, double distanceFromCityCentre, int numberOfBedrooms, int numberOfBathrooms,
                                                            int numberOfParkingSpaces, boolean hasCentralHeating, boolean hasAirConditioning,
                                                            double price, String propertyCategoryDescription,
                                                            String announcementCategoryDescription, Agent agent) {

        PropertyCategory propertyCategory = getPropertyCategoryByDescription(propertyCategoryDescription);
        AnnouncementCategory announcementCategory = getAnnouncementCategoryByDescription(announcementCategoryDescription);

        Optional<Agency> agency = getAgencyRepository().getAgencyByAgent(agent);

        Optional<SaleRequest> newRequest = Optional.empty();

        if (agency.isPresent()) {
            newRequest = agency.get().submitApartmentSaleRequest( stateAbbreviation, city, street, district, zipCode, photographsURI, area, distanceFromCityCentre, numberOfBedrooms, numberOfBathrooms, numberOfParkingSpaces, hasCentralHeating, hasAirConditioning, price, propertyCategory, announcementCategory, agent);
        }

        return newRequest;
    }

    public Optional<RentRequest> submitApartmentRentRequest(String stateAbbreviation, String city, String street, String district, String zipCode, String photographsURI,
                                                             double area, double distanceFromCityCentre, int numberOfBedrooms, int numberOfBathrooms,
                                                             int numberOfParkingSpaces, boolean hasCentralHeating, boolean hasAirConditioning,
                                                            double monthlyRent, int contractDuration, String propertyCategoryDescription,
                                                             String announcementCategoryDescription, Agent agent) {

        PropertyCategory propertyCategory = getPropertyCategoryByDescription(propertyCategoryDescription);
        AnnouncementCategory announcementCategory = getAnnouncementCategoryByDescription(announcementCategoryDescription);

        Optional<Agency> agency = getAgencyRepository().getAgencyByAgent(agent);

        Optional<RentRequest> newRequest = Optional.empty();

        if (agency.isPresent()) {
            newRequest = agency.get().submitApartmentRentRequest(stateAbbreviation, city, street, district, zipCode, photographsURI, area, distanceFromCityCentre, numberOfBedrooms, numberOfBathrooms, numberOfParkingSpaces, hasCentralHeating, hasAirConditioning, monthlyRent, contractDuration, propertyCategory, announcementCategory, agent);
        }

        return newRequest;

    }

    public Optional<SaleRequest> submitHouseSaleRequest(String stateAbbreviation, String city, String street, String district, String zipCode, String photographsURI,
                                                         double area, double distanceFromCityCentre, int numberOfBedrooms, int numberOfBathrooms,
                                                         int numberOfParkingSpaces, boolean hasCentralHeating, boolean hasAirConditioning,
                                                         boolean hasBasement, boolean hasInhabitableLoft, String sunExposure, double commission,
                                                         double price, String propertyCategoryDescription, String announcementCategoryDescription, Agent agent) {

        PropertyCategory propertyCategory = getPropertyCategoryByDescription(propertyCategoryDescription);
        AnnouncementCategory announcementCategory = getAnnouncementCategoryByDescription(announcementCategoryDescription);

        Optional<Agency> agency = getAgencyRepository().getAgencyByAgent(agent);

        Optional<SaleRequest> newRequest = Optional.empty();

        if (agency.isPresent()) {
            newRequest = agency.get().submitHouseSaleRequest(stateAbbreviation, city, street,
                    district, zipCode, photographsURI, area, distanceFromCityCentre, numberOfBedrooms, numberOfBathrooms, numberOfParkingSpaces,
                    hasCentralHeating, hasAirConditioning, hasBasement, hasInhabitableLoft, sunExposure, price, propertyCategory,
                    announcementCategory, agent);
        }

        return newRequest;

    }

    public Optional<RentRequest> submitHouseRentRequest(String stateAbbreviation, String city, String street, String district, String zipCode, String photographsURI,
                                                         double area, double distanceFromCityCentre, int numberOfBedrooms, int numberOfBathrooms,
                                                         int numberOfParkingSpaces, boolean hasCentralHeating, boolean hasAirConditioning,
                                                         boolean hasBasement, boolean hasInhabitableLoft, String sunExposure,
                                                         double monthlyRent, int contractDuration, String propertyCategoryDescription,
                                                         String announcementCategoryDescription, Agent agent) {

        PropertyCategory propertyCategory = getPropertyCategoryByDescription(propertyCategoryDescription);
        AnnouncementCategory announcementCategory = getAnnouncementCategoryByDescription(announcementCategoryDescription);

        Optional<Agency> agency = getAgencyRepository().getAgencyByAgent(agent);

        Optional<RentRequest> newRequest = Optional.empty();

        if (agency.isPresent()) {
            newRequest = agency.get().submitHouseRentRequest(stateAbbreviation, city, street, district,
                    zipCode, photographsURI, area, distanceFromCityCentre, numberOfBedrooms, numberOfBathrooms, numberOfParkingSpaces, hasCentralHeating,
                    hasAirConditioning, hasBasement, hasInhabitableLoft, sunExposure, monthlyRent, contractDuration, propertyCategory,
                    announcementCategory, agent);
        }

        return newRequest;

    }



    private PropertyCategory getPropertyCategoryByDescription(String propertyCategoryDescription) {

        PropertyCategory propertyCategoryByDescription = getPropertyCategoryRepository().getPropertyCategoryByDescription(propertyCategoryDescription);
        return propertyCategoryByDescription;
    }

    private AnnouncementCategory getAnnouncementCategoryByDescription(String announcementCategoryDescription) {

        AnnouncementCategory announcementCategoryByDescription = getAnnouncementCategoryRepository().getAnnouncementCategoryByDescription(announcementCategoryDescription);
        return announcementCategoryByDescription;
    }

    private Agency getAgencyById(String agencyId) {

        Agency agencyById = getAgencyRepository().getAgencyById(agencyId);
        return agencyById;
    }

    private Agent getAgentByName( String agentName){
        return null;
    }

    public List<PropertyCategory> getPropertyCategoryList() {
        PropertyCategoryRepository propertyCategoryRepository = getPropertyCategoryRepository();
        return propertyCategoryRepository.getPropertyCategoryList();
    }

    public List<AnnouncementCategory> getAnnouncementCategoryList() {
        AnnouncementCategoryRepository announcementCategoryRepository = getAnnouncementCategoryRepository();
        return announcementCategoryRepository.getAnnouncementCategoryList();
    }

    public List<Agency> getAgencyList() {
        AgencyRepository agencyRepository = getAgencyRepository();
        return agencyRepository.getAgencies();
    }

    public List<Agent> getAgentList() {
        AgencyRepository agencyRepository = getAgencyRepository();
        return agencyRepository.getAgents();
    }



}

package pt.ipp.isep.dei.esoft.project.domain;

public class RentRequest {

    private double monthlyRent;
    private int contractDuration;
    private Location location;
    private Land land;
    private Apartment apartment;
    private House house;
    private PropertyCategory propertyCategory;
    private AnnouncementCategory announcementCategory;
    private Agent agent;

    public RentRequest(String stateAbbreviation, String city, String street, String district,
                        String zipCode, String photographsURI, double area, double distanceFromCityCentre, double monthlyRent,
                       int contractDuration, PropertyCategory propertyCategory,
                        AnnouncementCategory announcementCategory, Agent agent) {

        location = new Location(stateAbbreviation, city, district, street, zipCode);
        land = new Land(photographsURI, area, distanceFromCityCentre);
        this.monthlyRent = monthlyRent;
        this.contractDuration = contractDuration;
        this.propertyCategory = propertyCategory;
        this.announcementCategory = announcementCategory;
        this.agent = agent;
    }

    public RentRequest(String stateAbbreviation, String city, String street, String district,
                        String zipCode, String photographsURI, double area, double distanceFromCityCentre, int numberOfBedrooms,
                        int numberOfBathrooms, int numberOfParkingSpaces, boolean hasCentralHeating, boolean hasAirConditioning,
                       double monthlyRent, int contractDuration, PropertyCategory propertyCategory, AnnouncementCategory announcementCategory, Agent agent) {

        location = new Location(stateAbbreviation, city, district, street, zipCode);
        apartment = new Apartment(photographsURI, area, distanceFromCityCentre, numberOfBedrooms, numberOfBathrooms, numberOfParkingSpaces, hasCentralHeating, hasAirConditioning);
        this.monthlyRent = monthlyRent;
        this.contractDuration = contractDuration;
        this.propertyCategory = propertyCategory;
        this.announcementCategory = announcementCategory;
        this.agent = agent;
    }

    public RentRequest(String stateAbbreviation, String city, String street, String district,
                        String zipCode, String photographsURI, double area, double distanceFromCityCentre, int numberOfBedrooms,
                        int numberOfBathrooms, int numberOfParkingSpaces, boolean hasCentralHeating, boolean hasAirConditioning, boolean hasBasement, boolean hasInhabitableLoft,
                        String sunExposure, double monthlyRent, int contractDuration, PropertyCategory propertyCategory, AnnouncementCategory announcementCategory, Agent agent) {

        location = new Location(stateAbbreviation, city, district, street, zipCode);
        house = new House(photographsURI, area, distanceFromCityCentre, numberOfBedrooms, numberOfBathrooms, numberOfParkingSpaces, hasCentralHeating, hasAirConditioning, hasBasement, hasInhabitableLoft, sunExposure);
        this.monthlyRent = monthlyRent;
        this.contractDuration = contractDuration;
        this.propertyCategory = propertyCategory;
        this.announcementCategory = announcementCategory;
        this.agent = agent;
    }

    public RentRequest(double monthlyRent, int contractDuration) {
        setMonthlyRent(monthlyRent);
        setContractDuration(contractDuration);
    }

    public double getMonthlyRent() {
        return monthlyRent;
    }

    public void setMonthlyRent(double monthlyRent) {
        this.monthlyRent = monthlyRent;
    }

    public int getContractDuration() {
        return contractDuration;
    }

    public void setContractDuration(int contractDuration) {
        this.contractDuration = contractDuration;
    }

    public RentRequest clone() {
        return this;
    }
}

package pt.ipp.isep.dei.esoft.project.domain;

public class SaleRequest {

    private double price;
    private Location location;
    private Land land;
    private Apartment apartment;
    private House house;
    private PropertyCategory propertyCategory;
    private AnnouncementCategory announcementCategory;
    private Agent agent;

    public SaleRequest(String stateAbbreviation, String city,
                       String street, String district, String zipCode, String photographsURI, double area,
                       double distanceFromCityCentre, double price,
                       PropertyCategory propertyCategory, AnnouncementCategory announcementCategory,
                       Agent agent) {

        location = new Location(stateAbbreviation, city, street, district, zipCode);
        land = new Land(photographsURI, area, distanceFromCityCentre);
        this.price = price;
        this.propertyCategory = propertyCategory;
        this.announcementCategory = announcementCategory;
        this.agent = agent;
    }

    public SaleRequest(String stateAbbreviation, String city, String street, String district,
                       String zipCode, String photographsURI, double area, double distanceFromCityCentre, int numberOfBedrooms,
                       int numberOfBathrooms, int numberOfParkingSpaces, boolean hasCentralHeating, boolean hasAirConditioning,
                       double price, PropertyCategory propertyCategory, AnnouncementCategory announcementCategory, Agent agent) {

        location = new Location(stateAbbreviation, city, district, street, zipCode);
        apartment = new Apartment(photographsURI, area, distanceFromCityCentre, numberOfBedrooms, numberOfBathrooms, numberOfParkingSpaces, hasCentralHeating, hasAirConditioning);
        this.price = price;
        this.propertyCategory = propertyCategory;
        this.announcementCategory = announcementCategory;
        this.agent = agent;
    }

    public SaleRequest(String stateAbbreviation, String city, String street, String district,
                        String zipCode, s double area, double distanceFromCityCentre, int numberOfBedrooms,
                        int numberOfBathrooms, int numberOfParkingSpaces, boolean hasCentralHeating, boolean hasAirConditioning, boolean hasBasement, boolean hasInhabitableLoft,
                        String sunExposure, double price, PropertyCategory propertyCategory, AnnouncementCategory announcementCategory, Agent agent) {

        location = new Location(stateAbbreviation, city, district, street, zipCode);
        house = new House(photographsURI, area, distanceFromCityCentre, numberOfBedrooms, numberOfBathrooms, numberOfParkingSpaces, hasCentralHeating, hasAirConditioning, hasBasement, hasInhabitableLoft, sunExposure);
        this.price = price;
        this.propertyCategory = propertyCategory;
        this.announcementCategory = announcementCategory;
        this.agent = agent;
    }

    public SaleRequest(double price) {
        setPrice(price);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public SaleRequest clone() {
        return this;
    }
}

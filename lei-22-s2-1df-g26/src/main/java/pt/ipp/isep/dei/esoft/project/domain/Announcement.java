package pt.ipp.isep.dei.esoft.project.domain;

public class Announcement {

    private final String publicationDate;
    private final Location location;
    private Land land;
    private Apartment apartment;
    private House house;
    private final double commission;
    private SaleRequest saleRequest;
    private RentRequest rentRequest;
    private final PropertyCategory propertyCategory;
    private final AnnouncementCategory announcementCategory;
    private final Agent agent;

    public Announcement(String publicationDate, String stateAbbreviation, String city,
                        String street, String district, String zipCode, double area,
                        double distanceFromCityCentre,
                        double commission, double price,
                        PropertyCategory propertyCategory, AnnouncementCategory announcementCategory,
                        Agent agent) {

        this.publicationDate = publicationDate;
        location = new Location(stateAbbreviation, city, street, district, zipCode);
        land = new Land(area, distanceFromCityCentre);
        this.commission = commission;
        saleRequest = new SaleRequest(price);
        this.propertyCategory = propertyCategory;
        this.announcementCategory = announcementCategory;
        this.agent = agent;
    }


    public Announcement(String publicationDate, String stateAbbreviation, String city, String street, String district,
                        String zipCode, double area, double distanceFromCityCentre, double commission,
                        double monthlyPrice, int contractDuration, PropertyCategory propertyCategory,
                        AnnouncementCategory announcementCategory, Agent agent) {

        this.publicationDate = publicationDate;
        location = new Location(stateAbbreviation, city, district, street, zipCode);
        land = new Land(area, distanceFromCityCentre);
        this.commission = commission;
        rentRequest = new RentRequest(monthlyPrice, contractDuration);
        this.propertyCategory = propertyCategory;
        this.announcementCategory = announcementCategory;
        this.agent = agent;
    }

    public Announcement(String publicationDate, String stateAbbreviation, String city, String street, String district,
                        String zipCode, double area, double distanceFromCityCentre, int numberOfBedrooms,
                        int numberOfBathrooms, int numberOfParkingSpaces, boolean hasCentralHeating, boolean hasAirConditioning,
                        double commission, double price, PropertyCategory propertyCategory, AnnouncementCategory announcementCategory, Agent agent) {

        this.publicationDate = publicationDate;
        location = new Location(stateAbbreviation, city, district, street, zipCode);
        apartment = new Apartment(area, distanceFromCityCentre, numberOfBedrooms, numberOfBathrooms, numberOfParkingSpaces, hasCentralHeating, hasAirConditioning);
        this.commission = commission;
        saleRequest = new SaleRequest(price);
        this.propertyCategory = propertyCategory;
        this.announcementCategory = announcementCategory;
        this.agent = agent;
    }

    public Announcement(String publicationDate, String stateAbbreviation, String city, String street, String district,
                        String zipCode, double area, double distanceFromCityCentre, int numberOfBedrooms,
                        int numberOfBathrooms, int numberOfParkingSpaces, boolean hasCentralHeating, boolean hasAirConditioning,
                        double commission, double monthlyPrice, int contractDuration, PropertyCategory propertyCategory, AnnouncementCategory announcementCategory, Agent agent) {

        this.publicationDate = publicationDate;
        location = new Location(stateAbbreviation, city, district, street, zipCode);
        apartment = new Apartment(area, distanceFromCityCentre, numberOfBedrooms, numberOfBathrooms, numberOfParkingSpaces, hasCentralHeating, hasAirConditioning);
        this.commission = commission;
        rentRequest = new RentRequest(monthlyPrice, contractDuration);
        this.propertyCategory = propertyCategory;
        this.announcementCategory = announcementCategory;
        this.agent = agent;
    }

    public Announcement(String publicationDate, String stateAbbreviation, String city, String street, String district,
                        String zipCode, double area, double distanceFromCityCentre, int numberOfBedrooms,
                        int numberOfBathrooms, int numberOfParkingSpaces, boolean hasCentralHeating, boolean hasAirConditioning, boolean hasBasement, boolean hasInhabitableLoft,
                        String sunExposure, double commission, double price, PropertyCategory propertyCategory, AnnouncementCategory announcementCategory, Agent agent) {

        this.publicationDate = publicationDate;
        location = new Location(stateAbbreviation, city, district, street, zipCode);
        house = new House(area, distanceFromCityCentre, numberOfBedrooms, numberOfBathrooms, numberOfParkingSpaces, hasCentralHeating, hasAirConditioning, hasBasement, hasInhabitableLoft, sunExposure);
        this.commission = commission;
        saleRequest = new SaleRequest(price);
        this.propertyCategory = propertyCategory;
        this.announcementCategory = announcementCategory;
        this.agent = agent;
    }

    public Announcement(String publicationDate, String stateAbbreviation, String city, String street, String district,
                        String zipCode, double area, double distanceFromCityCentre, int numberOfBedrooms,
                        int numberOfBathrooms, int numberOfParkingSpaces, boolean hasCentralHeating, boolean hasAirConditioning, boolean hasBasement, boolean hasInhabitableLoft,
                        String sunExposure, double commission, double monthlyPrice, int contractDuration, PropertyCategory propertyCategory, AnnouncementCategory announcementCategory, Agent agent) {

        this.publicationDate = publicationDate;
        location = new Location(stateAbbreviation, city, district, street, zipCode);
        house = new House(area, distanceFromCityCentre, numberOfBedrooms, numberOfBathrooms, numberOfParkingSpaces, hasCentralHeating, hasAirConditioning, hasBasement, hasInhabitableLoft, sunExposure);
        this.commission = commission;
        rentRequest = new RentRequest(monthlyPrice, contractDuration);
        this.propertyCategory = propertyCategory;
        this.announcementCategory = announcementCategory;
        this.agent = agent;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public Announcement clone() {
        return this;
    }

    public AnnouncementCategory getAnnouncementCategory() {
        return announcementCategory;
    }

    public PropertyCategory getPropertyCategory() {
        return propertyCategory;
    }

    public int getNumberOfRooms() {

        if (this.getPropertyCategory().getDescription().equalsIgnoreCase("House")) {
            return this.house.getNumberOfBedrooms();
        } else if (this.getPropertyCategory().getDescription().equalsIgnoreCase("Apartment")) {
            return this.apartment.getNumberOfBedrooms();
        } else {
            return 0;
        }

    }

}
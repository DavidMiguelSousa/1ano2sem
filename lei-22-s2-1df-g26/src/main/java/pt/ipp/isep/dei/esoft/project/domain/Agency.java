package pt.ipp.isep.dei.esoft.project.domain;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Agency {

    private final String id;
    List<Announcement> announcements = new ArrayList<>();

    List<SaleRequest> saleRequests = new ArrayList<>();

    List<RentRequest> rentRequests = new ArrayList<>();

    List<Agent> agents = new ArrayList<>();

    private String designation;

    private String email;

    private String phoneNumber;

    private static Location address;

    public Location getAddress() {
        return address;
    }

    public static void setAddress(Location address) {
        Agency.address = address;
    }

    public Agency(String id) {
        this.id = id;
    }
    
    public Agency(String id, String designation, String email, String phoneNumber, Location address) {
        this.id = id;
        this.designation = designation;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
    public boolean addAgent(Agent agent) {
        boolean success = false;
        if (validateAgent(agent)) {
            success = agents.add(agent);
        }
        return success;
    }

    public boolean employs(Agent agent) {
        return agents.contains(agent);
    }

    public Optional<Announcement> publishLandSaleAnnouncement(String publicationDate, String stateAbbreviation, String city,
                                                              String street, String district, String zipCode, double area,
                                                              double distanceFromCityCentre,
                                                              double commission, double price,
                                                              PropertyCategory propertyCategory, AnnouncementCategory announcementCategory,
                                                              Agent agent) {


        Optional<Announcement> optionalValue = Optional.empty();

        Announcement newAnnouncement = new Announcement(publicationDate, stateAbbreviation, city, street, district, zipCode,
                area, distanceFromCityCentre, commission, price, propertyCategory, announcementCategory, agent);

        if (addAnnouncement(newAnnouncement)) {
            optionalValue = Optional.of(newAnnouncement);
        }

        return optionalValue;
    }

    public Optional<Announcement> publishLandRentAnnouncement(String publicationDate, String stateAbbreviation, String city, String street, String district,
                                                              String zipCode, double area, double distanceFromCityCentre, double commission,
                                                              double monthlyPrice, int contractDuration, PropertyCategory propertyCategory,
                                                              AnnouncementCategory announcementCategory, Agent agent) {


        Optional<Announcement> optionalValue = Optional.empty();

        Announcement newAnnouncement = new Announcement(publicationDate, stateAbbreviation, city, street, district, zipCode, area,
                distanceFromCityCentre, commission, monthlyPrice, contractDuration, propertyCategory, announcementCategory, agent);

        if (addAnnouncement(newAnnouncement)) {
            optionalValue = Optional.of(newAnnouncement);
        }

        return optionalValue;
    }

    public Optional<Announcement> publishApartmentSaleAnnouncement(String publicationDate, String stateAbbreviation, String city, String street, String district,
                                                                   String zipCode, double area, double distanceFromCityCentre, int numberOfBedrooms,
                                                                   int numberOfBathrooms, int numberOfParkingSpaces, boolean hasCentralHeating, boolean hasAirConditioning,
                                                                   double commission, double price, PropertyCategory propertyCategory, AnnouncementCategory announcementCategory, Agent agent) {


        Optional<Announcement> optionalValue = Optional.empty();

        Announcement newAnnouncement = new Announcement(publicationDate, stateAbbreviation, city, street, district, zipCode, area,
                distanceFromCityCentre, numberOfBedrooms, numberOfBathrooms, numberOfParkingSpaces, hasCentralHeating, hasAirConditioning,
                commission, price, propertyCategory, announcementCategory, agent);

        if (addAnnouncement(newAnnouncement)) {
            optionalValue = Optional.of(newAnnouncement);
        }

        return optionalValue;
    }

    public Optional<Announcement> publishApartmentRentAnnouncement(String publicationDate, String stateAbbreviation, String city, String street, String district,
                                                                   String zipCode, double area, double distanceFromCityCentre, int numberOfBedrooms,
                                                                   int numberOfBathrooms, int numberOfParkingSpaces, boolean hasCentralHeating, boolean hasAirConditioning,
                                                                   double commission, double monthlyPrice, int contractDuration, PropertyCategory propertyCategory, AnnouncementCategory announcementCategory, Agent agent) {


        Optional<Announcement> optionalValue = Optional.empty();

        Announcement newAnnouncement = new Announcement(publicationDate, stateAbbreviation, city, street, district,
                zipCode, area, distanceFromCityCentre,numberOfBedrooms, numberOfBathrooms, numberOfParkingSpaces, hasCentralHeating,
                hasAirConditioning, commission, monthlyPrice, contractDuration, propertyCategory, announcementCategory, agent);

        if (addAnnouncement(newAnnouncement)) {
            optionalValue = Optional.of(newAnnouncement);
        }

        return optionalValue;
    }

    public Optional<Announcement> publishHouseSaleAnnouncement(String publicationDate, String stateAbbreviation, String city, String street, String district,
                                                               String zipCode, double area, double distanceFromCityCentre, int numberOfBedrooms,
                                                               int numberOfBathrooms, int numberOfParkingSpaces, boolean hasCentralHeating, boolean hasAirConditioning, boolean hasBasement, boolean hasInhabitableLoft,
                                                               String sunExposure, double commission, double price, PropertyCategory propertyCategory, AnnouncementCategory announcementCategory, Agent agent) {


        Optional<Announcement> optionalValue = Optional.empty();

        Announcement newAnnouncement = new Announcement(publicationDate, stateAbbreviation, city, street, district, zipCode, area,
                distanceFromCityCentre, numberOfBedrooms, numberOfBathrooms, numberOfParkingSpaces, hasCentralHeating, hasAirConditioning,
                hasBasement, hasInhabitableLoft, sunExposure, commission, price, propertyCategory, announcementCategory, agent);

        if (addAnnouncement(newAnnouncement)) {
            optionalValue = Optional.of(newAnnouncement);
        }

        return optionalValue;
    }

    public Optional<Announcement> publishHouseRentAnnouncement(String publicationDate, String stateAbbreviation, String city, String street, String district,
                                                               String zipCode, double area, double distanceFromCityCentre, int numberOfBedrooms,
                                                               int numberOfBathrooms, int numberOfParkingSpaces, boolean hasCentralHeating, boolean hasAirConditioning, boolean hasBasement, boolean hasInhabitableLoft,
                                                               String sunExposure, double commission, double monthlyPrice, int contractDuration, PropertyCategory propertyCategory, AnnouncementCategory announcementCategory, Agent agent) {


        Optional<Announcement> optionalValue = Optional.empty();

        Announcement newAnnouncement = new Announcement(publicationDate, stateAbbreviation, city, street, district, zipCode,
                area, distanceFromCityCentre, numberOfBedrooms, numberOfBathrooms, numberOfParkingSpaces, hasCentralHeating, hasAirConditioning, hasBasement,
                hasInhabitableLoft, sunExposure, commission, monthlyPrice, contractDuration, propertyCategory, announcementCategory, agent);

        if (addAnnouncement(newAnnouncement)) {
            optionalValue = Optional.of(newAnnouncement);
        }

        return optionalValue;

    }

    public Optional<SaleRequest> submitLandSaleRequest(String stateAbbreviation, String city,
                                                       String street, String district, String zipCode, String photographsURI, double area,
                                                       double distanceFromCityCentre, double price,
                                                       PropertyCategory propertyCategory, AnnouncementCategory announcementCategory,
                                                       Agent agent) {


        Optional<SaleRequest> optionalValue = Optional.empty();

        SaleRequest newRequest = new SaleRequest(stateAbbreviation, city, street, district, zipCode, photographsURI, area, distanceFromCityCentre, price, propertyCategory, announcementCategory, agent);

        if (addSaleRequest(newRequest)) {
            optionalValue = Optional.of(newRequest);
        }

        return optionalValue;
    }

    public Optional<RentRequest> submitLandRentRequest(String stateAbbreviation, String city, String street, String district,
                                                       String zipCode, String photographsURI, double area, double distanceFromCityCentre,
                                                       double monthlyPrice, int contractDuration, PropertyCategory propertyCategory,
                                                       AnnouncementCategory announcementCategory, Agent agent) {


        Optional<RentRequest> optionalValue = Optional.empty();

        RentRequest newRequest = new RentRequest(stateAbbreviation, city, street, district, zipCode, photographsURI, area,
                distanceFromCityCentre, monthlyPrice, contractDuration, propertyCategory, announcementCategory, agent);

        if (addRentRequest(newRequest)) {
            optionalValue = Optional.of(newRequest);
        }

        return optionalValue;
    }

    public Optional<SaleRequest> submitApartmentSaleRequest(String stateAbbreviation, String city, String street, String district,
                                                            String zipCode, String photographsURI, double area, double distanceFromCityCentre, int numberOfBedrooms,
                                                            int numberOfBathrooms, int numberOfParkingSpaces, boolean hasCentralHeating, boolean hasAirConditioning,
                                                            double price, PropertyCategory propertyCategory, AnnouncementCategory announcementCategory, Agent agent) {


        Optional<SaleRequest> optionalValue = Optional.empty();

        SaleRequest newRequest = new SaleRequest(stateAbbreviation, city, street, district, zipCode, photographsURI, area,
                distanceFromCityCentre, numberOfBedrooms, numberOfBathrooms, numberOfParkingSpaces, hasCentralHeating, hasAirConditioning,
                price, propertyCategory, announcementCategory, agent);

        if (addSaleRequest(newRequest)) {
            optionalValue = Optional.of(newRequest);
        }

        return optionalValue;
    }

    public Optional<RentRequest> submitApartmentRentRequest(String stateAbbreviation, String city, String street, String district,
                                                            String zipCode, String photographsURI, double area, double distanceFromCityCentre, int numberOfBedrooms,
                                                            int numberOfBathrooms, int numberOfParkingSpaces, boolean hasCentralHeating, boolean hasAirConditioning,
                                                            double monthlyPrice, int contractDuration, PropertyCategory propertyCategory, AnnouncementCategory announcementCategory, Agent agent) {


        Optional<RentRequest> optionalValue = Optional.empty();

        RentRequest newRequest = new RentRequest(stateAbbreviation, city, street, district,
                zipCode, photographsURI, area, distanceFromCityCentre,numberOfBedrooms, numberOfBathrooms, numberOfParkingSpaces, hasCentralHeating,
                hasAirConditioning, monthlyPrice, contractDuration, propertyCategory, announcementCategory, agent);

        if (addRentRequest(newRequest)) {
            optionalValue = Optional.of(newRequest);
        }

        return optionalValue;
    }

    public Optional<SaleRequest> submitHouseSaleRequest(String stateAbbreviation, String city, String street, String district,
                                                        String zipCode, String photographsURI, double area, double distanceFromCityCentre, int numberOfBedrooms,
                                                        int numberOfBathrooms, int numberOfParkingSpaces, boolean hasCentralHeating, boolean hasAirConditioning, boolean hasBasement, boolean hasInhabitableLoft,
                                                        String sunExposure, double price, PropertyCategory propertyCategory, AnnouncementCategory announcementCategory, Agent agent) {


        Optional<SaleRequest> optionalValue = Optional.empty();

        SaleRequest newRequest = new SaleRequest(stateAbbreviation, city, street, district, zipCode, photographsURI, area,
                distanceFromCityCentre, numberOfBedrooms, numberOfBathrooms, numberOfParkingSpaces, hasCentralHeating, hasAirConditioning,
                hasBasement, hasInhabitableLoft, sunExposure, price, propertyCategory, announcementCategory, agent);

        if (addSaleRequest(newRequest)) {
            optionalValue = Optional.of(newRequest);
        }

        return optionalValue;
    }

    public Optional<RentRequest> submitHouseRentRequest(String stateAbbreviation, String city, String street, String district,
                                                        String zipCode, String photographsURI, double area, double distanceFromCityCentre, int numberOfBedrooms,
                                                        int numberOfBathrooms, int numberOfParkingSpaces, boolean hasCentralHeating, boolean hasAirConditioning, boolean hasBasement, boolean hasInhabitableLoft,
                                                        String sunExposure, double monthlyPrice, int contractDuration, PropertyCategory propertyCategory, AnnouncementCategory announcementCategory, Agent agent) {


        Optional<RentRequest> optionalValue = Optional.empty();

        RentRequest newRequest = new RentRequest(stateAbbreviation, city, street, district, zipCode, photographsURI,
                area, distanceFromCityCentre, numberOfBedrooms, numberOfBathrooms, numberOfParkingSpaces, hasCentralHeating, hasAirConditioning, hasBasement,
                hasInhabitableLoft, sunExposure, monthlyPrice, contractDuration, propertyCategory, announcementCategory, agent);

        if (addRentRequest(newRequest)) {
            optionalValue = Optional.of(newRequest);
        }

        return optionalValue;

    }


    private boolean addAnnouncement(Announcement announcement) {
        boolean success = false;
        if (validateAnnouncement(announcement)) {
            success = announcements.add(announcement);
        }
        return success;
    }

    private boolean addSaleRequest(SaleRequest saleRequest) {
        boolean success = false;
        if (validateSaleRequest(saleRequest)) {
            success = saleRequests.add(saleRequest);
        }
        return success;
    }

    private boolean addRentRequest(RentRequest rentRequest) {
        boolean success = false;
        if (validateRentRequest(rentRequest)) {
            success = rentRequests.add(rentRequest);
        }
        return success;
    }

    private boolean validateAnnouncement(Announcement announcement) {
        return announcementsDoNotContain(announcement);
    }

    private boolean announcementsDoNotContain(Announcement announcement) {
        return !announcements.contains(announcement);
    }

    private boolean validateSaleRequest(SaleRequest saleRequest) {
        return requestsDoNotContain(saleRequest);
    }

    private boolean requestsDoNotContain(SaleRequest saleRequest) {
        return !saleRequests.contains(saleRequest);
    }

    private boolean validateRentRequest(RentRequest rentRequest) {
        return requestsDoNotContain(rentRequest);
    }

    private boolean requestsDoNotContain(RentRequest rentRequest) {
        return !rentRequests.contains(rentRequest);
    }

    private boolean validateAgent(Agent agent) {
        return agentsDoNotContain(agent);
    }

    private boolean agentsDoNotContain(Agent agent) {
        return !agents.contains(agent);
    }


    public Agency clone() {
        Agency clone = new Agency(this.id);

        clone.designation = this.designation;
        clone.email = this.email;
        clone.phoneNumber = this.phoneNumber;

        for (Agent agent : this.agents) {
            clone.agents.add(agent.clone());
        }

        for (Announcement announcement : this.announcements) {
            clone.announcements.add(announcement.clone());
        }

        return clone;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return this.designation;
    }

    public String setName() {
        return this.designation;
    }
}

# US 002- To create a Task 

# 4. Tests 

**Test 1:** Check that it is not possible to create an instance of the Announcement class with null value - AC2. 

	@Test(expected = IllegalArgumentException.class)
		public void ensureNullIsNotAllowed() {
		Announcement instance = new Announcement(null, null, null, null, null, null, null, null, null, null, null);
	}


**Test 2:** Check that it is not possible to create an instance of the Announcement class with a negative commission value - AC6.

    @Test(expected = IllegalArgumentException.class)
        public void ensureCommissionMeetsAC6() {
        Announcement instance = new Announcement(state, city, street, district, zipCode, area, distanceFromCityCentre, -5, price, propertyCategory, announcementCategory, agent);

# 5. Construction (Implementation)


## Class PublishAnnouncementController

```java
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
```


## Class Agency

```java
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
```

# 6. Integration and Demo 

# 7. Observations

There are a lot of constructors and options that make the code a little bit complex.
Is there any way to make the correct data requests in a simpler form?






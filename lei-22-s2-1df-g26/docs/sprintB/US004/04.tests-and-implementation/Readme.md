# US 004 - As an owner, I intend to submit a request for listing a property sale or rent, choosing the responsible agent. 

# 4. Tests 

**Test 1:** Check that it is not possible to create an instance of the SaleRequest class with null value - AC8.

	@Test(expected = IllegalArgumentException.class)
		public void ensureNullIsNotAllowed() {
		SaleRequest instance = new SaleRequest(null, null, null, null, null, null, null, null, null, null, null);
	}
	

**Test 2:** Check that it is not possible to create an instance of the SaleRequest class with a negative area value - AC2. 

	@Test(expected = IllegalArgumentException.class)
		public void ensureAreaMeetsAC2() {
		SaleRequest instance = new SaleRequest("stateAbbreviation", "city", "street", "district", "zipCode", -42, distanceFromCityCentre, price, propertyCategory, announcementCategory, agent);
	}



# 5. Construction (Implementation)


## Class RequestAnnouncementController 

```java
public Optional<SaleRequest> submitLandSaleRequest(String stateAbbreviation, String city, String district, String street, String zipCode,
        double price, double area, double distanceFromCityCentre,
        String propertyCategoryDescription, String announcementCategoryDescription, Agent agent) {

        PropertyCategory propertyCategory = getPropertyCategoryByDescription(propertyCategoryDescription);
        AnnouncementCategory announcementCategory = getAnnouncementCategoryByDescription(announcementCategoryDescription);

        Optional<Agency> agency = getAgencyRepository().getAgencyByAgent(agent);

        Optional<SaleRequest> newRequest = Optional.empty();

        if (agency.isPresent()) {
        newRequest = agency.get().submitLandSaleRequest(stateAbbreviation, city, street, district, zipCode, area, distanceFromCityCentre, price,propertyCategory, announcementCategory, agent);
        }

        return newRequest;



        }

public Optional<RentRequest> submitLandRentRequest(String stateAbbreviation, String city, String street, String district, String zipCode,
        double area, int contractDuration, double monthlyRent, double distanceFromCityCentre,
        String propertyCategoryDescription, String announcementCategoryDescription, Agent agent) {

        PropertyCategory propertyCategory = getPropertyCategoryByDescription(propertyCategoryDescription);
        AnnouncementCategory announcementCategory = getAnnouncementCategoryByDescription(announcementCategoryDescription);

        Optional<Agency> agency = getAgencyRepository().getAgencyByAgent(agent);

        Optional<RentRequest> newRequest = Optional.empty();

        if (agency.isPresent()) {
        newRequest = agency.get().submitLandRentRequest(stateAbbreviation, city, street, district, zipCode, area, distanceFromCityCentre, monthlyRent, contractDuration, propertyCategory, announcementCategory, agent);
        }

        return newRequest;

        }

public Optional<SaleRequest> submitApartmentSaleRequest(String stateAbbreviation, String city, String street, String district, String zipCode,
        double area, double distanceFromCityCentre, int numberOfBedrooms, int numberOfBathrooms,
        int numberOfParkingSpaces, boolean hasCentralHeating, boolean hasAirConditioning,
        double price, String propertyCategoryDescription,
        String announcementCategoryDescription, Agent agent) {

        PropertyCategory propertyCategory = getPropertyCategoryByDescription(propertyCategoryDescription);
        AnnouncementCategory announcementCategory = getAnnouncementCategoryByDescription(announcementCategoryDescription);

        Optional<Agency> agency = getAgencyRepository().getAgencyByAgent(agent);

        Optional<SaleRequest> newRequest = Optional.empty();

        if (agency.isPresent()) {
        newRequest = agency.get().submitApartmentSaleRequest( stateAbbreviation, city, street, district, zipCode, area, distanceFromCityCentre, numberOfBedrooms, numberOfBathrooms, numberOfParkingSpaces, hasCentralHeating, hasAirConditioning, price, propertyCategory, announcementCategory, agent);
        }

        return newRequest;
        }

public Optional<RentRequest> submitApartmentRentRequest(String stateAbbreviation, String city, String street, String district, String zipCode,
        double area, double distanceFromCityCentre, int numberOfBedrooms, int numberOfBathrooms,
        int numberOfParkingSpaces, boolean hasCentralHeating, boolean hasAirConditioning,
        double monthlyRent, int contractDuration, String propertyCategoryDescription,
        String announcementCategoryDescription, Agent agent) {

        PropertyCategory propertyCategory = getPropertyCategoryByDescription(propertyCategoryDescription);
        AnnouncementCategory announcementCategory = getAnnouncementCategoryByDescription(announcementCategoryDescription);

        Optional<Agency> agency = getAgencyRepository().getAgencyByAgent(agent);

        Optional<RentRequest> newRequest = Optional.empty();

        if (agency.isPresent()) {
        newRequest = agency.get().submitApartmentRentRequest(stateAbbreviation, city, street, district, zipCode, area, distanceFromCityCentre, numberOfBedrooms, numberOfBathrooms, numberOfParkingSpaces, hasCentralHeating, hasAirConditioning, monthlyRent, contractDuration, propertyCategory, announcementCategory, agent);
        }

        return newRequest;

        }

public Optional<SaleRequest> submitHouseSaleRequest(String stateAbbreviation, String city, String street, String district, String zipCode, 
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
        district, zipCode, area, distanceFromCityCentre, numberOfBedrooms, numberOfBathrooms, numberOfParkingSpaces,
        hasCentralHeating, hasAirConditioning, hasBasement, hasInhabitableLoft, sunExposure, price, propertyCategory,
        announcementCategory, agent);
        }

        return newRequest;

        }

public Optional<RentRequest> submitHouseRentRequest(String stateAbbreviation, String city, String street, String district, String zipCode,
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
        zipCode, area, distanceFromCityCentre, numberOfBedrooms, numberOfBathrooms, numberOfParkingSpaces, hasCentralHeating,
        hasAirConditioning, hasBasement, hasInhabitableLoft, sunExposure, monthlyRent, contractDuration, propertyCategory,
        announcementCategory, agent);
        }

        return newRequest;

        }
```


## Class Agency

```java
public Optional<SaleRequest> submitLandSaleRequest(String stateAbbreviation, String city,
        String street, String district, String zipCode, double area,
        double distanceFromCityCentre, double price,
        PropertyCategory propertyCategory, AnnouncementCategory announcementCategory,
        Agent agent) {


        Optional<SaleRequest> optionalValue = Optional.empty();

        SaleRequest newRequest = new SaleRequest(stateAbbreviation, city, street, district, zipCode, area, distanceFromCityCentre, price, propertyCategory, announcementCategory, agent);

        if (addSaleRequest(newRequest)) {
        optionalValue = Optional.of(newRequest);
        }

        return optionalValue;
        }

public Optional<RentRequest> submitLandRentRequest(String stateAbbreviation, String city, String street, String district,
        String zipCode, double area, double distanceFromCityCentre,
        double monthlyPrice, int contractDuration, PropertyCategory propertyCategory,
        AnnouncementCategory announcementCategory, Agent agent) {


        Optional<RentRequest> optionalValue = Optional.empty();

        RentRequest newRequest = new RentRequest(stateAbbreviation, city, street, district, zipCode, area,
        distanceFromCityCentre, monthlyPrice, contractDuration, propertyCategory, announcementCategory, agent);

        if (addRentRequest(newRequest)) {
        optionalValue = Optional.of(newRequest);
        }

        return optionalValue;
        }

public Optional<SaleRequest> submitApartmentSaleRequest(String stateAbbreviation, String city, String street, String district,
        String zipCode, double area, double distanceFromCityCentre, int numberOfBedrooms,
        int numberOfBathrooms, int numberOfParkingSpaces, boolean hasCentralHeating, boolean hasAirConditioning,
        double price, PropertyCategory propertyCategory, AnnouncementCategory announcementCategory, Agent agent) {


        Optional<SaleRequest> optionalValue = Optional.empty();

        SaleRequest newRequest = new SaleRequest(stateAbbreviation, city, street, district, zipCode, area,
        distanceFromCityCentre, numberOfBedrooms, numberOfBathrooms, numberOfParkingSpaces, hasCentralHeating, hasAirConditioning,
        price, propertyCategory, announcementCategory, agent);

        if (addSaleRequest(newRequest)) {
        optionalValue = Optional.of(newRequest);
        }

        return optionalValue;
        }

public Optional<RentRequest> submitApartmentRentRequest(String stateAbbreviation, String city, String street, String district,
        String zipCode, double area, double distanceFromCityCentre, int numberOfBedrooms,
        int numberOfBathrooms, int numberOfParkingSpaces, boolean hasCentralHeating, boolean hasAirConditioning,
        double monthlyPrice, int contractDuration, PropertyCategory propertyCategory, AnnouncementCategory announcementCategory, Agent agent) {


        Optional<RentRequest> optionalValue = Optional.empty();

        RentRequest newRequest = new RentRequest(stateAbbreviation, city, street, district,
        zipCode, area, distanceFromCityCentre,numberOfBedrooms, numberOfBathrooms, numberOfParkingSpaces, hasCentralHeating,
        hasAirConditioning, monthlyPrice, contractDuration, propertyCategory, announcementCategory, agent);

        if (addRentRequest(newRequest)) {
        optionalValue = Optional.of(newRequest);
        }

        return optionalValue;
        }

public Optional<SaleRequest> submitHouseSaleRequest(String stateAbbreviation, String city, String street, String district,
        String zipCode, double area, double distanceFromCityCentre, int numberOfBedrooms,
        int numberOfBathrooms, int numberOfParkingSpaces, boolean hasCentralHeating, boolean hasAirConditioning, boolean hasBasement, boolean hasInhabitableLoft,
        String sunExposure, double price, PropertyCategory propertyCategory, AnnouncementCategory announcementCategory, Agent agent) {


        Optional<SaleRequest> optionalValue = Optional.empty();

        SaleRequest newRequest = new SaleRequest(stateAbbreviation, city, street, district, zipCode, area,
        distanceFromCityCentre, numberOfBedrooms, numberOfBathrooms, numberOfParkingSpaces, hasCentralHeating, hasAirConditioning,
        hasBasement, hasInhabitableLoft, sunExposure, price, propertyCategory, announcementCategory, agent);

        if (addSaleRequest(newRequest)) {
        optionalValue = Optional.of(newRequest);
        }

        return optionalValue;
        }

public Optional<RentRequest> submitHouseRentRequest(String stateAbbreviation, String city, String street, String district,
        String zipCode, double area, double distanceFromCityCentre, int numberOfBedrooms,
        int numberOfBathrooms, int numberOfParkingSpaces, boolean hasCentralHeating, boolean hasAirConditioning, boolean hasBasement, boolean hasInhabitableLoft,
        String sunExposure, double monthlyPrice, int contractDuration, PropertyCategory propertyCategory, AnnouncementCategory announcementCategory, Agent agent) {


        Optional<RentRequest> optionalValue = Optional.empty();

        RentRequest newRequest = new RentRequest(stateAbbreviation, city, street, district, zipCode,
        area, distanceFromCityCentre, numberOfBedrooms, numberOfBathrooms, numberOfParkingSpaces, hasCentralHeating, hasAirConditioning, hasBasement,
        hasInhabitableLoft, sunExposure, monthlyPrice, contractDuration, propertyCategory, announcementCategory, agent);

        if (addRentRequest(newRequest)) {
        optionalValue = Optional.of(newRequest);
        }

        return optionalValue;

        }
```

# 6. Integration and Demo 


# 7. Observations

Had some doubts on how to implement the agent the owner chose in the submit methods.
Do you  a«have any advice?
There are a lot of constructors and options that make the code a little bit complex.
Is there any way to make the correct data requests in a simpler form?






package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.PublishAnnouncementController;
import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.AnnouncementCategory;
import pt.ipp.isep.dei.esoft.project.domain.PropertyCategory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.*;


public class PublishAnnouncementUI implements Runnable {

    static Scanner input = new Scanner(System.in);


    private final PublishAnnouncementController controller = new PublishAnnouncementController();


    private String propertyCategoryDescription;
    private String announcementCategoryDescription;
    private String publicationDate;

    private String stateAbbreviation;
    private String city;
    private String street;
    private String district;
    private String zipCode;
    private double commission;
    private double area;
    private double distanceFromCityCentre;
    private Integer numberOfBedrooms;
    private Integer numberOfBathrooms;
    private Integer numberOfParkingSpaces;
    private boolean hasCentralHeating;
    private boolean hasAirConditioning;
    private boolean hasBasement;
    private boolean hasInhabitableLoft;
    private String sunExposure;
    private int contractDuration;
    private double monthlyPrice;
    private double price;

    private PublishAnnouncementController getController() {
        return controller;
    }

    public void run() {
        System.out.println("Publish Announcement\n");

        propertyCategoryDescription = displayAndSelectPropertyCategory();
        announcementCategoryDescription = displayAndSelectAnnouncementCategory();


        switch (propertyCategoryDescription) {
            case ("Land"):
                switch (announcementCategoryDescription) {
                    case ("Sale"):
                        requestDataLandSale();
                        submitDataLandSale();
                        break;

                    case ("Rent"):
                        requestDataLandRent();
                        submitDataLandRent();
                        break;
                }
            case ("Apartment"):
                switch (announcementCategoryDescription) {
                    case ("Sale"):
                        requestDataApartmentSale();
                        submitDataApartmentSale();
                        break;

                    case ("Rent"):
                        requestDataApartmentRent();
                        submitDataApartmentRent();
                        break;
                }
            case ("House"):
                switch (announcementCategoryDescription) {
                    case ("Sale"):
                        requestDataHouseSale();
                        submitDataHouseSale();
                        break;

                    case ("Rent"):
                        requestDataHouseRent();
                        submitDataHouseRent();
                        break;
                }

        }
    }

    private String displayAndSelectPropertyCategory() {
        List<PropertyCategory> propertyCategoryList = controller.getPropertyCategoryList();

        int listSize = propertyCategoryList.size();
        int answer = -1;

        while (answer < 1 || answer > listSize) {
            displayPropertyCategoryList(propertyCategoryList);
            System.out.println("Select a property category.");
            answer = input.nextInt();
        }

        return propertyCategoryList.get(answer - 1).getDescription();
    }

    private String displayAndSelectAnnouncementCategory() {
        List<AnnouncementCategory> announcementCategoryList = controller.getAnnouncementCategoryList();

        int listSize = announcementCategoryList.size();
        int answer = -1;

        while (answer < 1 || answer > listSize) {
            displayAnnouncementCategoryList(announcementCategoryList);
            System.out.println("Select a announcement category.");
            answer = input.nextInt();
        }

        return announcementCategoryList.get(answer - 1).getDescription();
    }

    private void displayPropertyCategoryList(List<PropertyCategory> propertyCategoryList) {
        int iterator = 1;

        for (PropertyCategory propertyCategory : propertyCategoryList) {
            System.out.println(iterator + " - " + propertyCategory.getDescription());
        }

    }

    private void displayAnnouncementCategoryList(List<AnnouncementCategory> announcementCategoryList) {
        int iterator = 1;

        for (AnnouncementCategory announcementCategory : announcementCategoryList) {
            System.out.println(iterator + " - " + announcementCategory.getDescription());
        }

    }

    private void submitDataLandSale() {
        Optional<Announcement> announcement = getController().publishLandSaleAnnouncement(publicationDate,
                stateAbbreviation, city, street, district, zipCode, area, distanceFromCityCentre, commission, price, propertyCategoryDescription,
                announcementCategoryDescription);

        if (announcement.isPresent()) {
            System.out.println("Land sale announcement successfully published!");
        } else {
            System.out.println("Announcement not published!");
        }

    }

    private void submitDataLandRent() {
        Optional<Announcement> announcement = getController().publishLandRentAnnouncement(publicationDate,
                stateAbbreviation, city, street, district, zipCode, area, distanceFromCityCentre, commission, monthlyPrice,
                contractDuration, propertyCategoryDescription, announcementCategoryDescription);

        if (announcement.isPresent()) {
            System.out.println("Land rent announcement successfully published!");
        } else {
            System.out.println("Announcement not published!");
        }


    }

    private void submitDataApartmentSale() {
        Optional<Announcement> announcement = getController().publishApartmentSaleAnnouncement(publicationDate,
                stateAbbreviation, city, street, district, zipCode, area, distanceFromCityCentre, numberOfBedrooms,
                numberOfBathrooms, numberOfParkingSpaces, hasCentralHeating, hasAirConditioning, commission, price,
                propertyCategoryDescription, announcementCategoryDescription);

        if (announcement.isPresent()) {
            System.out.println("Apartment sale announcement successfully published!");
        } else {
            System.out.println("Announcement not published!");
        }

    }

    private void submitDataApartmentRent() {
        Optional<Announcement> announcement = getController().publishApartmentRentAnnouncement(publicationDate,
                stateAbbreviation, city, street, district, zipCode, area, distanceFromCityCentre, numberOfBedrooms,
                numberOfBathrooms, numberOfParkingSpaces, hasCentralHeating, hasAirConditioning, commission,
                monthlyPrice, contractDuration, propertyCategoryDescription, announcementCategoryDescription);

        if (announcement.isPresent()) {
            System.out.println("Apartment rent announcement successfully published!");
        } else {
            System.out.println("Announcement not published!");
        }

    }

    private void submitDataHouseSale() {
        Optional<Announcement> announcement = getController().publishHouseSaleAnnouncement(publicationDate, stateAbbreviation, city,
                street, district, zipCode, area, distanceFromCityCentre, numberOfBedrooms,
                numberOfBathrooms, numberOfParkingSpaces, hasCentralHeating, hasAirConditioning,
                hasBasement, hasInhabitableLoft, sunExposure, commission, price, propertyCategoryDescription, announcementCategoryDescription);

        if (announcement.isPresent()) {
            System.out.println("House sale announcement successfully published!");
        } else {
            System.out.println("Announcement not published!");
        }


    }

    private void submitDataHouseRent() {
        Optional<Announcement> announcement = getController().publishHouseRentAnnouncement(publicationDate, stateAbbreviation, city,
                street, district, zipCode, area, distanceFromCityCentre, numberOfBedrooms,
                numberOfBathrooms, numberOfParkingSpaces, hasCentralHeating, hasAirConditioning,
                hasBasement, hasInhabitableLoft, sunExposure, commission, monthlyPrice, contractDuration,
                propertyCategoryDescription, announcementCategoryDescription);

        if (announcement.isPresent()) {
            System.out.println("House rent announcement successfully published!");
        } else {
            System.out.println("Announcement not published!");
        }

    }



    private void requestDataLandSale() {

        publicationDate = getCurrentDate();
        requestLocation();
        requestLandDetails();
        requestSaleDetails();


    }

    private void requestDataLandRent() {

        publicationDate = getCurrentDate();
        requestLocation();
        requestLandDetails();
        requestRentDetails();
    }

    private void requestDataApartmentSale() {

        publicationDate = getCurrentDate();
        requestLocation();
        requestApartmentDetails();
        requestSaleDetails();
    }

    private void requestDataApartmentRent() {

        publicationDate = getCurrentDate();
        requestLocation();
        requestApartmentDetails();
        requestRentDetails();
    }

    private void requestDataHouseSale() {

        publicationDate = getCurrentDate();
        requestLocation();
        requestHouseDetails();
        requestSaleDetails();
    }

    private void requestDataHouseRent() {

        publicationDate = getCurrentDate();
        requestLocation();
        requestHouseDetails();
        requestRentDetails();
    }


    private void requestLocation() {
        stateAbbreviation = requestState();
        city = requestCity();
        street = requestStreet();
        district = requestDistrict();
        zipCode = requestZipCode();
    }

    private void requestLandDetails() {
        area = requestArea();
        distanceFromCityCentre = requestDistanceFromCityCentre();
    }

    private void requestApartmentDetails() {
        area = requestArea();
        distanceFromCityCentre = requestDistanceFromCityCentre();
        numberOfBedrooms = requestNumberOfBedrooms();
        numberOfBathrooms = requestNumberOfBathrooms();
        numberOfParkingSpaces = requestNumberOfParkingSpaces();
        hasCentralHeating = requestHasCentralHeating();
        hasAirConditioning = requestHasAirConditioning();
    }

    private void requestHouseDetails() {
        area = requestArea();
        distanceFromCityCentre = requestDistanceFromCityCentre();
        numberOfBedrooms = requestNumberOfBedrooms();
        numberOfBathrooms = requestNumberOfBathrooms();
        numberOfParkingSpaces = requestNumberOfParkingSpaces();
        hasCentralHeating = requestHasCentralHeating();
        hasAirConditioning = requestHasAirConditioning();
        hasBasement = requestHasBasement();
        hasInhabitableLoft = requestHasInhabitableLoft();
        sunExposure = requestSunExposure();
    }

    private void requestSaleDetails() {
        price = requestPrice();
        commission = requestCommission();
    }

    private void requestRentDetails() {
        monthlyPrice = requestMonthlyPrice();
        contractDuration = requestContractDuration();
        commission = requestCommission();
    }
    private String getCurrentDate() {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }

    private String requestState() {
        System.out.println("State: ");
        return input.nextLine();
    }

    private String requestCity() {
        System.out.println("City: ");
        return input.nextLine();
    }

    private String requestStreet() {
        System.out.println("Street: ");
        return input.nextLine();
    }

    private String requestDistrict() {
        System.out.println("District: ");
        return input.nextLine();
    }

    private String requestZipCode() {
        System.out.println("Zip Code: ");
        return input.nextLine();
    }
    private double requestArea() {
        System.out.println("Area: ");
        return input.nextDouble();
    }

    private double requestDistanceFromCityCentre() {
        System.out.println("Distance from city centre: ");
        return input.nextDouble();
    }

    private Integer requestNumberOfBedrooms() {
        System.out.println("Number of bedrooms: ");
        return input.nextInt();
    }

    private Integer requestNumberOfBathrooms() {
        System.out.println("Number of bathrooms: ");
        return input.nextInt();
    }

    private Integer requestNumberOfParkingSpaces() {
        System.out.println("Number of parking spaces: ");
        return input.nextInt();
    }

    private boolean requestHasCentralHeating() {
        System.out.println("Has central heating (yes/no): ");
        return equals("yes");
    }

    private boolean requestHasAirConditioning() {
        System.out.println("Has air conditioning (yes/no): ");
        return equals("yes");
    }

    private boolean requestHasBasement() {
        System.out.println("Has basement (yes/no): ");
        return equals("yes");
    }

    private boolean requestHasInhabitableLoft() {
        System.out.println("Has inhabitable loft (yes/no): ");
        return equals("yes");

    }

    private String requestSunExposure() {
        System.out.println("Sun exposure (N/S/W/E/None): ");
        return input.next();
    }

    private double requestCommission() {
        System.out.println("Commission: ");
        return input.nextDouble();
    }

    private int requestContractDuration() {
        System.out.println("Contract Duration: ");
        return input.nextInt();
    }

    private double requestPrice() {
        System.out.println("Sale price: ");
        return input.nextDouble();
    }

    private double requestMonthlyPrice() {
        System.out.println("Monthly price: ");
        return input.nextDouble();
    }

}

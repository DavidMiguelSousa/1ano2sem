package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.RequestAnnouncementController;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.AgencyRepository;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class RequestAnnouncementUI implements Runnable {

    //falta acabar os metodos submit
    //corrigir a parte da lista de agentes


    static Scanner input = new Scanner(System.in);

    private final RequestAnnouncementController ctrl = new RequestAnnouncementController();

    private final
    private String propertyCategoryDescription;
    private String announcementCategoryDescription;
    private String agencyDescription;
    private String agent;

    private String stateAbbreviation;
    private String city;
    private String street;
    private String district;
    private String zipCode;
    private String photographsURI;
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
    private double monthlyRent;
    private double price;

    private RequestAnnouncementController getCtrl() {
        return ctrl;
    }

    @Override
    public void run() {

    }

    private String displayAndSelectPropertyCategory() {
        List<PropertyCategory> propertyCategoryList = ctrl.getPropertyCategoryList();

        int listSize = propertyCategoryList.size();
        int answer = -1;

        while (answer < 1 || answer > listSize) {
            displayPropertyCategoryList(propertyCategoryList);
            System.out.println("Select a property category:");
            answer = input.nextInt();
        }
        String description = propertyCategoryList.get(answer - 1).getDescription();
        return description;
    }

    private void displayPropertyCategoryList(List<PropertyCategory> propertyCategoryList) {
        int i = 1;
        for (PropertyCategory propertyCategory : propertyCategoryList) {
            System.out.println(i + " - " + propertyCategory.getDescription());
            i++;
        }
    }


    private String displayAndSelectAnnouncementCategory() {
        List<AnnouncementCategory> announcementCategoryList = ctrl.getAnnouncementCategoryList();

        int listSize = announcementCategoryList.size();
        int answer = -1;

        while (answer < 1 || answer > listSize) {
            displayAnnouncementCategoryList(announcementCategoryList);
            System.out.println("Select an announcement category:");
            answer = input.nextInt();
        }
        String description = announcementCategoryList.get(answer - 1).getDescription();
        return description;
    }

    private void displayAnnouncementCategoryList(List<AnnouncementCategory> announcementCategoryList) {
        int i = 1;
        for (AnnouncementCategory announcementCategory : announcementCategoryList) {
            System.out.println(i + " - " + announcementCategory.getDescription());
            i++;
        }
    }

    private String findAgencyID() {
        List<Agency> agencyList = ctrl.getAgencyList();
        int i = 0;
        String agencyID = "Agency not found";
        do {
            i++;
            if (i == selectAgency()) {
                for (Agency agency : agencyList) {
                    agencyID = agency.getId();
                }
            }
        } while (i != selectAgency() && i < agencyList.size());
        return agencyID;
    }

    private String findAgentName() {
        List<Agent> agentList = ctrl.getAgentList();
        int y = 0;
        String agentName = "Agent not found.";
        for (Agent agent : agentList) {
            if (agencyRepository.getAgencyByAgent(agent).getId().equals(findAgencyID())) {
                y++;
                if (y == selectAgent()) {
                    agentName = agent.getName();
                }
            }
        }
        return agentName;

    }

    private int selectAgency() {
        List<Agency> agencyList = ctrl.getAgencyList();
        displayAgencyList(agencyList);
        System.out.print("Select an agency: ");
        return input.nextInt();
    }

    private int selectAgent() {
        List<Agent> agentList = ctrl.getAgentList();
        displayAgentList(agentList);
        System.out.print("Select an agent: ");
        return input.nextInt();
    }

    private void displayAgencyList(List<Agency> agencyList) {
        int i = 1;
        for (Agency agency : agencyList) {
            System.out.println(i + " - " + agency.getId());
            i++;
        }
    }

    private void displayAgentList(List<Agent> agentList) {
        int y = 1;
        for (Agent agent : agentList) {
            if (agencyRepository.getAgencyByAgent(agent).getId().equals(findAgencyID()))
                System.out.println(y + " - " + agent.getName());
            y++;
        }
    }

    private void submitDataLandSale() {
        Optional<SaleRequest> saleRequest = getCtrl().submitLandSaleRequest(stateAbbreviation, city, district, street, zipCode, price, photographsURI,
                area, distanceFromCityCentre, propertyCategoryDescription, announcementCategoryDescription);

        if (saleRequest.isPresent()) {
            System.out.println("Land sale request successfully submitted");
        } else {
            System.out.println("Land sale request not submitted");
        }
    }


    private void requestDataLandSale() {
        requestLocation();
        requestLandData();
        requestSaleData();
    }

    private void requestDataLandRent() {
        requestLocation();
        requestLandData();
        requestRentData();
    }

    private void requestDataApartmentSale() {
        requestLocation();
        requestApartmentData();
        requestSaleData();
    }

    private void requestDataApartmentRent() {
        requestLocation();
        requestApartmentData();
        requestRentData();
    }

    private void requestDataHouseSale() {
        requestLocation();
        requestHouseData();
        requestSaleData();
    }

    private void requestDataHouseRent() {
        requestLocation();
        requestHouseData();
        requestRentData();
    }

    private void requestLandData() {
        photographsURI = requestPhotographsURI();
        area = requestArea();
        distanceFromCityCentre = requestDistanceFromCityCentre();
    }

    private void requestApartmentData() {
        photographsURI = requestPhotographsURI();
        area = requestArea();
        distanceFromCityCentre = requestDistanceFromCityCentre();
        numberOfBedrooms = requestNumberOfBedrooms();
        numberOfBathrooms = requestNumberOfBathrooms();
        numberOfParkingSpaces = requestNumberOfParkingSpaces();
        hasCentralHeating = requestHasCentralHeating();
        hasAirConditioning = requestHasAirConditioning();
    }

    private void requestHouseData() {
        photographsURI = requestPhotographsURI();
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

    private void requestLocation() {
        stateAbbreviation = requestStateAbbreviation();
        city = requestCity();
        district = requestDistrict();
        street = requestStreet();
        zipCode = requestZipCode();
    }

    private void requestRentData() {
        monthlyRent = requestMonthlyRent();
        contractDuration = requestContractDuration();
    }

    private void requestSaleData() {
        price = requestPrice();
    }

    private int requestContractDuration() {
        System.out.println("Contract duration:");
        return input.nextInt();
    }

    private double requestPrice() {
        System.out.println("Price:");
        return input.nextDouble();
    }

    private double requestMonthlyRent() {
        System.out.println("Monthly rent:");
        return input.nextDouble();
    }

    private String requestZipCode() {
        System.out.println("Zip Code:");
        return input.nextLine();
    }

    private String requestCity() {
        System.out.println("City:");
        return input.nextLine();
    }

    private String requestDistrict() {
        System.out.println("District:");
        return input.nextLine();
    }

    private String requestStreet() {
        System.out.println("Street:");
        return input.nextLine();
    }

    private String requestStateAbbreviation() {
        System.out.println("State abbreviation:");
        return input.nextLine();
    }

    private String requestSunExposure() {
        System.out.println("Sun exposure (N/S/W/E):");
        return input.next();
    }

    private boolean requestHasAirConditioning() {
        System.out.println("Has air conditioning (yes/no):");
        return equals("yes");
    }

    private boolean requestHasCentralHeating() {
        System.out.println("Has central heating (yes/no):");
        return equals("yes");
    }

    private boolean requestHasInhabitableLoft() {
        System.out.println("Has inhabitable loft (yes/no):");
        return equals("yes");
    }

    private boolean requestHasBasement() {
        System.out.println("Has basement (yes/no):");
        return equals("yes");
    }

    private Integer requestNumberOfParkingSpaces() {
        System.out.println("Number of parking spaces:");
        return input.nextInt();
    }

    private Integer
    requestNumberOfBathrooms() {
        System.out.println("Number of bathrooms:");
        return input.nextInt();
    }

    private Integer requestNumberOfBedrooms() {
        System.out.println("Number of bedrooms:");
        return input.nextInt();
    }


    private double requestDistanceFromCityCentre() {
        System.out.println("Distance From City Centre::");
        return input.nextDouble();
    }

    private double requestArea() {
        System.out.println("Area (m2):");
        return input.nextDouble();
    }

    private String requestPhotographsURI() {
        System.out.println("Photographs URI:");
        return input.next();
    }


}

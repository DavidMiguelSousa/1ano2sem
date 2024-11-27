package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.SpecifyLocationController;
import pt.ipp.isep.dei.esoft.project.domain.Location;

import java.util.List;
import java.util.Scanner;


public class SpecifyLocationUI implements Runnable {

    public String stateAbbreviation = requestStateAbbreviation();;

    private final SpecifyLocationController locationController = new SpecifyLocationController();;

    public String location;

    @Override
    public void run() {
        requestStateAbbreviation();
        displayLocationsList(stateAbbreviation);
        requestLocation();
        specifyLocation(stateAbbreviation);
    }

    public String requestStateAbbreviation() {
        //Requests the State Abbreviation from the console
        Scanner input = new Scanner(System.in);
        System.out.print("State abbreviation: ");
        return input.next();
    }

    private int requestLocation() {
        //Requests the Location, selected from a list, from the console
        Scanner input = new Scanner(System.in);
        System.out.print("Location: ");
        return input.nextInt();
    }

    public String getStateAbbreviation() {
        return stateAbbreviation;
    }

    public void displayLocationsList(String stateAbbreviation) {
        if (locationController.checkStoresLocation(stateAbbreviation)) {
            int i = 0;
            List<Location> locationList = locationController.findStoresLocation(stateAbbreviation);
            for (Location location : locationList) {
                System.out.println("[" + i + "]\n" + location.toString());
                i++;
            }
        }
    }

    public void specifyLocation(String stateAbbreviation) {
        int i = 0;
        List<Location> locationList = locationController.findStoresLocation(stateAbbreviation);
        for (Location location : locationList) {
            if (i == requestLocation()) {
                System.out.println(location.toString());
            }
            i++;
        }
    }
}

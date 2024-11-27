package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.CreateAgencyController;
import pt.ipp.isep.dei.esoft.project.application.controller.CreateTaskController;
import pt.ipp.isep.dei.esoft.project.domain.Location;
import pt.ipp.isep.dei.esoft.project.domain.Task;
import pt.ipp.isep.dei.esoft.project.domain.TaskCategory;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * Create Task UI (console). This option is only available for administrators for demonstration purposes.
 */
public class CreateAgencyUI implements Runnable {

    private final CreateAgencyController controller = new CreateAgencyController();
    private Location location;
    private String id;
    private String designation;
    private String phone;
    private String email;
    private State state;
    private City city;
    private District district;

    private CreateAgencyController getController() {
        return controller;
    }

    public void run() {
        System.out.println("Create Task");

        requestData();

        submitData();
    }

    private void submitData() {
        CreateAgencyController controller= getController();
        if(controller.createAgency(location,id,designation,phone,email)){
            System.out.println("Agency successfully created!");
        } else {
            System.out.println("Agency not created!");
        }
    }

    private void requestData() {

        //Request the id from the console
        id=requestId();
        //Request the designation from the console
        designation=requestDesignation();
        //Request the phone from the console
        phone=requestPhone();
        //Request the email from the console
        email=requestEmail();

        //Request the state from the console
        state=displayAndSelectState();
        //Request the district from the console
        district=displayAndSelectDistrict();
        //Request the city from the console
        city=displayAndSelectCity();


        location=createLocation(state,city,district);

    }

    private String requestEmail() {
        Scanner input = new Scanner(System.in);
        System.out.println("Email:");
        return input.nextLine();
    }
    private String requestPhone() {
        Scanner input = new Scanner(System.in);
        System.out.println("Phone:");
        return input.nextLine();
    }
    private String requestDesignation() {
        Scanner input = new Scanner(System.in);
        System.out.println("Designation:");
        return input.nextLine();
    }
    private String requestId() {
        Scanner input = new Scanner(System.in);
        System.out.println("Id:");
        return input.nextLine();
    }
    private State displayAndSelectState(){
        //Display the list of states
        List<State> states = controller.getStates();

        int listSize = states.size();
        int answer = -1;

        Scanner input = new Scanner(System.in);

        while (answer < 1 || answer > listSize) {
            displayStateOptions(states);
            System.out.println("Select a state:");
            answer = input.nextInt();
        }

        State state = states.get(answer - 1);
        return state;
    }
    private City displayAndSelectCity(){
        //Display the list of cities
        List<City> cities = controller.getCities();

        int listSize = cities.size();
        int answer = -1;

        Scanner input = new Scanner(System.in);

        while (answer < 1 || answer > listSize) {
            displayCityOptions(cities);
            System.out.println("Select a city:");
            answer = input.nextInt();
        }

        City city = cities.get(answer - 1);
        return city;
    }
    private District displayAndSelectDistrict(){
        //Display the list of districts
        List<District> districts = controller.getDistricts();

        int listSize = districts.size();
        int answer = -1;

        Scanner input = new Scanner(System.in);

        while (answer < 1 || answer > listSize) {
            displayDistrictOptions(districts);
            System.out.println("Select a district:");
            answer = input.nextInt();
        }

        District district = districts.get(answer - 1);
        return district;
    }
    private Location createLocation(State state, City city, District district){
        return controller.createLocation(state,city,district);
    }
    private void displayStateOptions(List<State> states) {
        int i = 1;
        for (State state : states) {
            System.out.println(i + " - " + state.getName());
            i++;
        }
    }
    private void displayCityOptions(List<City> cities) {
        int i = 1;
        for (City city : cities) {
            System.out.println(i + " - " + city.getName());
            i++;
        }
    }
    private void displayDistrictOptions(List<District> districts) {
        int i = 1;
        for (District district : districts) {
            System.out.println(i + " - " + district.getName());
            i++;
        }
    }

}


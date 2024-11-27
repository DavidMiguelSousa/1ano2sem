package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.DisplayPropertiesController;
import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.AnnouncementCategory;
import pt.ipp.isep.dei.esoft.project.domain.PropertyCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DisplayPropertiesUI implements Runnable {

    Scanner scan = new Scanner(System.in);

    private final DisplayPropertiesController controller = new DisplayPropertiesController();

    private List<Announcement> displaybleAnnouncementList = new ArrayList<>();

    private List<AnnouncementCategory> announcementCategoryList = controller.getAnnouncementCategoryList();

    private List<PropertyCategory> propertyCategoryList = controller.getPropertyCategoryList();

    private String announcementCategoryDescription;

    private String propertyCategoryDescription;

    private String description = "";

    public int filterOption;

    public void run() {

        System.out.println("Display Properties\n");

        System.out.println("Do you want to select any filters?\n1 - Yes.\n2 - No.");
        filterOption = scan.nextInt();

        switch (filterOption) {
            case 1:
                System.out.println("Do you want to buy or rent a property?");
                displayAnnouncementCategoryList(announcementCategoryList);
                announcementCategoryDescription = selectAnnouncementCategory(announcementCategoryList);

                System.out.println("Which type of property are you looking for?");
                displayPropertyCategoryList(propertyCategoryList);
                propertyCategoryDescription = selectPropertyCategory(propertyCategoryList);

                break;
            case 2:
                break;
            default:
                System.out.println("Please input a valid number.");
                filterOption = scan.nextInt();
        }

    }

    private void displayAnnouncementCategoryList() {

        int iterator = 1;

        for (AnnouncementCategory announcementCategory : announcementCategoryList) {
            System.out.println(iterator + " - " + announcementCategory.getDescription());
        }

    }

    private void displayPropertyCategoryList() {

        int iterator = 1;

        for (PropertyCategory propertyCategory : propertyCategoryList) {
            System.out.println(iterator + " - " + propertyCategory.getDescription());
        }

    }

    private String selectAnnouncementCategory() {

        int listSize = announcementCategoryList.size();
        int answer = -1;

        while (answer < 1 || answer > listSize) {
            answer = scan.nextInt();
        }

        return announcementCategoryList.get(answer - 1).getDescription();

    }

    private String selectPropertyCategory() {

        int listSize = propertyCategoryList.size();
        int answer = -1;

        while (answer < 1 || answer > listSize) {
            answer = scan.nextInt();
        }

        return propertyCategoryList.get(answer - 1).getDescription();

    }

    public int getFilterOption() {
        return filterOption;
    }

    public DisplayPropertiesController getController() {
        return controller;
    }

}

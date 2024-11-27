package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;

import java.util.ArrayList;
import java.util.List;

public class DisplayPropertiesController {

    private List<Announcement> announcementsList = AnnouncementHandling.getAnnouncementsList();

    private AgencyRepository agencyRepository = Repositories.getInstance().getAgencyRepository();

    private AnnouncementCategoryRepository announcementCategoryRepository = Repositories.getInstance().getAnnouncementCategoryRepository();

    private PropertyCategoryRepository propertyCategoryRepository = Repositories.getInstance().getPropertyCategoryRepository();

    private AnnouncementCategory announcementCategory;

    private PropertyCategory propertyCategory;

    private String announcementCategoryDescription;

    private String propertyCategoryDescription;

    private int numberOfRooms;

    private AgencyRepository getAgencyRepository() {

        if (agencyRepository == null) {
            Repositories repositories = Repositories.getInstance();
            agencyRepository = repositories.getAgencyRepository();
        }

        return agencyRepository;
    }

    private AnnouncementCategoryRepository getAnnouncementCategoryRepository() {

        if (announcementCategoryRepository == null) {
            Repositories repositories = Repositories.getInstance();
            announcementCategoryRepository = repositories.getAnnouncementCategoryRepository();
        }

        return announcementCategoryRepository;
    }

    private PropertyCategoryRepository getPropertyCategoryRepository() {

        if (propertyCategoryRepository == null) {
            Repositories repositories = Repositories.getInstance();
            propertyCategoryRepository = repositories.getPropertyCategoryRepository();
        }

        return propertyCategoryRepository;
    }

    public List<AnnouncementCategory> getAnnouncementCategoryList() {

        AnnouncementCategoryRepository announcementCategoryRepository = getAnnouncementCategoryRepository();

        return announcementCategoryRepository.getAnnouncementCategoryList();
    }

    public List<PropertyCategory> getPropertyCategoryList() {

        PropertyCategoryRepository propertyCategoryRepository = getPropertyCategoryRepository();

        return propertyCategoryRepository.getPropertyCategoryList();
    }

    public List<Announcement> getDisplaybleAnnouncementList() {

        List<Announcement> displaybleAnnouncementList = new ArrayList<>();
        List<Announcement> defaultSortedAnnouncementList = AnnouncementHandling.getDefaultSortedAnnouncementList(announcementsList);

        switch (DisplayPropertiesUI.getFilterOption()) {

            case 1:
                announcementCategoryDescription = DisplayPropertiesUI.getAnnouncementCategoryDescription();
                propertyCategoryDescription = DisplayPropertiesUI.getPropertyCategoryDescription();
                announcementCategory = AnnouncementCategoryRepository.getAnnouncementCategoryByDescription(announcementCategoryDescription);
                propertyCategory = PropertyCategoryRepository.getPropertyCategoryByDescription(propertyCategoryDescription);
                if (propertyCategoryDescription.equals("House") || propertyCategoryDescription.equals("Apartment")) {
                    numberOfRooms = DisplayPropertiesUI.getNumberOfRooms();
                }
                displaybleAnnouncementList = AnnouncementHandling.getFilteredAnnouncementList(defaultSortedAnnouncementList, announcementCategory, propertyCategory, numberOfRooms);
                break;

            case 2:
                displaybleAnnouncementList = defaultSortedAnnouncementList;
                break;

            default:
                break;

        }

        return displaybleAnnouncementList;

    }

}
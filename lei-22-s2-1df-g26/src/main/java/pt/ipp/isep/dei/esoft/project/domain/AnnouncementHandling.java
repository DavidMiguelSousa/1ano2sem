package pt.ipp.isep.dei.esoft.project.domain;

import java.util.ArrayList;
import java.util.List;

public class AnnouncementHandling implements Comparable<Announcement> {
    private List<Announcement> announcementsList = new ArrayList<>();

    public List<Announcement> getFilteredAnnouncementList(List<Announcement> defaultSortedAnnouncementList, AnnouncementCategory announcementCategory, PropertyCategory propertyCategory, int numberOfRooms) {

        List<Announcement> filteredAnnouncementList = new ArrayList<>();

        for (Announcement announcement : defaultSortedAnnouncementList) {

            if (announcement.getAnnouncementCategory() == announcementCategory && announcement.getPropertyCategory() == propertyCategory && announcement.getNumberOfRooms() == numberOfRooms) {
                filteredAnnouncementList.add(announcement);
            }

        }

        return filteredAnnouncementList;

    }

    public List<Announcement> getFilteredAnnouncementList(List<Announcement> defaultSortedAnnouncementList, AnnouncementCategory announcementCategory, PropertyCategory propertyCategory) {
        List<Announcement> filteredAnnouncementList = new ArrayList<>();

        for (Announcement announcement : defaultSortedAnnouncementList) {
            if (announcement.getAnnouncementCategory() == announcementCategory && announcement.getPropertyCategory() == propertyCategory) {

                filteredAnnouncementList.add(announcement);

            }
        }

        return filteredAnnouncementList;
    }

    public static List<Announcement> getDefaultSortedAnnouncementList(List<Announcement> announcementsList) {

        List <Announcement> defaultSortedAnnouncementList = new ArrayList<>();
        Announcement copy;

        for (int i = 1; i < announcementsList.size(); i++) {

            if (announcementsList.get(i).getPublicationDate().compareTo(announcementsList.get(i-1).getPublicationDate()) > 0) {
                copy = announcementsList.get(i-1);
                announcementsList.set(i-1, announcementsList.get(i));
                announcementsList.set(i, copy);
            }

        }

        return defaultSortedAnnouncementList;

    }

    public List<Announcement> getAnnouncementsList() {
        return announcementsList;
    }

    public List<Announcement> addAgencyAnnouncementList(List<Announcement> agencyAnnouncementList) {

        announcementsList.addAll(agencyAnnouncementList);
        return announcementsList;

    }

    @Override
    public int compareTo(Announcement o) {
        //TODO: quando for implementada a classe Date, criar um método que compare duas datas e devolva um valor inteiro que traduza a relação.
        return 0;
    }
}
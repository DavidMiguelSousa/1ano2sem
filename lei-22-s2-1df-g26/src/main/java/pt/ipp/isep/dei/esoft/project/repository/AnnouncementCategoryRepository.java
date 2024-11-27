package pt.ipp.isep.dei.esoft.project.repository;



import pt.ipp.isep.dei.esoft.project.domain.AnnouncementCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AnnouncementCategoryRepository {

    private final List<AnnouncementCategory> announcementCategoryList = new ArrayList<>();

    public AnnouncementCategory getAnnouncementCategoryByDescription(String announcementCategoryDescription) {

        AnnouncementCategory newAnnouncementCategory = new AnnouncementCategory(announcementCategoryDescription);
        AnnouncementCategory announcementCategory = null;

        if (announcementCategoryList.contains(newAnnouncementCategory)) {
            announcementCategory = announcementCategoryList.get(announcementCategoryList.indexOf(newAnnouncementCategory));
        }
        if (announcementCategory == null) {
            throw new IllegalArgumentException("Announcement Category requested for [ " +announcementCategoryDescription + "] doesn't exist.");

        }

        return announcementCategory;
    }

    public Optional<AnnouncementCategory> add(AnnouncementCategory announcementCategory) {

        Optional<AnnouncementCategory> newAnnouncementCategory = Optional.empty();
        boolean operationSuccess = false;

        if (validateAnnouncementCategory(announcementCategory)) {
            newAnnouncementCategory = Optional.of(announcementCategory.clone());
            operationSuccess = announcementCategoryList.add(newAnnouncementCategory.get());
        }

        if (!operationSuccess) {
            newAnnouncementCategory = Optional.empty();
        }

        return newAnnouncementCategory;
    }

    private boolean validateAnnouncementCategory(AnnouncementCategory announcementCategory) {
        return !announcementCategoryList.contains(announcementCategory);
    }

    public List<AnnouncementCategory> getAnnouncementCategoryList() {
        return List.copyOf(announcementCategoryList);
    }
}

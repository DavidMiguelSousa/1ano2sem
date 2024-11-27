package pt.ipp.isep.dei.esoft.project.domain;

public class AnnouncementCategory {

    private final String description;

    public AnnouncementCategory(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof AnnouncementCategory)) {
            return false;
        }
        AnnouncementCategory that = (AnnouncementCategory) object;
        return description.equals(that.description);
    }

    public String getDescription() {
        return description;
    }

    public AnnouncementCategory clone() {
        return new AnnouncementCategory(this.description);
    }
}

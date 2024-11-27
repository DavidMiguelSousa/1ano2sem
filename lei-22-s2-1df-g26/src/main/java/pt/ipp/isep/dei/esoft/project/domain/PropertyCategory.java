package pt.ipp.isep.dei.esoft.project.domain;

public class PropertyCategory {

    private final String description;

    public PropertyCategory(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public PropertyCategory clone() {
        return new PropertyCategory(this.description);
    }
}

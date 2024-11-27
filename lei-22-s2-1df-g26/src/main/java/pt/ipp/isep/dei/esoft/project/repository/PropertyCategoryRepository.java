package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.PropertyCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PropertyCategoryRepository {

    private final List<PropertyCategory> propertyCategoryList = new ArrayList<>();

    public static PropertyCategory getPropertyCategoryByDescription(String propertyCategoryDescription) {

        PropertyCategory newPropertyCategory = new PropertyCategory(propertyCategoryDescription);
        PropertyCategory propertyCategory = null;

        if (propertyCategoryList.contains(newPropertyCategory)) {
            propertyCategory = propertyCategoryList.get(propertyCategoryList.indexOf(newPropertyCategory));
        }
        if (propertyCategory == null) {
            throw new IllegalArgumentException("Property Category requested for [ " + propertyCategoryDescription + "] doesn't exist.");

        }

        return propertyCategory;
    }

    public Optional<PropertyCategory> add(PropertyCategory propertyCategory) {

        Optional<PropertyCategory> newPropertyCategory = Optional.empty();
        boolean operationSuccess = false;

        if (validatePropertyCategory(propertyCategory)) {
            newPropertyCategory = Optional.of(propertyCategory.clone());
            operationSuccess = propertyCategoryList.add(newPropertyCategory.get());
        }

        if (!operationSuccess) {
            newPropertyCategory = Optional.empty();
        }

        return newPropertyCategory;
    }

    private boolean validatePropertyCategory(PropertyCategory propertyCategory) {
        return !propertyCategoryList.contains(propertyCategory);
    }

    public List<PropertyCategory> getPropertyCategoryList() {
        return List.copyOf(propertyCategoryList);
    }
}

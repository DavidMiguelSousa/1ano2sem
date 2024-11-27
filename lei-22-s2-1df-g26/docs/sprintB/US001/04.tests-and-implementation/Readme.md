# US 001 - As an unregistered user, I want to display listed properties. 

# 4. Tests 

**Test 1:** Ensure that sun exposure is defined in a house - AC4.

	@Test(expected = IllegalArgumentException.class)
		public void ensureNullSunExposureIsNotAllowedAC3() {
		House instance = new House(area, distanceFromCityCentre, numberOfBedrooms, numberOfBathrooms, numberOfParkingSpaces, hasCentralHeating, hasAirConditioning, hasBasement, hasInhabitableLoft, null);
	}
	

**Test 2:** Ensure that contract duration is defined in a rent request - AC5.

	@Test(expected = IllegalArgumentException.class)
		public void ensureRentHasContractDurationAC4() {
        RentRequest instance = new RentRequest (monthlyPayment, null)
	}


# 5. Construction (Implementation)


## Class DisplayPropertiesUI

```java
public void DisplayProperties(List<Announcement> displaybleAnnouncementList) {
    
    for (Announcement announcement : displaybleAnnouncementList) {
        System.out.println(announcement);
    }
    
}
```


## Class DisplayPropertiesController 

```java
public List<Announcement> getDisplaybleAnnouncementList() {
    
    List<Announcement> displaybleAnnouncementList = new ArrayList<>();
    List<Announcement> defaultSortedAnnouncementList = AnnouncementHandling.getDefaultSortedAnnouncementList();
    
    switch (DisplayPropertiesUI.getFilterOption()) {
    
        case 1: 
            announcementCategoryDescription = DisplayPropertiesUI.getAnnouncementCategoryDescription();
            propertyCategoryDescription = DisplayPropertiesUI.getPropertyCategoryDescription();
            announcementCategory = getAnnouncementCategoryByDescription(announcementCategoryDescription);
            propertyCategory = getPropertyCategoryByDescription(propertyCategoryDescription);
            if (propertyCategoryDescription.equals("House") || propertyCategoryDescription.equals("Apartment")) {
                numberOfRooms = DisplayPropertiesUI.getNumberOfRooms();    
            }       
            displaybleAnnouncementList() = AnnouncementHandling.getFilteredAnnouncementList(defaultSortedAnnouncementList, announcementCategory, propertyCategory, numberOfRooms);
            break;
            
        case 2:
            displaybleAnnouncementList() = defaultSortedAnnouncementList();
            break;
            
        default:
            break;
    }
    
    return displaybleAnnouncementList;
    
}
```


## Class AnnouncementHandling

```java
public List<Announcement> getDefaultSortedAnnouncementList(List<Announcement> announcementsList) {

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
```
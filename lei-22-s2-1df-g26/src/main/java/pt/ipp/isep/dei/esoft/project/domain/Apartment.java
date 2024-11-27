package pt.ipp.isep.dei.esoft.project.domain;

public class Apartment extends Land {

    private int numberOfBedrooms;
    private int numberOfBathrooms;
    private int numberOfParkingSpaces;
    private AvailableEquipment availableEquipment;

    public Apartment(String photographsURI, double area, double distanceFromCityCentre, int numberOfBedrooms, int numberOfBathrooms,
                     int numberOfParkingSpaces, boolean hasCentralHeating, boolean hasAirConditioning) {
        super(photographsURI, area, distanceFromCityCentre);
        availableEquipment = new AvailableEquipment(hasCentralHeating, hasAirConditioning);
        setNumberOfBedrooms(numberOfBedrooms);
        setNumberOfBathrooms(numberOfBathrooms);
        setNumberOfParkingSpaces(numberOfParkingSpaces);
    }

    public int getNumberOfBedrooms() {
        return numberOfBedrooms;
    }

    public void setNumberOfBedrooms(int numberOfBedrooms) {
        this.numberOfBedrooms = numberOfBedrooms;
    }

    public int getNumberOfBathrooms() {
        return numberOfBathrooms;
    }

    public void setNumberOfBathrooms(int numberOfBathrooms) {
        this.numberOfBathrooms = numberOfBathrooms;
    }

    public int getNumberOfParkingSpaces() {
        return numberOfParkingSpaces;
    }

    public void setNumberOfParkingSpaces(int numberOfParkingSpaces) {
        this.numberOfParkingSpaces = numberOfParkingSpaces;
    }


}

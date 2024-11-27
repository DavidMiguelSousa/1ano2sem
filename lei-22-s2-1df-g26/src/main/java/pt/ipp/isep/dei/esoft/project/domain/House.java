package pt.ipp.isep.dei.esoft.project.domain;

public class House extends Apartment {

    private boolean hasBasement;

    private boolean hasInhabitableLoft;

    private String sunExposure;

    public House(String photographsURI, double area, double distanceFromCityCentre, int numberOfBedrooms, int numberOfBathrooms, int numberOfParkingSpaces,
                 boolean hasCentralHeating, boolean hasAirConditioning, boolean hasBasement, boolean hasInhabitableLoft, String sunExposure) {
        super(photographsURI, area, distanceFromCityCentre, numberOfBedrooms, numberOfBathrooms, numberOfParkingSpaces, hasCentralHeating, hasAirConditioning);
        setHasBasement(hasBasement);
        setHasInhabitableLoft(hasInhabitableLoft);
        setSunExposure(sunExposure);
    }

    public boolean isHasBasement() {
        return hasBasement;
    }

    public void setHasBasement(boolean hasBasement) {
        this.hasBasement = hasBasement;
    }

    public boolean isHasInhabitableLoft() {
        return hasInhabitableLoft;
    }

    public void setHasInhabitableLoft(boolean hasInhabitableLoft) {
        this.hasInhabitableLoft = hasInhabitableLoft;
    }

    public String getSunExposure() {
        return sunExposure;
    }

    public void setSunExposure(String sunExposure) {
        this.sunExposure = sunExposure;
    }


}

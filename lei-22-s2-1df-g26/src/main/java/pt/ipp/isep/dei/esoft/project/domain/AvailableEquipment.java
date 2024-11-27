package pt.ipp.isep.dei.esoft.project.domain;

public class AvailableEquipment{

    private boolean hasCentralHeating;
    private boolean hasAirConditioning;


    public AvailableEquipment(boolean hasCentralHeating, boolean hasAirConditioning) {
        setHasCentralHeating(hasCentralHeating);
        setHasAirConditioning(hasAirConditioning);
    }

    public boolean isHasCentralHeating() {
        return hasCentralHeating;
    }

    public void setHasCentralHeating(boolean hasCentralHeating) {
        this.hasCentralHeating = hasCentralHeating;
    }

    public boolean isHasAirConditioning() {
        return hasAirConditioning;
    }

    public void setHasAirConditioning(boolean hasAirConditioning) {
        this.hasAirConditioning = hasAirConditioning;
    }
}

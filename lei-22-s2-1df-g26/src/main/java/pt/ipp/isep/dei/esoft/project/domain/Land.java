package pt.ipp.isep.dei.esoft.project.domain;

public class Land {



    private String photographsURI;
    private double area;
    private double distanceFromCityCentre;

    // private List<Photographs> photographies;

    public Land(String photographsURI, double area, double distanceFromCityCentre) {
        setPhotographsURI(photographsURI);
        setArea(area);
        setDistanceFromCityCentre(distanceFromCityCentre);


    }

    public String getPhotographsURI() {
        return photographsURI;
    }

    public void setPhotographsURI(String photographsURI) {
        if (photographsURI == null){
            throw new IllegalArgumentException("This field must be filled.");

        }
        this.photographsURI = photographsURI;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        if (area < 0) {
            throw new IllegalArgumentException("This field must be filled.");
        }
        this.area = area;
    }

    public double getDistanceFromCityCentre() {
        return distanceFromCityCentre;
    }

    public void setDistanceFromCityCentre(double distanceFromCityCentre) {
        if (distanceFromCityCentre < 0) {
            throw new IllegalArgumentException("This field must be filled.");
        }
        this.distanceFromCityCentre = distanceFromCityCentre;
    }
}

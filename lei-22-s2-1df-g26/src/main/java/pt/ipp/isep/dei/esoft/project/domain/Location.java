package pt.ipp.isep.dei.esoft.project.domain;

public class Location {
    private String state;
    private String city;
    private String district;
    private String street;
    private String zipCode;

    public Location(String state, String city, String district, String street, String zipCode) {
        setStateAbbreviation(state);
        setCity(city);
        setDistrict(district);
        setStreet(street);
        setZipCode(zipCode);

    }


    @Override
    public String toString() {
        String districtString = district == null ? "" : "District: " + district + "\n";
        return String.format("\nStreet: %s\nCity: %s\n%sState: %s\nZip-Code: %s\n", street, city, districtString, state, zipCode);
    }


    public String getStateAbbreviation() {
        return state;
    }

    public void setStateAbbreviation(String stateAbbreviation) {
        this.state = stateAbbreviation;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

}




package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Agency;
import pt.ipp.isep.dei.esoft.project.domain.Location;
import pt.ipp.isep.dei.esoft.project.repository.AgencyRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.util.List;

public class CreateAgencyController {
    private AgencyRepository agencyRepository = null;
    private CityRepository cityRepository = null;
    private StateRepository stateRepository = null;
    private DistrictRepository districtRepository = null;

    public CreateAgencyController() {
        getAgencyRepository();
        getCityRepository();
        getStateRepository();
        getDistrictRepository();
    }

    public CreateAgencyController(AgencyRepository agencyRepository) {
        this.agencyRepository = agencyRepository;
    }

    private AgencyRepository getAgencyRepository() {
        if (agencyRepository == null) {
            Repositories repositories = Repositories.getInstance();
            agencyRepository = repositories.getAgencyRepository();
        }
        return agencyRepository;
    }
    private CityRepository getCityRepository() {
        if (cityRepository == null) {
            Repositories repositories = Repositories.getInstance();
            cityRepository = repositories.getCityRepository();
        }
        return cityRepository;
    }
    private StateRepository getStateRepository() {
        if (stateRepository == null) {
            Repositories repositories = Repositories.getInstance();
            stateRepository = repositories.getStateRepository();
        }
        return stateRepository;
    }
    private DistrictRepository getDistrictRepository() {
        if (districtRepository == null) {
            Repositories repositories = Repositories.getInstance();
            districtRepository = repositories.getDistrictRepository();
        }
        return districtRepository;
    }

    public List<Agency> getAgencies() {
        return agencyRepository.getAgencies();
    }
    public List<States> getStates() {
        return stateRepository.getStates();
    }
    public List<City> getCities() {
        return cityRepository.getCities();
    }
    public List<District> getDistricts() {
        return districtRepository.getDistricts();
    }

    public Boolean createAgency(Location location,String id, String designation, String phone, String email){
        return agencyRepository.createAgency(id,designation,email,phone,location);
    }
    public Location createLocation(State state, City city, String street, String zipCode){
        Location location = new Location(state, city, district, street,zipCode);
        return location;
    }
}

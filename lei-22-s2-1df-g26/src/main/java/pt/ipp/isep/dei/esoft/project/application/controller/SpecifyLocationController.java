package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Agency;
import pt.ipp.isep.dei.esoft.project.domain.Location;
import pt.ipp.isep.dei.esoft.project.repository.AgencyRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.ui.console.SpecifyLocationUI;

import java.util.ArrayList;
import java.util.List;

public class SpecifyLocationController {

    private AgencyRepository agencyRepository;

    private SpecifyLocationUI specifyLocationUI;

    public String stateAbbreviation;

    public SpecifyLocationController() {
        agencyRepository = getAgencyRepository();
        specifyLocationUI = getSpecifyLocationUI();
        stateAbbreviation = specifyLocationUI.getStateAbbreviation();
    }

    public SpecifyLocationController(AgencyRepository agencyRepository, SpecifyLocationUI specifyLocationUI, String stateAbbreviation) {
        this.agencyRepository = agencyRepository;
        this.specifyLocationUI = specifyLocationUI;
        this.stateAbbreviation = stateAbbreviation;
    }

    public AgencyRepository getAgencyRepository() {
        if(agencyRepository == null){
            Repositories repositories = Repositories.getInstance();
            agencyRepository = repositories.getAgencyRepository();
        }

        return agencyRepository;
    }

    public SpecifyLocationUI getSpecifyLocationUI() {
        if(specifyLocationUI == null){
            specifyLocationUI = new SpecifyLocationUI();
        }

        return specifyLocationUI;
    }

    public String getStateAbbreviation() {
        if(specifyLocationUI.getStateAbbreviation() == null){
            SpecifyLocationUI specifyLocation = getSpecifyLocationUI();
            specifyLocation.requestStateAbbreviation();
            stateAbbreviation = specifyLocation.getStateAbbreviation();
        }

        return stateAbbreviation;
    }

    public boolean checkStoresLocation(String stateAbbreviation) {
        List<Agency> agencies = agencyRepository.getAgencies();

        boolean storesLocationExists = false;

        if (stateAbbreviation != null) {
            for (Agency agency : agencies) {
                String agencyStateAbbreviation = (agency.getAddress()).getStateAbbreviation(); //(Agency.getAddress()).getStateAbbreviation();
                if (stateAbbreviation.equals(agencyStateAbbreviation)) {
                    storesLocationExists = true;
                    break;
                }
            }
        }
        return storesLocationExists;
    }

    public List<Location> findStoresLocation(String stateAbbreviation) {
        List<Agency> agencies = agencyRepository.getAgencies();
        List<Location> storesLocations = new ArrayList<>();

        if (stateAbbreviation != null) {
            for (Agency agency : agencies) {
                String state = (agency.getAddress()).getStateAbbreviation();
                if (stateAbbreviation.equals(state)) {
                    storesLocations.add(agency.getAddress());
                }
            }
        }

        return storesLocations;
    }
}

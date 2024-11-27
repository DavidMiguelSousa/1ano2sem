package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Agent;
import pt.ipp.isep.dei.esoft.project.domain.Agency;
import pt.ipp.isep.dei.esoft.project.domain.Location;
import pt.ipp.isep.dei.esoft.project.domain.PropertyCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AgencyRepository {

    private List<Agency> agencies = new ArrayList<>();

    private List<Agent> agents = new ArrayList<>();

    public List<Agency> getAgencies() {
        return List.copyOf(agencies);
    }

    public List<Agent> getAgents() {
        return List.copyOf(agents);
    }

    public Optional<Agency> getAgencyByAgent(Agent agent) {

        Optional<Agency> returnAgency = Optional.empty();

        for (Agency agency : agencies) {
            if (agency.employs(agent)) {
                returnAgency = Optional.of(agency);
            }
        }

        return returnAgency;
    }




    public Agency getAgencyById(String agencyId) {

        Agency newAgency = new Agency(agencyId);
        Agency agency = null;

        if (agencies.contains(newAgency)) {
            agency = agencies.get(agencies.indexOf(newAgency));
        }
        if (agency == null) {
            throw new IllegalArgumentException("Agency requested for [ " + agencyId + "] doesn't exist.");

        }

        return agency;
    }


    public Optional<Agency> add(Agency agency) {

        Optional<Agency> newAgency = Optional.empty();
        boolean operationSuccess = false;

        if (validateAgency(agency)) {
            newAgency = Optional.of(agency.clone());
            operationSuccess = agencies.add(newAgency.get());
        }

        if (!operationSuccess) {
            newAgency = Optional.empty();
        }

        return newAgency;

    }

    public boolean createAgency(String id, String designation, String phone, String email, Location location){
        Agency agency = new Agency(id, designation, email,phone, location);
        if(validateAgency(agency)){
            add(agency);
            return true;
        }
        return false;
    }

    private boolean validateAgency(Agency agency) {
        boolean isValid = !agencies.contains(agency);

        return isValid;
    }
}


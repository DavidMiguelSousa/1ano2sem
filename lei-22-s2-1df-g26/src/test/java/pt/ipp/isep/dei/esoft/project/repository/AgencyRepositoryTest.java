package pt.ipp.isep.dei.esoft.project.repository;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.Agency;
import pt.ipp.isep.dei.esoft.project.domain.Agent;
import pt.ipp.isep.dei.esoft.project.domain.Location;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AgencyRepositoryTest {

    @Test
    void testadd() {
        AgencyRepository agencyRepository = new AgencyRepository();
        Agency agency = new Agency("123456789", "123456789", "ola@hotmail.com","919700111", new Location("Portugal", "Porto", "Porto", "4000-007"));
        agencyRepository.add(agency);
        assertTrue(agencyRepository.getAgencies().contains(agency));
    }

    @Test
    void createAgency() {
        AgencyRepository agencyRepository = new AgencyRepository();
        agencyRepository.createAgency("123456789", "123456789", "ola@hotmail.com","919700111", new Location("Portugal", "Porto", "Porto", "4000-007"));

        assertTrue(agencyRepository.getAgencies().contains(agencyRepository.getAgencies().get(0)));
    }

    @Test
    void getAgencies() {
        AgencyRepository agencyRepository = new AgencyRepository();
        Agency agency = new Agency("123456789", "123456789", "ola@hotmail.com","919700111", new Location("Portugal", "Porto", "Porto", "4000-007"));
        List<Agency> agenciesReal = agencyRepository.getAgencies();

        assertEquals(1, agenciesReal.size());
    }

    @Test
    void getAgencyByAgent() {
        AgencyRepository agencyRepository = new AgencyRepository();
        Agency agency = new Agency("123456789", "123456789", "ola@hotmail.com","919700111", new Location("Portugal", "Porto", "Porto", "4000-007"));
        Agent agent= new Agent("Ola@hotmail.com");
        agency.addAgent(agent);
        agencyRepository.add(agency);
        assertEquals(agency, agencyRepository.getAgencyByAgent(agent));
    }

    @Test
    void getAgencyById() {
        AgencyRepository agencyRepository = new AgencyRepository();
        Agency agency = new Agency("123456789", "123456789", "ola@hotmail.com","919700111", new Location("Portugal", "Porto", "Porto", "4000-007"));
        agencyRepository.add(agency);
        assertEquals(agency, agencyRepository.getAgencyById("123456789"));
    }
}
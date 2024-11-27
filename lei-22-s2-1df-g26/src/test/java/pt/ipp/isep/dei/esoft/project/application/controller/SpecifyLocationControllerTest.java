package pt.ipp.isep.dei.esoft.project.application.controller;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.Agency;
import pt.ipp.isep.dei.esoft.project.domain.Location;
import pt.ipp.isep.dei.esoft.project.repository.AgencyRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SpecifyLocationControllerTest {

    @Test
        //verify that getAgencyRepository() NEVER returns null with no data
    void ensureGetAgencyRepositoryWorks() {
        SpecifyLocationController test = new SpecifyLocationController();
        assertNotNull(test.getAgencyRepository());
    }

    @Test
        //verify that getSpecifyLocationUI() NEVER returns null with no data
    void ensureGetSpecifyLocationUIWorks() {
        SpecifyLocationController test = new SpecifyLocationController();
        assertNotNull(test.getSpecifyLocationUI());
    }

    @Test
        //verify that getStateAbbreviation() NEVER returns null with no data
    void ensureGetStateAbbreviationWorks() {
        SpecifyLocationController test = new SpecifyLocationController();
        assertNotNull(test.getStateAbbreviation());
    }

    @Test
    void ensureCheckStoresLocationWorksWithExistingLocation() {

        //Arrange
        //Get repository
        AgencyRepository agencyRepository = new AgencyRepository();

        //Get UI
        SpecifyLocationController controller = new SpecifyLocationController();

        //Fill agencyRepository
        Location adressAgencyTest = new Location("AK","NORTH POLE","Fairbanks North Star","71 ST. NICHOLAS DRIVE","1234");
        Agency agencyTest = new Agency("idAgencyTest1234", "AgencyTest", "agencytest@email.com", "555-789", adressAgencyTest);
        agencyRepository.add(agencyTest);

        //Act
        assertTrue(controller.checkStoresLocation(agencyTest.getAddress().getStateAbbreviation()));
    }

    @Test
    void ensureCheckStoresLocationFailsWithNonExistingLocation() {

        //Arrange
        //Get repository
        AgencyRepository agencyRepository = new AgencyRepository();

        //Get Controller
        SpecifyLocationController controller = new SpecifyLocationController();

        //Fill agencyRepository
        Location adressAgencyTest = new Location("AK","NORTH POLE","Fairbanks North Star","71 ST. NICHOLAS DRIVE","1234");
        Agency agencyTest = new Agency("idAgencyTest1234", "AgencyTest", "agencytest@email.com", "555-789", adressAgencyTest);
        agencyRepository.add(agencyTest);

        //Act
        assertFalse(controller.checkStoresLocation("NY"));
    }

    @Test
    void ensureFindStoresLocationWorksWithExistingLocation() {

        //Arrange
        //Get Repository
        AgencyRepository agencyRepository = new AgencyRepository();

        //Get Controller
        SpecifyLocationController controller = new SpecifyLocationController();

        //Fill agencyRepository
        Location adressAgencyTest1 = new Location("AK","NORTH POLE","districtTest1","streetTest1","1234");
        Agency agencyTest1 = new Agency("idAgencyTest1234", "AgencyTest1", "agencytest1@email.com", "555-789", adressAgencyTest1);
        agencyRepository.add(agencyTest1);

        Location adressAgencyTest2 = new Location("AK","NORTH POLE","districtTest2","streetTest2","2341");
        Agency agencyTest2 = new Agency("idAgencyTest2341", "AgencyTest2", "agencytest2@email.com", "555-897", adressAgencyTest2);
        agencyRepository.add(agencyTest2);

        //Fill expectedList
        List<Location> expectedList = new ArrayList<>();

        expectedList.add(adressAgencyTest1);
        expectedList.add(adressAgencyTest2);

        //Act
        assertEquals(expectedList, controller.findStoresLocation("AK"));

    }

    @Test
    void ensureFindStoresLocationFailsWithNonExistingLocation() {

        //Arrange
        //Get Repository
        AgencyRepository agencyRepository = new AgencyRepository();

        //Get Controller
        SpecifyLocationController controller = new SpecifyLocationController();

        //Fill agencyRepository
        Location adressAgencyTest1 = new Location("AK","NORTH POLE","districtTest1","streetTest1","1234");
        Agency agencyTest1 = new Agency("idAgencyTest1234", "AgencyTest1", "agencytest1@email.com", "555-789", adressAgencyTest1);
        agencyRepository.add(agencyTest1);

        Location adressAgencyTest3 = new Location("stateAbbreviation", "NORTH POLE","Fairbanks North Star","71 ST. NICHOLAS DRIVE","1234");
        Agency agencyTest3 = new Agency("idAgencyTest3412", "AgencyTest3", "agencytest3@email.com", "555-978", adressAgencyTest3);
        agencyRepository.add(agencyTest3);

        //Fill expectedList
        List<Location> expectedList = new ArrayList<>();

        expectedList.add(adressAgencyTest1);

        //Act
        assertEquals(expectedList, controller.findStoresLocation("AK"));

    }
}
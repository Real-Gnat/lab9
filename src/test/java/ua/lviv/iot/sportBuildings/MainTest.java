package ua.lviv.iot.sportBuildings;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class MainTest {

    @Test
    public void testCreateSportBuildingsList() {
        assertNotNull(Main.createSportBuildingsList());
    }
}

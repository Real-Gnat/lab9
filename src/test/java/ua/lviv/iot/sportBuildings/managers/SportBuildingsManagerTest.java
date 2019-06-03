package ua.lviv.iot.sportBuildings.managers;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ua.lviv.iot.sportBuildings.models.AquaticsHall;
import ua.lviv.iot.sportBuildings.models.AthleticsPlayground;
import ua.lviv.iot.sportBuildings.models.ChessHall;
import ua.lviv.iot.sportBuildings.models.FootballField;
import ua.lviv.iot.sportBuildings.models.ShootingPlayground;
import ua.lviv.iot.sportBuildings.models.SportBuilding;
import ua.lviv.iot.sportBuildings.models.SportKind;
import ua.lviv.iot.sportBuildings.models.SportSeason;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SportBuildingsManagerTest {

    private List<SportBuilding> sportBuildings = new ArrayList<>();
    private SportBuildingsManager manager;

    // init all objects to improve performance
    private AquaticsHall aquaticsHall = new AquaticsHall("Aqua Hall", "Red st 117", 1994,
            SportSeason.ALL_SEASONS, 600, SportKind.AQUATICS, 8,
            20);
    private AthleticsPlayground athleticsPlayground = new AthleticsPlayground("Athletics playground",
            "Baker st 88", 2003, SportSeason.SUMMER, 800, SportKind.ATHLETICS,
            3000, 10);
    private ChessHall chessHall = new ChessHall("Chess Hall", "Silent st 204", 1990,
            SportSeason.ALL_SEASONS, 90, SportKind.CHESS, 10);
    private FootballField footballField = new FootballField("Football field", "Liberty st 39",
            1968, SportSeason.SUMMER, 1100, SportKind.FOOTBALL, 30, 70);
    private ShootingPlayground shootingPlayground = new ShootingPlayground("Winter Archery",
            "Silver st 42", 1999, SportSeason.WINTER, 500, SportKind.ARCHERY,
            30, 15, 250);

    // variables for tests
    private int sportBuildingsSize;

    @Before
    public void setUp() {
        sportBuildings.add(aquaticsHall);
        sportBuildings.add(athleticsPlayground);
        sportBuildings.add(chessHall);
        sportBuildings.add(footballField);
        sportBuildings.add(shootingPlayground);

        sportBuildingsSize = sportBuildings.size();
        manager = new SportBuildingsManager(sportBuildings);
    }

    @After
    public void clean() {
        sportBuildings.clear();
    }

    @Test
    public void testFindByViewersNumber() {
        final int minViewersNumber = 100;
        final int maxViewersNumber = 1000;
        List<SportBuilding> selectedBuildings = manager.findByViewersNumber(minViewersNumber, maxViewersNumber);
        for (SportBuilding selectedBuilding : selectedBuildings) {
            assertTrue("findByViewersNumber() doesn't work properly",
                    selectedBuilding.getViewersNumber() > minViewersNumber
                            && selectedBuilding.getViewersNumber() < maxViewersNumber);
        }
    }

    @Test
    public void testSortBySportKind() {
        manager.sortBySportKind(sportBuildings);
        for (int i = 1; i < sportBuildingsSize; i++) {
            assertTrue("sortBySportKind() doesn't work properly",
                    sportBuildings.get(i).getSportKind().ordinal() >=
                            sportBuildings.get(i - 1).getSportKind().ordinal());
        }
    }

    @Test
    public void testSortBySportSeason() {
        manager.sortBySportSeason(sportBuildings);
        for (int i = 1; i < sportBuildingsSize; i++) {
            assertTrue("sortBySportSeason() doesn't work properly",
                    sportBuildings.get(i).getSportSeason().ordinal() >=
                            sportBuildings.get(i - 1).getSportSeason().ordinal());
        }
    }

    @Test
    public void testSetterAndGetterOfSportBuildingsManager() {
        manager.setSportBuildings(sportBuildings);
        assertEquals("setter and getter don't work properly",
                sportBuildings, manager.getSportBuildings());
    }
}

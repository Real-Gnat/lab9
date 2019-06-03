package ua.lviv.iot.sportBuildings;

import ua.lviv.iot.sportBuildings.managers.SportBuildingsManager;
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

public class Main {

    public static void oldMain() {
        System.out.println("\tSport Buildings\n");

        // calling manager to manipulate the data
        SportBuildingsManager manager = new SportBuildingsManager(createSportBuildingsList());

        // search buildings with chosen viewerNumber according to the task
        List<SportBuilding> selectedBuildings = manager.findByViewersNumber(100, 1000);

        // sorting list according to the task
        manager.sortBySportKind(selectedBuildings);

        // print sorted chosen list to console
        manager.printSportBuildingsInfo(selectedBuildings);
    }

    /**
     * method to init the ArrayList
     */
    static List<SportBuilding> createSportBuildingsList() {
        List<SportBuilding> sportBuildings = new ArrayList<>();

        sportBuildings.add(new AquaticsHall("Aqua Hall", "Red st 117", 1994,
                SportSeason.ALL_SEASONS, 600, SportKind.AQUATICS, 8,
                20));
        sportBuildings.add(new AthleticsPlayground("Athletics playground", "Baker st 88",
                2003, SportSeason.SUMMER, 800, SportKind.ATHLETICS, 3000,
                10));
        sportBuildings.add(new ChessHall("Chess Hall", "Silent st 204", 1990,
                SportSeason.ALL_SEASONS, 90, SportKind.CHESS, 10));
        sportBuildings.add(new FootballField("Football field", "Liberty st 39", 1968,
                SportSeason.SUMMER, 1100, SportKind.FOOTBALL, 30, 70));
        sportBuildings.add(new ShootingPlayground("Winter Archery", "Silver st 42", 1999,
                SportSeason.WINTER, 500, SportKind.ARCHERY, 30, 15,
                250));

        return sportBuildings;
    }
}

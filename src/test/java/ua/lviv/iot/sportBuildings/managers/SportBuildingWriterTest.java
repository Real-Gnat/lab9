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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class SportBuildingWriterTest {

    private List<SportBuilding> sportBuildings = new ArrayList<>();
    private SportBuildingWriter sportBuildingWriter;
    private String filePath = "csvFile";

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

    @Before
    public void setUp() {
        sportBuildings.add(aquaticsHall);
        sportBuildings.add(athleticsPlayground);
        sportBuildings.add(chessHall);
        sportBuildings.add(footballField);
        sportBuildings.add(shootingPlayground);

        sportBuildingWriter = new SportBuildingWriter(filePath);
    }

    @After
    public void clean() {
        sportBuildings.clear();
    }

    @Test
    public void testWriteToFile() {
        File csvFile = new File(filePath);
        sportBuildingWriter.writeToFile(sportBuildings);

        try (FileInputStream fis = new FileInputStream(csvFile);
             InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(isr)
        ) {
            for (SportBuilding sportBuilding : sportBuildings) {

                assertEquals("Headers weren't written",
                        sportBuilding.getHeaders(), reader.readLine());

                assertEquals("toCSV() values weren't written",
                        sportBuilding.toCSV(), reader.readLine());
            }
            assertNull("Besides needed values, csv file has some mess!", reader.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Reading the file ended");
        }
    }

    @Test
    public void testGetterAndSetterFilePath() {
        sportBuildingWriter.setFilePath(filePath);
        assertEquals("SportBuildingWriter Getter/Setter test failed",
                filePath, sportBuildingWriter.getFilePath());
    }
}

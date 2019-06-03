package ua.lviv.iot.sportBuildings.managers;

import ua.lviv.iot.sportBuildings.models.SportBuilding;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class SportBuildingWriter {

    private String filePath;

    SportBuildingWriter() {
    }

    SportBuildingWriter(String filePath) {
        this.filePath = filePath;
    }

    public void writeToFile(List<SportBuilding> sportBuildings) {
        File csvFile = new File(filePath + ".csv");

        try (FileOutputStream fos = new FileOutputStream(csvFile);
             OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
             BufferedWriter writer = new BufferedWriter(osw)
        ) {
            for (SportBuilding sportBuilding : sportBuildings) {
                writer.write(sportBuilding.getHeaders());
                writer.newLine();
                writer.write(sportBuilding.toCSV());
                writer.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Writing to the file ended");
        }
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}

package ua.lviv.iot.sportBuildings.managers;

import ua.lviv.iot.sportBuildings.models.SportBuilding;

import java.util.List;

public interface ISportBuildingsManager {

    List<SportBuilding> findByViewersNumber(int min, int max);

    void sortBySportKind(List<SportBuilding> sportBuildings);

    void sortBySportSeason(List<SportBuilding> sportBuildings);

    void printSportBuildingsInfo(List<SportBuilding> sportBuildings);
}

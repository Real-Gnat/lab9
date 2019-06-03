package ua.lviv.iot.sportBuildings.managers;

import ua.lviv.iot.sportBuildings.models.SportBuilding;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SportBuildingsManager implements ISportBuildingsManager {

    private List<SportBuilding> sportBuildings;

    public SportBuildingsManager() {
    }

    public SportBuildingsManager(List<SportBuilding> sportBuildings) {
        this.sportBuildings = sportBuildings;
    }

    @Override
    public List<SportBuilding> findByViewersNumber(int min, int max) {
        return sportBuildings.stream()
                .filter(sportBuilding -> sportBuilding.getViewersNumber() >= min &&
                        sportBuilding.getViewersNumber() <= max)
                .collect(Collectors.toList());
    }

    @Override
    public void sortBySportKind(List<SportBuilding> sportBuildings) {
        sportBuildings.sort(Comparator.comparing(SportBuilding::getSportKind));
    }

    @Override
    public void sortBySportSeason(List<SportBuilding> sportBuildings) {
        sportBuildings.sort(Comparator.comparing(SportBuilding::getSportSeason));
    }

    @Override
    public void printSportBuildingsInfo(List<SportBuilding> sportBuildings) {
        sportBuildings.forEach(System.out::println);
    }

    public List<SportBuilding> getSportBuildings() {
        return sportBuildings;
    }

    public void setSportBuildings(List<SportBuilding> sportBuildings) {
        this.sportBuildings = sportBuildings;
    }
}

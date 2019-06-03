package ua.lviv.iot.sportBuildings.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.sportBuildings.models.AquaticsHall;
import ua.lviv.iot.sportBuildings.models.SportBuilding;
import ua.lviv.iot.sportBuildings.repositories.AquaticsHallRepository;

import java.util.LinkedList;
import java.util.List;

@RestController
public class AquaticsHallController {

    @Autowired
    private AquaticsHallRepository repository;

    @RequestMapping(value = "/sportBuildings", method = RequestMethod.GET)
    public List<SportBuilding> getAquaticsHalls() {
        List<SportBuilding> buildings = new LinkedList<>();
        repository.findAll().forEach(buildings::add);
        if (buildings.isEmpty()) {
            return null;
        }
        return buildings;
    }

    @RequestMapping(value = "/sportBuildings/{id}", method = RequestMethod.GET)
    public AquaticsHall getAquaticsHall(@PathVariable Integer id) {
        if (repository.findById(id).isPresent()) {
            return repository.findById(id).get();
        }
        return null;
    }

    @RequestMapping(value = "/sportBuildings", method = RequestMethod.POST)
    public AquaticsHall addAquaticsHall(@RequestBody AquaticsHall newBuilding) {
        return repository.save(newBuilding);
    }

    @RequestMapping(value = "/sportBuildings/{id}", method = RequestMethod.PUT)
    public AquaticsHall replaceAquaticsHall(@PathVariable Integer id, @RequestBody AquaticsHall newBuilding) {
        return repository.findById(id)
                .map(building -> {
                    building.setName(newBuilding.getName());
                    building.setLocation(newBuilding.getLocation());
                    building.setConstructionYear(newBuilding.getConstructionYear());
                    building.setSportSeason(newBuilding.getSportSeason());
                    building.setViewersNumber(newBuilding.getViewersNumber());
                    building.setSportKind(newBuilding.getSportKind());
                    building.setPoolsNumber(newBuilding.getPoolsNumber());
                    building.setAveragePoolVolume(newBuilding.getAveragePoolVolume());
                    return repository.save(building);
                })
                .orElseGet(() -> {
                    newBuilding.setId(id);
                    return repository.save(newBuilding);
                });
    }

    @RequestMapping(value = "/sportBuildings/{id}", method = RequestMethod.DELETE)
    public void deleteAquaticsHall(@PathVariable Integer id) {
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
        }
    }
}

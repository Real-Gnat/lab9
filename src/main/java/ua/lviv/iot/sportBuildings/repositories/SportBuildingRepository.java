package ua.lviv.iot.sportBuildings.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.lviv.iot.sportBuildings.models.SportBuilding;

public interface SportBuildingRepository<T extends SportBuilding> extends CrudRepository<T, Integer> {
}

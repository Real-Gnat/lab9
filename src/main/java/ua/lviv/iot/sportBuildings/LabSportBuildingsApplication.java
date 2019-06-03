package ua.lviv.iot.sportBuildings;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ua.lviv.iot.sportBuildings.models.AquaticsHall;
import ua.lviv.iot.sportBuildings.models.SportKind;
import ua.lviv.iot.sportBuildings.models.SportSeason;
import ua.lviv.iot.sportBuildings.repositories.AquaticsHallRepository;

import static ua.lviv.iot.sportBuildings.Main.oldMain;

@SpringBootApplication
public class LabSportBuildingsApplication {

    public static void main(String[] args) {
        SpringApplication.run(LabSportBuildingsApplication.class, args);
        oldMain();
    }

    @Bean
    public CommandLineRunner aquaticsHallCLR(AquaticsHallRepository repository) {
        AquaticsHall aquaticsHall = new AquaticsHall("Aqua Hall", "Red st 117", 1994,
                SportSeason.ALL_SEASONS, 600, SportKind.AQUATICS, 8,
                20);

        return (args) -> {
            repository.save(aquaticsHall);
            repository.findAll().forEach(obj -> System.out.println(obj));
        };
    }
}

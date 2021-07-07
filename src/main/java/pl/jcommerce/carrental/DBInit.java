package pl.jcommerce.carrental;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.jcommerce.carrental.car.CarRepository;
import pl.jcommerce.carrental.car.entity.Body;
import pl.jcommerce.carrental.car.entity.Car;
import pl.jcommerce.carrental.car.entity.Color;
import pl.jcommerce.carrental.car.entity.Fuel;

@Component
public class DBInit {

    private CarRepository carRepository;

    public DBInit(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void runExample() {
        carRepository.save(new Car("Fiat", "Punto", 2014, Body.HATCHBACK, Fuel.PETROL,
                Color.RED, 5, 3, false, true));
        carRepository.save(new Car("Fiat", "Punto", 2017, Body.HATCHBACK, Fuel.PETROL,
                Color.SILVER, 5, 5, false, true));
        carRepository.save(new Car("Ford", "Pocus", 2017, Body.KOMBI, Fuel.DIESEL,
                Color.SILVER, 5, 5, true, true));
        carRepository.save(new Car("Fiat", "Stilo", 2019, Body.SEDAN, Fuel.DIESEL,
                Color.SILVER, 5, 5, false, true));
        carRepository.save(new Car("Fiat", "Stilo", 2020, Body.KOMBI, Fuel.PETROL,
                Color.WHITE, 5, 5, false, true));
    }
}

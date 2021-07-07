package pl.jcommerce.carrental.car;

import org.springframework.web.bind.annotation.*;
import pl.jcommerce.carrental.car.entity.Car;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    private final CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @GetMapping("/{carId}")
    public Car getCarById(@PathVariable Long carId) {
        return carRepository.findById(carId).orElseThrow();
    }

    @PostMapping
    public Car addCar(@RequestBody Car car) {
        return carRepository.save(car);
    }

    @PutMapping("/{carId}")
    public Car updateCar(@PathVariable Long carId, @RequestBody Car car) {
        car.setId(carId);
        return carRepository.save(car);
    }

    @DeleteMapping("/{carId}")
    public void deleteCarById(@PathVariable Long carId) {
        carRepository.deleteById(carId);
    }

}

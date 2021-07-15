package pl.jcommerce.carrental.car;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.jcommerce.carrental.car.dto.CarWithoutReservationDTO;
import pl.jcommerce.carrental.car.entity.Car;
import pl.jcommerce.carrental.reservation.entity.Reservation;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    private final CarManager carManager;

    public CarController(CarManager carManager) {
        this.carManager = carManager;
    }

    @GetMapping
    public ResponseEntity<List<CarWithoutReservationDTO>> getAllCars() {
        return carManager.getAllCars();
    }

    @GetMapping("/{carId}")
    public ResponseEntity<CarWithoutReservationDTO> getCarById(@PathVariable Long carId) {
        return carManager.getCarById(carId);
    }

    @PostMapping
    public ResponseEntity<Car> addCar(@RequestBody Car car) {
        return carManager.addCar(car);
    }

    @PutMapping("/{carId}")
    public Car updateCar(@PathVariable Long carId, @RequestBody Car car) {
        return carManager.updateCar(carId, car);
    }

    @DeleteMapping
    public ResponseEntity<Car> deleteAllCars(){
        return carManager.deleteAllCars();
    }

    @DeleteMapping("/{carId}")
    public ResponseEntity<Car> deleteCarById(@PathVariable Long carId) {
        return carManager.deleteCarById(carId);
    }

    @GetMapping("/search")
    public ResponseEntity<List<CarWithoutReservationDTO>> getAllAcceptedCarsForTheGivenDate(@RequestBody Reservation expectedReservation){
        return carManager.getAllAcceptedCarsForTheGivenDate(expectedReservation);
    }
}

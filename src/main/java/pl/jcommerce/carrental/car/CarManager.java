package pl.jcommerce.carrental.car;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.jcommerce.carrental.car.entity.Car;
import pl.jcommerce.carrental.reservation.entity.Reservation;

import java.util.List;

@Service
public class CarManager {

    private final CarRepository carRepository;

    public CarManager(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public ResponseEntity<List<Car>> getAllCars() {
        return new ResponseEntity<>(carRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Car> getCarById(Long carId) {
        if (carRepository.findById(carId).isPresent()) {
            return new ResponseEntity<>(carRepository.findById(carId).get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    public ResponseEntity<Car> addCar(Car car) {
        return new ResponseEntity<>(carRepository.save(car), HttpStatus.CREATED);
    }


    public Car updateCar(Long carId, Car car) {
        car.setId(carId);
        return carRepository.save(car);
    }


    public ResponseEntity<Car> deleteCarById(Long carId) {
        carRepository.deleteById(carId);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    public ResponseEntity<List<Car>> getAllAcceptedCarsForTheGivenDate(Reservation expectedReservation) {
        return new ResponseEntity<>(carRepository.getAllAcceptedCarsForTheGivenDate(
                expectedReservation.getCar().getBrand(),
                expectedReservation.getCar().getModel(),
                expectedReservation.getCar().getBody(),
                expectedReservation.getStartDate(),
                expectedReservation.getEndDate()),
                HttpStatus.ACCEPTED);
    }
}

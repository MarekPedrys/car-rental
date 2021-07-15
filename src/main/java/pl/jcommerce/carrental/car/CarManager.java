package pl.jcommerce.carrental.car;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.jcommerce.carrental.car.dto.CarMapper;
import pl.jcommerce.carrental.car.dto.CarWithoutReservationDTO;
import pl.jcommerce.carrental.car.entity.Car;
import pl.jcommerce.carrental.reservation.ReservationRepository;
import pl.jcommerce.carrental.reservation.entity.Reservation;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarManager {

    private final CarRepository carRepository;
    private final CarMapper carMapper;
    private final ReservationRepository reservationRepository;

    public CarManager(CarRepository carRepository, CarMapper carMapper, ReservationRepository reservationRepository) {
        this.carRepository = carRepository;
        this.carMapper = carMapper;
        this.reservationRepository = reservationRepository;
    }

    public ResponseEntity<List<CarWithoutReservationDTO>> getAllCars() {
        List<CarWithoutReservationDTO> carWithoutReservationDTOS = carRepository.findAll()
                .stream()
                .map(carMapper::mapToCarDTO)
                .collect(Collectors.toList());

        return new ResponseEntity<>(carWithoutReservationDTOS, HttpStatus.OK);
    }

    public ResponseEntity<CarWithoutReservationDTO> getCarById(Long carId) {
        if (carRepository.findById(carId).isPresent()) {
            Car car = carRepository.findById(carId).get();
            CarWithoutReservationDTO carWithoutReservationDTO = carMapper.mapToCarDTO(car);

            return new ResponseEntity<>(carWithoutReservationDTO, HttpStatus.OK);
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
        List<Reservation> reservations = carRepository.getById(carId).getReservations();
        for (Reservation reservation : reservations) {
            reservation.setCar(null);
            reservationRepository.save(reservation);
        }
        carRepository.deleteById(carId);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    public ResponseEntity<Car> deleteAllCars() {
        List<Reservation> reservations = reservationRepository.findAll();
        for (Reservation reservation : reservations) {
            reservation.setCar(null);
            reservationRepository.save(reservation);
        }
        carRepository.deleteAll();
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    public ResponseEntity<List<CarWithoutReservationDTO>> getAllAcceptedCarsForTheGivenDate(Reservation expectedReservation) {
        List<Car> allAcceptedCarsForTheGivenDate =
                carRepository.getAllAcceptedCarsForTheGivenDate(
                expectedReservation.getCar().getBrand(),
                expectedReservation.getCar().getModel(),
                expectedReservation.getCar().getBody(),
                expectedReservation.getStartDate(),
                expectedReservation.getEndDate());

        List<CarWithoutReservationDTO> allAcceptedCarsForTheGivenDateDTOs =
                allAcceptedCarsForTheGivenDate
                .stream()
                .map(carMapper::mapToCarDTO)
                .collect(Collectors.toList());

        return new ResponseEntity<>(allAcceptedCarsForTheGivenDateDTOs, HttpStatus.ACCEPTED);
    }

}

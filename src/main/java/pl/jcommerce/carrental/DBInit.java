package pl.jcommerce.carrental;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.jcommerce.carrental.car.CarRepository;
import pl.jcommerce.carrental.car.entity.Body;
import pl.jcommerce.carrental.car.entity.Car;
import pl.jcommerce.carrental.car.entity.Color;
import pl.jcommerce.carrental.car.entity.Fuel;
import pl.jcommerce.carrental.reservation.ReservationRepository;
import pl.jcommerce.carrental.reservation.entity.Reservation;
import pl.jcommerce.carrental.user.UserRepository;
import pl.jcommerce.carrental.user.entity.User;

import java.time.LocalDate;

@Component
public class DBInit {

    private final CarRepository carRepository;
    private final UserRepository userRepository;
    private final ReservationRepository reservationRepository;


    public DBInit(CarRepository carRepository, UserRepository userRepository, ReservationRepository reservationRepository) {
        this.carRepository = carRepository;
        this.userRepository = userRepository;
        this.reservationRepository = reservationRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void runExample() {

        Car car1 = new Car("Fiat", "Punto", 2014, Body.HATCHBACK, Fuel.PETROL,
                Color.RED, 5, 3, false, true);
        Car car2 = new Car("Fiat", "Punto", 2017, Body.HATCHBACK, Fuel.PETROL,
                Color.SILVER, 5, 5, false, true);
        Car car3 = new Car("Fiat", "Stilo", 2019, Body.SEDAN, Fuel.DIESEL,
                Color.SILVER, 5, 5, false, true);
        Car car4 = new Car("Fiat", "Stilo", 2020, Body.KOMBI, Fuel.PETROL,
                Color.WHITE, 5, 5, false, true);
        Car car5 = new Car("Ford", "Focus", 2017, Body.KOMBI, Fuel.DIESEL,
                Color.SILVER, 5, 5, true, true);
        carRepository.save(car1);
        carRepository.save(car2);
        carRepository.save(car3);
        carRepository.save(car4);
        carRepository.save(car5);

        User user1 = new User("Adam Adamowski", "adam@gmail.com");
        User user2 = new User("Basia Basiowska", "basia@gmail.com");
        User user3 = new User("Celina Celinowska", "celina@gmail.com");
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        Reservation reservation1 = new Reservation(car1, user3, LocalDate.of(2021, 7, 13), LocalDate.of(2021, 7, 14), false);
        Reservation reservation2 = new Reservation(car4, user2, LocalDate.of(2021, 7, 22), LocalDate.of(2021, 7, 26), true);
        reservationRepository.save(reservation1);
        reservationRepository.save(reservation2);

    }
}

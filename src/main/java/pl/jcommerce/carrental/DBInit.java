package pl.jcommerce.carrental;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.jcommerce.carrental.car.CarRepository;
import pl.jcommerce.carrental.car.entity.Car;
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

        Car car1 = new Car("Fiat", "Punto", "Hatchback");
        Car car2 = new Car("Fiat", "Punto", "Hatchback");
        Car car3 = new Car("Fiat", "Stilo", "Kombi");
        Car car4 = new Car("Ford", "Focus", "Kombi");
        Car car5 = new Car("Ford", "Focus", "Hatchback");
        Car car6 = new Car("BMW", "X5", "SUV");
        Car car7 = new Car("Peugeot", "208", "Hatchback");
        Car car8 = new Car("Peugeot", "208", "Hatchback");

        carRepository.save(car1);
        carRepository.save(car2);
        carRepository.save(car3);
        carRepository.save(car4);
        carRepository.save(car5);
        carRepository.save(car6);
        carRepository.save(car7);
        carRepository.save(car8);

        User user1 = new User("Adam Adamowski", "adam@gmail.com");
        User user2 = new User("Basia Basiowska", "basia@gmail.com");
        User user3 = new User("Celina Celinowska", "celina@gmail.com");
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        Reservation reservation1 = new Reservation(car1, user3, LocalDate.of(2021, 7, 19), LocalDate.of(2021, 7, 21), false);
        Reservation reservation2 = new Reservation(car4, user2, LocalDate.of(2021, 7, 23), LocalDate.of(2021, 7, 26), true);
        Reservation reservation3 = new Reservation(car4, user2, LocalDate.of(2021, 7, 28), LocalDate.of(2021, 7, 29), true);
        Reservation reservation4 = new Reservation(car4, user2, LocalDate.of(2021, 7, 17), LocalDate.of(2021, 7, 22), true);
        reservationRepository.save(reservation1);
        reservationRepository.save(reservation2);
        reservationRepository.save(reservation3);
        reservationRepository.save(reservation4);

    }
}

package pl.jcommerce.carrental.reservation.dto;

import pl.jcommerce.carrental.car.dto.CarWithoutReservationDTO;
import pl.jcommerce.carrental.user.dto.UserWithoutReservationDTO;

import java.time.LocalDate;


public class ReservationDTO {
    private Long id;
    private CarWithoutReservationDTO car;
    private UserWithoutReservationDTO user;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean paid;

    public ReservationDTO(Long id, CarWithoutReservationDTO car, UserWithoutReservationDTO user, LocalDate startDate, LocalDate endDate, Boolean paid) {
        this.id = id;
        this.car = car;
        this.user = user;
        this.startDate = startDate;
        this.endDate = endDate;
        this.paid = paid;
    }

    public Long getId() {
        return id;
    }

    public CarWithoutReservationDTO getCar() {
        return car;
    }

    public UserWithoutReservationDTO getUser() {
        return user;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Boolean getPaid() {
        return paid;
    }
}

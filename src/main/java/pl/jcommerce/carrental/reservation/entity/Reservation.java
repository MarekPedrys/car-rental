package pl.jcommerce.carrental.reservation.entity;

import pl.jcommerce.carrental.car.entity.Car;
import pl.jcommerce.carrental.user.entity.User;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    private Car car;
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean paid;

    public Reservation() {
    }

    public Reservation(Car car, User user, LocalDate startDate, LocalDate endDate, Boolean paid) {
        this.car = car;
        this.user = user;
        this.startDate = startDate;
        this.endDate = endDate;
        this.paid = paid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }
}

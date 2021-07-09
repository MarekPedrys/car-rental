package pl.jcommerce.carrental.car.entity;

import javax.persistence.*;

@Entity
//@Table(name = "ourCars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    private int yearOfProduction;
    @Enumerated(EnumType.STRING)
    private Body body;
    @Enumerated(EnumType.STRING)
    private Fuel fuel;
    @Enumerated(EnumType.STRING)
    private Color color;
    private int numberOfSeats;
    private int numberOfDoors;
    private boolean automaticTransmission;
    private boolean available;

    public Car(String brand, String model, Integer yearOfProduction, Body body, Fuel fuel, Color color,
               Integer numberOfSeats, Integer numberOfDoors, Boolean automaticTransmission, boolean available) {
        this.brand = brand;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.body = body;
        this.fuel = fuel;
        this.color = color;
        this.numberOfSeats = numberOfSeats;
        this.numberOfDoors = numberOfDoors;
        this.automaticTransmission = automaticTransmission;
        this.available = available;
    }

    public Car(Long id, String brand, String model, int yearOfProduction, Body body, Fuel fuel, Color color,
               int numberOfSeats, int numberOfDoors, boolean automaticTransmission, boolean available) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.body = body;
        this.fuel = fuel;
        this.color = color;
        this.numberOfSeats = numberOfSeats;
        this.numberOfDoors = numberOfDoors;
        this.automaticTransmission = automaticTransmission;
        this.available = available;
    }

    public Car() {
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public Fuel getFuel() {
        return fuel;
    }

    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public boolean isAutomaticTransmission() {
        return automaticTransmission;
    }

    public void setAutomaticTransmission(boolean automaticTransmission) {
        this.automaticTransmission = automaticTransmission;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

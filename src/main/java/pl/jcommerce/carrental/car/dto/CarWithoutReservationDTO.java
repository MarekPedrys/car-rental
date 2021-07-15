package pl.jcommerce.carrental.car.dto;

public class CarWithoutReservationDTO {
    private Long id;
    private String brand;
    private String model;
    private String body;


    public CarWithoutReservationDTO(Long id, String brand, String model, String body) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.body = body;
    }

    public Long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getBody() {
        return body;
    }

}

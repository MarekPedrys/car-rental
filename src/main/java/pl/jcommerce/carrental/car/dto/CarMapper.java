package pl.jcommerce.carrental.car.dto;

import org.springframework.stereotype.Service;
import pl.jcommerce.carrental.car.entity.Car;

@Service
public class CarMapper {


    public CarWithoutReservationDTO mapToCarDTO(Car car) {
        return new CarWithoutReservationDTO(car.getId(), car.getBrand(), car.getModel(), car.getBody());
    }
}

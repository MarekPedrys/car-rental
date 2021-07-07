package pl.jcommerce.carrental.car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.jcommerce.carrental.car.entity.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}

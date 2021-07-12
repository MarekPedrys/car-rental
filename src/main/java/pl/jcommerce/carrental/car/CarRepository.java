package pl.jcommerce.carrental.car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.jcommerce.carrental.car.entity.Car;

import java.time.LocalDate;
import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    public List<Car> findByBrand(String brand);

    @Query(value = "SELECT * FROM car " +
            "WHERE " +
            "((:expectedBrand IS NULL OR car.brand = :expectedBrand) AND" +
            "(:expectedModel IS NULL OR car.model = :expectedModel) AND" +
            "(:expectedBody IS NULL OR car.body = :expectedBody))" +
            "MINUS " +
            "SELECT car.* FROM car LEFT JOIN reservation " +
            "ON reservation.car_id = car.id " +
            "WHERE" +
            "(reservation.start_date<:expectedEndDate AND reservation.end_date>:expectedStartDate)",
            nativeQuery = true)
    List<Car> getAllAcceptedCarsForTheGivenDate(
            @Param("expectedBrand") String brand,
            @Param("expectedModel") String model,
            @Param("expectedBody") String body,
            @Param("expectedStartDate") LocalDate startDate,
            @Param("expectedEndDate") LocalDate endDate
    );

}

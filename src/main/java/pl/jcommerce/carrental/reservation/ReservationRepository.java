package pl.jcommerce.carrental.reservation;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.jcommerce.carrental.reservation.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}

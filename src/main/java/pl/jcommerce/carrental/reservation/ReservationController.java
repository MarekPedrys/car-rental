package pl.jcommerce.carrental.reservation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.jcommerce.carrental.reservation.entity.Reservation;

import java.util.List;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {
    
    private final ReservationManager reservationManager;

    public ReservationController(ReservationManager reservationManager) {
        this.reservationManager = reservationManager;
    }

    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservations() {
        return reservationManager.getAllReservations();
    }

    @GetMapping("/{reservationId}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable Long reservationId) {
        return reservationManager.getReservationById(reservationId);
    }

    @PostMapping
    public ResponseEntity<Reservation> addReservation(@RequestBody Reservation reservation) {
        return reservationManager.addReservation(reservation);
    }

    @PutMapping("/{reservationId}")
    public Reservation updateReservation(@PathVariable Long reservationId, @RequestBody Reservation reservation) {
        return reservationManager.updateReservation(reservationId, reservation);
    }

    @DeleteMapping("/{reservationId}")
    public ResponseEntity<Reservation> deleteReservationById(@PathVariable Long reservationId) {
        return reservationManager.deleteReservationById(reservationId);
    }

}

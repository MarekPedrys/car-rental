package pl.jcommerce.carrental.reservation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.jcommerce.carrental.reservation.entity.Reservation;

import java.util.List;

@Service
public class ReservationManager {
    
    private final ReservationRepository reservationRepository;

    public ReservationManager(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public ResponseEntity<List<Reservation>> getAllReservations() {
        return new ResponseEntity<>(reservationRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Reservation> getReservationById(Long reservationId) {
        if (reservationRepository.findById(reservationId).isPresent()) {
            return new ResponseEntity<>(reservationRepository.findById(reservationId).get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Reservation> addReservation(Reservation reservation) {
        return new ResponseEntity<>(reservationRepository.save(reservation), HttpStatus.CREATED);
    }

    public Reservation updateReservation(Long reservationId, Reservation reservation) {
        reservation.setId(reservationId);
        return reservationRepository.save(reservation);
    }

    public ResponseEntity<Reservation> deleteReservationById(Long reservationId) {
        reservationRepository.deleteById(reservationId);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}

package pl.jcommerce.carrental.reservation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.jcommerce.carrental.reservation.dto.ReservationDTO;
import pl.jcommerce.carrental.reservation.dto.ReservationMapper;
import pl.jcommerce.carrental.reservation.entity.Reservation;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationManager {

    private final ReservationMapper reservationMapper;
    private final ReservationRepository reservationRepository;

    public ReservationManager(ReservationMapper reservationMapper, ReservationRepository reservationRepository) {
        this.reservationMapper = reservationMapper;
        this.reservationRepository = reservationRepository;
    }

    public ResponseEntity<List<ReservationDTO>> getAllReservations() {
        List<ReservationDTO> reservationDTOS =
                reservationRepository.findAll()
                .stream()
                .map(reservationMapper::mapToDTO)
                .collect(Collectors.toList());

        return new ResponseEntity<>(reservationDTOS, HttpStatus.OK);
    }

    public ResponseEntity<ReservationDTO> getReservationById(Long reservationId) {
        if (reservationRepository.findById(reservationId).isPresent()) {
            return new ResponseEntity<>(reservationMapper.mapToDTO(reservationRepository.findById(reservationId).get()), HttpStatus.OK);
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

    public ResponseEntity<Reservation> deleteAllReservations() {
        reservationRepository.deleteAll();
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}

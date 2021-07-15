package pl.jcommerce.carrental.reservation.dto;

import org.springframework.stereotype.Service;
import pl.jcommerce.carrental.car.dto.CarMapper;
import pl.jcommerce.carrental.reservation.entity.Reservation;
import pl.jcommerce.carrental.user.dto.UserMapper;

@Service
public class ReservationMapper {

    private final CarMapper carMapper;
    private final UserMapper userMapper;

    public ReservationMapper(CarMapper carMapper, UserMapper userMapper) {
        this.carMapper = carMapper;
        this.userMapper = userMapper;
    }

    public ReservationDTO mapToDTO(Reservation reservation) {
        return new ReservationDTO(
                reservation.getId(),
                carMapper.mapToCarDTO(reservation.getCar()),
                userMapper.mapToUserWithoutReservationDTO(reservation.getUser()),
                reservation.getStartDate(),
                reservation.getEndDate(),
                reservation.getPaid());
    }

}

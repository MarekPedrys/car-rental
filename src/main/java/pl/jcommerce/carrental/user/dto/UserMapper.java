package pl.jcommerce.carrental.user.dto;

import org.springframework.stereotype.Service;
import pl.jcommerce.carrental.user.entity.User;

@Service
public class UserMapper {

    public UserWithoutReservationDTO mapToUserWithoutReservationDTO(User user){
        return new UserWithoutReservationDTO(user.getId(), user.getUsername(), user.getEmail());
    }
}

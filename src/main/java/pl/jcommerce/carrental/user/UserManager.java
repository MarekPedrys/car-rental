package pl.jcommerce.carrental.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.jcommerce.carrental.user.dto.UserMapper;
import pl.jcommerce.carrental.user.dto.UserWithoutReservationDTO;
import pl.jcommerce.carrental.user.entity.User;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserManager {
    
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserManager(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public ResponseEntity<List<UserWithoutReservationDTO>> getAllUsers() {
        List<UserWithoutReservationDTO> userWithoutReservationDTOS = userRepository.findAll()
                .stream()
                .map(userMapper::mapToUserWithoutReservationDTO)
                .collect(Collectors.toList());

        return new ResponseEntity<>(userWithoutReservationDTOS, HttpStatus.OK);
    }

    public ResponseEntity<UserWithoutReservationDTO> getUserById(Long userId) {
        if (userRepository.findById(userId).isPresent()) {
            User user = userRepository.findById(userId).get();
            UserWithoutReservationDTO userWithoutReservationDTO = userMapper.mapToUserWithoutReservationDTO(user);

            return new ResponseEntity<>(userWithoutReservationDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<User> addUser(User user) {
        return new ResponseEntity<>(userRepository.save(user), HttpStatus.CREATED);
    }

    public User updateUser(Long userId, User user) {
        user.setId(userId);
        return userRepository.save(user);
    }

    public ResponseEntity<User> deleteUserById(Long userId) {
        userRepository.deleteById(userId);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    public ResponseEntity<User> deleteAllUsers() {
        userRepository.deleteAll();
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}

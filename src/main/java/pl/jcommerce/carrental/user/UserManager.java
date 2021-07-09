package pl.jcommerce.carrental.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.jcommerce.carrental.user.entity.User;

import java.util.List;

@Service
public class UserManager {
    
    UserRepository userRepository;

    public UserManager(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<User> getUserById(Long userId) {
        if (userRepository.findById(userId).isPresent()) {
            return new ResponseEntity<>(userRepository.findById(userId).get(), HttpStatus.OK);
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
}

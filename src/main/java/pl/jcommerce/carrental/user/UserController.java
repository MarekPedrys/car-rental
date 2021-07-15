package pl.jcommerce.carrental.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.jcommerce.carrental.user.dto.UserWithoutReservationDTO;
import pl.jcommerce.carrental.user.entity.User;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    
    private final UserManager userManager;

    public UserController(UserManager userManager) {
        this.userManager = userManager;
    }

    @GetMapping
    public ResponseEntity<List<UserWithoutReservationDTO>> getAllUsers() {
        return userManager.getAllUsers();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserWithoutReservationDTO> getUserById(@PathVariable Long userId) {
                return userManager.getUserById(userId);
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return userManager.addUser(user);
    }

    @PutMapping("/{userId}")
    public User updateUser(@PathVariable Long userId, @RequestBody User user) {
        return userManager.updateUser(userId, user);
    }

    @DeleteMapping
    public ResponseEntity<User> deleteAllUsers(){
        return userManager.deleteAllUsers();
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<User> deleteUserById(@PathVariable Long userId) {
        return userManager.deleteUserById(userId);
    }


}

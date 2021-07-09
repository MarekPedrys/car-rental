package pl.jcommerce.carrental.user;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.jcommerce.carrental.user.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}

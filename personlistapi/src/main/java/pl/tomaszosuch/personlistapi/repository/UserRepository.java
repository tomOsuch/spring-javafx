package pl.tomaszosuch.personlistapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tomaszosuch.personlistapi.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}

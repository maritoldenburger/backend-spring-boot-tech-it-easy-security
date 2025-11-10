package nl.techiteasy.techiteasy.repositories;

import nl.techiteasy.techiteasy.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
package dev.byte_forge.project001.user;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;
import java.util.Optional;



@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    public Optional<User> getByEmail(String email);

}

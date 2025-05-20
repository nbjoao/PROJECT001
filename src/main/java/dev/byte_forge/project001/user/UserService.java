package dev.byte_forge.project001.user;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dev.byte_forge.project001.exception.EmailAlreadyRegisteredException;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserMapper map = new UserMapper();

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public User createUser(UserCreateRequestDTO createRequestDTO) {
        if (getByEmail(createRequestDTO.getEmail()).isEmpty()) {
            createRequestDTO.setPassword(passwordEncoder.encode(createRequestDTO.getPassword()));
            return userRepository.save(map.toEntity(createRequestDTO));
        } else {
            throw new EmailAlreadyRegisteredException("Email already registered.");
        }
    }

    public Optional<User> getByEmail(String email) {
        return userRepository.getByEmail(email);
    }

}

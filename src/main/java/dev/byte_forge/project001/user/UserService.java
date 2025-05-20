package dev.byte_forge.project001.user;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dev.byte_forge.project001.exception.EmailAlreadyRegisteredException;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserEventPublisher eventPublisher;

    public UserMapper map = new UserMapper();

    public UserService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            UserEventPublisher eventPublisher
        ) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.eventPublisher = eventPublisher;
    }

    public void createUser(UserCreateRequestDTO createRequestDTO) {
        if (getByEmail(createRequestDTO.getEmail()).isEmpty()) {
            createRequestDTO.setPassword(passwordEncoder.encode(createRequestDTO.getPassword()));
            userRepository.save(map.toEntity(createRequestDTO));
            this.eventPublisher.sendVerificationMessage(createRequestDTO.getEmail());
        } else {
            throw new EmailAlreadyRegisteredException("Email already registered.");
        }
    }

    public Optional<User> getByEmail(String email) {
        return userRepository.getByEmail(email);
    }

}

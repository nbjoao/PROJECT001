package dev.byte_forge.project001.user;

import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    public UserMapper map = new UserMapper();

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(UserCreateRequestDTO createRequestDTO) {
        if (getByEmail(createRequestDTO.getEmail()).isEmpty()) {
            return userRepository.save(map.toEntity(createRequestDTO));
        } else {
            throw new IllegalArgumentException("Email already registered.");
        }
    }

    public Optional<User> getByEmail(String email) {
        return userRepository.getByEmail(email);
    }

}

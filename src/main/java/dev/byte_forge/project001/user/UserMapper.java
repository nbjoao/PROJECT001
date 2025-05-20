package dev.byte_forge.project001.user;

import java.util.UUID;

public class UserMapper {

    public User toEntity(UserCreateRequestDTO createRequestDTO) {
        User user = new User(createRequestDTO.getEmail(), createRequestDTO.getPassword());
        user.setVerificationToken(UUID.randomUUID().toString());
        return user;
    }

}

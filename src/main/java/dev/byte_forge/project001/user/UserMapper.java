package dev.byte_forge.project001.user;

public class UserMapper {

    public User toEntity(UserCreateRequestDTO createRequestDTO) {
        return new User(createRequestDTO.getEmail(), createRequestDTO.getPassword());
    }

}

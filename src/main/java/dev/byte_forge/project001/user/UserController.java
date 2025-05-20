package dev.byte_forge.project001.user;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.byte_forge.project001.exception.EmailAlreadyRegisteredException;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("users")
public class UserController {

    public UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<String> createUser(@Valid @RequestBody UserCreateRequestDTO createRequestDTO) {
        try {
            userService.createUser(createRequestDTO);
            return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Email registered with success.");
        } catch (EmailAlreadyRegisteredException e) {
            return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body("Email already registered");
        }
        
    }

}
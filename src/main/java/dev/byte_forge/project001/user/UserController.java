package dev.byte_forge.project001.user;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.byte_forge.project001.exception.EmailAlreadyRegisteredException;
import jakarta.validation.Valid;

import java.util.Optional;

import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



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

    @GetMapping("/verify")
    public ResponseEntity<String> verify(@RequestParam("token") String token) {
        try {
            this.userService.verifyUser(token);
            return ResponseEntity
                .status(HttpStatus.OK)
                .body("Email registered with success."); 
        } catch (BadRequestException e) {
            return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Invalid verification token.");
        }
    }

}
package pk.iamsafidev.expensetrackerapi.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pk.iamsafidev.expensetrackerapi.entity.User;
import pk.iamsafidev.expensetrackerapi.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public ResponseEntity<User> get() {
        return new ResponseEntity<>(userService.read(), HttpStatus.OK);
    }

    @PutMapping("/profile")
    public ResponseEntity<User> update(@RequestBody User user) {
        User existingUser = userService.update(user);
        return new ResponseEntity<>(existingUser, HttpStatus.OK);
    }

    @DeleteMapping("/deactivate")
    public ResponseEntity<User> delete() {
        userService.delete();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

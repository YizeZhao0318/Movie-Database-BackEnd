package dev.yize.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        User foundUser = userService.login(user.getEmail(), user.getPassword());
        if (foundUser == null) {
            return new ResponseEntity<>("Incorrect email or password", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Login successful", HttpStatus.OK);
    }

    @PostMapping
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    @GetMapping("/{email}")
    public ResponseEntity<User> findUserByEmail(@PathVariable String email) {
        Optional<User> user = userService.findUserByEmail(email);
        if (!user.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user.get(), HttpStatus.OK);
    }

}

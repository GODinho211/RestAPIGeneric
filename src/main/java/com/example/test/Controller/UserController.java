package com.example.test.Controller;

import com.example.test.Service.UserService;
import com.example.test.model.Users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UserController {

   private final UserService userService;

    @Autowired
    public UserController(UserService userService){

        this.userService = userService;
    }
    @PostMapping("/adduser")
    public ResponseEntity<String> saveUser(@RequestBody User data) {
        userService.save(data);
        return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");
    }

    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable long userId) {

        userService.delete(userId);
        return ResponseEntity.status(HttpStatus.CREATED).body("User Deleted successfully");
    }

    @PutMapping("/updateUser/{userId}")
    public void updateUser(@PathVariable long userId, @RequestBody User updatedUserData) {
//        userService.update(userId, updatedUserData);
    }

    @GetMapping("/getAll")
    public List<User> getAllUsers()
    {
        return userService.getAllUsers();
    }

    @GetMapping("/findById/{userId}")
    public ResponseEntity<User> findById(@PathVariable long userId) {
        User user = userService.findById(userId);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}

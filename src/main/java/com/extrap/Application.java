package com.extrap;

import com.extrap.Models.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@SpringBootApplication
@RestController
@RequestMapping("/api/users")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // RestAPI

    // In-memory user store
    private final List<User> users = new ArrayList<>();

    /*===============================================
    # Method: Get
    # Endpoint: /api/greeting
    # Description: Get a greeting
    ===============================================*/
    @GetMapping("/greeting/{name}")
    public String greeting(@PathVariable String name) {
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(name)) {
                return "Hello " + user.getName();
            }
        }
        return "User not found: " + name;
    }

    /*===============================================
    # Method: Get
    # Endpoint: /api/users
    # Description: Get all users
    ===============================================*/
    @GetMapping
    public List<User> getAllUsers() {
        return users;
    }

    /*===============================================
    # Method: Get
    # Endpoint: /api/users/{id}
    # Description: Get a user by ID
    ===============================================*/
    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    /*===============================================
    # Method: Post
    # Endpoint: /api/users
    # Description: Create a new user
    ===============================================*/
    private int nextId = 1;

    @PostMapping
    public User createUser(@RequestBody User newUser) {
        newUser.setId(nextId++);
        users.add(newUser);
        return newUser;
    }

    /*===============================================
    # Method: Put
    # Endpoint: /api/users/{id}
    # Description: Update a user
    ===============================================*/
    @PutMapping("/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User updatedUser) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                users.set(i, updatedUser);
                return updatedUser;
            }
        }
        throw new RuntimeException("User not found");
    }

    /*===============================================
    # Method: Delete
    # Endpoint: /api/users/{id}
    # Description: Delete a user
    ===============================================*/
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        boolean removed = users.removeIf(user -> user.getId() == id);
        if (!removed) {
            throw new RuntimeException("User not found");
        }
        return "User deleted";
    }

}

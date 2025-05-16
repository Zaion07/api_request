package com.example.demo.Service;

import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UserService {
    private final Map<Long, User> users = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public List<User> getAllUsers() {return new ArrayList<>(users.values());}

    public User addUser(User user) {
        long id = idCounter.getAndIncrement();
        user.setId(id);
        users.put(id, user);
        return user;
    }

    public User updateUser(Long id,User user) {
        users.containsKey(id);
        user.setId(id);
        users.put(id, user);
        return user;
    }


    public boolean deleteUser(Long id) {
        return users.remove(id) != null;
    }
}
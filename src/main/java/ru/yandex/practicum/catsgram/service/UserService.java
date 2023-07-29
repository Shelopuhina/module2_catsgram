package ru.yandex.practicum.catsgram.service;

import org.springframework.stereotype.Service;
import ru.yandex.practicum.catsgram.exceptions.InvalidEmailException;
import ru.yandex.practicum.catsgram.exceptions.UserAlreadyExistException;
import ru.yandex.practicum.catsgram.model.User;

import java.util.HashSet;

@Service
public class UserService {
    private final HashSet<User> users = new HashSet<>();

    public HashSet<User> findAll() {
        return users;
    }

    public User create(User user) {
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new InvalidEmailException("Неверно указан email");
        }
        for (User user1 : users) {
            if (user1.equals(user)) {
                throw new UserAlreadyExistException("Пользователь с таким email уже существует.");
            }
        }
        users.add(user);
        return user;
    }

    public User addOrUpdate(User user) {
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new InvalidEmailException("Неверно указан email.");
        }
        users.removeIf(user1 -> user1.hashCode() == user.hashCode());
        users.add(user);
        return user;
    }

}

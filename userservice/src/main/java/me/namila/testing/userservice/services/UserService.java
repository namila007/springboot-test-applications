package me.namila.testing.userservice.services;

import me.namila.testing.userservice.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserService implements IUserService {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Override
    public User createNewUser(User user) {
        return null;
    }
}

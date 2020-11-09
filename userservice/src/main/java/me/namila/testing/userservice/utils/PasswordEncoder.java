package me.namila.testing.userservice.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordEncoder {

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public PasswordEncoder() {
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }

    public String encodePassword(String password) {
        return bCryptPasswordEncoder.encode(password);
    }

    public boolean comparePassword(String password, String hashedPassword) {
        return bCryptPasswordEncoder.matches(password, hashedPassword);
    }


}

package edu.school21.cinema.User;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class UserRepositoryImpl implements UserRepository {

    JdbcTemplate jdbcTemplate;

    public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void saveUser(User user) {
        jdbcTemplate.update("INSERT INTO users(phone_number, password, first_name, last_name) VALUES(?, ?, ?, ?)",
                user.getPhoneNumber(),
                user.getPass(),
                user.getFirstName(),
                user.getLastName());
    }
}

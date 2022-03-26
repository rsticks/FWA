package edu.school21.cinema.User.repository;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import edu.school21.cinema.User.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class UserRepositoryImpl implements UserRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRepositoryImpl.class);
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

    @Override
    public void findByNumber(String number) {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("SELECT * FROM users where phone_number = ?", number);
        LOGGER.trace("name");
    }
}

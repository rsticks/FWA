package edu.school21.cinema.User.repository;

import edu.school21.cinema.User.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

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
                user.getPassword(),
                user.getFirstName(),
                user.getLastName());
    }

    @Override
    public User findByNumber(String number) {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("SELECT * FROM users where phone_number = ?", number);
        User user = new User();
        if (!list.isEmpty()) {
            user.setID((Integer) list.get(0).get("id"));
            user.setFirstName((String) list.get(0).get("first_name"));
            user.setFirstName((String) list.get(0).get("last_name"));
            user.setPhoneNumber((String) list.get(0).get("phone_number"));
            user.setPassword((String) list.get(0).get("password"));
        }
        return user;
    }
}

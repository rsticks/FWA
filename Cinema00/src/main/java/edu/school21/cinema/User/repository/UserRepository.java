package edu.school21.cinema.User.repository;

import edu.school21.cinema.User.User;

public interface UserRepository {

    void saveUser(User user);

    void findByNumber(String number);
}

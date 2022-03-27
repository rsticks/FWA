package edu.school21.cinema.User.repository;

import edu.school21.cinema.User.User;

import javax.naming.AuthenticationException;

public interface UserRepository {

    void saveUser(User user);

    User findByNumber(String number);
}

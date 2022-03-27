package edu.school21.cinema.User.service;

import edu.school21.cinema.User.User;

import javax.naming.AuthenticationException;

public interface UserService {
    void saveUser(String phoneNum, String password, String firstName, String lastName);

    User signInUser(String number, String password) throws AuthenticationException;
}

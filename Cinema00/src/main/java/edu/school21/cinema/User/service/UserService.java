package edu.school21.cinema.User.service;

public interface UserService {
    void saveUser(String phoneNum, String password, String firstName, String lastName);

    void findUser(String number);
}

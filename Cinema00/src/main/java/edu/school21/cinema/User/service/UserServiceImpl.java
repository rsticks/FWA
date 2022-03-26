package edu.school21.cinema.User.service;

import edu.school21.cinema.User.User;
import edu.school21.cinema.User.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public void saveUser(String phoneNum, String password, String firstName, String lastName) {
        userRepository.saveUser(new User(firstName, lastName, phoneNum, bCryptPasswordEncoder.encode(password)));
    }

    @Override
    public void findUser(String number) {
        userRepository.findByNumber(number);
    }
}

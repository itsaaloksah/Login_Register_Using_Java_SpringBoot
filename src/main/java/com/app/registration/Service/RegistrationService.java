package com.app.registration.Service;

import com.app.registration.Model.User;
import com.app.registration.Repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository repo;

    public User saveUser(User user) {
        return repo.save(user);
    }

    public User fetchUserByEmailId(String email) {
        return repo.findByEmailId(email);
    }

    public User fetchUserByEmailIdAndPassword(String email, String password) {
        return repo.findByEmailIdAndPassword(email, password);
    }
}

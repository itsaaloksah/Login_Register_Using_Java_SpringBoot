package com.app.registration.Controller;

import com.app.registration.Model.User;
import com.app.registration.Service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RegistrationController {

    @Autowired
    private RegistrationService service;

    @PostMapping("/registerUser")
    @CrossOrigin(origins = "http://localhost:4200")
    public User registerUser(@RequestBody User user) throws Exception {
        String tempEmailId = user.getEmailId();
        if (tempEmailId != null && !"".equals(tempEmailId)) {
            User userobj = service.fetchUserByEmailId(tempEmailId);
            if (userobj != null) {
                throw new Exception("User with "+tempEmailId+" already exist");
            }
        }
        User userObj = null;
        userObj = service.saveUser(user);
        return userObj;
    }

    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:4200")
    public User loginUser(@RequestBody User user) throws Exception {
        String tempEmailId = user.getEmailId();
        String tempPassword = user.getPassword();
        User userObj = null;
        if (tempEmailId != null && tempPassword != null) {
            userObj = service.fetchUserByEmailIdAndPassword(tempEmailId, tempPassword);
        }
        if (userObj == null) {
            throw new Exception("Bad Credentials");
        }
        return userObj;
    }
}

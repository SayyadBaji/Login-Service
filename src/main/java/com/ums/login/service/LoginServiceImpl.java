package com.ums.login.service;

import com.ums.login.dto.User;
import com.ums.login.exception.LoginFailedException;
import com.ums.login.exception.NoUserFoundException;
import com.ums.login.model.LoginId;
import com.ums.login.model.UserLogin;
import com.ums.login.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    //@Autowired
    private LoginRepository loginRepository;

    @Autowired
    public LoginServiceImpl(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    /*@Override
    public User login(User user) {
        boolean isValid = false;
        if (user.getUsername().equals("student") && user.getPassword().equals("student")) {
            user.setUserType(UserType.STUDENT.name());
            isValid = true;
        }
        if (user.getUsername().equals("admin") && user.getPassword().equals("admin")) {
            user.setUserType(UserType.ADMIN.name());
            isValid = true;
        }
        if (user.getUsername().equals("faculty") && user.getPassword().equals("faculty")) {
            user.setUserType(UserType.FACULTY.name());
            isValid = true;
        }
        if (isValid)
            return user;
        throw new LoginFailedException("Invalid Credentils");
    }*/

    @Override
    public User login(User user) {
        //UserLogin userLogin = loginRepository.findByUsername(user.getUsername());
        LoginId loginId = new LoginId(user.getUsername(), user.getUsertype());
        UserLogin userLogin = loginRepository.findByLoginId(loginId);
        if (userLogin==null)
            throw new NoUserFoundException("No "+user.getUsertype()+" available with user id: "+user.getUsername());

        if (user.getUsername().equals(userLogin.getLoginId().getUserName()) && user.getPassword().equals(userLogin.getPassword())) {
            //user.setUsertype(userLogin.getLoginId().getUserType());
            return user;
        }
        throw new LoginFailedException("Invalid Credentials");
    }

    /*@Override
    public User resetPassword(User user) {
        return null;
    }*/

    /*@Override
    public String generateUsername(String firstName, String lastName, String userType) {
        String username = firstName+"."+lastName+"@ums.com";
        UserLogin userLogin = loginRepository.findByUsername(username);
        if (userLogin==null)
            return username;
        Integer count = loginRepository.getCount(firstName, lastName);
        return firstName+"."+lastName+"_"+count+"@ums.com";
    }*/

    @Override
    public String generateUsername(String firstName, String lastName, String userType) {
        String username = firstName+"."+lastName+"@ums.com";
        LoginId loginId = new LoginId(username, userType);
        UserLogin userLogin = loginRepository.findByLoginId(loginId);


        //UserLogin userLogin = loginRepository.findByUsername(username);
        if (userLogin==null)
            return username;
        String usernameSuffix = firstName+"."+lastName;
        Integer count = loginRepository.getCount(usernameSuffix, userType);
        return firstName+"."+lastName+"_"+count+"@ums.com";
    }
}

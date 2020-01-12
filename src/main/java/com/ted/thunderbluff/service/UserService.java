package com.ted.thunderbluff.service;

import com.ted.thunderbluff.model.Authority;
import com.ted.thunderbluff.model.AuthorityName;
import com.ted.thunderbluff.model.UserModel;
import com.ted.thunderbluff.model.pojo.UserPOJO;
import com.ted.thunderbluff.repository.AuthorityRepository;
import com.ted.thunderbluff.repository.UserModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    UserModelRepository userModelRepository;

    @Autowired
    AuthorityRepository authorityRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void addUser(UserModel user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(false);

        AuthorityName name = AuthorityName.ROLE_USER;
        Authority auth = authorityRepository.findByName(name);
        List<Authority> authorities = new ArrayList<>();
        authorities.add(auth);
        user.setAuthorities(authorities);
        userModelRepository.save(user);
    }

    public List<UserModel> getAllUsers() {
        List<UserModel> users = new ArrayList<>();
        userModelRepository.findAll().forEach(users::add);
        return users;
    }

    public UserModel getUserByUsername(String username) {
        return userModelRepository.findByUsername(username);
    }


    public List<UserPOJO> getOtherUsers(String username) {
        List<UserPOJO> retList = new ArrayList<>();
        for (UserModel user: userModelRepository.findAll() ) {
            if (!user.getUsername().equals(username) && !user.getUsername().equals("admin")){
                retList.add(user.convertToPOJO());
            }
        }
        return retList;
    }

    public void confirmUser(String username) {
        UserModel userModel = userModelRepository.findByUsername(username);
        userModel.setEnabled(true);
        userModelRepository.save(userModel);
    }
}

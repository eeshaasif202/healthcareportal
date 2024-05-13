package com.portal.healthcare.service;

import com.portal.healthcare.interfaces.CrudService;
import com.portal.healthcare.model.Role;
import com.portal.healthcare.model.User;
import com.portal.healthcare.model.UserInfo;
import com.portal.healthcare.repository.RoleRepository;
import com.portal.healthcare.repository.UserInfoRepository;
import com.portal.healthcare.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService extends CrudService<User> {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserInfoRepository userInfoRepositiory;



    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User register(User user, int roleId) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCreatedAt(LocalDateTime.now().toString());
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(user);
        userInfoRepositiory.save(userInfo);
        Optional<Role> optionalRole = roleRepository.findById(roleId);
        if (optionalRole.isPresent()) {
            Role role = optionalRole.get();
            user.setRoleId(role); // Set the role for the user
            user.setUserInfo(userInfo);
            return userRepository.save(user);
        } else {
            // Handle case when role with given ID is not found
            throw new IllegalArgumentException("Role with ID " + roleId + " not found");
        }


    }

    public String logOut(String userName) {
      return "logout";
    }
}

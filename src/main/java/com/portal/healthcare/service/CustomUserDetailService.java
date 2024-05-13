package com.portal.healthcare.service;

import com.portal.healthcare.config.JwtUtil;
import com.portal.healthcare.model.Role;
import com.portal.healthcare.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);

        if(user==null){
            throw new UsernameNotFoundException("User not found with username: " + username);
        }


        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                true,
                true,
                true,
                true,
                getAuthorities(user.getRoleId()));
    }
    private Collection<? extends GrantedAuthority> getAuthorities(Role role) {
        Set<SimpleGrantedAuthority> permissions = new HashSet<>();
        permissions.add(new SimpleGrantedAuthority(role.getName()));
        return permissions;
    }


    public Map<String,String> login(org.springframework.security.core.userdetails.User user) {
        User user1=userService.findByUsername(user.getUsername());
        Map<String,String> map= JwtUtil.getTokens(user);
        Role role = user1.getRoleId();
        String roleName = (role != null) ? role.getName() : "No Role Assigned"; // Assuming Role has a 'name' field
        map.put("role", roleName);
        return map;
    }
}

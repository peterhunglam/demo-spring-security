package com.gpa.demo_spring_security.service;

import com.gpa.demo_spring_security.model.User;
import com.gpa.demo_spring_security.model.UserPrincipal;
import com.gpa.demo_spring_security.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repo.findByUsername(username);

        if (user == null) {
            System.out.println("User Not Found with username: " + username);
            throw new UsernameNotFoundException("User Not Found with username: " + username);
        }

        return new UserPrincipal(user);
    }
}

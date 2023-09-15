package com.gfa.springadvanced.services.retrofitServices;

import com.gfa.springadvanced.configs.UserInfoUserDetails;
import com.gfa.springadvanced.models.User;
import com.gfa.springadvanced.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class UserInfoUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userInfo = userRepository.findByUsername(username);

        return userInfo.map( UserInfoUserDetails ::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));

    }

}
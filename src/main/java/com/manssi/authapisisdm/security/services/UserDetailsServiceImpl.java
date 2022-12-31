package com.manssi.authapisisdm.security.services;

import com.manssi.authapisisdm.dao.UserRepository;
import com.manssi.authapisisdm.models.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService, org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserRepository userRepository ;


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(()->new UsernameNotFoundException("User not found with username"+username));
        return UserDetailsImpl.build(user);
    }
}

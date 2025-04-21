package com.onedata.remotepatientmonitoring.service;

import com.onedata.remotepatientmonitoring.entity.UserPrincipal;
import com.onedata.remotepatientmonitoring.models.tables.pojos.Users;
import com.onedata.remotepatientmonitoring.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = userRepo.findByUsername(username);
        if(users == null){
            throw new UsernameNotFoundException("User not found");
        }
        return new UserPrincipal(users);
    }
}

package com.ensapay.ebanking.config;

import com.ensapay.ebanking.entities.AppUser;
import com.ensapay.ebanking.exceptions.NotFoundExcepton;
import com.ensapay.ebanking.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserprincipalService implements UserDetailsService {

    UserRepository userRepository;

    @Autowired
    public UserprincipalService(UserRepository userRepository)
    {
        this.userRepository=userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = null;

        try
        {
            if(!userRepository.findUserByUsername(username).isPresent()) throw new NotFoundExcepton("th user not found");
            else{
                appUser=userRepository.findUserByUsername(username).get();
            }
        }
        catch (UsernameNotFoundException e)
        {
            e.printStackTrace();
        }

        return new Userprincipal(appUser);
    }
}

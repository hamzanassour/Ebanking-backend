package com.ensapay.ebanking.config;

import com.ensapay.ebanking.entities.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Userprincipal implements UserDetails {


        AppUser appUser;

        @Autowired
        public  Userprincipal(AppUser appUser)
        {
            super();
            this.appUser=appUser;
        }


        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            List<GrantedAuthority> authorityList = new ArrayList<>();
            GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_"+this.appUser.getRole());
            authorityList.add(authority);
            return authorityList;
        }

        @Override
        public String getPassword() {
            return this.appUser.getPassword();
        }

        @Override
        public String getUsername() {
            return this.appUser.getUsername();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
}

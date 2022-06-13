package com.ensapay.ebanking.config;

import com.ensapay.ebanking.entities.Admin;
import com.ensapay.ebanking.exceptions.NotFoundExcepton;
import com.ensapay.ebanking.services.AdminService;
import com.google.common.collect.ImmutableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Collections;

public class AppSecurity extends WebSecurityConfigurerAdapter {

     private final AdminService adminService;
     private final UserprincipalService userprincipalService;

    @Autowired
    public AppSecurity(AdminService adminService,UserprincipalService userprincipalService)
    {
        this.adminService=adminService;
        this.userprincipalService=userprincipalService;
    }



    @Bean
    public DaoAuthenticationProvider AuthProvider()
    {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userprincipalService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder());

        return  provider;
    }

    @Bean
    public UrlBasedCorsConfigurationSource corsConfiguration()
    {
       final CorsConfiguration corsConfig= new CorsConfiguration();
       corsConfig.setAllowedOrigins(Collections.singletonList("*"));
       corsConfig.setAllowedOrigins(Arrays.asList("*"));
       corsConfig.setAllowedMethods(ImmutableList.of("*"));
       corsConfig.setAllowedHeaders(ImmutableList.of("*"));
       corsConfig.setAllowCredentials(true);

       final UrlBasedCorsConfigurationSource source= new UrlBasedCorsConfigurationSource();
       source.registerCorsConfiguration("/**",corsConfig);

       return  source;

    }
}

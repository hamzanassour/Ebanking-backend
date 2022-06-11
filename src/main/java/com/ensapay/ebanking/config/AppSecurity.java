package com.ensapay.ebanking.config;

import com.ensapay.ebanking.services.AdminService;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class AppSecurity extends WebSecurityConfigurerAdapter {

    AdminService adminService;
}

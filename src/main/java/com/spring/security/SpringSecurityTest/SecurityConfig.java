package com.spring.security.SpringSecurityTest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService detailsService(){

        UserDetails normalUser = User.withUsername("ankit")
                .password(passwordEncoder().encode("ankit"))
                .roles("NORMAL")
                .build();

        UserDetails adminUser = User.withUsername("ajay")
                .password(passwordEncoder().encode("ajay")).
                roles("ADMIN").
                build();

        return new InMemoryUserDetailsManager(normalUser, adminUser);


    }



    public SecurityFilterChain filterChain(HttpSecurity security) throws Exception {
        security.csrf().disable()
                .authorizeHttpRequests()
//                .requestMatchers("/admin")
//                .hasRole("Admin")
//                .requestMatchers("/normal")
//                .hasRole("NORMAL")
//                .requestMatchers("/public")
//                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin();

        return security.build();
    }

}

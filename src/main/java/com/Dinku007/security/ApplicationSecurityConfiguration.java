package com.Dinku007.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anand SN
 */

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/home/").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    public UserDetailsService userDetailsService() {

        List<UserDetails> user = new ArrayList<>();

        user.add(User.withDefaultPasswordEncoder().username("Anand").password("Anand").roles("USER","ADMIN").build());

        user.add(User.withDefaultPasswordEncoder().username("Santosh").password("Santosh").roles("USER").build());

        return new InMemoryUserDetailsManager(user);

    }
}

package org.example.pocspringpagablesecurity.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class SecurityConfig {

    final Map<String, MyUserDetails> users;

    public SecurityConfig() {
        users = new HashMap<>();

        User.UserBuilder builder = User.withDefaultPasswordEncoder();
        UserDetails user = builder.username("user").password("password").roles("USER").build();
        users.put("user", new MyUserDetailsImpl(
                user.getUsername(),
                user.getPassword(),
                user.getAuthorities()
        ));
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(users.values().toArray(new MyUserDetails[0])) {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                // workaround: ensure it's still an MyUserDetails
                return users.get(username);
            }
        };
    }


}

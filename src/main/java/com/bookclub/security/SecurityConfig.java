/**
 * Krasso, R. (2021). CIS 530 Server-Side Development. Bellevue University, all right reserved.
 * Modified by D. Locascio (2026)
 * 
 * Migrate application from Spring Security 5 to spring security 6/Spring Boot 3 | baeldung. (n.d.). https://www.baeldung.com/spring-security-migrate-5-to-6 
 */

package com.bookclub.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * This method creates an in-memory UserDetailsService bean.
     * Spring Security 6 requires user definitions to be supplied via a bean instead of the deprecated WebSecurityConfigurerAdapter. 
     * 
     * @return UserDetailsService containing two in-memory users:
     *         - 'user' with USER role
     *         - 'dlocascio' with USER and ADMIN roles
     */
    @Bean
    public UserDetailsService userDetailsService() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        UserDetails user = User.withUsername("user")
                .password(encoder.encode("password"))
                .roles("USER")
                .build();

        UserDetails admin = User.withUsername("dlocascio")
                .password(encoder.encode("bellevue"))
                .roles("USER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    /**
     * This method configures the security filter chain for the application.
     * It requires authentication for all requests and enables form-based login and HTTP Basic authentication.
     * Spring Security 6 replaces the deprecated configure(HttpSecurity) method with a bean that returns a SecurityFilterChain.
     * 
     * @param http     // HttpSecurity object used to configure security settings for the application.
     * @return SecurityFilterChain configured to require authentication for all requests and enable form login and HTTP Basic authentication.
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .permitAll()
            )
            .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}

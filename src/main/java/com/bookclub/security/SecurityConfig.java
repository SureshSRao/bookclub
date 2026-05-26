/*
 * Suresh, Sripathi Rao. (2026). CIS 530 Server-Side Development.
 */

package com.bookclub.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

/**
 * SecurityConfig configures authentication and authorization
 * rules for the Bookclub application.
 */
@Configuration
public class SecurityConfig {

    /**
     * Configures Spring Security filter chain.
     *
     * @param http the HttpSecurity object
     * @return configured SecurityFilterChain
     * @throws Exception if configuration fails
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .authorizeHttpRequests(authorize -> authorize

                // Public resources
                .requestMatchers(
                        "/login",
                        "/css/**",
                        "/js/**",
                        "/images/**"
                ).permitAll()

                // Admin-only pages
                .requestMatchers(
                        "/monthly-books",
                        "/monthly-books/**"
                ).hasRole("ADMIN")

                // All other requests require authentication
                .anyRequest().authenticated()
            )

            // Form login configuration
            .formLogin(form -> form
                    .loginPage("/login")
                    .defaultSuccessUrl("/", true)
                    .permitAll()
            )

            // Logout configuration
            .logout(logout -> logout
                    .logoutSuccessUrl("/login?logout=true")
                    .permitAll()
            )

            // Enable HTTP Basic authentication
            .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    /**
     * Creates in-memory users for authentication.
     *
     * Preloaded Accounts:
     * user/password
     * testuser01/password01
     *
     * @return configured UserDetailsService
     */
    @Bean
    public UserDetailsService users() {

        UserDetails user = User.withUsername("user")
                .password("{noop}password")
                .roles("USER")
                .build();

        UserDetails testUser = User.withUsername("testuser01")
                .password("{noop}password01")
                .roles("USER")
                .build();

        UserDetails admin = User.withUsername("admin")
                .password("{noop}admin")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(
                user,
                testUser,
                admin
        );
    }
}
package com.unifacisa.ouvidoria.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.io.IOException;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorize -> authorize
            		.requestMatchers(new AntPathRequestMatcher("/h2-console/**")).permitAll()
                    .requestMatchers(new AntPathRequestMatcher("/swagger-ui/index.html")).permitAll()
                    .requestMatchers(new AntPathRequestMatcher("/swagger-ui/**")).permitAll()
                    .requestMatchers(new AntPathRequestMatcher("/email")).permitAll()
                    .requestMatchers(new AntPathRequestMatcher("/swagger-ui.html")).permitAll()
                    .requestMatchers(new AntPathRequestMatcher("/v3/api-docs/**")).permitAll()
                    .requestMatchers(new AntPathRequestMatcher("/login")).permitAll()
                    .requestMatchers(new AntPathRequestMatcher("/cadastro")).permitAll()
                    .requestMatchers(new AntPathRequestMatcher("/solicitacao")).permitAll()
                    .requestMatchers(new AntPathRequestMatcher("/api/registro")).permitAll()
                    .requestMatchers(new AntPathRequestMatcher("/static/**")).permitAll()
                    .requestMatchers(new AntPathRequestMatcher("/js/**")).permitAll()
                    .requestMatchers(new AntPathRequestMatcher("/css/**")).permitAll()
                    .requestMatchers(new AntPathRequestMatcher("api/churn/prever")).permitAll()
                    .requestMatchers(new AntPathRequestMatcher("/funcionario/**")).hasRole("FUNCIONARIO")
                    .requestMatchers(new AntPathRequestMatcher("/user/**")).hasRole("USER")
                    .requestMatchers(new AntPathRequestMatcher("/api/solicitacao")).hasRole("USER")
                    .requestMatchers(new AntPathRequestMatcher("/solicitacao")).hasRole("USER")

                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login")
                .successHandler(authenticationSuccessHandler())  
                .permitAll()
            )
            .logout(logout -> logout
                .permitAll()
            )
            .csrf(csrf -> csrf.disable())
            .headers(headers -> headers
                .frameOptions(frameOptions -> frameOptions.disable())
            );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return new AuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                                Authentication authentication) throws IOException, ServletException {
                if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_USER"))) {
                    response.sendRedirect("/solicitacao");
                } else if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_FUNCIONARIO"))) {
                    response.sendRedirect("/funcionario");
                } else {
                    response.sendRedirect("/login?error");
                }
            }
        };
    }
}
package com.unifacisa.ouvidoria.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {

//    @Autowired
  //  private UserDetailsService usuarioService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers(new AntPathRequestMatcher("/h2-console/**")).permitAll() // Habilita o H2 console
                .requestMatchers(new AntPathRequestMatcher("/funcionario/**")).hasRole("FUNCIONARIO")
                .requestMatchers(new AntPathRequestMatcher("/user/**")).hasRole("USER")
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .permitAll()
            )
            .logout(logout -> logout
                .permitAll()
            )
            // Configurações específicas para H2 e CSRF
            .csrf(csrf -> csrf.disable())  // Forma correta de desabilitar CSRF
            .headers(headers -> headers
                .frameOptions(frameOptions -> frameOptions.disable())  // Forma correta de desabilitar frameOptions
            );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

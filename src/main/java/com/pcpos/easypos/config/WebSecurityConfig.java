package com.pcpos.easypos.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.pcpos.easypos.filter.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    
    @Autowired private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    protected SecurityFilterChain config(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
            .cors(Customizer.withDefaults())
            .csrf(AbstractHttpConfigurer::disable)
            .httpBasic(AbstractHttpConfigurer::disable)
            .sessionManagement(sessionManagement->sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(c -> c.requestMatchers("/","/auth/**").permitAll().anyRequest().authenticated());

        httpSecurity
        .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
    }

}

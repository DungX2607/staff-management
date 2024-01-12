package com.dungnx.staffmanagement.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.dungnx.staffmanagement.service.IManagerService;

import static org.springframework.security.config.Customizer.withDefaults;

@Component
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    private IManagerService managerService;


    //	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(service).passwordEncoder(new BCryptPasswordEncoder());
//		//12346-> $2a$12$RodqLBlawspUPZS/Jg0srOU4f4EfpLrNy.pN9x2yJA9U.aLE6W9WG
//	}
    // Thay thế bên dưới
    // ===================
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    // ===================

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors(withDefaults()).httpBasic(withDefaults())
                .authorizeHttpRequests((authz) -> authz.requestMatchers("api/v1/auth/**").permitAll()
                        .anyRequest().authenticated())
                .httpBasic(withDefaults())
                .csrf(csrf -> csrf.disable());
        return http.build();
    }

    //Spring Security 5 (Viết lại ở bên trên (ver 6))
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//		.cors()
//		.and()
//        .httpBasic()
//        .and()
//		.authorizeRequests()
////			.antMatchers("/api/v1/Manager/**").hasAnyAuthority("ADMIN")
////
//			.antMatchers("/api/v1/auth/**").permitAll()
//			.anyRequest().authenticated()
////			.anyRequest().permitAll()
//			.and()
//			.httpBasic()
//			.and()
//			.csrf().disable();
//	}

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedMethods(Arrays.asList("HEAD", "GET", "POST", "PUT", "DELETE"));
        configuration.applyPermitDefaultValues();

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}

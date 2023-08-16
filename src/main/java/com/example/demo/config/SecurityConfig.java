//package com.example.demo.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public UserDetailsService service() {
//        PasswordEncoder encoder = this.passwordEncoder();
//        UserDetails admin = User.builder()
//                .username("HuynhNe")
//                .password(encoder.encode("1590"))
//                .roles("ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(admin);
//    }
//
//    @Bean
//    public SecurityFilterChain chain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.authorizeHttpRequests(req ->
//                req.requestMatchers("/api/danhSach/**").hasRole("ADMIN")
//                        .anyRequest().permitAll())
//                .formLogin(login -> login.loginProcessingUrl("/login"))
//                .httpBasic(Customizer.withDefaults())
//                .csrf().disable();
//        return httpSecurity.build();
//    }
//}

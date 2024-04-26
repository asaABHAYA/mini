package com.exam.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig {

    @Autowired
    UserDetailsService userDetailsService;

    @Bean
    AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
    daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        return daoAuthenticationProvider;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.csrf(AbstractHttpConfigurer::disable)
            .formLogin(form -> form
                    .loginPage("/login.html")
                    .permitAll())
            .logout(logout -> logout.logoutUrl("/logout").permitAll())
        .authorizeHttpRequests(
            requests ->
                requests
                    .requestMatchers( "/photos/**",  "/js/**",
                            "/css/**", "/graphql", "/graphiql",
                            "/about.html", "/contact.html", "/index.html",
                            "/dash.html", "/404.html", "/events.html",
                            "/error.html", "/e1.html", "/addevent.html",
                            "/addcat.html", "/eve1.html", "/starfeed.html",
                            "/feed.html", "/eve2.html", "/eve3.html")
                    .permitAll()
                    .requestMatchers("/admin.html")
                    .hasAnyAuthority("ADMIN")
                    .anyRequest()
                    .authenticated())

        .sessionManagement(
            session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
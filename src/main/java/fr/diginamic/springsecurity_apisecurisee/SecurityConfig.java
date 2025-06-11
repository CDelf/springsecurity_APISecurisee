package fr.diginamic.springsecurity_apisecurisee;

import fr.diginamic.springsecurity_apisecurisee.security.JwtFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Bean
    public static BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, JwtFilter filter) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/login", "/auth/create-candidat", "/auth/create-recruteur", "/h2-console/**", "/annonce/get-all").permitAll()
                        .requestMatchers("/annonce/create").hasRole("RECRUTEUR")
                        .requestMatchers("/annonce/candidate-by-id/**").hasRole("CANDIDAT")
                        .requestMatchers("/annonce/delete-by-id/**").hasRole("ADMIN")
                        .requestMatchers("/auth/create-admin", "/auth/delete-admin-by-id/**", "/user/get-all").hasRole("SUPER_ADMIN")
                        .requestMatchers("/candidature/get-all").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .headers(headers -> headers.frameOptions(frame -> frame.sameOrigin()))
                .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}

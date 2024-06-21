package it.epicode.capstone.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity(debug = true)
public class Config {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity) throws Exception {
        httpSecurity.formLogin(http -> http.disable());
        httpSecurity.csrf(http -> http.disable());
        httpSecurity.sessionManagement(http -> http.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        httpSecurity.cors(Customizer.withDefaults());

        httpSecurity.authorizeHttpRequests(http -> http.requestMatchers("/api/**").permitAll());
        httpSecurity.authorizeHttpRequests(http -> http.requestMatchers("/api/books").permitAll());
        httpSecurity.authorizeHttpRequests(http -> http.requestMatchers( HttpMethod.POST,"/auth/**").permitAll());
//    httpSecurity.authorizeHttpRequests(http->http.anyRequest().authenticated());

        httpSecurity.authorizeHttpRequests(http -> http.requestMatchers("/api/auth/**")
                .permitAll()
                .anyRequest().authenticated()
        );

        return httpSecurity.build();
    }
}

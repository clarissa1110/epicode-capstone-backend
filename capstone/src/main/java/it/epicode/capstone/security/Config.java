package it.epicode.capstone.security;

import it.epicode.capstone.services.UserService;
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
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import java.util.Arrays;


@Configuration
@EnableWebSecurity(debug = true)
public class Config {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtTool jwtTool, UserService userService) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .cors(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.POST, "/api/auth/register").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/auth/login").permitAll()
                        .anyRequest().authenticated()
                )
                .addFilterBefore(new JwtFilter(jwtTool, userService), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

//    @Bean
//    public SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.formLogin(http -> http.disable());
//        httpSecurity.csrf(http -> http.disable());
//        httpSecurity.sessionManagement(http -> http.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//        httpSecurity.cors(Customizer.withDefaults());
//
//        httpSecurity.authorizeHttpRequests(http -> http.requestMatchers("/api/**").permitAll());
//        httpSecurity.authorizeHttpRequests(http -> http.requestMatchers("/api/books").permitAll());
//        httpSecurity.authorizeHttpRequests(http -> http.requestMatchers( HttpMethod.POST,"/auth/**").permitAll());
////    httpSecurity.authorizeHttpRequests(http->http.anyRequest().authenticated());
//
//        httpSecurity.authorizeHttpRequests(http -> http.requestMatchers("/api/auth/**")
//                .permitAll()
//                .anyRequest().authenticated()
//        );
//
//        return httpSecurity.build();
//    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();

        corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        corsConfiguration.setAllowedHeaders(Arrays.asList("*"));
        corsConfiguration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);

        return source;
    }

//    @Bean
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/api/**")
//                .allowedOrigins("http://localhost:4200")
//                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
//                .allowedHeaders("*")
//                .allowCredentials(true);
//    }

//    public CorsConfigurationSource corsConfigurationSource(){
//        CorsConfiguration corsConfiguration = new CorsConfiguration();
//        corsConfiguration.setAllowedOrigins(List.of("http://localhost:4200"));
//        corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
//        corsConfiguration.setAllowedHeaders(List.of("*"));
//        corsConfiguration.setAllowCredentials(true);
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", corsConfiguration);
//
//        return source;
//    }

}

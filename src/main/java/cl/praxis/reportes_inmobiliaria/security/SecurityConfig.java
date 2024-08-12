package cl.praxis.reportes_inmobiliaria.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.builder()
                        .username("user")
                        .password(passwordEncoder().encode("1234"))
                        .roles("USER")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((requests) -> requests
                    .requestMatchers("/", "/home", "/login").permitAll()  // Permitir acceso sin autenticación
                    .requestMatchers("/api/reports/**").permitAll()  // Permitir acceso a la API sin autenticación
                    .anyRequest().authenticated()  // Requiere autenticación para cualquier otra solicitud

            )
            .formLogin((form) -> form
                    .loginPage("/login")
                    .permitAll()
            )
            .logout(LogoutConfigurer::permitAll)
                .csrf(csrf -> csrf.disable());

        return http.build();
    }
}

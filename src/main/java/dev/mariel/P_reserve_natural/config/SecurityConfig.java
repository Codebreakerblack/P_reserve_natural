package dev.mariel.P_reserve_natural.config;

import static org.springframework.security.config.Customizer.withDefaults;

import dev.mariel.P_reserve_natural.security.JpaUserDetailsService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Value("${api-endpoint:/api}")
    String endpoint;

    private JpaUserDetailsService jpaUserDetailsService;

    public SecurityConfig(JpaUserDetailsService userDetailsService) {
                this.jpaUserDetailsService = userDetailsService;
        }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .cors(withDefaults())
                .csrf(csrf -> csrf.disable())
                .formLogin(form -> form.disable())
                .logout(out -> out
                        .logoutUrl(endpoint + "/logout")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID"))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll() // Consola H2
                        .requestMatchers(endpoint).permitAll() // Punto de inicio público
                        .requestMatchers(HttpMethod.POST, endpoint + "/register").permitAll() // Registro público
                        .requestMatchers(endpoint + "/login").hasAnyRole("USER", "ADMIN") // Usuarios autenticados
                        .requestMatchers(endpoint + "/public").permitAll() // Endpoint público
                        .requestMatchers(endpoint + "/private").hasRole("ADMIN") // Sólo admins
                        .requestMatchers(HttpMethod.GET, endpoint + "/countries").hasAnyRole("USER", "ADMIN") // Lectura
                                                                                                              // países
                        .requestMatchers(HttpMethod.POST, endpoint + "/countries").hasRole("ADMIN") // Creación países
                        .anyRequest().authenticated()) // Todos los demás requieren autenticación
                .userDetailsService(jpaUserDetailsService) // Servicio personalizado para cargar usuarios
                .httpBasic(withDefaults()) // Autenticación básica
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)); // Gestión de sesiones

        http.headers(header -> header.frameOptions(frame -> frame.sameOrigin())); // Permitir H2 en frames

        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

package com.exemplo.meuapp.infrastructure.config.security;

import com.exemplo.meuapp.application.port.in.usuarios.EncontrarUsuariosUseCase;
import com.exemplo.meuapp.common.mapper.UsuariosMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfigurationSource;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    private final EncontrarUsuariosUseCase encontrarUsuariosUseCase;
    private final UsuariosMapper usuariosMapper;
    private final JwtTokenProvider jwtTokenProvider;
    private final CorsConfigurationSource corsConfigurationSource;

    @Autowired
    public SecurityConfig(
            EncontrarUsuariosUseCase encontrarUsuariosUseCase,
            UsuariosMapper usuariosMapper,
            JwtTokenProvider jwtTokenProvider,
            CorsConfigurationSource corsConfigurationSource) {
        this.encontrarUsuariosUseCase = encontrarUsuariosUseCase;
        this.usuariosMapper = usuariosMapper;
        this.corsConfigurationSource = corsConfigurationSource;
        this.jwtTokenProvider = jwtTokenProvider;
    }

@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // seu filtro JWT (se ainda precisar)
        JwtAuthenticationFilter jwtFilter = new JwtAuthenticationFilter(
            encontrarUsuariosUseCase, jwtTokenProvider, usuariosMapper
        );

        http
          .csrf(csrf -> csrf.disable())
          .cors(cors -> cors.configurationSource(corsConfigurationSource))
          .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

          .authorizeHttpRequests(auth -> auth
              // libera endpoint de login tradicional e OAuth2
              .requestMatchers(HttpMethod.POST, "/api/user/**").permitAll()
              .requestMatchers("/api/user/login/**").permitAll()
              .requestMatchers("/api/user/refresh-token",
                               "/api/user/update",
                               "/api/v1/senai/**")
                .authenticated()
              .anyRequest().authenticated()
          )

          .oauth2Login(oauth2 -> oauth2
              // inicia com /api/user/login/{registrationId}
              .authorizationEndpoint(a -> a.baseUri("/api/user/login"))
              // callback: /api/user/login/oauth2/code/{registrationId}
              .redirectionEndpoint(r -> r.baseUri("/api/user/login/oauth2/code/*"))
              // depois do sucesso, vai pra /api/user/login/google/success
              .defaultSuccessUrl("/api/user/login/google/success", true)
          )

          // remove form login HTML, se não quiser
          .formLogin(Customizer.withDefaults())

          // aplica seu filtro JWT antes
          .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}

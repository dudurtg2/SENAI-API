package com.exemplo.meuapp.infrastructure.config.security;


import com.exemplo.meuapp.application.port.in.usuarios.CriarUsuariosUseCase;
import com.exemplo.meuapp.application.port.in.usuarios.EncontrarUsuariosUseCase;
import com.exemplo.meuapp.common.mapper.UsuariosMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
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
import org.springframework.boot.autoconfigure.security.oauth2.client.servlet.OAuth2ClientAutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import jakarta.servlet.http.HttpServletResponse;



@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@EnableAutoConfiguration(exclude = {OAuth2ClientAutoConfiguration.class})
public class SecurityConfig {private final EncontrarUsuariosUseCase encontrarUsuariosUseCase;
    private final UsuariosMapper usuariosMapper;
    private final JwtTokenProvider jwtTokenProvider;
    private final CriarUsuariosUseCase criarUsuariosUseCase;
    private final CorsConfigurationSource corsConfigurationSource;

    @Autowired
    public SecurityConfig(
            EncontrarUsuariosUseCase encontrarUsuariosUseCase,
            UsuariosMapper usuariosMapper,
            JwtTokenProvider jwtTokenProvider,
            CriarUsuariosUseCase criarUsuariosUseCase,
            CorsConfigurationSource corsConfigurationSource) {
        this.encontrarUsuariosUseCase = encontrarUsuariosUseCase;
        this.usuariosMapper = usuariosMapper;
        this.jwtTokenProvider = jwtTokenProvider;
        this.criarUsuariosUseCase = criarUsuariosUseCase;
        this.corsConfigurationSource = corsConfigurationSource;
    }    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http,
                                           JwtTokenProvider tokenProvider) throws Exception {

        JwtAuthenticationFilter jwtFilter = new JwtAuthenticationFilter(encontrarUsuariosUseCase,tokenProvider, usuariosMapper);
          http
                .csrf(csrf -> csrf.disable())
                .cors(cors -> cors.configurationSource(corsConfigurationSource))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .formLogin(form -> form.disable())
                .httpBasic(basic -> basic.disable())
                .logout(logout -> logout.disable())
                .requestCache(cache -> cache.disable())
                .securityContext(context -> context.disable())
                .anonymous(anonymous -> anonymous.disable())
                .rememberMe(rememberMe -> rememberMe.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/user/login", "/api/user/register", "/api/user/test").permitAll()
                        .requestMatchers("/api/user/refresh-token").authenticated()
                        .requestMatchers("/api/user/update").authenticated()
                        .requestMatchers("/api/v1/senai/**").authenticated()
                        .anyRequest().denyAll()
                )
                .exceptionHandling(exceptions -> exceptions
                        .authenticationEntryPoint((request, response, authException) -> {
                            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                            response.setContentType("application/json");
                            response.getWriter().write("{\"error\":\"Unauthorized\",\"message\":\"Authentication required\"}");
                        })
                )
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

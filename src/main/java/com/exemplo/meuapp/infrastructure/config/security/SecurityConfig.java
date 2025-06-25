package com.exemplo.meuapp.infrastructure.config.security;


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

import com.exemplo.meuapp.application.port.in.usuarios.CriarUsuariosUseCase;
import com.exemplo.meuapp.application.port.in.usuarios.EncontrarUsuariosUseCase;
import com.exemplo.meuapp.common.mapper.UsuariosMapper;
import com.exemplo.meuapp.infrastructure.webclient.CustomOAuth2UserService;
import com.exemplo.meuapp.infrastructure.webclient.CustomUserDetailsService;



@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    private EncontrarUsuariosUseCase encontrarUsuariosUseCase;
    private UsuariosMapper usuariosMapper;
    private JwtTokenProvider jwtTokenProvider;
    private CriarUsuariosUseCase criarUsuariosUseCase;

    @Autowired
    public SecurityConfig(
            EncontrarUsuariosUseCase encontrarUsuariosUseCase,
            UsuariosMapper usuariosMapper,
            JwtTokenProvider jwtTokenProvider,
            CriarUsuariosUseCase criarUsuariosUseCase) {
        this.encontrarUsuariosUseCase = encontrarUsuariosUseCase;
        this.usuariosMapper = usuariosMapper;
        this.jwtTokenProvider = jwtTokenProvider;
        this.criarUsuariosUseCase = criarUsuariosUseCase;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http,
                                           JwtTokenProvider tokenProvider,
                                           CustomUserDetailsService uds,
                                           CustomOAuth2UserService oauth2UserService,
                                           OAuth2SuccessHandler successHandler) throws Exception {        JwtAuthenticationFilter jwtFilter = new JwtAuthenticationFilter(encontrarUsuariosUseCase,tokenProvider, usuariosMapper);        
        
        http
                // 🔒 Desabilitar CSRF para APIs REST
                .csrf(csrf -> csrf.disable())
                
                // 🌐 Habilitar CORS
                .cors(cors -> cors.configurationSource(request -> {
                    var corsConfig = new org.springframework.web.cors.CorsConfiguration();
                    corsConfig.setAllowedOriginPatterns(java.util.Arrays.asList("*"));
                    corsConfig.setAllowedMethods(java.util.Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH"));
                    corsConfig.setAllowedHeaders(java.util.Arrays.asList("*"));
                    corsConfig.setAllowCredentials(true);
                    corsConfig.setMaxAge(3600L);
                    return corsConfig;
                }))
                
                // 📊 Configurar sessões como stateless (JWT)
                .sessionManagement(session -> session
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)                ).authorizeHttpRequests(auth -> auth
                        // 🔓 Endpoints públicos de autenticação
                        .requestMatchers("/auth/**", "/oauth2/**").permitAll()
                        .requestMatchers("/api/user/login", "/api/user/register", "/api/user/auth/register").permitAll()
                        .requestMatchers("/login/oauth2/code/google").permitAll()
                        
                        // 📚 Endpoints públicos do Swagger/OpenAPI
                        .requestMatchers("/swagger-ui/**", "/swagger-ui.html").permitAll()
                        .requestMatchers("/api-docs/**", "/api-docs").permitAll()
                        .requestMatchers("/v3/api-docs/**", "/v3/api-docs").permitAll()
                        .requestMatchers("/swagger-resources/**").permitAll()
                        .requestMatchers("/webjars/**").permitAll()
                          // 🧪 Endpoints de demonstração (públicos)
                        .requestMatchers("/api/v1/demo/**").permitAll()
                        
                        // 👁️ Endpoints públicos para visitantes (limitados)
                        .requestMatchers("/api/v1/senai/projeto/findAll").permitAll()
                        .requestMatchers("/api/v1/senai/projeto/findByUUID/**").permitAll()
                        .requestMatchers("/api/v1/senai/disciplina/findAll").permitAll()
                        .requestMatchers("/api/v1/senai/unidadeCurricular/findAll").permitAll()
                        
                        // 🔒 Endpoints que precisam de autenticação
                        .requestMatchers("/api/user/refresh-token").authenticated()
                        .requestMatchers("/api/user/update").authenticated()
                        .requestMatchers("/api/v1/senai/**").authenticated()
                        
                        // 🔒 Todos os outros precisam de autenticação
                        .anyRequest().authenticated()
                )
                .oauth2Login(oauth2 -> oauth2
                        .userInfoEndpoint(u -> u.userService(oauth2UserService))
                        .successHandler(successHandler)
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

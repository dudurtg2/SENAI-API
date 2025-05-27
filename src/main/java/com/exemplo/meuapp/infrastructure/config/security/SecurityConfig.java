package com.exemplo.meuapp.infrastructure.config.security;


import com.exemplo.meuapp.application.port.in.usuarios.CriarUsuariosUseCase;
import com.exemplo.meuapp.application.port.in.usuarios.EncontrarUsuariosUseCase;
import com.exemplo.meuapp.common.mapper.UsuariosMapper;
import com.exemplo.meuapp.infrastructure.webclient.CustomOAuth2UserService;
import com.exemplo.meuapp.infrastructure.webclient.CustomUserDetailsService;
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
                                           OAuth2SuccessHandler successHandler) throws Exception {

        JwtAuthenticationFilter jwtFilter = new JwtAuthenticationFilter(encontrarUsuariosUseCase,tokenProvider, usuariosMapper);

        http
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/**", "/oauth2/**").permitAll()
                        .requestMatchers("/api/user/login", "/api/user/register").permitAll()
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

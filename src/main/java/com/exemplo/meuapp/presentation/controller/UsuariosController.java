package com.exemplo.meuapp.presentation.controller;

import com.exemplo.meuapp.application.port.in.usuarios.AtualizarUsuariosUseCase;
import com.exemplo.meuapp.application.port.in.usuarios.CriarUsuariosUseCase;
import com.exemplo.meuapp.application.port.in.usuarios.EncontrarUsuariosUseCase;
import com.exemplo.meuapp.common.mapper.UsuariosMapper;
import com.exemplo.meuapp.domain.model.Usuarios;
import com.exemplo.meuapp.infrastructure.config.security.JwtTokenProvider;
import com.exemplo.meuapp.infrastructure.persistence.entity.UsuariosEntity;
import com.exemplo.meuapp.infrastructure.webclient.CollectEmailForTokenService;
import com.exemplo.meuapp.presentation.dto.AuthorizationDTO;
import com.exemplo.meuapp.presentation.dto.LoginResponseDTO;
import com.exemplo.meuapp.presentation.dto.NovoPerfil;
import com.exemplo.meuapp.presentation.dto.PerfilUsuario;
import com.exemplo.meuapp.presentation.dto.TokenUpdateDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.token.TokenService;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.*;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.context.annotation.RequestScope;

import java.util.UUID;

@RestController
@RequestScope
@CrossOrigin
@RequestMapping("/api/user")
public class UsuariosController {

    private final CriarUsuariosUseCase criarUsuariosUseCase;
    private final EncontrarUsuariosUseCase encontrarUsuariosUseCase;
    private final AtualizarUsuariosUseCase atualizarUsuariosUseCase;

    private final UsuariosMapper usuariosMapper;
    private final AuthenticationManager authenticationManager;

    private JwtTokenProvider jwtTokenProvider;
    private CollectEmailForTokenService collectEmailForTokenService;

    @Autowired
    public UsuariosController(CriarUsuariosUseCase criarUsuariosUseCase,
                              EncontrarUsuariosUseCase encontrarUsuariosUseCase,
                              UsuariosMapper usuariosMapper,
                              AuthenticationManager authenticationManager,
                              JwtTokenProvider jwtTokenProvider,
                              CollectEmailForTokenService collectEmailForTokenService,
                              AtualizarUsuariosUseCase atualizarUsuariosUseCase) {
        this.criarUsuariosUseCase = criarUsuariosUseCase;
        this.atualizarUsuariosUseCase = atualizarUsuariosUseCase;
        this.collectEmailForTokenService = collectEmailForTokenService;
        this.encontrarUsuariosUseCase = encontrarUsuariosUseCase;
        this.usuariosMapper = usuariosMapper;
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
    }
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody NovoPerfil data) {

         Usuarios usuarios = criarUsuariosUseCase.criar(data);

        return ResponseEntity.ok(
                jwtTokenProvider.generateTokens(
                        encontrarUsuariosUseCase.buscarPorEmail(
                                data.email()
                        )
                )
        );

    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthorizationDTO data) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(data.login(), data.senha())
            );
            return ResponseEntity.ok(
                    jwtTokenProvider.generateTokens(
                                    encontrarUsuariosUseCase.buscarPorEmail(
                                            data.login()
                                    )
                    )
            );

        } catch (Exception e) {
            return ResponseEntity.status(401).body("Credenciais inválidas ou autenticação falhou.");
        }
    }

    @GetMapping("/login/google")
    public void loginGoogle(@AuthenticationPrincipal OidcUser user) {
    }


    @GetMapping("/online")
    public ResponseEntity<?> online() {
        return ResponseEntity.ok("Usuário online");
    }


    @PostMapping("/refresh-token")
    public ResponseEntity<?> refreshToken(@RequestBody TokenUpdateDTO refreshTokenRequest) {

        String login = jwtTokenProvider.validateRefreshToken(refreshTokenRequest.token());
        if (login == null) {
            return ResponseEntity.status(401).body("Refresh Token inválido ou expirado.");
        }

        PerfilUsuario user = encontrarUsuariosUseCase.buscarPorEmail(login);

        return ResponseEntity
                .ok(new TokenUpdateDTO(jwtTokenProvider.generateAccessToken(user)));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody NovoPerfil user, HttpServletRequest request) {
        try {
            UUID uuid = encontrarUsuariosUseCase.buscarPorEmailUser(collectEmailForTokenService.execute(request)).getUuid();
            Usuarios updatedUser = atualizarUsuariosUseCase.atualizar(uuid, usuariosMapper.toDomain(user));
            return ResponseEntity.ok(updatedUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao atualizar usuário: " + e.getMessage());
        }
    }


}
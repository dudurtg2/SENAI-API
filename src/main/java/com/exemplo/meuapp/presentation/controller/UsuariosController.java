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
    @GetMapping("/test")
    public ResponseEntity<?> test() {
        System.out.println("Endpoint de teste chamado com sucesso!");
        return ResponseEntity.ok("Test endpoint working!");
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

    }    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthorizationDTO data) {
        System.out.println("=== INÍCIO DO LOGIN ===");
        System.out.println("Email recebido: " + data.login());
        System.out.println("Senha recebida: " + data.senha());
        
        try {
            // Verificar se o usuário existe no banco
            var usuario = encontrarUsuariosUseCase.buscarPorEmailUser(data.login());
            if (usuario == null) {
                System.out.println("❌ Usuário não encontrado no banco de dados");
                return ResponseEntity.status(401).body("Usuário não encontrado.");
            }
            
            System.out.println("✅ Usuário encontrado:");
            System.out.println("   UUID: " + usuario.getUuid());
            System.out.println("   Email: " + usuario.getEmail());
            System.out.println("   Tipo: " + usuario.getTipo());
            System.out.println("   Status: " + usuario.getStatus());
            System.out.println("   Senha completa no banco: " + usuario.getSenha());
            System.out.println("   Senha é BCrypt? " + (usuario.getSenha().startsWith("$2a$") ? "SIM" : "NÃO"));
            
            // Testar se a senha BCrypt funciona manualmente
            org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder encoder = 
                new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder();
            boolean senhaCorreta = encoder.matches(data.senha(), usuario.getSenha());
            System.out.println("🔐 Teste manual BCrypt: " + (senhaCorreta ? "✅ SENHA CORRETA" : "❌ SENHA INCORRETA"));
            
            System.out.println("🔐 Tentando autenticar com AuthenticationManager...");
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(data.login(), data.senha())
            );
            
            System.out.println("✅ Autenticação bem-sucedida, gerando tokens...");
            var tokens = jwtTokenProvider.generateTokens(
                    encontrarUsuariosUseCase.buscarPorEmail(data.login())
            );
            
            System.out.println("✅ Tokens gerados com sucesso");
            return ResponseEntity.ok(tokens);

        } catch (Exception e) {
            System.out.println("❌ Erro na autenticação:");
            System.out.println("   Tipo do erro: " + e.getClass().getSimpleName());
            System.out.println("   Mensagem: " + e.getMessage());
            if (e.getCause() != null) {
                System.out.println("   Causa: " + e.getCause().getMessage());
            }
            
            // Stack trace mais detalhado
            System.out.println("   Stack trace:");
            for (StackTraceElement element : e.getStackTrace()) {
                if (element.getClassName().contains("security") || 
                    element.getClassName().contains("authentication") ||
                    element.getClassName().contains("password")) {
                    System.out.println("     " + element);
                }
            }
            
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
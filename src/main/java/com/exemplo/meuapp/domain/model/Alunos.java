package com.exemplo.meuapp.domain.model;

import com.exemplo.meuapp.domain.enums.UsuariosStatus;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class Alunos {
   private String id;
   private Usuarios usariosId;
   private String matricula;
   private String curso;
   private String telefonePessoal;
   private String telefoneProfissional;
   private String linkedin;
   private Endereco endereco;
   private UsuariosStatus status;
   private LocalDateTime criadoEm;
   private LocalDateTime atualizadoEm;

}

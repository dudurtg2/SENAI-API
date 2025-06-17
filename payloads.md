# Payloads de Exemplo

## Endereco

```json
{
  "cep": "01001-000",
  "logradouro": "Praça da Sé",
  "numero": 100,
  "complemento": "Apto 1",
  "bairro": "Sé",
  "cidade": "São Paulo",
  "estado": "SP",
  "pais": "Brasil"
}
```

```json
{
  "cep": "20040-002",
  "logradouro": "Rua Primeiro de Março",
  "numero": 50,
  "complemento": "Sala 10",
  "bairro": "Centro",
  "cidade": "Rio de Janeiro",
  "estado": "RJ",
  "pais": "Brasil"
}
```

---

## Usuarios

```json
{
  "usuario": "jose.aluno",
  "senha": "SenhaSegura123!",
  "email": "jose.aluno@exemplo.com",
  "tipo": "ALUNO",
  "status": "ATIVO"
}
```

```json
{
  "usuario": "maria.prof",
  "senha": "Prof@2025",
  "email": "maria.prof@exemplo.com",
  "tipo": "PROFESSOR",
  "status": "INATIVO"
}
```

---

## Curso

```json
{
  "nome": "Engenharia de Software",
  "descricao": "Aborda metodologias ágeis, arquitetura e testes",
  "cargaHoraria": "120h"
}
```

```json
{
  "nome": "Banco de Dados",
  "descricao": "Modelagem relacional e NoSQL",
  "cargaHoraria": "80h"
}
```

---

## Disciplina

```json
{
  "nome": "Estruturas de Dados",
  "descricao": "Listas, pilhas, filas e árvores",
  "cargaHoraria": "60h",
  "professor": { "uuid": "11111111-1111-1111-1111-111111111111" },
  "curso":     { "uuid": "22222222-2222-2222-2222-222222222222" }
}
```

```json
{
  "nome": "Programação Orientada a Objetos",
  "descricao": "Conceitos de classes, herança e polimorfismo",
  "cargaHoraria": "70h",
  "professor": { "uuid": "33333333-3333-3333-3333-333333333333" },
  "curso":     { "uuid": "44444444-4444-4444-4444-444444444444" }
}
```

---

## Professores

```json
{
  "usuarios":             { "uuid": "55555555-5555-5555-5555-555555555555" },
  "especialidade":        "Sistemas Embarcados",
  "departamento":         "Eletrônica",
  "telefonePessoal":      "11988887777",
  "telefoneProfissional": "11333334444",
  "linkedin":             "https://linkedin.com/in/prof-eletronica",
  "endereco":             { "uuid": "11111111-1111-1111-1111-111111111111" },
  "status":               "ATIVO"
}
```

```json
{
  "usuarios":             { "uuid": "66666666-6666-6666-6666-666666666666" },
  "especialidade":        "Engenharia de Software",
  "departamento":         "Computação",
  "telefonePessoal":      "21977776666",
  "telefoneProfissional": "21333335555",
  "linkedin":             "https://linkedin.com/in/prof-software",
  "endereco":             { "uuid": "20000000-2000-2000-2000-200000000000" },
  "status":               "INATIVO"
}
```

---

## Anexo

```json
{
  "etapa":      { "uuid": "44444444-4444-4444-4444-444444444444" },
  "nomeArquivo":"plano_teste.pdf",
  "url":        "https://storage.exemplo.com/anexos/plano_teste.pdf",
  "tipo":       "DOCUMENTO"
}
```

```json
{
  "etapa":      { "uuid": "55555555-5555-5555-5555-555555555555" },
  "nomeArquivo":"diagrama.png",
  "url":        "https://storage.exemplo.com/anexos/diagrama.png",
  "tipo":       "IMAGEM"
}
```

---

## Alunos

```json
{
  "usuarios":             { "uuid": "77777777-7777-7777-7777-777777777777" },
  "matricula":            "2025-1001",
  "curso":                "Engenharia",
  "telefonePessoal":      "11966665555",
  "telefoneProfissional": "11333336666",
  "linkedin":             "https://linkedin.com/in/aluno-eng",
  "endereco":             { "uuid": "11111111-1111-1111-1111-111111111111" },
  "status":               "ATIVO"
}
```

```json
{
  "usuarios":             { "uuid": "88888888-8888-8888-8888-888888888888" },
  "matricula":            "2025-1002",
  "curso":                "Banco de Dados",
  "telefonePessoal":      "21955554444",
  "telefoneProfissional": "21333334444",
  "linkedin":             "https://linkedin.com/in/aluno-db",
  "endereco":             { "uuid": "20000000-2000-2000-2000-200000000000" },
  "status":               "INATIVO"
}
```

---

## Projeto

```json
{
  "titulo":        "Sistema de Gerenciamento de Biblioteca",
  "descricao":     "App para catalogar e emprestar livros",
  "turma":         "Turma A",
  "bannerUrl":     "https://img.exemplo.com/banner-lib.png",
  "codigo":        "PROJ-BIB-2025",
  "disciplina":    { "uuid": "11112222-3333-4444-5555-666677778888" },
  "lider":         { "uuid": "77777777-7777-7777-7777-777777777777" },
  "labMaker":      true,
  "participouSaga":false,
  "itinerario":    false,
  "visibilidade":  "PUBLICO",
  "status":        "EM_ANDAMENTO"
}
```

```json
{
  "titulo":        "Portal de E-commerce",
  "descricao":     "Loja online com carrinho de compras",
  "turma":         "Turma B",
  "bannerUrl":     "https://img.exemplo.com/banner-ecom.png",
  "codigo":        "PROJ-ECOM-2025",
  "disciplina":    { "uuid": "99990000-aaaa-bbbb-cccc-ddddeeeeffff" },
  "lider":         { "uuid": "88888888-8888-8888-8888-888888888888" },
  "labMaker":      false,
  "participouSaga":true,
  "itinerario":    true,
  "visibilidade":  "PRIVADO",
  "status":        "FINALIZADO"
}
```

---

## EtapasProjeto

```json
{
  "projeto":   { "uuid": "11112222-3333-4444-5555-666677778888" },
  "nomeEtapa": "Levantamento de Requisitos",
  "descricao": "Entrevistas e levantamento de expectativas",
  "ordem":     1,
  "status":    "PENDENTE"
}
```

```json
{
  "projeto":   { "uuid": "11112222-3333-4444-5555-666677778888" },
  "nomeEtapa": "Desenvolvimento",
  "descricao": "Implementação das funcionalidades",
  "ordem":     2,
  "status":    "CONCLUIDA"
}
```

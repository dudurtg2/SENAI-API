# Endpoints da API

## Usuários (`UsuariosController.java`)
Base: `/api/user`
- **POST** `/api/user/login`
- **GET**  `/api/user/login/google`
- **GET**  `/api/user/online`
- **POST** `/api/user/refresh-token`
- **PUT**  `/api/user/update`

## Endereço (`EnderecoController.java`)
Base: `/api/v1/senai/endereco`
- **POST**   `/api/v1/senai/endereco/create`
- **GET**    `/api/v1/senai/endereco/findAll`
- **GET**    `/api/v1/senai/endereco/findByUUID/{uuid}`
- **PUT**    `/api/v1/senai/endereco/update/{uuid}`
- **DELETE** `/api/v1/senai/endereco/delete/{uuid}`

## Projeto (`ProjetoController.java`)
Base: `/api/v1/senai/projeto`
- **POST**   `/api/v1/senai/projeto/create`
- **GET**    `/api/v1/senai/projeto/findAll`
- **GET**    `/api/v1/senai/projeto/findByUUID/{uuid}`
- **PUT**    `/api/v1/senai/projeto/update/{uuid}`
- **DELETE** `/api/v1/senai/projeto/delete/{uuid}`
- **GET**    `/api/v1/senai/projeto/findByTitulo/{titulo}`
- **GET**    `/api/v1/senai/projeto/findByStatus/{status}`
- **GET**    `/api/v1/senai/projeto/findByCurso/{curso}`
- **GET**    `/api/v1/senai/projeto/findByTurma/{turma}`
- **GET**    `/api/v1/senai/projeto/findByLiderProjeto/{liderProjeto}`
- **GET**    `/api/v1/senai/projeto/findByrUnidadeCurricular/{unidadeCurricular}`

## Disciplina (`DisciplinaController.java`)
Base: `/api/v1/senai/disciplina`
- **POST**   `/api/v1/senai/disciplina/create`
- **GET**    `/api/v1/senai/disciplina/findAll`
- **GET**    `/api/v1/senai/disciplina/findByUUID/{uuid}`
- **PUT**    `/api/v1/senai/disciplina/update/{uuid}`
- **DELETE** `/api/v1/senai/disciplina/delete/{uuid}`
- **GET**    `/api/v1/senai/disciplina/findByNome/{nome}`

## Curso (`CursoController.java`)
Base: `/api/v1/senai/Curso`
- **POST**   `/api/v1/senai/Curso/create`
- **GET**    `/api/v1/senai/Curso/findAll`
- **GET**    `/api/v1/senai/Curso/findByUUID/{uuid}`
- **PUT**    `/api/v1/senai/Curso/update/{uuid}`
- **DELETE** `/api/v1/senai/Curso/delete/{uuid}`
- **GET**    `/api/v1/senai/Curso/findByNome/{nome}`

## Anexo de Etapa (`AnexoEtapaController.java`)
Base: `/api/v1/senai/AnexoEtapa`
- **POST**   `/api/v1/senai/AnexoEtapa/create`
- **GET**    `/api/v1/senai/AnexoEtapa/findAll`
- **GET**    `/api/v1/senai/AnexoEtapa/findByUUID/{uuid}`
- **PUT**    `/api/v1/senai/AnexoEtapa/update/{uuid}`
- **DELETE** `/api/v1/senai/AnexoEtapa/delete/{uuid}`
- **GET**    `/api/v1/senai/AnexoEtapa/findByEtapa/{etapa_uuid}`
- **GET**    `/api/v1/senai/AnexoEtapa/findByEtapaETipo/{etapa_uuid}/{tipo}`

## Alunos (`AlunosController.java`)
Base: `/api/v1/senai/alunos`
- **POST**   `/api/v1/senai/alunos/create`
- **GET**    `/api/v1/senai/alunos/findAll`
- **GET**    `/api/v1/senai/alunos/findByUUID/{uuid}`
- **PUT**    `/api/v1/senai/alunos/update/{uuid}`
- **DELETE** `/api/v1/senai/alunos/delete/{uuid}`
- **GET**    `/api/v1/senai/alunos/findByMatricula/{matricula}`

## Professor (`ProfessorController.java`)
Base: `/api/v1/senai/professor`
- **POST**   `/api/v1/senai/professor/create`
- **GET**    `/api/v1/senai/professor/findAll`
- **GET**    `/api/v1/senai/professor/findByUUID/{uuid}`
- **PUT**    `/api/v1/senai/professor/update/{uuid}`
- **DELETE** `/api/v1/senai/professor/delete/{uuid}`
- **GET**    `/api/v1/senai/professor/findByUsuario/{usuario}`
- **GET**    `/api/v1/senai/professor/findByDepartamento/{departamento}`
- **GET**    `/api/v1/senai/professor/findByStatus/{status}`

## Etapas do Projeto (`EtapasProjetoController.java`)
Base: `/api/v1/senai/etapasProjeto`
- **POST**   `/api/v1/senai/etapasProjeto/create`
- **GET**    `/api/v1/senai/etapasProjeto/findAll`
- **GET**    `/api/v1/senai/etapasProjeto/findByUUID/{uuid}`
- **PUT**    `/api/v1/senai/etapasProjeto/update/{uuid}`
- **DELETE** `/api/v1/senai/etapasProjeto/delete/{uuid}`
- **GET**    `/api/v1/senai/etapasProjeto/findByProjeto/{projeto}`
- **GET**    `/api/v1/senai/etapasProjeto/findByStatus/{status}`

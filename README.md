# Estudo - JPAStream

Aplicação de estudo do JPAStream


## Rodando a aplicação em modo desenvolvedor

Você pode executar a aplicação em modo desenvolvedor que abilita o uso de "live coding":
```shell script
./mvn compile quarkus:dev
```
Para testar o funcionamento da aplicação, recomendo utilizar alguma ferramenta que realize requisições Http como o insomnia ou postman

NOTE: Na raiz do projeto tem uma collection para teste chamada **preparacao-jpastream-collection.json**


> **_NOTE:_**  Agora o quarkus disponibiliza a Dev UI no modo desenvolvedor em http://localhost:8080/q/dev/.

## Entidades do projeto

### Aluno
- Id
- Nome
- idade
- Curso

### Nota
- Aluno
- Materia
- data
- valor

## Extensões utilizadas
- Hibernate ORM
- JDBC Driver - PostgreSQL
- JPAStreamer
- Resteasy Reactive
- Resteasy Reactive jakcson

## Etapas do desenvolvimento
- [Iniciar banco de dados com docker](https://www.youtube.com/watch?v=GXEatIJ2hXc)
- Configurar conexão com o banco
- Escrever o service
- Escrever o controller
- Escrever entities
- Escrever a collection no insomnia


## Canal do youtube
[@FlavioDiminuto](https://www.youtube.com/@flaviodiminuto)
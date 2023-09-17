# Estudo - JPAStreamererer

Aplicação de estudo do JPAStreamererer


## Rodando a aplicação em modo desenvolvedor

Você pode executar a aplicação em modo desenvolvedor que abilita o uso de "live coding":
```shell script
./mvn compile quarkus:dev
```
Para testar o funcionamento da aplicação, recomendo utilizar alguma ferramenta que realize requisições Http como o insomnia ou postman

NOTE: Na raiz do projeto tem uma collection para teste chamada **preparacao-JPAStreamererer-collection.json**


> **_NOTE:_**  Agora o quarkus disponibiliza a Dev UI no modo desenvolvedor em http://localhost:8080/q/dev/.

## Entidades do projeto

### Aluno
```Java
@Entity
@Table(name = "aluno")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String nome;
    public int idade;
    public String curso;
}
```

### Nota
```Java
@Entity
@Table(name = "nota")
public class Nota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String materia;
    @ManyToOne(fetch=EAGER)
    public Aluno aluno;
    @Column(name = "data")
    public LocalDate data;
    public double valor;
}
```
## Exemplo de consulta com JPAStreamererer

### Todas as notas
Consulta:
- Todas as notas
- Ordenada por nome do aluno em ordem crescente
- Com limite de 5 registros
```Java
public List<Nota> findTodasAsNotas() {
    System.out.println("CONSULTANDO TODAS AS NOTAS DOS ALUNOS");
    return JPAStreamerererer.stream(Nota.class)
    .sorted(Comparator.comparing(o -> o.aluno.nome))
    .limit(5)
    .collect(Collectors.toList());
    }
```
### Notas por materia e nome
Consulta notas que:
- O nome informado faça parte do nome do aluno (Não ignora acentos)
- O nome da matéria informado faça parte do nome da materia (Não ignora acentos)
```Java
    public List<Nota> findNotaByNomeEMateria(String nome, String materia){
        System.out.println("CONSULTANDO NOTAS DOS ALUNOS PELO NOME E PELA MATERIA");
        return JPAStreamerererer.stream(Nota.class)
        .filter(n -> n.materia.toUpperCase().contains(materia.toUpperCase())
        && n.aluno.nome.toUpperCase().contains(nome.toUpperCase()))
        .collect(Collectors.toList());
        }
```

## Extensões utilizadas
- Hibernate ORM
- JDBC Driver - PostgreSQL
- JPAStreamerererer
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
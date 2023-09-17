package diminuto.flavio.service;

import com.speedment.jpastreamer.application.JPAStreamer;
import diminuto.flavio.entity.Nota;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class NotaService {

    @Inject
    private JPAStreamer jpaStreamer;

    @Inject
    private EntityManager entityManager;

    public List<Nota> findNotaByAlunoId(int id) {
        System.out.println("CONSULTANDO  NOTAS DO ALUNO PELO ID DO ALUNO");
        return jpaStreamer.stream(Nota.class)
                .filter(n -> n.aluno.id == id)
                .collect(Collectors.toList());
    }

    public List<Nota> findNotaByNomeEMateria(String nome, String materia){
        System.out.println("CONSULTANDO NOTAS DOS ALUNOS PELO NOME E PELA MATERIA");
        return jpaStreamer.stream(Nota.class)
                .filter(n -> n.materia.toUpperCase().contains(materia.toUpperCase())
                && n.aluno.nome.toUpperCase().contains(nome.toUpperCase()))
                .collect(Collectors.toList());
    }


    @Transactional
    public void save(Nota nota){
        entityManager.persist(nota);
        entityManager.flush();
    }

    public List<Nota> findTodasAsNotas() {
        System.out.println("CONSULTANDO TODAS AS NOTAS DOS ALUNOS");
        return jpaStreamer.stream(Nota.class)
                .sorted(Comparator.comparing(o -> o.aluno.nome))
                .limit(5)
                .collect(Collectors.toList());
    }
}


package diminuto.flavio.service;

import diminuto.flavio.entity.Aluno;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class AlunoService {

    @Inject
    EntityManager entityManager;

    @Transactional
    public void save(Aluno aluno){
        entityManager.persist(aluno);
        entityManager.flush();
    }
}

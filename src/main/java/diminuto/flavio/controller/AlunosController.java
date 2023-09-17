package diminuto.flavio.controller;

import diminuto.flavio.entity.Aluno;
import diminuto.flavio.service.AlunoService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/alunos")
public class AlunosController {

    @Inject
    private AlunoService alunoService;

    @POST
    @Transactional
    public Response saveAluno(Aluno aluno){
        alunoService.save(aluno);

        return Response.ok(aluno).build();
    }
}

package diminuto.flavio.controller;

import diminuto.flavio.entity.Aluno;
import diminuto.flavio.entity.Nota;
import diminuto.flavio.service.AlunoService;
import diminuto.flavio.service.NotaService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Path("/notas")
public class NotasController {

    @Inject
    private NotaService notaService;

    @POST
    @Transactional
    public Response saveNota(Nota nota){
        notaService.save(nota);
        return Response.ok(nota).build();
    }

    @GET
    @Path("/{id_aluno}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNotas(@PathParam("id_aluno") int idAluno) {
        List<Nota> notas = notaService.findNotaByAlunoId(idAluno);
        return !notas.isEmpty()
                ? Response.ok(notas).build() :
                Response.status(Response.Status.NOT_FOUND).build();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response get(
            @QueryParam("nome") String nome,
            @QueryParam("materia") String materia) {

        List<Nota> notas;
        if(nome != null && materia != null)
            notas = notaService.findNotaByNomeEMateria(nome, materia);
        else
            notas = notaService.findTodasAsNotas();

        return !notas.isEmpty()
                ? Response.ok(notas).build() :
                Response.status(Response.Status.NO_CONTENT).build();
    }
}

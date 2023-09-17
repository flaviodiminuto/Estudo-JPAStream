package diminuto.flavio.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

import static jakarta.persistence.FetchType.EAGER;

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

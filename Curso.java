import java.util.ArrayList;
import java.util.List;

public class Curso {

    int id;
    String nome;
    int cargaHoraria;
    Professor professor;
    List<Aluno> alunos;

    public Curso(int id, String nome, int cargaHoraria, Professor professor) {
        this.id = id;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.professor = professor;
        this.alunos = new ArrayList<>();
        professor.adicionarCurso(this);
    }

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public String exibirCurso() {
        return nome + " ( " + cargaHoraria + "h ) - Prof: " + professor.nome;
    }
}
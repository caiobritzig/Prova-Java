import java.util.ArrayList;
import java.util.List;

public class Professor {
    
    int id;
    String nome;
    String departamento;
    List<Curso> cursos;

    public Professor(int id, String nome, String departamento) {
        this.id = id;
        this.nome = nome;
        this.departamento = departamento;
        this.cursos = new ArrayList<>();
    }

    public void adicionarCurso(Curso curso) {
        cursos.add(curso);
    }

    public String exibirProfessor() {
        return nome + " - " + departamento;
    }
}

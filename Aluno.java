public class Aluno {
    
    int id;
    String nome;
    String dataNascimento;
    String cpf;
    Curso curso;

    public Aluno(int id, String nome, String dataNascimento, String cpf, Curso curso) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.curso = curso;
        curso.adicionarAluno(this);
    }
    public String exibirAluno() {
        return nome + " - Nascido em: " + dataNascimento + " - CPF: " + cpf + " - Curso: " + curso.nome; // Retorna uma string com o nome, data de nascimento, CPF e nome do curso
    }
}
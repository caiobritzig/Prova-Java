import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    static List<Professor> professores = new ArrayList<>();
    static List<Curso> cursos = new ArrayList<>();
    static List<Aluno> alunos = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao = -1; //-1 para evitar erros antes do usuário selecionar a opção desejada
        while (opcao != 0) {
            mostrarMenu();
            opcao = Integer.parseInt(scanner.nextLine()); //é pra converter para inteiro o que o usuário digitou
            if (opcao == 1) cadastrarProfessor();
            else if (opcao == 2) cadastrarCurso();
            else if (opcao == 3) cadastrarAluno();
            else if (opcao == 4) listarProfessores();
            else if (opcao == 5) listarCursos();
            else if (opcao == 6) listarAlunos();
        }
        System.out.println();
        System.out.println("Sistema encerrado.");
    }

    static void mostrarMenu() {
        System.out.println();
        System.out.println("1 - Para Cadastrar o Professor");
        System.out.println("2 - Para Cadastrar o Curso");
        System.out.println("3 - Para Cadastrar o Aluno");
        System.out.println("4 - Para Listar os Professores");
        System.out.println("5 - Para Listar os Cursos");
        System.out.println("6 - Para Listar os Alunos");
        System.out.println("0 - Sair");
        System.out.print("Escolha: ");
    }

    static void cadastrarProfessor() {
        System.out.println();
        System.out.print("ID do professor: ");
        int id = Integer.parseInt(scanner.nextLine());//é pra converter para inteiro o que o usuário digitou
        System.out.print("Nome do professor: ");
        String nome = scanner.nextLine();
        System.out.print("Departamento do professor: ");
        String departamento = scanner.nextLine();
        System.out.println();
        professores.add(new Professor(id, nome, departamento));
    }

    static void cadastrarCurso() {
        System.out.println();
        System.out.print("ID do curso: ");
        int id = Integer.parseInt(scanner.nextLine());//é pra converter para inteiro o que o usuário digitou
        System.out.print("Nome do curso: ");
        String nome = scanner.nextLine();
        System.out.print("Carga Horária do curso: ");
        int cargaHoraria = Integer.parseInt(scanner.nextLine());//é pra converter para inteiro o que o usuário digitou
        System.out.println();

        System.out.println("Selecione o Professor:");
        professores.forEach(p -> System.out.println(p.id + " - " + p.nome));

        int idProfessor = Integer.parseInt(scanner.nextLine());//é pra converter para inteiro o que o usuário digitou
        Professor professor = null;
        for (Professor p : professores) {
            if (p.id == idProfessor) {
                professor = p;
                break;
            }
        }

        if (professor != null) {
            cursos.add(new Curso(id, nome, cargaHoraria, professor));
        } else {
            System.out.println("Professor não encontrado.");
        }
    }

    static void cadastrarAluno() {
        System.out.println();
        System.out.print("ID do aluno: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nome do aluno: ");
        String nome = scanner.nextLine();
        System.out.print("Data de Nascimento (dd-mm-aaaa) do aluno: ");
        String dataNascimento = scanner.nextLine();
        System.out.print("CPF do aluno: ");
        String cpf = scanner.nextLine();
        System.out.println();

        System.out.println("Selecione o Curso:");
        cursos.forEach(c -> System.out.println(c.id + " - " + c.nome));

        int idCurso = Integer.parseInt(scanner.nextLine());//é pra converter para inteiro o que o usuário digitou
        Curso curso = null;
        for (Curso c : cursos) {
            if (c.id == idCurso) {
                curso = c;
                break;
            }
        }

        if (curso != null) {
            alunos.add(new Aluno(id, nome, dataNascimento, cpf, curso));
        } else {
            System.out.println("Curso não encontrado.");
        }
    }

    static void listarProfessores() {
        System.out.println();
        System.out.println("Professores:");
        professores.forEach(p -> {
            System.out.println(p.exibirProfessor());
            System.out.println("Cursos:");
            for (Curso curso : p.cursos) {
                System.out.println(curso.nome + " - Alunos: " + curso.alunos.size());
            }
            System.out.println();
        });
    }

    static void listarCursos() {
        System.out.println();
        System.out.println("Cursos:");
        cursos.forEach(c -> {
            System.out.println(c.exibirCurso());
        });
    }

    static void listarAlunos() {
        System.out.println();
        System.out.println("Alunos:");
        alunos.forEach(a -> {
            System.out.println(a.exibirAluno());
        });
    }
}

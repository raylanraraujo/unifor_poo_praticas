import java.util.List;
import java.util.ArrayList;

public class Turma {
    // atributos
    private String codigo;
    private Disciplina disciplina;
    private Professor professor;
    private List<Aluno> alunos;

    // construtor
    public Turma(String codigo, Disciplina disciplina, Professor professor) {
        this.codigo = codigo;
        this.disciplina = disciplina;
        this.professor = professor;
        this.alunos = new ArrayList<>();
    }

    // getters e setters
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public Disciplina getDisciplina() { return disciplina; }
    public void setDisciplina(Disciplina disciplina) { this.disciplina = disciplina; }

    public Professor getProfessor() { return professor; }
    public void setProfessor(Professor professor) { this.professor = professor; }

    public List<Aluno> getAlunos() { return alunos; }
    public void setAlunos(List<Aluno> alunos) { this.alunos = alunos; }

    // métodos próprios
    public void adicionaAluno( Aluno aluno ){
        alunos.add(aluno);
    }

    public void removerAluno( Aluno aluno ){
        alunos.remove(aluno);
    }
    
    public List<Aluno> listarAlunos(){
        return new ArrayList<>(alunos);
    }

    // método para mostrar na tela
    @Override
    public String toString() {
        return "Turma: " + codigo +
               " | Disciplina: " + disciplina.getNome() +
               " | Professor: " + professor.getNome() +
               " | Alunos: " + listarAlunos();
    }

    
}
import java.util.List;
import java.util.ArrayList;

public class Turma {
    //atributos
    private int codigo;
    private Disciplina disciplina;
    private Professor professor;
    private List<Aluno> alunos;

    //construtor
    public Turma(int codigo, Disciplina disciplina, Professor professor){
        this.codigo = codigo;
        this.disciplina = disciplina;
        this.professor = professor;
        this.alunos = new ArrayList<>();
    }
    
    //metodos getters e setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    //metodos proprios
    public void adicionarAluno(){
        
    }

    @Override
    public String toString() {
        return "Turma [codigo=" + codigo + ", disciplina=" + disciplina + ", professor=" + professor + ", alunos="
                + alunos + "]";
    }
    
}

public class Aluno extends Pessoa {
    // atributos
    private String matricula;

    // construtor
    public Aluno(String nome, String cpf, int idade, String matricula) {
        super(nome, cpf, idade); 
        this.matricula = matricula;
    }

    // getters e setters
    public String getMatricula () { return matricula; }
    public void setMatricula(String matricula){ this.matricula = matricula;}

    // método próprio
    public void pagarMensalidade(){ 
        System.out.println(getNome() + " pagou a mensalidade integral.");
    }

    // método pra mostrar o nome do aluno
    @Override
    public String toString(){
        return getNome();
    } 
}
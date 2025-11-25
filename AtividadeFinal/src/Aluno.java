public class Aluno extends Pessoa{
    //atributos
    private int matricula;

    //construtor
    public Aluno(int cpf, String nome, int idade, int matricula){
        super(cpf, nome, matricula);
        this.matricula = matricula;
    }

    //metodos getters e setters
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
    
    //metodos proprios
    public void pagarMensalidade(){
        System.out.println("Pagando mensalidade");
    }
}

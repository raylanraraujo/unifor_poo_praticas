public class Professor extends Pessoa{
    //atributos
    private String centro;

    //construtor
    public Professor(int cpf, String nome, int idade, String centro){
        super(cpf, nome, idade);
        this.centro = centro;
    }
    
    //metodos getters e setters
    public String getCentro() {
        return centro;
    }

    public void setCentro(String centro) {
        this.centro = centro;
    }

    //metodos próprios
    public void darAula(){
        System.out.println("Ministrando aula.");
    }

}

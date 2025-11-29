public class Professor extends Pessoa {
    // atributos
    private String centro;

    // construtor
    public Professor (String nome, String cpf, int idade, String centro){
        super(nome, cpf, idade);
        this.centro = centro;
    }

    // getters e setters
    public String getCentro() { return centro; }
    public void setCentro(String centro) { this.centro = centro; }

    // método próprio
    public void darAula(){
        System.out.println( "O Professor " + getNome() + " começou a aula. ");
    }
}
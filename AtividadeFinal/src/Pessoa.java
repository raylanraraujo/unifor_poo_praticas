public abstract class Pessoa {
    //atributos
    private int cpf;
    private String nome;
    private int idade;

    //metodo construtor
    public Pessoa(int cpf, String nome, int idade){
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
    }

    //métodos getters e setters
    public int getCpf() {
        return cpf;
    }
    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    //métodos próprios
    public void fazerAniversario(){
        this.idade++;
    }   
}

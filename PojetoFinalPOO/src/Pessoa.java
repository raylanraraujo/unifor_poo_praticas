public abstract class Pessoa {
    // atributos
    private String nome;
    private int idade;
    private String cpf;

    // construtor
    public Pessoa(String nome, String cpf, int idade){
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    }
    // getters e setters
    public String getNome() { return this.nome; }
    public void setNome(String nome) { this.nome = nome; }  

    public String getCpf() { return this.cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    
    public int getIdade() { return this.idade; }
    public void setIdade(int idade) { this.idade = idade; }
    
    // métodos próprios - Questão 2
    public void fazerAniversario(){ this.idade++; }
}
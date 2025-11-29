public class Bolsista extends Aluno {
    // construtor
    public Bolsista (String nome, String cpf, int idade, String matricula){
        super(nome, cpf, idade, matricula);
    }

    // método sobrescrito
    @Override
    public void pagarMensalidade(){
        System.out.println(getNome() + " é bolsista e não paga mensalidade.");
    }
}

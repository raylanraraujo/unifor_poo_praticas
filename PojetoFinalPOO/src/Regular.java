public class Regular extends Aluno {
    // construtor
    public Regular (String nome, String cpf, int idade, String matricula){
        super(nome, cpf, idade, matricula);
    }

    // método sobrescrito
    @Override
    public void pagarMensalidade(){
        System.out.println(getNome() + " pagou mensalidade como aluno regular.");
    }
}

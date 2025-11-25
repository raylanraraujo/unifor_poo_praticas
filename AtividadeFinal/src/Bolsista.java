public class Bolsista extends Aluno{
    //construtor
    public Bolsista(int cpf, String nome, int idade, int matricula){
        super(cpf, nome, idade, matricula);
    }

    //metodo proprios
    @Override
    public void pagarMensalidade(){
        System.out.println("Bolsista - pagando mensalidade com desconto.");
    }
}

public class Regular extends Aluno{
    //construtor
    public Regular(int cpf, String nome, int idade, int matricula){
        super(cpf, nome, idade, matricula);
    }

    //método proprio
    @Override
    public void pagarMensalidade(){
        System.out.println("Regular - paga mensalidade com valor cheio.");
    }
}

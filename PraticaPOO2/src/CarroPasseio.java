public class CarroPasseio extends Carro{
    public CarroPasseio(String tipoCombustivel, int velocidadeMaxima) {
        super(tipoCombustivel, velocidadeMaxima);

    }

    public CarroPasseio(String tipoCombustivel, int kilometragem, int velocidadeMaxima) {
        super(tipoCombustivel, kilometragem, velocidadeMaxima);

    }

    public void passear(){
        System.out.println("Passeio de carro");
    }
    
}

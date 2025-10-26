public class CarroEsportivo extends Carro{
    public CarroEsportivo(String tipoCombustivel, int velocidadeMaxima) {
        super(tipoCombustivel, velocidadeMaxima);

    }

    public CarroEsportivo(String tipoCombustivel, int kilometragem, int velocidadeMaxima) {
        super(tipoCombustivel, kilometragem, velocidadeMaxima);
        
    }


    public void turbinar(){
        System.out.println("Carro turbinado");
    }

    public void frear(){ //estamos sobreescrevendo o método da superclassse
        System.out.println("Freio esportivo");
    }
}

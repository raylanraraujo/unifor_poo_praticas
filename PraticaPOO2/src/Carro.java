public class Carro {
    private String tipoCombustivel;
    private int kilometragem;
    private int velocidadeMaxima;


    
    public Carro(String tipoCombustivel, int velocidadeMaxima) {
        this.tipoCombustivel = tipoCombustivel;
        this.velocidadeMaxima = velocidadeMaxima;
    }

    public Carro(String tipoCombustivel, int kilometragem, int velocidadeMaxima) {
        this.tipoCombustivel = tipoCombustivel;
        this.kilometragem = kilometragem;
        this.velocidadeMaxima = velocidadeMaxima;
    }

    public void andar() {
        System.out.println("Anda");
    }

    public void frear(){
        System.out.println("Frea");
    }

    public void ligar(String dono){
        System.out.println("Ligou com o " + dono);
    }


    public void ligar(int hora, int minuto){
        if (hora == 12 && minuto == 00){
            System.out.println("Ligou com o na hora correta");
        }
    }

    public void desligar(){
        System.out.println("Desliga");
    }


    public String getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(String tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    public int getKilometragem() {
        return kilometragem;
    }
    
    public void setKilometragem(int kilometragem) {
        this.kilometragem = kilometragem;
    }

    public int getVelocidadeMaxima() {
        return velocidadeMaxima;
    }

    public void setVelocidadeMaxima(int velocidadeMaxima) {
        this.velocidadeMaxima = velocidadeMaxima;
    }

    @Override
    public String toString() {
        return "Carro [tipoCombustivel= " + tipoCombustivel + ", kilometragem= " + kilometragem + ", velocidadeMaxima= "
                + velocidadeMaxima + "]";
    }

}

/*
 * O método ligar tem um polimorfismo de sobrecarga, pois eu tenho o mesmo comportamento que é de Ligar o Carro, mas quando eu o parametro dono ele vai executar uma determinada ação e quando eu passo com 2 atributos inteiros ( hora e minuto) ele executa uma ação de forma diferente. 
 * 
 */
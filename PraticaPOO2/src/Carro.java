public class Carro {
    public class Car {
        private String tipoCombustivel;
        private int kilometragem;
        private int velocidadeMaxima;

        public void andar() {
            System.out.println("Anda");
        }

        public void frear(){
            System.out.println("Frea");
        }

        public void ligar(){
            System.out.println("Liga");
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
    }
}

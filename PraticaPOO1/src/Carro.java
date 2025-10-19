public class Carro {
   //atributos que um carro tem.
   private int kilometragem;
   private int qtdeCombustivel;
   private String marca;
   private String modelo;

   //agora vamos incluir os comportamentos que um carro faz. para isso temos que criar um método
   public void andar() {
    System.out.println("Andar");
   }

   public void frear(){
    System.out.println("Frear");
   }

   // incluindo os getters e setters
   public int getKilometragem() { //esse método retorna o valor armazenado na variável kilometragem
    return kilometragem;
   }

   public int getQtdeCombustivel() {
    return qtdeCombustivel;
   }

   public String getMarca() {
    return marca;
   }

   public String getModelo() {
    return modelo;
   }


   public void setKilometragem(int kilometragem) { //esse método recebe um valor que eu vou passar e ele alterará a variável kilometragem
    this.kilometragem = kilometragem;
   }

   public void setQtdeCombustivel(int qtdeCombustivel) {
    this.qtdeCombustivel = qtdeCombustivel;
   }

   public void setMarca(String marca) {
    this.marca = marca;
   }

   public void setModelo(String modelo) {
    this.modelo = modelo;
   }
}

/* 
   Nessa pratica vamos exercitar os pilares da orientacao a objetos: abstracao, encapsulamento, heranca e polimorfismo.

   Vamos imaginar um cenário que temos que criar um sistema para uma concessionária. Portanto o que seria util a gente representar um objeto em uma concessionária? Um objeto principal com certeza seria um carro. Entao vamos criar um projeto para criar a representação de um carro. 

   Criado um novo projeto chamado PraticaPOO1.
   Dentro desse projeto, foi criado a classe Carro dentro da pasta SRC, pois é nessa pasta onde ficam os arquivos de código-fonte.

   Primeiro vamos usar do primeiro pilar do POO que é a abstração. Entao vamos extrair agora as caracteristicas e comportamenos  de um carro. Os atributos sao (kilometragem, quantidade de combustivei, marca, modelo). Os métodos (comportamentos) dele são Andar e Frear. 

   Agora vamos trabalhar com o segundo pilar: encapsulamento.
   Quando falamos de encapsulamento, nós estamos falando de guardar e proteger as informaçoes. Para isso alteramos a visibilidade das variáveis (os atributos) definindo-as como privadas. Isso faz com que apenas a classe Carro consegue enxergar os valores dessas variáveis e alterá-las. 
   
   Se outra classe precisar acessar e alterar essas variáveis é que eu terei que ter os métodos getters e setters ( acessores e modificadores). O método Get serve para eu recuperar um valor. E o método Set serve para eu alterar o valor dessa variável. O IDE (nesse caso o VS Code) ele gera de maneira automática para nós. Posso fazer isso de maneira rápida no VS Code. Tenho que clicar com o botão direito do mouse e escolher "Ação de Código". Depois eu coloco para ser gerado os Setters e coloco todas as variáveis que eu desejo. Depois faço a mesma coisa para os Getters
*/
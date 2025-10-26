public class Principal {
    public static void main(String[] args) {
        
        Carro carro = new Carro("Diesel", 2000, 250); //Aqui estamos declarando uma variável com o nome "carro" e ela é do tipo "Carro" e faço a sua instanciação.

        Carro carro2 = new Carro("Etanol", 100);
        //carro.setKilometragem(1000); //preenchendo as informações do carro
        //carro.setTipoCombustivel("Gasolina");
        //carro.setVelocidadeMaxima(200);

        CarroPasseio carroPasseio = new CarroPasseio("Elétrico", 300, 120);

        CarroEsportivo carroEsportivo = new CarroEsportivo("Gasolina", 100, 300);
        
        System.out.println(carro);
        
        System.out.println(carro2); //imprime na tela as informações desejadas se na classe Carro tiver sido criado o método toString()

        //carroEsportivo.ligar(); essa linha foi comentada para tirar o erro do polimorfismo de sobrecarga feita depois
        carroEsportivo.turbinar();
        //carroPasseio.ligar(); 
        carroPasseio.passear();
        carroEsportivo.frear();
    }

}

/*

Criamos uma nova classe chamada "Principal" e a definimos como sendo a classe principal do programa. Ela quem vai atuar como maestro orquestrando todas as outras classes. 

Em seguida declaramos uma variável. 
    
    Carro carro;

    Esta se chama "carro" e ela é do tipo "Carro". Entretanto, com essa variável declarada assim não é possível atribuir valores a essa entidade carro. Para atribuir valores eu tenho que instanciar essa minha classe carro. 

Instanciar é como se eu tivesse pegando esse molde dessa classe Carro em branco, isto é, todos os atributos dela estão em branco, pois eu nao disse nada sobre ele como o tipo de combustivel, a kilometragem nem a velocidade máxima dele. 

Depois de instanciar é que eu faco a inclusao dos valores dos atributos através dos métodos setters correspondentes. 

Se eu colocar para exibir na tela com o comando abaixo:
    System.out.println(carro); 

    A saída nao sera das informações que eu inclui. Na verdade será impresso apenas o código com o espaço na memoria que as informacoes estao no meu computador. 

Para imprimir de fato os valores que foram inseridos eu tenho que definir um método toString() na classe Carro para imprimir aquilo que eu quero. PAra isso eu vou na Classe Carro, clico com o botao direito e seleciono "Ação do código..." e ai peço para ser gerado o método toString()

 Inserir as informações através dos setters acaba ficando muito trabalhoso. Nesse caso é tranquilo porque só temos 3 atributos, mas se fossem 10 ou mais seria complicado. Por conta disso vamos usar os construtores da classe. A funcionalidade do método construtor é pegar esses valores passados como argumento e atribuir esses valores das variáveis no momento da instanciação da variável. 
    
 Quando eu vou na classe Carro e crio a classe Construtor ele vai dar um erro porque ele quer que eu vá no programa principal e informe os valores das variaveis que ele pede como argumento. E eu posso criar mais de um construtor na minha classe.


 Criamos classes novas (CarroEsportivo e CarroPasseio) para serem classes filhas de Carro. Quando criei e coloquei o extends apareceu um erro. Entao eu so preciso criar um construtor em cada classe filha que o erro some
*/ 
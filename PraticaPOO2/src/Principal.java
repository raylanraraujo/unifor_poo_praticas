public class Principal {
    public static void main(String[] args) {
        
        Carro carro = new Carro(); //Aqui estamos declarando uma variável com o nome "carro" e ela é do tipo "Carro"
        carro.setKilometragem(1000);
    }
}

/*

Criamos uma nova classe chamada "Principal" e a definimos como sendo a classe principal do programa. Ela quem vai atuar como maestro orquestrando todas as outras classes. 

Em seguida declaramos uma variável. 
    
    Carro carro;

    Esta se chama "carro" e ela é do tipo "Carro". Entretanto, com essa variável declarada assim não é possível atribuir valores a essa entidade carro. Para atribuir valores eu tenho que instanciar essa minha classe carro. 

Instanciar é como se eu tivesse pegando esse molde dessa classe Carro em branco, isto é, todos os atributos dela estão em branco.

Depois é que eu faco a inclusao dos valores dos atributos.

pois eu nao disse nada sobre ele como o tipo de combustivel, a kilometragem nem a velocidade máxima dele.  
*/ 
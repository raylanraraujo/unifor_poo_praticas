public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Inicializando...");
        Hippo h = new Hippo();
    }
}

/**
 * Encadeamento de Construtores
 * 
 *  Para que um objeto seja totalmente criado, todas as partes da sua SUPERCLASSE devem ser integralmente criadas.
 * 
 *  Um novo objeto Hippo também É-UM Animal e É-UM Objetct. Portanto, criar um onjeto Hippo também é criar partes de Animal e de Object.
 * 
 */
import javax.swing.*;
import java.awt.event.*;

public class Calc implements ActionListener { // a classe está implementando a interface ActionListener
    //Declarando as variáveis
    JFrame janela; // Jframe é como se fosse a janela que eu vou contruir a minha calculadora
    JTextField tela; // a área da calculadora onde sao exibidos os nuúmeros
    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bsoma, bsub, bdiv, bmult, bdec, bigual, bdel, bclr;

    static double a=0, b=0, resultado=0; //declarando e inicializando as 3 variáveis (a, b e resultado) com o valor zero
    static int operador = 0;
    Calc(){

        //
        janela = new JFrame("Calculadora");
        tela = new JTextField();
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");
        b0 = new JButton("0");
        bsoma = new JButton("+");
        bsub = new JButton("-");
        bdiv = new JButton("/");
        bmult = new JButton("*");
        bdec = new JButton(".");
        bigual = new JButton("=");
        bdel = new JButton("Deletar");
        bclr = new JButton("Limpar");

        // Definindo tamanho e localização de cada componente gráfico
        tela.setBounds(30, 40, 280,30);
        
        b7.setBounds(40, 100, 50, 40);
        b8.setBounds(110, 100, 50, 40);
        b9. setBounds(180, 100, 50, 40);
        bdiv.setBounds(250, 100, 50, 40);

        b4.setBounds(40, 170, 50, 40);
        b5.setBounds(110, 170, 50, 40);        
        b6.setBounds(180, 170, 50, 40);
        bmult.setBounds(250, 170, 50, 40);

        b1.setBounds(40, 240, 50, 40);
        b2.setBounds(110, 240,50,40);
        b3.setBounds(180,240, 50,40);
        bsub.setBounds(250, 240, 50,40);

        bdec.setBounds(40, 310, 50,40);
        b0.setBounds(110, 310, 50,40);
        bigual.setBounds(180, 310, 50,40);
        bsoma.setBounds(250, 310, 50,40);
        
        bdel.setBounds(60, 380, 100, 40);
        bclr.setBounds(180, 380, 50, 40);

        //Adicionando os componentes gráficos no JFrame
        janela.add(tela);
        janela.add(b7);
        janela.add(b8);
        janela.add(b9);
        janela.add(bdiv);
        janela.add(b4);
        janela.add(b5);
        janela.add(b6);
        janela.add(bmult);
        janela.add(b1);
        janela.add(b2);
        janela.add(b3);
        janela.add(bsub);
        janela.add(bdec);
        janela.add(b0);
        janela.add(bigual);
        janela.add(bsoma);
        janela.add(bdel);
        janela.add(bclr);

        //configurações do JFrame
        janela.setLayout(null); // aqui digo que não estu usando nenhum gerenciados de layout
        janela.setVisible(true); // isso diz que é para janela aparecer. toda vez que voce for usar uma janela, um JFrame, tem que se lembrar sempre de settar a visibilidade dele para verdadeira fazendo com que ele apareça na tua tela.
        janela.setSize(350, 500); // aquie é definido o tamanho da janela
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // é preciso colocar esse comando, pois caso contrário, quando eu fechar a janela o programa continua rodando. Entao esse comando diz que quando eu clicar no X da janela, ele vai matar a aplicação do Java.
        janela.setResizable(false); // é para informar que eu nao posso pegar a janela e ficar redimensionando ela. Ou seja ela tem a sua largura e altura e não poderá ser redimensionada. 
        
        // adicionando os Listeners de ação para cada componente
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b0.addActionListener(this);
        bsoma.addActionListener(this);
        bsub.addActionListener(this);
        bdiv.addActionListener(this);
        bmult.addActionListener(this);
        bdec.addActionListener(this);
        bigual.addActionListener(this);
        bdel.addActionListener(this);
        bclr.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == b1){
            tela.setText(tela.getText().concat("1")); //se o usuário clicou no botao b1, eu quero que no meu visor seja escrito o número 1. Entã0
        }
        if(e.getSource() == b2){
            tela.setText(tela.getText().concat("2"));
        }
        if(e.getSource() == b3){
            tela.setText(tela.getText().concat("3"));
        }
        if(e.getSource() == b4){
            tela.setText(tela.getText().concat("4"));
        }
        if(e.getSource() == b5){
            tela.setText(tela.getText().concat("5"));
        }
        if(e.getSource() == b6){
            tela.setText(tela.getText().concat("6"));
        }
        if(e.getSource() == b7){
            tela.setText(tela.getText().concat("7"));
        }
        if(e.getSource() == b8){
            tela.setText(tela.getText().concat("8"));
        }
        if(e.getSource() == b9){
            tela.setText(tela.getText().concat("9"));
        }
        if(e.getSource() == b0){
            tela.setText(tela.getText().concat("0"));
        }
        if(e.getSource() == bdec){
            tela.setText(tela.getText().concat("."));
        }

        //armazenado o valor digitado antes de apertar o botao de somar
        if(e.getSource() == bsoma){
            a = Double.parseDouble(tela.getText()); // a variável armazenará o valor digitado covertendo para o tipo Double
            operador = 1;
            tela.setText(""); // apaga os números exibidos na tela 
        }

        if(e.getSource() == bsub){
            a = Double.parseDouble(tela.getText());
            operador = 2;
            tela.setText("");
        }

        if(e.getSource() == bmult){
            a = Double.parseDouble(tela.getText());
            operador = 3;
            tela.setText("");
        }

        if(e.getSource() == bdiv){
            a = Double.parseDouble(tela.getText());
            operador = 4;
            tela.setText("");
        }

        if(e.getSource() == bigual){
            b = Double.parseDouble(tela.getText());
            switch (operador) {
                case 1:
                    resultado = a + b;
                    break;
                case 2:
                    resultado = a - b;
                    break;
                case 3:
                    resultado = a * b;
                    break;
                case 4:
                    resultado = a / b;
                    break;
                default:
                    break;
            }
            tela.setText("" + resultado);
        }

        if(e.getSource() == bclr){
            tela.setText("");
        }
        if(e.getSource()==bdel){
            String s = tela.getText();
            tela.setText("");
            for (int i = 0; i < s.length()-1; i++){
                tela.setText(tela.getText()+s.charAt(i));
            }
        }


    }
    
    
    
}

/*
 * Iniciamos importando as bibliotecas.
 * 
 * Jframe é como se fosse a janela que eu vou contruir a minha calculadora.
 * Inicialmente ele começa como sendo uma tela em branco e depois vai sendo inseridos os componentes nela. 
 * 
 * JTextField é um campo de texto. Será a área da calculadora onde sao exibidos os nuúmeros.
 * 
 * JButton serve para eu declarar os botoes da minha calculadora e dizer os botoes que minha interface terá. 
 * 
 * Inicialmente a calculadora servirá para fazer uma operação entre dois numeros. O primeiro número eu defino que armazenarei na variável a, o segundo número na variável b. Será executado alguma operação com esses números e eu vou armazenar esse resultado na variável resultado. 
 * 
 * Tambem foi declarado a variável operador que se inicia com o valor de zero. Cada operação recebe um valor diferente e será atribuido a essa variável. Caso for soma por exemplo operador recebe 1 e por ai vai.
 * 
 * Em seguida eu tenho o construtor da classe, o Calc()
 * Dentro dele eu vou instanciar todos os elementos de interface gráfica que irá compor a minha calculadora. 
 * E também eu tenho que definir o tamanho e a locaalização de cada componente gráfico.
 * Depois eu tenho que adicionar cada componente na minha tela. O frame é como se fosse uma tela em branco e dentro dessa janela eu vou colocar os meus botoes. A tela que era branca, agora passa a ter os componentes de interface. 
 * Mas antes de exibir é preciso definir as configurações dessa jenala em branco, o frame que é a janela do programa.i
 * 
 * Depois sao adicionado os Listeners. A função do listener tem a funcao de escutar. Ele vai ficar sempre "escutando" para ver se alguma coisa está interagindo com aquele componente de interface gráfica. Por exemplo, eu quero colocar o comportamento de um clique. Como eu nao sei o momento em que vai haver um clique no botão, então eu preciso definir um escutador. algo que vai ficar, vendo / escutando esse botao e vai notificar se alguem interagir com ele. Entao queremos capturar o momento que o usuario clica no botao. Isso é uma ação que eu vou executar dentro da minha interface grafica. Então eu preciso de um Listener de ação. Algum escutador que, quando alguem interaja com aquele componente de interface gráfica, ele avisa que alguem interagiu.
 * foi adicionado o parametro "this" porque na minha classe foi implementado a interface ActionListenner. Entao toda vida que adiciona um ActionListener ele pede um listenner. Como eu implementei o ActionListener eu posso passar o this que é a referencia da classe Calc. Essa é uma boa pratica e uma boa forma de se fazer. Existem outras. 
 * 
 * Isso tudo acima foi usado para definir a classe construtora da Classe Calc.
 * 
 * Deposi disso, vamos definir as acoes que serao executadas quando os botes forem clicados na minha calculadora. Caso contrario será clicado o botão e nada vai acontecer.
 * Portanto, fora do construtor cria-se um método actionPerformed() para quando alguem realizar uma ação eu vou receber um evento "e"). E esse evento eu vou saber com qual componente de interface esse usuário está interagindo.
 * se o usuário clicou no botao b1, eu quero que no meu visor seja escrito o número 1. Entã0 é isso que eu to fazendo no código. Eu to pegando o campo de texto e to settando o texto dele para o valor 1. e faco isso para os outros botoes. 
 * Repare que o código está pegando o valor que o campo de texto já tem "tela.getText()" - no caso quando ele inicializa ele nao tem nada. E está concatenando com o valor do botão que ele está digitando. Entao se eu digitar o botao 1 e depois o botao 2, ele vai colocar o numero 1 e depois concatena com o 2 formando "12".
 * 
 * Depois disso nós vamos para as operacoes matemáticas.
 * No caso se o usuário clicar no botao de adicao, eu vou querer que ele pegue o valor que o usuario digitou antes de apertar o botao "+" e atribuir a minha variável "a". 
 * Eu pego o valor digitado no textField e armazendo na variável a que é do tipo double.
 * Depois operador recebe o valor de 1. Essa é uma convenção adotada pelo professor. Quando for soma, foi definido que o operador é 1. Quando subtração é 2 e por ai vai.
 * Depois que clica no botao da soma, o texto exibido na tela será apagado, e para isso eu defino que o texto da tela receberá "".
 * 
 * Quando eu clicar no botao igual:
 * eu peguo o novo valor digitado e armazenei na variável "b".
 * em seguida eu uso um switch verificando qual é o operador que foi clicado
 * se for soma, operador recebe o valor e 1 e faz uma coisa. Se for subtração, operador recebe 2 e faz outra coisa. E por ai vai
 * O valor da operação realizada é armazenado na variável resultado.
 * Por fim, o texto que sera exibido na tela vai ser uma string vazia, para apagar o número anterior digitado concatenado com o valor armazenado em "resultado". 
 * 
 * O botao clear, faz a limpa o textField settando uma string vazia ""
 * O botao delete vai deletar o digito que eu acabei de digitar na minha calculadora. 
 */

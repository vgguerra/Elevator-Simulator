package engtelecom.poo;

import java.util.Scanner;

/**
     * Classe App, onde terá nosso método main para executar nosso programa
     * 
     * @author Victor Guerra
     */

public class App {

    /**
     * Irá representar um prédio
     */
    private Predio predio;

    /**
     * Irá indicar o andar em que o usuário se encontra
     */
    private int andarAtual;

    /**
     * Irá indicar se o usuário está ou não dentro do elevador no momento
     */
    private boolean dentro;

    /**
     * Irá indicar o número de andares do prédio
     */
    private int numAndar;

    /**
     * Irá ser utilizado para ler do teclado as informações necessárias
     */
    private static Scanner teclado = new Scanner(System.in);

    /**
     * Método construtor, onde irá instanciar um prédio. O número de andares do prédio deve ser sempre um valor positivo. Caso seja passado um valor negativo, o programa irá iniciar um prédio com 10 andares.
     * @param numAndar
     */
    public App(int numAndar){
        if(numAndar <= 0){
            numAndar = 10;
        }
        this.predio = new Predio(numAndar);
        this.andarAtual = 0;
        this.dentro = false;
        this.numAndar = numAndar;

    }

    /**
     * Método main, onde será feita a execução do programa
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        System.out.print("Digite o número de andares que o prédio terá, sendo um deles o 0: ");

        App app = new App(teclado.nextInt());
        teclado.nextLine();

        int escolha = -1;
        
        while (escolha != 0 ) {
            System.out.println("Você está dentro ou fora do elevador?");
            if(teclado.nextLine().equals("Dentro")){
                
            }else{
                System.out.println("Em qual andar você está?");
                app.andarAtual = teclado.nextInt();
                teclado.nextLine();

                System.out.println("Você deseja subir ou descer?");
                String sobeDesce = teclado.nextLine(); 

                if(sobeDesce.equals("Subir")){
                    app.predio.chamaElevador(sobeDesce, app.andarAtual);
                }else{
                    app.predio.chamaElevador("Descer", app.andarAtual);
                }


            }
        }

    }
}

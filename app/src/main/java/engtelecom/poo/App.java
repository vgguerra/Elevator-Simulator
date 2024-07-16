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
        app.dentro = true;
        while(escolha != 0){
            if(!app.dentro){
                System.out.print("Selecione a opção para chamar o elevador: \"Descer\" para pressionar o botão de descer ou \"Subir\" para pressionar o botão de subir:");
                String opcao = teclado.nextLine();
                if(app.andarAtual > app.predio.getAndarAtual()){
                    app.predio.chamaElevador(opcao,app.andarAtual,"⬆");
                    app.dentro = true;
                }else if(app.andarAtual < app.predio.getAndarAtual()){
                    app.predio.chamaElevador(opcao,app.andarAtual,"⬇");
                    app.dentro = true;
                } else {
                    System.out.println("O elevador já está em seu andar");
                    app.dentro = true;
                }
                System.out.println("Andar atual: " + app.andarAtual + " || Direção: " + app.predio.getVisorPainelExterno(app.andarAtual));
            }else{
                System.out.print("Selecione para qual andar você deseja ir: 0 - ");
                for (int i = 1;i < app.numAndar;i++){
                    if(i == app.numAndar - 1 ){
                        System.out.println(i+":");
                    }else{
                        System.out.print(i + " - ");
                    }
                }
                int andar = teclado.nextInt();
                if(andar == app.andarAtual || andar < 0 || andar >= app.numAndar ){
                    while(app.andarAtual == andar || andar < 0 || andar >= app.numAndar){
                    System.out.println("Selecione outro andar: ");
                    andar = teclado.nextInt();
                }}
                app.predio.selecioneAndar(andar);
                teclado.nextLine();

                if(app.andarAtual > andar) {
                    for (int i = app.andarAtual; i >= andar; i--) {
                        if(app.andarAtual == andar){
                            app.predio.desativaBota(andar);
                            app.predio.setVisorElevador("---");
                            app.predio.setVisorPainelExterno("---",andar);
                        }else{
                            app.predio.setVisorElevador("⬇");
                            app.predio.setVisorPainelExterno("⬇",andar);
                        }
                        System.out.println("Visor externo no "+ andar +  "° Andar -  Visor: " + app.predio.getVisorPainelExterno(andar)+ " " + app.andarAtual   +  "|| Painel dentro do elevador - Andar: " + app.andarAtual + " | Direção: " + app.predio.getVisorElevador());
                        System.out.print("Botões: ");
                        for(int j = 0;j < app.numAndar;j++){
                            int op;
                            if(app.predio.getEstadoBotaoElevador(j)){
                                op = 1;
                            }else{
                                op = 0;
                            }
                            System.out.print(j + "(" + op + ")");
                        }
                        System.out.println();
                        app.predio.setAndarAtual(app.predio.getAndarAtual() - 1);
                        app.andarAtual--;
                        Thread.sleep(1000);
                    }
                } else{
                    for(int i = app.andarAtual;i <= andar;i++){
                        if(app.andarAtual == andar){
                            app.predio.desativaBota(andar);
                            app.predio.setVisorElevador("---");
                            app.predio.setVisorPainelExterno("---",andar);
                        }else{
                            app.predio.setVisorElevador("⬆");
                            app.predio.setVisorPainelExterno("⬆",andar);
                        }
                        System.out.println("Visor externo no "+ andar + "° Andar - Visor: " + app.predio.getVisorPainelExterno(andar) + " " + app.andarAtual +    " || Painel dentro do elevador - Andar: " + app.andarAtual + " | Direção: " + app.predio.getVisorElevador());
                        System.out.print("Botões: " );
                        for(int j = 0;j < app.numAndar;j++){
                            int op;
                            if(app.predio.getEstadoBotaoElevador(j)){
                                op = 1;
                            }else{
                                op = 0;
                            }
                            System.out.print(j + "(" + op + ")");
                        }
                        System.out.println();
                        app.predio.setAndarAtual(app.predio.getAndarAtual() + 1);
                        app.andarAtual++;
                        Thread.sleep(1000);
                    }
                }
                app.andarAtual = andar;
                app.dentro = false;
            }

        }

    }
}

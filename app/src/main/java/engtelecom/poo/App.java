package engtelecom.poo;

import java.security.PublicKey;
import java.util.Scanner;

/**
 * Classe App, onde terá nosso método main para executar nosso programa
 *
 * @author Victor Guerra
 */

public class App {
    /**
     * Irá representar um prédio em nosso programa
     */
    private Predio predio;

    /**
     * Irá representar o andar atual onde o usuário está no momento
     */
    private int andarAtual;

    /**
     * Irá indicar o número de andares do prédio
     */
    private int numAndar;

    private static Scanner teclado = new Scanner(System.in);

    public App(int numAndar) {
        if (numAndar <= 0) {
            numAndar = 10;
        }
        this.predio = new Predio(numAndar);
        this.andarAtual = 0;
        this.numAndar = numAndar;
    }

    public static void main(String[] args) throws InterruptedException {
        
        System.out.print("Bem vindo ao sistema de um elevador dentro de um prédio\n\nDigite o número de andares que o prédio terá, sendo um deles o 0: ");
        App app = new App(teclado.nextInt());
        teclado.nextLine();

        String dentroFora = "";
        System.out.println("Para sair do programa, digite qualquer coisa diferente de \"Fora\" ou \"Dentro\"");
        while (!dentroFora.equalsIgnoreCase("Sair") ){
            System.out.println("Você está dentro ou fora do elevador?");
            dentroFora = teclado.nextLine();
            
            if(dentroFora.equalsIgnoreCase("Dentro")){

                System.out.print("Selecione para qual andar você deseja ir: ");
                app.imprimeAndares(app.numAndar);

                int andarSelecionado = teclado.nextInt();
                app.predio.selecioneAndar(andarSelecionado);
                teclado.nextLine();

                app.imprimePainel(app,andarSelecionado,dentroFora); 
            } else if(dentroFora.equalsIgnoreCase("Fora")){
                System.out.println("Em qual andar você está?");
                app.andarAtual = teclado.nextInt();
                teclado.nextLine();

                System.out.println("Você deseja subir ou descer?");
                
                if(teclado.nextLine().equalsIgnoreCase("subir")){
                    app.predio.chamaElevador("Subir", app.andarAtual);
                    app.imprimePainel(app, 0, dentroFora);
                } else{
                    app.predio.chamaElevador("Descer",app.andarAtual);
                    app.imprimePainel(app,0,dentroFora);
                }
            } else{
                dentroFora = "Sair";
            }
        
        }

    }

    /**
     * Irá imprimir na tela os andares do prédio
     * @param numAndar
     */
    public void imprimeAndares(int numAndar){
        for(int i = 0;i < numAndar;i++){
            if(i == numAndar - 1){
                System.out.println(i + ":");
            }else{
                System.out.print(i + " | ");
            }   
        }
    }

    /**
     * Irá imprimir, a cada movimento do elevador, sua situação, o andar atual e se os botões de subir e descer neste andar estão pressionados
     * @param app
     * @param andarSelecionado
     * @throws InterruptedException 
     */
    public void imprimePainel (App app,int andarSelecionado,String dentroFora) throws InterruptedException{
        int guardaAndarAtual = app.predio.getAndarAtual();

        if(dentroFora.equalsIgnoreCase("Dentro")){
            for(int i = 0; i <= Math.abs(andarSelecionado - guardaAndarAtual);i++) {
                for (int j = 0; j < app.numAndar; j++) {
                if (andarSelecionado > app.predio.getAndarAtual()) {
                    System.out.println("Painel no °" + j + " andar: " + "Subindo || Andar atual do elevador: " + app.predio.getAndarAtual() + "|| Botões: Subir(" + app.predio.getEstadoBotaoPainelExternoSobe(j) + ") Descer (" + app.predio.getEstadoBotaoPainelExternoDesce(j) + ")");

                } else if (andarSelecionado < app.predio.getAndarAtual()) {
                    System.out.println("Painel no °" + j + " andar: " + "Descendo || Andar atual do elevador: " + app.predio.getAndarAtual() + "|| Botões: Subir(" + app.predio.getEstadoBotaoPainelExternoSobe(j) + ") Descer (" + app.predio.getEstadoBotaoPainelExternoDesce(j) + ")");
                  
                } else {
                    app.predio.desativaBotaElevador(andarSelecionado);
                    System.out.println("Painel no °" + j + " andar: " + "Parado || Andar atual do elevador: " + app.predio.getAndarAtual() + "|| Botões: Subir(" + app.predio.getEstadoBotaoPainelExternoSobe(j) + ") Descer (" + app.predio.getEstadoBotaoPainelExternoDesce(j) + ")");
                    app.predio.desativaBotaElevador(andarSelecionado);
                }
            }
    
            if (andarSelecionado > app.predio.getAndarAtual()) {
                app.predio.setAndarAtual(app.predio.getAndarAtual() + 1);
            } else if (andarSelecionado < app.predio.getAndarAtual()) {
                app.predio.setAndarAtual(app.predio.getAndarAtual() - 1);
            }

            System.out.print("Botões do painel do elevador: ");
                for(int k = 0;k < app.numAndar;k++){
                    if(k == numAndar - 1){
                        System.out.println(k + "(" + app.predio.getEstadoBotaoElevador(k) + ") :");
                    }else{
                        System.out.print(k + "(" + app.predio.getEstadoBotaoElevador(k) + ") | ");
                    }  
                }
                System.out.println("===========================================");
                Thread.sleep(1000);
            }
        }else{
            for(int i = 0; i <= Math.abs(guardaAndarAtual - app.predio.getAndarAtual());i++) {
                for (int j = 0; j < app.numAndar; j++) {
                if (app.andarAtual > app.predio.getAndarAtual()) {
                    System.out.println("Painel no °" + j + " andar: " + "Subindo || Andar atual do elevador: " + app.predio.getAndarAtual() + "|| Botões: Subir(" + app.predio.getEstadoBotaoPainelExternoSobe(j) + ") Descer (" + app.predio.getEstadoBotaoPainelExternoDesce(j) + ")");

                } else if (app.andarAtual < app.predio.getAndarAtual()) {
                    System.out.println("Painel no °" + j + " andar: " + "Descendo || Andar atual do elevador: " + app.predio.getAndarAtual() + "|| Botões: Subir(" + app.predio.getEstadoBotaoPainelExternoSobe(j) + ") Descer (" + app.predio.getEstadoBotaoPainelExternoDesce(j) + ")");
                  
                } else {
                    app.predio.desativaBotaPainelExterno(j);
                    System.out.println("Painel no °" + j + " andar: " + "Parado || Andar atual do elevador: " + app.predio.getAndarAtual() + "|| Botões: Subir(" + app.predio.getEstadoBotaoPainelExternoSobe(j) + ") Descer (" + app.predio.getEstadoBotaoPainelExternoDesce(j) + ")");                            
                    }        
                }
                System.out.println("===========================================");

                if (app.andarAtual > app.predio.getAndarAtual()) {
                    app.predio.setAndarAtual(app.predio.getAndarAtual() + 1);
                } else if (app.andarAtual < app.predio.getAndarAtual()) {
                    app.predio.setAndarAtual(app.predio.getAndarAtual() - 1);
                }
                Thread.sleep(1000);
            }
        }
        

        

                    
    }


}



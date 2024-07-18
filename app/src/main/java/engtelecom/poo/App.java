package engtelecom.poo;

import java.util.Scanner;

/**
 * Classe App, onde terá nosso método main para executar nosso programa
 *
 * @author Victor Guerra
 */

public class App {

    private Predio predio;
    private int andarAtual;
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
        System.out.print("Digite o número de andares que o prédio terá, sendo um deles o 0: ");
        App app = new App(teclado.nextInt());
        teclado.nextLine();

        int escolha = -1;

        while (escolha != 0) {
            System.out.println("Você está dentro ou fora do elevador?");
            String dentroFora = teclado.nextLine();

            if (dentroFora.equalsIgnoreCase("Dentro")) {
                System.out.print("Digite para qual andar você deseja ir: ");
                int andarDesejado = teclado.nextInt();
                teclado.nextLine();

                if (andarDesejado > app.predio.getAndarAtual()) {
                    for (int j = app.predio.getAndarAtual(); j <= andarDesejado; j++) {
                        if (j == app.predio.getAndarAtual()) {
                            System.out.println(j + "° Andar: Elevador: Parado | Andar: " + j + " Botões: subir ("
                                    + app.predio.getEstadoBotaoPainelExternoSobe(j) + ") descer: ("
                                    + app.predio.getEstadoBotaoPainelExternoDesce(j) + ")");
                        } else {
                            System.out.println(j + "° Andar: Elevador: Subindo | Andar: " + j + " Botões: subir ("
                                    + app.predio.getEstadoBotaoPainelExternoSobe(j) + ") descer: ("
                                    + app.predio.getEstadoBotaoPainelExternoDesce(j) + ")");
                        }
                        Thread.sleep(1000);
                    }
                } else if (andarDesejado < app.predio.getAndarAtual()) {
                    for (int j = app.predio.getAndarAtual(); j >= andarDesejado; j--) {
                        if (j == app.predio.getAndarAtual()) {
                            System.out.println(j + "° Andar: Elevador: Parado | Andar: " + j + " Botões: subir ("
                                    + app.predio.getEstadoBotaoPainelExternoSobe(j) + ") descer: ("
                                    + app.predio.getEstadoBotaoPainelExternoDesce(j) + ")");
                        } else {
                            System.out.println(j + "° Andar: Elevador: Descendo | Andar: " + j + " Botões: subir ("
                                    + app.predio.getEstadoBotaoPainelExternoSobe(j) + ") descer: ("
                                    + app.predio.getEstadoBotaoPainelExternoDesce(j) + ")");
                        }
                        Thread.sleep(1000);
                    }
                }
                app.predio.setAndarAtual(andarDesejado);
                app.predio.desativaBota(andarDesejado);

            } else {
                System.out.println("Em qual andar você está?");
                app.andarAtual = teclado.nextInt();
                teclado.nextLine();

                System.out.println("Você deseja subir ou descer?");
                String sobeDesce = teclado.nextLine();

                if (sobeDesce.equalsIgnoreCase("Subir")) {
                    app.predio.chamaElevador("Subir", app.andarAtual);
                    for (int j = 0; j < app.numAndar; j++) {
                        if (app.andarAtual > app.predio.getAndarAtual()) {
                            if (j < app.predio.getAndarAtual()) {
                                System.out.println(j + "° Andar: Elevador: Parado | Andar: " + j
                                        + " Botões: subir (" + app.predio.getEstadoBotaoPainelExternoSobe(j)
                                        + ") descer: (" + app.predio.getEstadoBotaoPainelExternoDesce(j) + ")");
                            } else if (j < app.andarAtual) {
                                System.out.println(j + "° Andar: Elevador: Subindo | Andar: " + j
                                        + " Botões: subir (" + app.predio.getEstadoBotaoPainelExternoSobe(j)
                                        + ") descer: (" + app.predio.getEstadoBotaoPainelExternoDesce(j) + ")");
                            } else {
                                System.out.println(j + "° Andar: Elevador: Parado | Andar: " + j + " Botões: subir ("
                                        + app.predio.getEstadoBotaoPainelExternoSobe(j) + ") descer: ("
                                        + app.predio.getEstadoBotaoPainelExternoDesce(j) + ")");
                            }
                        } else {
                            if (j > app.predio.getAndarAtual() && j <= app.andarAtual) {
                                System.out.println(j + "° Andar: Elevador: Descendo | Andar: " + j + " Botões: subir ("
                                        + app.predio.getEstadoBotaoPainelExternoSobe(j) + ") descer: ("
                                        + app.predio.getEstadoBotaoPainelExternoDesce(j) + ")");
                            } else {
                                System.out.println(j + "° Andar: Elevador: Parado | Andar: " + j + " Botões: subir ("
                                        + app.predio.getEstadoBotaoPainelExternoSobe(j) + ") descer: ("
                                        + app.predio.getEstadoBotaoPainelExternoDesce(j) + ")");
                            }
                        }
                        Thread.sleep(1000);
                    }
                    app.predio.setAndarAtual(app.andarAtual);
                    app.predio.desativaBota(app.andarAtual);

                } else if (sobeDesce.equalsIgnoreCase("Descer")) {
                    app.predio.chamaElevador("Descer", app.andarAtual);
                    for (int j = 0; j < app.numAndar; j++) {
                        if (app.andarAtual < app.predio.getAndarAtual()) {
                            if (j > app.predio.getAndarAtual()) {
                                System.out.println(j + "° Andar: Elevador: Parado | Andar: " + j + " Botões: subir ("
                                        + app.predio.getEstadoBotaoPainelExternoSobe(j) + ") descer: ("
                                        + app.predio.getEstadoBotaoPainelExternoDesce(j) + ")");
                            } else if (j > app.andarAtual) {
                                System.out.println(j + "° Andar: Elevador: Descendo | Andar: " + j + " Botões: subir ("
                                        + app.predio.getEstadoBotaoPainelExternoSobe(j) + ") descer: ("
                                        + app.predio.getEstadoBotaoPainelExternoDesce(j) + ")");
                            } else {
                                System.out.println(j + "° Andar: Elevador: Parado | Andar: " + j + " Botões: subir ("
                                        + app.predio.getEstadoBotaoPainelExternoSobe(j) + ") descer: ("
                                        + app.predio.getEstadoBotaoPainelExternoDesce(j) + ")");
                            }
                        } else {
                            if (j < app.predio.getAndarAtual() && j >= app.andarAtual) {
                                System.out.println(j + "° Andar: Elevador: Subindo | Andar: " + j + " Botões: subir ("
                                        + app.predio.getEstadoBotaoPainelExternoSobe(j) + ") descer: ("
                                        + app.predio.getEstadoBotaoPainelExternoDesce(j) + ")");
                            } else {
                                System.out.println(j + "° Andar: Elevador: Parado | Andar: " + j + " Botões: subir ("
                                        + app.predio.getEstadoBotaoPainelExternoSobe(j) + ") descer: ("
                                        + app.predio.getEstadoBotaoPainelExternoDesce(j) + ")");
                            }
                        }
                        Thread.sleep(1000);
                    }
                    app.predio.setAndarAtual(app.andarAtual);
                    app.predio.desativaBota(app.andarAtual);
                }
            }
        }
    }
}

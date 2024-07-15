package engtelecom.poo;

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
     * Método construtor, onde irá instanciar um prédio
     * @param numAndar
     */
    public App(int numAndar){
        this.predio = new Predio(numAndar);
    }

    /**
     * Método main, onde será feita a execução do programa
     * @param args
     */
    public static void main(String[] args) {
            
    }
}

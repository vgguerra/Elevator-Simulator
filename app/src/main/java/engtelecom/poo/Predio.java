package engtelecom.poo;

import java.util.ArrayList;

/**
     * Representa um prédio, que terá um elevador para realizar locomover de um andar para outro
     * 
     * @author Victor Guerra
     */

public class Predio{

    /**
     * Irá representar o número de andares que o prédio terá 
     */
    private int numAndares;

    /**
     * Irá representar os painéis externos que tem em cada andar do prédio
     */
    private ArrayList<PainelExterno> paineisExternos;

    /**
     * Irá representar o elevador dentro do prédio
     */
    private Elevador elevador;

    /**
     * Método construtor que irá instaciar um predio para a utilização do elevador dele
     * 
     * @param numAndares
     */
    public Predio(int numAndar){
        this.numAndares = numAndar;
        this.elevador = new Elevador(numAndar);
        this.paineisExternos = new ArrayList<>(numAndar);

        for(int i = 0;i < numAndares;i++){
            this.paineisExternos.add(new PainelExterno());
        }
    }


    /**
     * Método que irá ser utilizado para que o usuário chame o elevador no andar onde o usuário esta, onde o usuário deve selecionar se irá subir ou descer e indicar o andar onde está.
     * Caso o andar passado seja inválido, ou seja, menor que 0 ou maior que o andar mais alto do prédio, ou caso a direção passada seja inválida,o método retornará falso.
     * 
     * @param sobeDesce
     * @param andar
     * @return boolean
     */
    public boolean chamaElevador(String sobeDesce,int andar){

        if(sobeDesce.equals("Subir") && andar >= 0 && andar < numAndares ){
            this.paineisExternos.get(andar).apertarBotaoSubida();
            return true;
        }if(sobeDesce.equals("Descer") && andar >= 0 && andar < numAndares){
            this.paineisExternos.get(andar).apertarBotaoDescida();
            return true;
        }
        return false;
    }

    public boolean selecioneAndar(int andar){
        if(andar >= 0 && andar < numAndares){

            return elevador.selecioneAndar(andar);
        }
        return false;
    }

    /**
     * Irá retornar o número de andares que o prédio tem
     * @return int
     */
    public int getNumAndares() {
        return numAndares;
    }


}
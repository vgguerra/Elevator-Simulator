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
    }


    /**
     * Método que irá ser utilizado para que o usuário chame o elevador no andar onde o usuário esta, onde o usuário deve selecionar se irá subir ou descer
     * 
     * @param sobeDesce
     * @param andar
     * @return boolean
     */
    public boolean chamaElevador(String sobeDesce,int andar){
        
        if(sobeDesce.equals("Sobe") && andar >=00 && andar < numAndares ){
            this.paineisExternos.get(andar).apertarBotaoSubida();
        }if(sobeDesce.equals("Desce")){
            this.paineisExternos.get(andar).apertarBotaoDescida();
        }
    } 

    public boolean selecioneAndar(int andar){
        
    }

    
}
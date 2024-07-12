package engtelecom.poo;

import java.util.ArrayList;

/**
 * Representa o painel interno de
 * 
 * @author Victor Guerra
 */

public class PainelInterno{

    /**
     * Lista que representará os botões, sendo o número de botões o número de andares +1 por conta do térreo
     */
    private ArrayList<Botao> botoesAndares;

    /**
     * Irá representar o andar em que o elevador se encontra no momento
     */
    private int andar;

    /**
     * Irá representar o visor do elevador, que irá indicar se o mesmo está subindo ou descendo
     */
    private String visor;


    /**
     * Método construtor, onde irá iniciar painel interno de um elevador
     * 
     * @param numAndar 
     */

     public PainelInterno(int numAndar){
        this.botoesAndares = new ArrayList<>(numAndar);
        this.andar = 0;
        this.visor = "Estático";
     }

     /**
      * Método no qual irá pressionar o botão de um andar e irá retonar se o botão foi pressionado ou não
      * @param andar 
      * @return boolean
      */

    public boolean selecioneAndar(int andar){
        botoesAndares.get(andar).ativaBotado();
        return botoesAndares.get(andar).isEstadoBotao();
    }

    /**
     * Irá retornar o que está sendo apresentado no visor
     * @return String
     */
    public String getVisor() {
        return visor;
    }

    /**
     * Irá alterar o que está sendo apresentado no visor
     * @param visor
     * @return String
     */
    public void setVisor(String visor) {
        this.visor = visor;
    }

    /**
     * Irá retornar o andar em que o elevador se encontra no momento
     * @return int
     */
    public int getAndar() {
        return andar;
    }

    /**
     * Irá alterar o andar em que o elevador se encontra
     * @return int
     */
    public void setAndar(int andar) {
        this.andar = andar;
    }

    public int numAndares(){
        return this.botoesAndares.size();
    }

}
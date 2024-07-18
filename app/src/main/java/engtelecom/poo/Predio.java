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
     * Irá retornar o estado de um botão do painela interno de um elevador(Verdadeiro para aceso e falso para apagado).
     * @param andar
     * @return boolean
     */
    public boolean getEstadoBotaoElevador(int andar){
        return elevador.getEstadoBotao(andar);
    }

    public void desativaBota(int andar){
     paineisExternos.get(andar).desativaBotoes();
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
            this.paineisExternos.get(andar).setVisor("⬆");
            return true;
        }if(sobeDesce.equals("Descer") && andar >= 0 && andar < numAndares){
            this.paineisExternos.get(andar).apertarBotaoDescida();
            this.paineisExternos.get(andar).setVisor("⬇");
            return true;
        }
        return false;
    }

    public boolean selecioneAndar(int andar){
        return elevador.selecioneAndar(andar);
    }

    /**
     * Irá retornar o número de andares que o prédio tem
     * @return int
     */
    public int getNumAndares() {
        return numAndares;
    }

    /**
     * Irá alterar a direção para onde o elevador está indo (Subindo ou descendo)
     * @param andar
     */
    public String getVisorPainelExterno(int andar){
        return paineisExternos.get(andar).getVisor();
    }

    public void setVisorPainelExterno(String visor, int andar){
        paineisExternos.get(andar).setVisor(visor);
    }

    /**
     * Irá retornar a direção para onde o elevador está indo
      * @return String
     */
    public String getVisorElevador(){
        return elevador.getVisor();
    }


    /**
     * Irá alterar a direcção para onde o elevador está indo(subindo ou descendo)
     * @param visor
     */
    public void setVisorElevador(String visor){
        elevador.setVisor(visor);
    }

    /**
     * Irá retornar 1 se o botão de subida estiver pressionado e 0 caso não esteja
     * @param andar
     * @return
     */
    public int getEstadoBotaoPainelExternoSobe(int andar){
        if(paineisExternos.get(andar).getSobe()){
            return 1;
        }
        return 0;
    }

    public int getEstadoBotaoPainelExternoDesce(int andar){
        if(paineisExternos.get(andar).getDesce()){
            return 1;
        }
        return 0;
    }

    public void setEstadoBotaoPainelExterno(boolean estadoBotaoPainelExterno,int andar){
        paineisExternos.get(andar).desativaBotoes();
    }

    /**
     * Irá retornar o andar em que o elevador se encontra no momento
     * @return int
     */
    public int getAndarAtual(){
        return elevador.getAndar();
    }

    /**
     * Irá indicar o andar em que o elevador se encontra no momento
     * @param andar
     */
    public void setAndarAtual(int andar){
        elevador.setAndar(andar);
    }


}
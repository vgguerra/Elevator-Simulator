package engtelecom.poo;

import org.checkerframework.checker.units.qual.t;

public class PainelExterno{

    /**
     * Irá representar o botão de subida do painel externo do elevador 
     */
    private Botao sobe;

    /**
     * Irá representar o botão de descida do painel externo do elevador
     */
    private Botao desce;

     /**
     * Irá representar o andar em que elevador se encontra no momento
     */
    private int andar;

     /**
     * Irá representar a direção em que o elevador está indo no momento
     */
    private String visor;

     /**
     * Método construtor, onde irá instanciar um painel externo de um elevador
     */
    public PainelExterno(){
        this.andar = 0;
        this.visor = "";
        this.sobe = new Botao();
        this.desce = new Botao();
    }

     /**
     * Método que irá pressionar o botão de descida para chamar o elevador indicando que o usuário irá descer
     * @return boolean
     */
    public boolean apertarBotaoDescida(){
        desce.ativaBotao();
        setVisor("⬇️");
        return desce.isEstadoBotao();
    }

    /**
     * Método que irá pressionar o botão de subida para chamar o elevador indicando que o usuário irá subir
     * @return boolean
     */
    public boolean apertarBotaoSubida(){
        this.sobe.ativaBotao();
        setVisor("⬆️");
        return sobe.isEstadoBotao();
    }

    /**
     * Irá retornar se o botão está ativo ou não (True para ativo e false para desativado)
     * @return boolean
     */
    public boolean getSobe() {
        return sobe.isEstadoBotao();
    }

    /**
     * Irá retornar se o botão está ativo ou não (True para ativo e false para desativado)
     * @return boolean
     */
    public boolean getDesce() {
        return desce.isEstadoBotao();
    }

    /**
     * Irá retornar o andar em que o elevador se encontra
     * @return int
     */
    public int getAndar() {
        return andar;
    }

    /**
     * Irá mostrar o que está sendo exibido no visor do painel no momento
     * @return String
     */
    public String getVisor() {
        return visor;
    }

    public void setVisor(String visor){
        this.visor = visor;
    }

    
}
package engtelecom.poo;

/**
 * Representa um botão
 * 
 * @author Victor Guerra
 */

public class Botao{

    /**
     * Estado atual do botão(Falso para apagado, verdadeiro para aceso)
     */
    private boolean estadoBotao;


    /**
     * Irá ativar o botão e irá retornar o estado dele(Falso para apagado, verdadeiro para aceso)
     * @return boolean
     */
    public boolean ativaBotado(){
        estadoBotao = true;
        retorn estadoBotao;
    }

    /**
     * Irá desativar o botão, e irá retornar o estado dele(Falso para apagado, verdadeiro para aceso)
     * @return boolean
     */
    public boolean desativaBotao(){
        estadoBotao = false;
        retorn estadoBotao;
    }

    /**
     * Irá retornar o estado do botão
     * @return boolean
     */
    public boolean isEstadoBotao() {
        return estadoBotao;
    }


}
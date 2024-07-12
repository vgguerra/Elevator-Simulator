package engtelecom.poo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TesteBotao {

    @Test
    public void testaBotao(){
        Botao botao = new Botao();

        assertFalse(botao.isEstadoBotao());

        botao.ativaBotado();
        assertTrue(botao.isEstadoBotao());

        botao.desativaBotao();
        assertFalse(botao.isEstadoBotao());
    }

    @Test
    public void testaPainelInterno(){
        PainelInterno painelInterno = new PainelInterno(10);


        assertEquals(11,painelInterno.numAndares());
        assertTrue(painelInterno.selecioneAndar(2));
    }


    
}

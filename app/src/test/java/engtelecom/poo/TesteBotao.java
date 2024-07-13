package engtelecom.poo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TesteBotao {

    @Test
    public void testaBotao(){
        Botao botao = new Botao();

        assertFalse(botao.isEstadoBotao());

        botao.ativaBotao();
        assertTrue(botao.isEstadoBotao());

        botao.desativaBotao();
        assertFalse(botao.isEstadoBotao());
    }
    
}
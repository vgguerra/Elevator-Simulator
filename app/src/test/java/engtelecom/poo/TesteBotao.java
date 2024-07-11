package engtelecom.poo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TesteBotao {

    @Test
    public void testaBotao{
        Botao botao = new Botao();

        assertEquals(false,botao.isEstadoBotao);
    }

    
}

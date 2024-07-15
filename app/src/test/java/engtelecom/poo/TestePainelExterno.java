package engtelecom.poo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestePainelExterno {

    @Test
    public void testePainelExterno(){

        PainelExterno painelExterno = new PainelExterno();

        assertTrue(painelExterno.apertarBotaoSubida());
        assertTrue(painelExterno.apertarBotaoDescida());

        painelExterno.apertarBotaoSubida();
        assertEquals("⬆", painelExterno.getVisor());

        painelExterno.apertarBotaoDescida();
        assertEquals("⬇", painelExterno.getVisor());


    }
    
}

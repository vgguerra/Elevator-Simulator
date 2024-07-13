package engtelecom.poo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TesteElevador {

      @Test
    public void testaElevador(){
        Elevador painelInterno = new Elevador(10);


        assertEquals(11,painelInterno.numBotoes());
        assertTrue(painelInterno.selecioneAndar(2));

        assertFalse(painelInterno.selecioneAndar(11));
        assertFalse(painelInterno.selecioneAndar(-1));
    }
    
}

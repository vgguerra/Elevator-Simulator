package engtelecom.poo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestePredio {
    
    @Test
    public void testePredio(){
        
        Predio predio = new Predio(10);

        assertEquals(10,predio.getNumAndares());

        assertTrue(predio.chamaElevador("Subir",2));
        assertTrue(predio.chamaElevador("Descer",3));

        assertFalse(predio.chamaElevador("Subi", 9));
        assertFalse(predio.chamaElevador("Subir",10));
        assertFalse(predio.chamaElevador("Desc",9));
        assertFalse(predio.chamaElevador("Descer",13));


    }

}



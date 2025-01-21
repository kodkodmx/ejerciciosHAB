package com.softek;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class RomanosTest {
     Romanos romanos = new Romanos();
    
    @Test
    public void testearRomanos() {
        
       

        assertEquals("I", romanos.convertir(1));

    }

    
}

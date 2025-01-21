package com.softek.ejerciciocodigomorse.logica;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TraductorMorseTest {

    TraductorMorse traductor = new TraductorMorse();

    @Test
    void testTraducirAMorse() {
        // Letra minúscula 'a' se traduzca correctamente a Morse
        assertEquals(".-", traductor.aMorse('a'));
    }

    @Test
    void testTraducirAMorseConMayuscula() {
        // Letra mayúscula 'A' también se traduzca correctamente a Morse
        assertEquals(".-", traductor.aMorse('A'));
    }

    @Test
    void testTraducirAMorseConCaracterEspecial() {
        // Se maneje correctamente los caracteres especiales
        assertEquals("?", traductor.aMorse('1')); 
    }

    @Test
    void testTraducirAEspañol() {
        // Traducir de Morse a Español
        assertEquals('A', traductor.aEspañol(".-"));
        assertEquals('Ñ', traductor.aEspañol("--.--"));
        // No existe
        assertEquals('?', traductor.aEspañol("----")); 
    }
}

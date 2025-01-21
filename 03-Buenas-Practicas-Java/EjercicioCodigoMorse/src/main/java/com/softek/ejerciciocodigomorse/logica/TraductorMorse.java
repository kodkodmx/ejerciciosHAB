package com.softek.ejerciciocodigomorse.logica;

public class TraductorMorse {

    public String aMorse(char letra) {

        letra = Character.toUpperCase(letra);

        String morse[] = {
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
            ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.",
            "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."
        };

        if (letra == 'Ñ') {
            return "--.--";
        } else if (letra >= 'A' && letra <= 'Z') {
            return morse[letra - 65];
        }else{
        return "?";
        }
    }
    

    public char aEspañol(String codigo) {

        String morse[] = {
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
            ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.",
            "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."
        };

        if (codigo.equals("--.--")) {
            return 'Ñ';
        } else {
            for(int i=0; i<morse.length; i++){
                if (morse[i].equals(codigo)){
                    return (char) (i+65);
                }
            }
        }
        
        return '?';
    }
    
    
}

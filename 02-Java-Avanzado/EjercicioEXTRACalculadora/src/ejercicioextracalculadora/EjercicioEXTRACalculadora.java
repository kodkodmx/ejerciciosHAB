package ejercicioextracalculadora;

import logica.Operador;


public class EjercicioEXTRACalculadora {


    public static void main(String[] args) {
        Operador suma = new Operador(){
            @Override
            public void operacion(int a, int b) {
                int resultado = a + b;
                System.out.println( "El resultado de la suma usando clases anónimas es: " + resultado);
            }
        };
        suma.operacion(2, 3);
        suma.operacion(8, 17);
    
    Operador oper = (a,b)-> {
                            int resultado = a + b;
                            System.out.println("El resultado de la suma usando lambdas es: " + resultado);
                            };
    oper.operacion(12,38);
    oper.operacion(74,11);
    
    }
    
}

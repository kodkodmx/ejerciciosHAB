package jugar;


public class Jugar {

    public static void main(String[] args) {
        double resultado;
        
        try{
            resultado = division(3,3);
            System.out.println(resultado);
        }catch (esunzero e){
            System.out.println(e);
        }catch (esuncuatro e){
            System.out.println(e);
        }catch (sumaesseis e){
            System.out.println(e);
        }                        
    
    }
    
    static double division (double a, double b)throws esunzero, esuncuatro, sumaesseis {
        if ( b == 0.0){
            throw new esunzero ("El divisor no puede ser zero");
        }else if (a == 4){
            throw new esuncuatro ("El primer numero no puede ser 4");
        }else if (a+b==6){
            throw new sumaesseis ("La suma no puede ser 6");

        }else{
            return a/b;
        }
    }
}

class esunzero extends Exception{

    public esunzero(String message) {
        super(message);
    }
}

class esuncuatro extends Exception{

    public esuncuatro(String message) {
        super(message);
    }
}

class sumaesseis extends Exception{

    public sumaesseis(String message) {
        super(message);
    }
}
    
 
       
    
    
    


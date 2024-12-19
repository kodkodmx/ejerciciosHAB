package logica;

public class Squirtle extends Pokemon implements IAgua{

    public Squirtle() {
    }

    
  protected void atacarPlacaje(){
        System.out.println("Hola soy Squirtle y este es mi ataque Placaje");  
    }
    
    @Override
    protected void atacarAraniazo(){
        System.out.println("Hola soy Squirtle y este es mi ataque Araniazo");
    }
    
    @Override
    protected void atacarMordisco(){
        System.out.println("Hola soy Squirtle y este es mi ataque Mordisco");
    }

    @Override
    public void atacarHidrobomba() {
        System.out.println("Hola soy Squirtle y este es mi ataque Hidrobombao");
    }

    @Override
    public void atacarPistolaAgua() {
        System.out.println("Hola soy Squirtle y este es mi ataque Pistola de Agua");
    }

    @Override
    public void atacarBurbuja() {
        System.out.println("Hola soy Squirtle y este es mi ataque Burbuja");
    }

    @Override
    public void atacarHidropulso() {
        System.out.println("Hola soy Squirtle y este es mi ataque Hidropulsoa");
    }
}

package logica;

public class Pikachu extends Pokemon implements IElectrico{

    public Pikachu() {
    }
    
    protected void atacarPlacaje(){
        System.out.println("Hola soy Pikachu y este es mi ataque Placaje");  
    }
    
    @Override
    protected void atacarAraniazo(){
        System.out.println("Hola soy Pikachu y este es mi ataque Araniazo");
    }
    
    @Override
    protected void atacarMordisco(){
        System.out.println("Hola soy Pikachu y este es mi ataque Mordisco");
    }

    @Override
    public void atacarImpactrueno() {
        System.out.println("Hola soy Pikachu y este es mi ataque Impactrueno");
    }

    @Override
    public void atacarPunioTrueno() {
        System.out.println("Hola soy Pikachu y este es mi ataque Punio de trueno");
    }

    @Override
    public void atacarRayo() {
        System.out.println("Hola soy Pikachu y este es mi ataque Rayo");
    }

    @Override
    public void atacarRayoCarga() {
        System.out.println("Hola soy Pikachu y este es mi ataque RayoCarga");
    }
    
}
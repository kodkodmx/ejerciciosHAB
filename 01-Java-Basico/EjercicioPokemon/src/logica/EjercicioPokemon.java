package logica;

import logica.Bulbasaur;
import logica.Charmander;
import logica.Pikachu;
import logica.Squirtle;



public class EjercicioPokemon{

    public static void main(String[] args) {
        Charmander charmander = new Charmander();
        Bulbasaur bulbasaur = new Bulbasaur();
        Squirtle squirtle = new Squirtle();
        Pikachu pikachu = new Pikachu();

        System.out.println("----- Ataques Comunes -----");
        charmander.atacarPlacaje();
        bulbasaur.atacarAraniazo();
        squirtle.atacarMordisco();
        pikachu.atacarPlacaje();

        System.out.println("\n----- Ataques Específicos -----");

        charmander.atacarPunioFuego();
        charmander.atacarAscuas();
        charmander.atacarLanzallamas();


        bulbasaur.atacarParalizar();
        bulbasaur.atacarDrenaje();
        bulbasaur.atacarHojaAfilada();
        bulbasaur.atacarLatigoCepa();


        squirtle.atacarHidrobomba();
        squirtle.atacarPistolaAgua();
        squirtle.atacarBurbuja();
        squirtle.atacarHidropulso();


        pikachu.atacarImpactrueno();
        pikachu.atacarPunioTrueno();
        pikachu.atacarRayo();
        pikachu.atacarRayoCarga();
    }
}   
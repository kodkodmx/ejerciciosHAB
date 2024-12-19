package logica;

abstract class Pokemon {
    protected int numPokedex;
    protected String nombrePokemon;
    protected double pesoPokemon;
    protected String sexo;
    protected int temporadaQueAparece;
    protected String tipo;

//    protected Pokemon(int numPokedex, String nombrePokemon, double pesoPokemon, String sexo, int temporadaQueAparece, String tipo) {
//        this.numPokedex = numPokedex;
//        this.nombrePokemon = nombrePokemon;
//        this.pesoPokemon = pesoPokemon;
//        this.sexo = sexo;
//        this.temporadaQueAparece = temporadaQueAparece;
//        this.tipo = tipo;
//    }

    protected abstract void atacarPlacaje();
    protected abstract void atacarAraniazo();
    protected abstract void atacarMordisco();
}

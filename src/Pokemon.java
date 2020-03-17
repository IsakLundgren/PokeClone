public class Pokemon extends Entity {

    PokemonType type;

    Pokemon(String name, int level, PokemonType type, int baseHealth){
        super(name, level);
        this.type = type;
        this.health = baseHealth;
        this.baseHealth = baseHealth;
    }

    Pokemon(Pokemon pokemon){
       super(pokemon.getName(), pokemon.getLevel());
       this.type = pokemon.getType();
       this.health = pokemon.getHealth();
       this.baseHealth = pokemon.getBaseHealth();
    }

    public PokemonType getType(){
        return type;
    }
}

public class Pokemon extends Entity {

    PokemonType type;

    Pokemon(String name, int level, PokemonType type, int baseHealth){
        super(name, level);
        this.type = type;
        this.health = baseHealth;
        this.baseHealth = baseHealth;
    }
}

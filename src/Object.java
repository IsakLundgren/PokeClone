public class Object {
    private String name;
    private Pokemon[] presentPokemon;
    private int rarity;

    Object(String name, Pokemon[] presentPokemon, int rarity) {
        this.name = name;
        this.presentPokemon = presentPokemon;
        this.rarity = rarity;
    }

    public String getName() {
        return name;
    }

    public Pokemon inspect(){
        double rng = Math.random() * (presentPokemon.length + rarity);
        if((int) rng < rarity){
            System.out.println("Oh wow, it's nothing! You suck!");
            return null;
        }
        else{
            System.out.println("time to get your ass kicked");
            return presentPokemon[(int) rng - rarity];
        }
    }
}

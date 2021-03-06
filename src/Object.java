import java.util.ArrayList;

public class Object {
    private String name;
    private ArrayList<Pokemon> presentPokemon;
    private int rarity;

    Object(String name, ArrayList<Pokemon> presentPokemon, int rarity) {
        this.name = name;
        this.presentPokemon = presentPokemon;
        this.rarity = rarity;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Pokemon> getPresentPokemon() {
        return presentPokemon;
    }

    public int inspect(){
        double rng = Math.random() * (presentPokemon.size() + rarity);
        if((int) rng < rarity){
            return -1;
        }
        else{
            System.out.println(presentPokemon.get((int) rng - rarity).getName() + " jumps you.");
            System.out.println("Time to get your ass kicked");
            return (int) rng - rarity;
        }
    }
}

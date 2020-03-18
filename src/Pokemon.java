import java.util.Scanner;

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

    public void attack(Entity opponent){
        System.out.println(getName() + " strikes " + opponent.getName() + " for " + level * 10 + " hp.");
        opponent.setHealth(opponent.getHealth() - level * 10);
        if(opponent.getHealth() < 0){
            opponent.setHealth(0);
        }
    }

    public void attack(Pokemon opponent){
        opponent.setHealth(opponent.getHealth() - level * 10);
    }

    public boolean fight(Player player) { //true if win
        while (true) {
            if (player.isDed()) {
                return false;
            } else if (isDed()) {
                System.out.println("Wow, you've won, you're so good at this!");
                return true;
            }
            //Here's the actual fight
            else {
                Scanner scanner = new Scanner(System.in);
                System.out.println(player.getName() + ": Level " + player.getLevel() + " HP: " + player.getHealth());
                System.out.println(getName() + ": Level " + getLevel() + " HP: " + getHealth() + "\n");
                System.out.println("What would you like to do?");
                System.out.println("0. Run away like a cuck.");
                System.out.println("1. Kick the lil shit.");
                String ans = scanner.nextLine();
                try {
                    if(Integer.parseInt(ans) == 0){
                        System.out.println("While you run like a bitch, " + getName() + " manages to hit you.");
                        this.attack(player);
                        return false;
                    }
                    else if(Integer.parseInt(ans) == 1){
                        player.kick(this);
                        this.attack(player);
                    }
                    else{
                        System.out.println("Uh, yeah, no you cant do that, read ffs.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Uh, yeah, no you cant do that, read ffs.");
                }
            }
        }
    }

    //TODO make fights code for 2 pokemon
    public boolean fight(Player player, int pI){ //prisonIndex, true if win
        return false;
    }
}

import java.util.*;

public class Player extends Entity {

    ArrayList<Pokemon> prison;

    Player(String name, int level){
        super(name, level);
        this.baseHealth = 100;
        this.health = 100;
        prison = new ArrayList<Pokemon>();
    }

    @Override
    public void checkLevelUp() {
        if(exp >= level * 100){
            System.out.println("Congratulations, your dick grew. You suck!");
            increaseLevel();
            exp = 0;
        }
    }

    @Override
    public void damage(int amount){
        if(amount < 0){
            throw new NumberFormatException("The amount of damage was lower than 0, that's not how it works!");
        }
        if(amount >= health){
            System.out.println("You died, git gud lol!");
            health = 0;
        }
        else{
            System.out.println("You took " + amount + " damage!");
            health -= amount;
        }
    }

    public void printPrison(){
        if(prison.size() != 0) {
            for (int i = 0; i < prison.size(); i++) {
                if(prison.get(i).getHealth() == 0){
                    System.out.println(i + ". " + prison.get(i).getName() + ": Level " + prison.get(i).getLevel() +
                            ", " + prison.get(i).getType() + " type. (Dead)");
                }
                else {
                    System.out.println(i + ". " + prison.get(i).getName() + ": Level " + prison.get(i).getLevel() +
                            ", " + prison.get(i).getType() + " type.");
                }
            }
        }
        else{
            System.out.println("You have no pokemon, fight yourself, dumb cunt!");
        }
    }

    public ArrayList<Pokemon> getPrison() {
        return prison;
    }

    public void addPokemon(Pokemon pokemon){
        prison.add(new Pokemon(pokemon));
    }

    public void removePokemon(int slot){
        try{
            prison.remove(slot);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("There's no pokemon in slot " + slot + ".");
        }
    }

    public void update() {
        if(isDed()){
            System.out.println("HAH! YOU DIED! YOU SUCK!");
            System.exit(1);
        }
    }

    public void kick(Entity opponent){
        System.out.println("You kick " + opponent.getName() + " in the nuts for " + level * 12 + " hp.");
        opponent.setHealth(opponent.getHealth() - level * 12);
        if(opponent.getHealth() < 0){
            opponent.setHealth(0);
        }
    }
}

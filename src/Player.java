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

    public void kidnap(Pokemon pokemon){

    }

    public void update() {
        if(isDed()){
            System.exit(1);
        }
    }
}

import java.util.ArrayList;

public abstract class Entity {

    protected String name;
    protected int level;
    protected int exp;
    protected int baseHealth;
    protected int health;

    Entity(String name, int level){
        this.name = name;
        this.level = level;
        this.exp = 0;
    }

    public String toString(){
        return "Name: " + getName() + ". Level: " + getLevel() + ". Exp: " + getExp() + ".";
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getExp() {
        return exp;
    }

    public int getBaseHealth() {
        return baseHealth;
    }

    public int getHealth() {
        return health;
    }

    public void decreaseLevel(){
        level--;
    }

    public void increaseLevel(){
        level++;
    }

    public void checkLevelUp() {
        if(exp >= level * 100){
            increaseLevel();
            exp = 0;
        }
    }

    public void damage(int amount){
        if(amount < 0){
            throw new NumberFormatException("The amount of damage was lower than 0, that's not how it works!");
        }
        if(amount >= health){
            health = 0;
        }
        else{
            health -= amount;
        }
    }

    public boolean isDed(){
        return health == 0;
    }
}

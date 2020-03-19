import java.lang.reflect.Array;
import java.util.Scanner;

public class Room {

    protected RoomName name;
    protected int[] access;
    protected Object[] obj;

    Room(RoomName name, int[] access, Object[] obj){
        this.name = name;
        this.access = access;
        this.obj = obj;
    }

    public RoomName getName() {
        return name;
    }

    public void printOptions(){
        if(obj.length != 0){
            for(int i = 0; i < obj.length; i++){
                System.out.println("inspect" + i + ": inspect the " + obj[i].getName() + ".");
            }
        }
        for (int value : access) {
            System.out.println("move" + value + ": go to " + RoomName.values()[value] + ".");
        }
    }

    public void inspect(Player player, int objectNumber){
        try{
            try {
                int objPokeIndex = obj[objectNumber].inspect();
                Pokemon opponent = obj[objectNumber].getPresentPokemon().get(objPokeIndex);
                while (true) {
                    System.out.println("Pick your pokemon:");
                    player.printPrison();
                    if (player.getPrison().size() != 0) {
                        Scanner scan = new Scanner(System.in);
                        try {
                            int i = Integer.parseInt(scan.nextLine());
                            try {
                                boolean outcome = opponent.fight(player, i);
                                if (outcome) {
                                    player.addPokemon(new Pokemon(obj[objectNumber].getPresentPokemon().get(objPokeIndex)));
                                    obj[objectNumber].getPresentPokemon().remove(objPokeIndex);
                                    break;
                                }
                                else{
                                    System.out.println("Just as expected, " + player.getPrison().get(i).getName() + " has died." +
                                            " Now pick something else that will die!");
                                }
                            } catch (ArrayIndexOutOfBoundsException e) {
                                System.out.println("Yeah, there's no pokemon in that slot.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Well, that's no number, now is it?");
                        }
                    }
                    else {
                        if (opponent.fight(player)) {
                            player.addPokemon(new Pokemon(obj[objectNumber].getPresentPokemon().get(objPokeIndex)));
                            obj[objectNumber].getPresentPokemon().remove(objPokeIndex);
                            break;
                        }
                    }
                }
            }
            catch (IndexOutOfBoundsException e){
                System.out.println("Oh wow, it's nothing! You suck!");
            }
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("No, that can't be right.");
        }
    }

    public int[] getAccess(){
        return access;
    }

    public Object[] getObj() {
        return obj;
    }
}

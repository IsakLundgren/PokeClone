import java.util.*;

public class Game {

    private int room;
    private Player player;
    ArrayList<NPC> npc;
    Room[] rooms;

    Game(){
        this.room = 0;
        npc = new ArrayList<>();
        npc.add(new NPC("Mother", 30, 0));
        rooms = new Room[]{
                new Room(RoomName.MomsHouse, new int[]{1}, new Object[]{}),
                new Room(RoomName.MomsFrontYard, new int[]{0}, new Object[]{

                        new Object("Grass", new ArrayList<Pokemon>(Arrays.asList(
                                new Pokemon("Wabba", 1, PokemonType.Water, 70),
                                new Pokemon("RIP snorting", 1, PokemonType.Sand, 90)
                        )), 0),

                        new Object("Rock", new ArrayList<Pokemon>(Arrays.asList(
                                new Pokemon("2002 Honda Civic", 1, PokemonType.Fire, 150)
                                )), 0)

                })
        };
    }

    public void start() {

        Scanner scanner =new Scanner(System.in);

        System.out.println("F*ck, don't creep up on me like that. *Ugh* I swear to god, every fucking time. " +
                "Hello and welcome, what is your name?");

        String name;
        while(true) {
            String temp = scanner.nextLine();
            if (npc.get(0).getAnnoyance() <= 1) {
                System.out.println(temp + " huh? That's strange, sounds a bit dumb if you ask me. " +
                        "Are you sure that's your name? \nY/N");
            } else {
                System.out.println(temp + ". That's it right? \nY/N");
            }
            String ans = scanner.nextLine();
            if (ans.equals("Y") || ans.equals("y")) {
                System.out.println("*Sigh* Alright then.");
                name = temp;
                break;
            } else if (ans.equals("N") || ans.equals("n")) {
                System.out.println("I knew it. You may look dumb, but that name really was out of the park. " +
                        "Now, whats your name?");
            } else {
                switch (npc.get(0).getAnnoyance()) {
                    case 0:
                        System.out.println("Look, I've had a long day. Could you please just play along " +
                                "and pretend you're normal? Just tell me your name.");
                        npc.get(0).increaseAnnoyance();
                        break;
                    case 1:
                        System.out.println("Oh come on, give me a break. Please, just tell me your name.");
                        npc.get(0).increaseAnnoyance();
                        break;
                    case 2:
                        System.out.println("OH FOR F... Please. tell. me. your. name.");
                        npc.get(0).increaseAnnoyance();
                        break;
                    case 3:
                        System.out.println("OH MY GOD JUST FUCKING TELL ME YOUR NAME AND ENTER YES.");
                        npc.get(0).increaseAnnoyance();
                        break;
                    case 4:
                        if (ans.equals("YES") || ans.equals("yes") || ans.equals("Yes")) {
                            System.out.println("Y! FUCKING PRESS Y! Dipshit.");
                        } else {
                            System.out.println("Are you retarded? For real, just enter your fucking name and we'll " +
                                    "be done here.");
                            npc.get(0).increaseAnnoyance();
                        }
                        break;
                    case 5:
                        throw new NumberFormatException("GO FUCK YOURSELF");
                }
            }
        }
        System.out.println("Now, how big are you packing? Answer in inches");
        String unnessecary = scanner.nextLine();
        if(npc.get(0).getAnnoyance() > 1) {
            System.out.println(unnessecary + "? Right. Im going to mark it as 1, since we both know that's the case.");
            player = new Player(name, 1);
        }
        else {
            System.out.println(unnessecary + "? I have my doubts, but I'll mark it as 2, just this once");
            player = new Player(name, 2);
        }
        System.out.println("Now, off you go.");
        System.out.println("Do you want to flip her off? \n Y/N");
        String ans = scanner.nextLine();
        if(ans.equals("Y") || ans.equals("y")){
            if(npc.get(0).getAnnoyance() == 0) {
                System.out.println("Well, fuck you too then.");
                npc.get(0).increaseAnnoyance();
                System.out.println("You leave your moms house.");
            }
            else if(npc.get(0).getAnnoyance() == 1){
                System.out.println("Oh, did I say 2? Well of course i meant 1");
                player.decreaseLevel();
                npc.get(0).increaseAnnoyance();
                System.out.println("You leave your moms house.");
            }
            else{
                System.out.println("Come here you little shit!");
                player.damage(npc.get(0).getAnnoyance()*10);
                System.out.println("You manage to escape your moms clutches before she kills you!");
                npc.get(0).increaseAnnoyance();
                npc.get(0).increaseAnnoyance();
            }
        }
        else if(ans.equals("N") || ans.equals("n")) {
            System.out.println("You leave your moms house.");
            System.out.println("She's glad you went away");
            npc.get(0).decreaseAnnoyance();
        }
        else{
            System.out.println("You're retarded.");
            System.out.println("You leave your moms house.");
        }
        room = 1;
        System.out.println("You are now outside!");
    }

    public void quickStart(){
        player = new Player("Default", 1);
    }

    private void move(int designation){
        boolean check = false;
        for(int i = 0; i < rooms[room].getAccess().length; i++){
            if(rooms[room].getAccess()[i] == designation){
                check = true;
            }
        }
        if(check){
            System.out.println("You have left " + rooms[room].getName() + ".");
            room = designation;
            System.out.println("You have entered " + rooms[room].getName() + ".");
        }
        else if(designation == room){
            System.out.println("You're already here.");
        }
        else{
            System.out.println("Sorry, you cannot go there.");
        }
    }

    private void options(){
        System.out.println("What would you like to do?");
        Scanner scan = new Scanner(System.in);
        String ans = scan.nextLine();
        if(ans.equals("help")){
            System.out.println("You're currently in " + rooms[room].getName() + ".");
            System.out.println("Here's your available options: \n");
            rooms[room].printOptions();
        }
        else if(ans.startsWith("move")){
            if(ans.length() > 4) {
                try{
                    move(Integer.parseInt(ans.substring(4)));
                }
                catch(NumberFormatException e){
                    System.out.println("That's not a place");
                }
            }
        }
        else if(ans.startsWith("inspect")){
            if(rooms[room].getObj().length == 0){
                System.out.println("There's nothing to inspect here.");
            }
            else if(ans.length() > 7) {
                try{
                    rooms[room].inspect(player, Integer.parseInt(ans.substring(7)));
                }
                catch(NumberFormatException e){
                    System.out.println("That's not a thing" + ans.substring(7));
                }
            }
        }
        else{
            System.out.println("That did not make any sense. (type \"help\" for a list of available commands).");
        }
    }

    public void go() {
        options();
        player.update();
    }
}

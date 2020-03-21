public class Honda extends Pokemon {
    private int evo;

    Honda(int level, int hp, int evo){
        super("Honda", level, PokemonType.Fire, hp);
        this.evo = evo;
    }

    @Override
    public String getName(){
        switch(evo){
            case 1:
                return "2002 Honda Jazz";

            case 2:
                return "2002 Honda HR-V";

            case 3:
                return "2002 Honda Civic";

            case 4:
                return "Yoda Car";
        }
        return "Honda";
    }

    public int getEvo() {
        return evo;
    }

    public void printAbilities(){
        //TODO Fix this and implement abilities in fights
        System.out.println("1. Attack the lil shit\n" +
                "2. Drive\n" +
                "3. Pull over and take a nap\n" +
                "4. Nitro\n" +
                "5. Run over minorities");
    }

    public void ability1(Pokemon opponent){
        String name = "Drive";
        System.out.println(getName() + " used " + name + ".");
        System.out.println(opponent.getName() + " took " + level * 12 + " damage.");
        opponent.setHealth(opponent.getHealth() - level * 12);
        if(opponent.getHealth() < 0){
            opponent.setHealth(0);
        }
    }

    public void ability2(Pokemon opponent){
        String name = "Pull over and take a nap";
        if(evo >= 2) {
            System.out.println(getName() + " used " + name + ".");
            setHealth(getHealth() + level * 20);
            System.out.println(getName() + " healed " + level * 20 + " HP.");
        }
    }

    public void ability3(Pokemon opponent){
        String name = "Nitro";
        if(evo >= 3) {
            System.out.println(getName() + " used " + name + ".");
            System.out.println(opponent.getName() + " took " + level * 15 + " damage.");
            opponent.setHealth(opponent.getHealth() - level * 15);
            if (opponent.getHealth() < 0) {
                opponent.setHealth(0);
            }
        }
    }

    public void ability4(Pokemon opponent){
        String name = "Run over minorities";
        if(evo >= 4) {
            if (opponent.getType() == PokemonType.Black) {
                System.out.println(getName() + " used " + name + ".");
                System.out.println("Since " + opponent.getName() + " is black, they take " + level * 20 + " damage.");
                opponent.setHealth(opponent.getHealth() - level * 20);
                if(opponent.getHealth() < 0){
                    opponent.setHealth(0);
                }
            }
            else {
                System.out.println(getName() + " used " + name + ".");
                System.out.println(opponent.getName() + " took " + level * 10 + " damage.");
                opponent.setHealth(opponent.getHealth() - level * 10);
                if(opponent.getHealth() < 0){
                    opponent.setHealth(0);
                }
            }
        }
    }

}

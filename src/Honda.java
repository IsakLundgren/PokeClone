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

    public void ability1(Pokemon opponent){
        String name = "";
    }

    public void ability2(Pokemon opponent){
        String name = "";
    }

    public void ability3(Pokemon opponent){
        String name = "";
    }

    public void ability4(Pokemon opponent){
        String name = "Run over minorities";
    }

}

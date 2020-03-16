public class NPC extends Entity {

    private int annoyance;

    NPC(String name, int level, int annoyance){
        super("Mother", level);
        this.annoyance = annoyance;
    }

    public int getAnnoyance() {
        return annoyance;
    }

    public void increaseAnnoyance() {
        annoyance++;
    }

    public void decreaseAnnoyance() {
        if(annoyance > 0) {
            annoyance--;
        }
    }
}

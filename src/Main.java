public class Main {

    public static void main(String[] args) {

        Game game = new Game();

        game.start();

        while(true) {
            game.go();
        }

    }
}

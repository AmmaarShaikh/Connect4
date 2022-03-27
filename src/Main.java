public class Main {
    public static void main(String[] args){
        Connect4 newGame = new Connect4("\033[0;31m"+"X", "\033[0;33m"+"O");
        newGame.startGame();
    }
}

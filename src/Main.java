/** This class will start the program
 *
 * @author Ammaar Shaikh
 */

public class Main {
    public static void main(String[] args){
        //Creates a Connect4 object and starts the game
        Connect4 newGame = new Connect4("\033[0;31m"+"X", "\033[0;33m"+"O");
        newGame.startGame();
    }
}

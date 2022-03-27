/** This class represents a Connect4 object
 *
 * @author Ammaar Shaikh
 */

import java.util.Scanner;
import java.util.ArrayList;

public class Connect4 {
    /** The Board object on which the game will be played*/
    private Board theBoard;

    /** The Player object that represents player 1*/
    private Player player1;
    /** The Player object that represents player 2*/
    private Player player2;
    /** Keeps check of who is currently playing*/
    private boolean player1Playing;
    /** The list of the moves that the players did during the game*/
    private ArrayList<String> recordedTurns;
    /** Allows the players to interact with the game*/
    private Scanner scanner;

    /** Instantiates a Connect4 object
     * <p>
     * Creates 2 Player objects based on the strings given, and also
     * creates the Board object, recordedTurns ArrayList, and the scanner.
     * Also sets player1Playing true, as player 1 always goes first
     * <p>
     * @param player1 The string that represents the first player
     * @param player2 The string that represents the second player
     */
    public Connect4(String player1, String player2){
        theBoard = new Board();
        this.player1 = new Player("Player 1", player1);
        this.player2 = new Player("Player 2", player2);
        recordedTurns = new ArrayList<>();
        scanner = new Scanner(System.in);

        player1Playing = true;
    }

    /** Starts the Connect 4 game by using the player1Playing variable
     * to determine who's turn it is, and then asks them, using the
     * scanner, which column they would like the piece to go in. If
     * the Board is completely filled, game ends by turning off the while
     * loop that is turning the game. Else it puts the piece in and uses
     * the checkWinner method to see if the current player won. If they
     * did, the while loop ends and the list of player moves is printed
     *
     */
    public void startGame(){
        boolean endGame = false;
        String player;
        String playerName;
        boolean success = false;
        int choice = 0;

        while(!endGame){ //Loops while the game has not ended
            if(player1Playing){ //Determines who is currently playing
                System.out.println("\033[1;36m"+"---------------");
                System.out.println("\033[0;32m"+"Player 1's turn");
                player = player1.getColor();
                playerName = player1.getName();
            }
            else{
                System.out.println("\033[1;36m"+"---------------");
                System.out.println("\033[0;32m"+"Player 2's turn");
                player = player2.getColor();
                playerName = player2.getName();
            }
            if(!(theBoard.isBoardFilled())){ //Continue if the Board is not filled
                theBoard.printBoard();
                System.out.println("\033[0;32m"+playerName + "\033[0;32m"+", where would you like to place the piece");
                System.out.print("\033[0;32m"+"Choose between 1 and 7: ");
                choice = scanner.nextInt();
                recordedTurns.add(playerName + ": " + choice);
                success = theBoard.placePiece(choice, player);
            }
            else{
                System.out.println("The board is filled\nGame ended, a tie!");
                int count = 1;
                System.out.println("\033[1;93m"+"Game Turn Directory");
                System.out.println("\033[1;93m"+"---------------");
                for(int i = 0; i < recordedTurns.size(); i++){
                    System.out.println("\033[1;93m"+count +"\033[1;93m"+ ". " +"\033[1;93m"+ recordedTurns.get(i));
                    count++;
                }
                endGame = true;
            }

            if (success){ //If the piece was placed
                if (checkWinner(choice-1)){
                    theBoard.printBoard();
                    System.out.println(playerName + " got 4 in a row\nGame ended!");
                    int count = 1;
                    System.out.println("\033[1;93m"+"Game Turn Directory");
                    System.out.println("\033[1;93m"+"---------------");
                    for(int i = 0; i < recordedTurns.size(); i++){
                        System.out.println("\033[1;93m"+count +"\033[1;93m"+ ". " +"\033[1;93m"+ recordedTurns.get(i));
                        count++;
                    }
                    endGame = true;
                }
                player1Playing = !player1Playing; //Gives the other player the turn
            }
        }
    }

    /** Uses the checkForWinner method from the Board
     * to see if the Piece placed results in a win.
     *
     * @param place The position of the Piece that was placed
     * @return true if there is a winning position, false if not
     */
    public boolean checkWinner(int place){
        String color;
        if (player1Playing){
            color = player1.getColor();
        }
        else{
            color = player2.getColor();
        }
        return theBoard.checkForWinner(place, color);
    }
}

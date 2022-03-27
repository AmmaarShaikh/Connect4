import java.util.Scanner;
import java.util.ArrayList;

public class Connect4 {
    private Board theBoard;

    private Player player1;
    private Player player2;
    private boolean player1Playing;
    private ArrayList<String> recordedTurns;
    private Scanner scanner;

    public Connect4(String player1, String player2){
        theBoard = new Board();
        this.player1 = new Player("Player 1", player1);
        this.player2 = new Player("Player 2", player2);
        recordedTurns = new ArrayList<>();
        scanner = new Scanner(System.in);

        player1Playing = true;
    }

    public void startGame(){
        boolean endGame = false;
        String player;
        String playerName;
        boolean success = false;
        int choice = 0;

        while(!endGame){
            if(player1Playing){
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
            if(!(theBoard.isBoardFilled())){
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

            if (success){
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
                player1Playing = !player1Playing;
            }
        }
    }

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

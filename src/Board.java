/** This class represents a Board object
 *
 * @author Ammaar Shaikh
 */

public class Board {

    /** The 2d Array of Piece with 6 rows and 7 columns which is the board*/
    private Piece[][] theBoard = new Piece[6][7];

    /** Instantiates a Board object
     */
    public Board() {
        for (int row = 0; row < theBoard.length; row++) {
            for (int col = 0; col < theBoard[0].length; col++) {
                theBoard[row][col] = null;
            }
        }
    }

    /** Prints the Board in the console
     */
    public void printBoard(){
        for (Piece[] row : theBoard){
            System.out.print("\033[1;37m"+"|");
            for (Piece col : row){
                if (col == null){
                    System.out.print("\033[1;37m"+"_");
                }
                else {
                    System.out.print(col.getColor());
                }
                System.out.print("\033[1;37m"+"|");
            }
            System.out.println();
        }
    }

    /** Places a specific piece into the Board
     *
     * @param column The number of the column where the piece will go
     * @param color The type of piece that will go there i.e. red or yellow
     * @return True if the piece was successfully, false if not
     */
    public boolean placePiece(int column, String color){
        boolean pieceAdded = false;
        if (column > 0 && column < 8){
            if (!isBoardFilled()){
                if (theBoard[0][column-1] != null){
                    System.out.println("The column is filled");
                    return false;
                }
                else{
                    for (int row = theBoard.length-1; row >=0; row--){
                        if (theBoard[row][column-1] == null){
                            theBoard[row][column-1] = new Piece();
                            theBoard[row][column-1].setColor(color);
                            pieceAdded = true;
                            break;
                        }
                    }
                }

            }
            else{
                System.out.println("The Board is filled");
                return false;
            }
            }
        else{
            System.out.println("Not real column");
            return false;
        }
        return pieceAdded;
    }

    /** Checks to see if the Board is completely filled with Pieces
     * by checking to see if none of the Pieces are null
     *
     * @return true if the Board is filled, false if not
     */
    public boolean isBoardFilled(){
        for (Piece[] row : theBoard){
            for (Piece col : row){
                if (col == null){
                    return false;
                }
            }
        }
        return true;
    }

    /** Checks to see if a specific player has gotten 4 in a row
     * and has won the game
     *
     * @param place The position of the Piece that it will check from
     * @param color The specific color of the Piece, it will determine who won
     * @return true if there are 4 of the same colored Pieces in a row, false if not
     */
    public boolean checkForWinner(int place, String color){
        boolean hasWon = false;

        for(int row = 0; row < theBoard.length; row++){
            if(theBoard[row][place] != null){
                int streak = 3;
                //Checking down
                for (int row1 = row + 1; row1 < theBoard.length; row1++){
                    if (theBoard[row1][place].getColor() == color){
                        streak--;
                        if(streak == 0){
                            hasWon = true;
                        }
                    }
                    else{
                        streak = 3;
                    }
                }
                streak = 4;
                //Check horizontal
                for (int col = place - 3; col < place + 3; col++){
                    if(col < 0) continue;
                    if (col >= theBoard[0].length){
                        break;
                    }
                    if (theBoard[row][col] != null && theBoard[row][col].getColor() == color){
                        streak--;
                        if(streak == 0){
                            hasWon = true;
                        }
                    }
                    else{
                        streak = 4;
                    }
                }
            }
        }
        return hasWon;
    }
}
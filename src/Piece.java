/** This class represents a Piece object
 *
 * @author Ammaar Shaikh
 */

public class Piece {

    /** The color of the Piece, corresponds to the player*/
    private String color;


    /** Instantiates a Piece object
     */
    public Piece(){};

    /** Returns the color of the Piece
     *
     * @return the color of the Piece
     */
    public String getColor(){
        return color;
    }

    /** Sets the color of the Piece
     *
     * @param color The color that will be set as the Pieces color
     */
    public void setColor(String color) {
        this.color = color;
    }
}

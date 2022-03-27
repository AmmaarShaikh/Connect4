/** This class represents a Player object
 *
 * @author Ammaar Shaikh
 */

public class Player {
    /** The string that represents the player on the Board*/
    private String color;
    /** The name of the player*/
    private String name;

    /** Instantiates a Player object
     *
     * @param name The name
     * @param color The String that will represent it on the Board
     */
    public Player(String name, String color){
        this.name = name;
        this.color = color;
    }

    /** Returns the symbol of the player
     *
     * @return The symbol of the Player
     */
    public String getColor() {
        return color;
    }

    /** Returns the name of the Player
     *
     * @return the name of the Player
     */
    public String getName() {
        return name;
    }
}

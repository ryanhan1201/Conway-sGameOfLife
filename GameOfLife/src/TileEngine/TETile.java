package TileEngine;
import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;


public class TETile {
    private final char character;
    private final Color textColor;
    private final Color bgColor;

    public TETIle(char character, Color textColor, Color backgroundColor){
        this.character = character;
        this.textColor = textColor;
        this.backgroundColor = backgroundColor;
    }

    public void draw(double x, double y) {
        if (filepath != null) {
            try {
                StdDraw.picture(x + 0.5, y + 0.5, filepath);
                return;
            } catch (IllegalArgumentException e) {
                // Exception happens because the file can't be found. In this case, fail silently
                // and just use the character and background color for the tile.
            }
        }

        StdDraw.setPenColor(backgroundColor);
        StdDraw.filledSquare(x + 0.5, y + 0.5, 0.5);
        StdDraw.setPenColor(textColor);
        StdDraw.text(x + 0.5, y + 0.5, Character.toString(character()));
    }


}

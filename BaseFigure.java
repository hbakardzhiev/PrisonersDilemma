import java.awt.*;

abstract class BaseFigure {
    // holds the color
    protected Color color;
    // setting the const row and col size
    protected static final int ROW_SIZE = 50;
    protected static final int COL_SIZE = 50;
    // used for drawing in the GUI
    // overwritten in the classes which extend this one
    public abstract void draw(Graphics g);
}

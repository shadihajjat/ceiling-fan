import java.awt.*;
import java.awt.geom.Line2D;

public class DrawFan {
    /**
     * draw the fan
     * <p>
     * draw the ceiling fan shape
     * </p>
     * @author shadi hajjat
     * @version 1.0
     **/
    private Line2D.Double line= new Line2D.Double(400,0,400,200);
    private Graphics2D g2d;

    /**
     * take the required values for the drawing the fan shape
     **/
    protected void draw(Graphics g, int startA1,int startA2,int startA3){
        g2d=(Graphics2D) g;
        g2d.draw(line);
        g2d.fillOval(390,190,20,20);
        g2d.fillArc(250,50,300,300,startA1, 30);
        g2d.fillArc(250,50,300,300,startA2, 30);
        g2d.fillArc(250,50,300,300,startA3, 30);
    }

}

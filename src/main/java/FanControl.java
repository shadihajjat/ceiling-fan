import javax.swing.*;
import java.awt.*;

public class FanControl extends JPanel implements FanRunnable {
    /**
     * build the panel
     * <p>
     *     here we build and control the drawing, the class implement the FanRunnable
     *
     * </p>
     *  @see FanRunnable
     * @author shadi hajjat
     * @version 1.0
     **/
    private int startA1=30;
    private int startA2=160;
    private int startA3=280;
    private Timer timer;
    private int delay=210;
    private int speed=1;
    private int mode =1;
    private DrawFan drawFan=new DrawFan();

    /**
     * set the speed and mode
     * create and start the timer
     * on the timer constructor we use the lambda for teh actionListener
     **/
    FanControl(int speed, int mode){
        this.speed=speed;
        this.mode=mode;
        timer=new Timer(delay,e->fresh());
        timer.start();
    }


    public Timer getTimer() {
        return timer;
    }

    public int getSpeed() {
        return speed;
    }

    public int getMode() {
        return mode;
    }



    /**
     * to reset the fan drawing and call the repaint

     **/
    private void fresh() {
        startA1+=(30 * mode);
        startA2+=(30 * mode);
        startA3+=(30 * mode);
        repaint();
    }

    /**
     * paint the fan shape

     **/
    @Override
    public void paint(Graphics g) {
        drawFan.draw(g,startA1,startA2,startA3);
     }

    /**
     * called to increase the speed, or turn off after 3
     * if the fan is stopped to restart the timer

     **/
    @Override
    public void increaseSpeed() {
         speed++;
        if(speed>3) {
            turnOff();
            speed=0;
        }
        else {
            if (!timer.isRunning()) timer.restart();
            timer.setDelay(delay / (speed*2));
        }
    }

    /**
     * called to reset the mode between summer and winter mode

     **/
    @Override
    public void setMode() {
        this.mode = - mode;
        if(timer.isRunning())
        fresh();
    }

    /**
     * to turn off teh fan by stop the timer

     **/
    @Override
    public void turnOff() {
     this.timer.stop();
    }

}

import javax.swing.*;
import java.awt.event.WindowAdapter;


public class FanFrame extends JFrame {
/**
 * build the main frame
 * <p>
 *     here we build all the components for our frame
 *     no professional layout added,
 *     used the lambda on the actionListeners
 * </p>
 *
 * @author shadi hajjat
 * @version 1.0
 **/
private FanControl fanControl;
private JTextField speedLabel,modeLabel;

FanFrame(){
        initFrame();
        initFanControl();
        initLabels();
        initButton();
        this.setVisible(true);
    }

    /**
     * set the frame properties
     **/
    private void initFrame() {
        this.setSize(800,600);
        this.setTitle(" Ceiling Fan Simulation");
        this.setLayout(null);

        this.addWindowListener(new java.awt.event.WindowAdapter() {
                                   public void windowClosing(java.awt.event.WindowEvent e) {
                                       fanControl.getTimer().stop();
                                       fanControl=null;
                                       System.gc();
                                       System.exit(0);
                                   } });

      //  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     *<p>
     *create the buttons and set the actionListener using lambda exp,
     * update the label
     *</p>
     **/
    private void initButton() {
        JButton speed=new JButton("speed");
        JButton mode=new JButton("mode");
        speed.setBounds(300,450,100,30);
        mode.setBounds(400,450,100,30);
        speed.addActionListener(e-> {
            fanControl.increaseSpeed();
            speedLabel.setText( fanControl.getSpeed()==0?"Stopped": fanControl.getSpeed()+" speed");
        });
        mode.addActionListener(e-> {
            fanControl.setMode();
            modeLabel.setText((fanControl.getMode()==1?"winter":"summer")+" mode");
        });
        this.add(speed);
        this.add(mode);
    }

    /**
     * set the frame properties
     **/
    private void initLabels() {
        speedLabel=new JTextField("1 speed");
        modeLabel=new JTextField("summer mode");
        speedLabel.setBounds(300,500,100,30);
        modeLabel.setBounds(400,500,110,30);
        speedLabel.setEditable(false);
        modeLabel.setEditable(false);
        this.add(speedLabel);
        this.add(modeLabel);
    }

    /**
     * instantiate the {@link FanControl}  to add to the frame
     **/
    private void initFanControl() {
        fanControl =new FanControl(1,1);
        fanControl.setBounds(0,0,800,400);
        this.add(fanControl);
    }


}

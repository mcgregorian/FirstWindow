import oracle.jrockit.jfr.JFR;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CtFSuwak extends JFrame implements ChangeListener {

    private JLabel lC, lF;
    private JSlider sC,sF;
    private int tempC,tempF;

    public CtFSuwak()
    {
        setSize(500,300);
        setTitle("Przeliczanie stopni Celsiusza na Hahrenheita");
        setLayout(null);

        sC=new JSlider(0,100,0);
        sC.setBounds(50,50,300,50);
        sC.setMajorTickSpacing(20);
        sC.setMinorTickSpacing(5);
        sC.setPaintTicks(true);
        sC.setPaintLabels(true);
        sC.addChangeListener(this);
        add(sC);

        sF=new JSlider(30,212,30);
        sF.setBounds(50,150,300,50);
        sF.setMajorTickSpacing(20);
        sF.setMinorTickSpacing(5);
        sF.setPaintTicks(true);
        sF.setPaintLabels(true);
        sF.addChangeListener(this);
        sF.setEnabled(false);
        add(sF);

        lC=new JLabel("Celsius : ");
        lC.setBounds(380,50,300,50);
        add(lC);

        lF=new JLabel("Fahrenheit : ");
        lF.setBounds(380,150,300,50);
        add(lF);

    }

    public static void main(String args[])
    {
        CtFSuwak app=new CtFSuwak();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    }

    @Override
    public void stateChanged(ChangeEvent e)
    {
        tempC=sC.getValue();
        lC.setText("Celsius : " + tempC);

        tempF=(int)Math.round(32+(9.0/5.0)*tempC);
        lF.setText("Fahrenheit : "+tempF);
        sF.setValue(tempF);
    }
}

import com.sun.org.apache.xerces.internal.xs.StringList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FtC extends JFrame implements ActionListener
{
    private JLabel lCelsius, lFahrenheit;
    private JTextField tCelsius, tFahrenheit;
    private JButton bKonwert;
    private ButtonGroup radioPanel ;
    private JRadioButton rbCtoF, rbFtoC;
    private double tempC,tempF;


    public FtC()
    {

        setSize(400,300);
        setTitle("Przeliczanie stopni Celsiusza na Fahrenheita");
        setLayout(null);

        lCelsius=new JLabel("Stopnie Celsiusza");
        lCelsius.setBounds(20,20,150,20);
        add(lCelsius);

        tCelsius=new JTextField("");
        tCelsius.setBounds(170,20,150,20);
        add(tCelsius);
        tCelsius.addActionListener(this);


        lFahrenheit=new JLabel("Stopnie Fahrenheita");
        lFahrenheit.setBounds(20,70,150,20);
        add(lFahrenheit);

        tFahrenheit=new JTextField("");
        tFahrenheit.setBounds(170,70,150,20);
        add(tFahrenheit);
        tFahrenheit.addActionListener(this);

        bKonwert=new JButton("Konwertuj");
        bKonwert.setBounds(110,120,150,20);
        add(bKonwert);
        bKonwert.addActionListener(this);

        radioPanel= new ButtonGroup();
        rbCtoF=new JRadioButton("Celsius to Fahrenheit");
        rbCtoF.setBounds(50,150,150,20);
        rbCtoF.setSelected(true);

        rbFtoC=new JRadioButton("Fahrenheit to Celsius");
        rbFtoC.setBounds(200,150,150,20);

        radioPanel.add(rbCtoF);
        radioPanel.add(rbFtoC);

        add(rbCtoF);
        add(rbFtoC);




    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object zrodlo=e.getSource();
        if(zrodlo==bKonwert) {
            if(rbCtoF.isSelected()) {

                tempC = Double.parseDouble(tCelsius.getText());
                tempF = 32.0 + (9.0 / 5.0) * tempC;
                tFahrenheit.setText(String.valueOf(tempF));
            }
            else if(rbFtoC.isSelected())
            {
                tempF=Double.parseDouble(tFahrenheit.getText());
                tempC=(tempF-32.0)*(5.0/9.0);
                tCelsius.setText(String.valueOf(tempC));
            }
        }
        if(zrodlo==tCelsius){
            tempC = Double.parseDouble(tCelsius.getText());
            tempF = 32.0 + (9.0 / 5.0) * tempC;
            tFahrenheit.setText(String.valueOf(tempF));
        }
        else if(zrodlo==tFahrenheit){
            tempF=Double.parseDouble(tFahrenheit.getText());
            tempC=(tempF-32.0)*(5.0/9.0);
            tCelsius.setText(String.valueOf(tempC));
        }


    }

    public static void main(String args[])
    {
        FtC przelicznik=new FtC();
        przelicznik.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        przelicznik.setVisible(true);
    }

}


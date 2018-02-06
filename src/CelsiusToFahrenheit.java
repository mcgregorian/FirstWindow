import com.sun.org.apache.xerces.internal.xs.StringList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CelsiusToFahrenheit extends JFrame implements ActionListener
{
    private JLabel lCelsius, lFahrenheit;
    private JTextField tCelsius, tFahrenheit;
    private JButton bKonwert;
    private JCheckBox chWielkie;
    private ButtonGroup bgRozmiar;
    private JRadioButton rbS, rbM, rbL;
    private double tempC,tempF;


    public CelsiusToFahrenheit()
    {

     setSize(500,500);
     setTitle("Przeliczanie stopni Celsiusza na Fahrenheita");
     setLayout(null);

     lCelsius=new JLabel("Stopnie Celsiusza");
     lCelsius.setBounds(20,20,150,20);
     add(lCelsius);

     tCelsius=new JTextField("");
     tCelsius.setBounds(170,20,150,20);
     add(tCelsius);
     tCelsius.addActionListener(this);
     tCelsius.setToolTipText("Podaj temperaturę w stopniach Celsiusza");

     lFahrenheit=new JLabel("Stopnie Fahrenheita");
     lFahrenheit.setBounds(20,70,150,20);
     add(lFahrenheit);

     tFahrenheit=new JTextField("");
     tFahrenheit.setBounds(170,70,150,20);
     add(tFahrenheit);

     bKonwert=new JButton("Konwertuj");
     bKonwert.setBounds(110,120,150,20);
     add(bKonwert);
     bKonwert.addActionListener(this);

     chWielkie = new JCheckBox("Wielkie litery");
     chWielkie.setBounds(280,120,150,20);
     add(chWielkie);
    // chWielkie.addActionListener(this);

     bgRozmiar=new ButtonGroup();
     rbS=new JRadioButton("Mały", true);
     rbS.setBounds(50,150,100,20);
     bgRozmiar.add(rbS);
     add(rbS);
     //rbS.addActionListener(this);

        rbM=new JRadioButton("Sredni", false);
        rbM.setBounds(150,150,100,20);
        bgRozmiar.add(rbM);
        add(rbM);
        //rbM.addActionListener(this);

        rbL=new JRadioButton("Duży", false);
        rbL.setBounds(250,150,100,20);
        bgRozmiar.add(rbL);
        add(rbL);
        //rbL.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object zrodlo=e.getSource();
        if(zrodlo==bKonwert||zrodlo==tCelsius) {

            if(chWielkie.isSelected()){
                tFahrenheit.setFont(new Font("SansSerif", Font.BOLD, 18));
            }
            else{
                tFahrenheit.setFont(new Font("SansSerif", Font.PLAIN, 12));
            }
            tempC = Double.parseDouble(tCelsius.getText());
            tempF = 32 + (9 / 5) * tempC;
            tFahrenheit.setText(String.valueOf(tempF));
        }
        //else if(zrodlo==rbS){
        //    tFahrenheit.setFont(new Font("SansSerif", Font.PLAIN, 12));
        //}
        //else if(zrodlo==rbM){
        //    tFahrenheit.setFont(new Font("SansSerif", Font.PLAIN, 16));
        //}
        //else if(zrodlo==rbL){
        //    tFahrenheit.setFont(new Font("SansSerif", Font.PLAIN, 20));
        //}


    }

    public static void main(String args[])
    {
     CelsiusToFahrenheit aplikacja=new CelsiusToFahrenheit();
     aplikacja.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     aplikacja.setVisible(true);
    }

}

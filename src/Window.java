import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

public class Window extends JFrame implements ActionListener
{
    JButton bPodajDate, bExit;
    JLabel lPokazDate;

    public Window(){
        setSize(500,500);
        setTitle("Hello world!");
        setLayout(null);
        bPodajDate=new JButton("Podaj datę");
        bPodajDate.setBounds(100,100,100,30);
        add(bPodajDate);
        bPodajDate.addActionListener(this);

        bExit = new JButton("Exit");
        bExit.setBounds(200,100,100,30);
        add(bExit);
        bExit.addActionListener(this);

        lPokazDate = new JLabel("Data");
        lPokazDate.setBounds(150,150,300,100);
        lPokazDate.setForeground(Color.magenta);
        lPokazDate.setFont(new Font("SansSerif", Font.BOLD, 16));
        add(lPokazDate);

    }
    public static void main(String args[]){
        Window window=new Window();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object zrodlo=e.getSource();
        if(zrodlo==bPodajDate) {
            LocalDateTime date = LocalDateTime.now();
           String a = Integer.toString(date.getDayOfMonth());
           String b= date.getMonth().toString();
           String c=Integer.toString(date.getYear());
            lPokazDate.setText(a+" "+b+" "+c);

        //    System.out.println(date.getDayOfMonth());
        //    System.out.println(date.getMonth());
        //    System.out.println(date.getYear());
        }
        else if(zrodlo==bExit){
            dispose();
        }

    }
}

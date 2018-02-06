package RownanieKwadratowe;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class rownanieGUI extends JFrame implements ActionListener {

    private JTextField ta,tb,tc,twynik;
    private JLabel la,lb,lc,wzor;
    private JButton bSolve;

    public rownanieGUI()
    {
        setSize(400,400);
        setTitle("Rozwiązywanie równania kwadratowego");
        setLayout(null);

        wzor=new JLabel("ax^2 + bx + c = 0");
        wzor.setBounds(10,20,200,20);

        la=new JLabel("a");
        la.setBounds(30,50,20,20);
        ta=new JTextField();
        ta.setBounds(50,50,50,20);
        ta.setToolTipText("Podaj współczynnik a");

        lb=new JLabel("b");
        lb.setBounds(130,50,20,20);
        tb=new JTextField();
        tb.setBounds(150,50,50,20);
        tb.setToolTipText("Podaj współczynnik b");

        lc=new JLabel("c");
        lc.setBounds(230,50,20,20);
        tc=new JTextField();
        tc.setBounds(250,50,50,20);
        tc.setToolTipText("Podaj współczynnik c");

        bSolve=new JButton("Rozwiąż równanie");
        bSolve.setBounds(110,150,150,20);
        bSolve.addActionListener(this);

        twynik=new JTextField();
        twynik.setBounds(0,200,400,20);

        add(la);
        add(ta);
        add(lb);
        add(tb);
        add(lc);
        add(tc);
        add(wzor);
        add(bSolve);
        add(twynik);
    }
    public static void main(String args[])
    {
        rownanieGUI app=new rownanieGUI();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        double a=Double.parseDouble(ta.getText());
        double b=Double.parseDouble(tb.getText());
        double c=Double.parseDouble(tc.getText());

        RownanieKwadratowe rownanie=new RownanieKwadratowe(a,b,c);
        String solution=rownanie.solve();
        twynik.setText(solution);

    }
}

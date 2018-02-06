package Menu;

import sun.security.util.Password;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordTest extends JFrame implements ActionListener {

    private JTextArea notatnik;
    private JScrollPane scP;
    private JButton bAddUser;


    public PasswordTest()
    {
        setTitle("Demonstracja okna dialogowego");
        setSize(400,400);
        setLayout(null);

        notatnik=new JTextArea();
        notatnik.setWrapStyleWord(true);
        scP=new JScrollPane(notatnik);
        scP.setBounds(0,0,300,200);
        add(scP);

        bAddUser=new JButton("Dodaj użytkownika");
        bAddUser.setBounds(0,250,150,20);
        add(bAddUser);
        bAddUser.addActionListener(this);

    }

    public static void main(String args[])
    {
        PasswordTest app=new PasswordTest();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
           PanelHasla panelHasla = new PanelHasla(this);
        panelHasla.setVisible(true);
        panelHasla.setFocus();

        if(panelHasla.isOk())
        {
            notatnik.append(panelHasla.getUser()+", ");
            notatnik.append(panelHasla.getPassword()+"\n");

        }

    }
}



class PanelHasla extends JDialog implements ActionListener
{
    private JLabel lUser, lHaslo;
    private JTextField tUser;
    private JPasswordField pHaslo;
    private JButton bOk, bCancel;
    private boolean okData;

    public PanelHasla(JFrame owner)
    {
        super(owner, "Wprowadzanie hasła", true);
        setSize(300,200);
        setLayout(null);

        lUser=new JLabel("Użytkownik", JLabel.RIGHT);
        lUser.setBounds(0,0,100,20);
        add(lUser);

        tUser=new JTextField();
        tUser.setBounds(120,0,100,20);
        add(tUser);

        lHaslo=new JLabel("Hasło", JLabel.RIGHT);
        lHaslo.setBounds(0,50,100,20);
        add(lHaslo);

        pHaslo=new JPasswordField();
        pHaslo.setBounds(120,50,100,20);
        add(pHaslo);

        bOk=new JButton("Ok");
        bOk.setBounds(0,100,100,20);
        add(bOk);
        bOk.addActionListener(this);

        bCancel=new JButton("Cancel");
        bCancel.setBounds(120,100,100,20);
        add(bCancel);
        bCancel.addActionListener(this);


    }

    public String getUser()
    {
        return tUser.getText();
    }

    public String getPassword()
    {
        return new String(pHaslo.getPassword());
    }

    public boolean isOk()
    {
        return okData;
    }

    public void setFocus()
    {
        tUser.requestFocusInWindow();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object z=e.getSource();
        if(z==bOk)
            okData=true;
        else
            okData=false;

        setVisible(false);

    }


}

package Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class JMenuTest extends JFrame implements ActionListener
{
    private JMenuBar menuBar;
    private JMenu menuPlik, menuTools, menuPomoc, menuOpcje, menuLaF;
    private JMenuItem mOpen, mZapisz, mExit, mNarz1, mNarz2, mOp1, mpCopy, mpPaste, mpEnclose, mOProgramie, mMetal, mNimbus, mWindows;
    private JCheckBoxMenuItem chOp2;
    private JTextArea notatnik;
    private JButton bSzukaj, bKolor;
    private JTextField tSzukany;
    private JPopupMenu popup;
    private String wybranyTekst;
    private JComboBox colorCombo;

    public JMenuTest()
    {
        setTitle("Demonstracja JMenuBar");
        setSize(800,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        menuBar=new JMenuBar();
        menuPlik=new JMenu("Plik");

        mOpen=new JMenuItem("Otwórz plik .txt", 'O');
        mOpen.addActionListener(this);

        mZapisz=new JMenuItem("Zapisz");
        mZapisz.addActionListener(this);

        mExit=new JMenuItem("Wyjście");

        mExit.addActionListener(this);
        mExit.setAccelerator(KeyStroke.getKeyStroke("ctrl X"));

        menuPlik.add(mOpen);
        menuPlik.add(mZapisz);
        menuPlik.addSeparator();
        menuPlik.add(mExit);

        menuTools=new JMenu("Narzędzia");

        mNarz1=new JMenuItem("Narz1");
        mNarz1.setEnabled(false);
        mNarz2=new JMenuItem("Narz2");
        mNarz2.addActionListener(this);

        menuTools.add(mNarz1);
        menuTools.add(mNarz2);

        menuOpcje=new JMenu("Opcje");
        mOp1=new JMenuItem("Opcja 1");
        chOp2=new JCheckBoxMenuItem("Opcja 2");

        chOp2.addActionListener(this);

        menuOpcje.add(mOp1);
        menuOpcje.add(chOp2);

        menuTools.add(menuOpcje);

        menuLaF=new JMenu("Look and Feel");
        mMetal=new JMenuItem("Metal");
        mNimbus=new JMenuItem("Nimbus");
        mWindows=new JMenuItem("Windows");

        mMetal.addActionListener(this);
        mNimbus.addActionListener(this);
        mWindows.addActionListener(this);

        menuLaF.add(mMetal);
        menuLaF.add(mNimbus);
        menuLaF.add(mWindows);


        setJMenuBar(menuBar);
        menuBar.add(menuPlik);
        menuBar.add(menuTools);
        menuBar.add(menuLaF);

        menuBar.add(Box.createHorizontalGlue());

        menuPomoc=new JMenu("Pomoc");
        menuBar.add(menuPomoc);
        mOProgramie=new JMenuItem("O Programie");
        mOProgramie.addActionListener(this);
        menuPomoc.add(mOProgramie);

        notatnik=new JTextArea();
        JScrollPane scP=new JScrollPane(notatnik);
        scP.setBounds(50,50,400,400);
        add(scP);

        tSzukany = new JTextField();
        tSzukany.setBounds(50,500,100,20);
        add(tSzukany);

        bSzukaj = new JButton("Szukaj");
        bSzukaj.setBounds(200,500,100,20);
        add(bSzukaj);
        bSzukaj.addActionListener(this);

        bKolor = new JButton("Wybierz kolor tła");
        bKolor.setBounds(350,500,150,20);
        add(bKolor);
        bKolor.addActionListener(this);

        popup=new JPopupMenu();
        mpCopy=new JMenuItem("Kopiuj");
        mpCopy.addActionListener(this);
        mpPaste=new JMenuItem("Wklej");
        mpPaste.addActionListener(this);
        mpEnclose=new JMenuItem("Dołącz");
        mpEnclose.addActionListener(this);

        popup.add(mpCopy);
        popup.add(mpPaste);
        popup.add(mpEnclose);

        notatnik.setComponentPopupMenu(popup);

        colorCombo=new JComboBox();
        colorCombo.setBounds(500,50,100,20);
        colorCombo.addItem("czarny");
        colorCombo.addItem("czerwony");
        colorCombo.addItem("zielony");
        colorCombo.addItem("niebieski");
        colorCombo.addItem("różowy");
        add(colorCombo);
        colorCombo.addActionListener(this);
    }



@Override
public void actionPerformed(ActionEvent e)
{
    Object z=e.getSource();

    if(z==mOpen)
    {
     JFileChooser fc=new JFileChooser();
     if(fc.showOpenDialog(this)==JFileChooser.APPROVE_OPTION)
     {
         File plik=fc.getSelectedFile();
         BufferedReader bf;

         try {
             bf = new BufferedReader(new FileReader(plik));
             String tekst = bf.readLine();
             do {
                 notatnik.append(tekst+"\n");
                 tekst = bf.readLine();
             } while (tekst != null);
             bf.close();


         }

         catch(Exception e1)
         {
             e1.printStackTrace();
         }
     }
    }
    if(z==mZapisz)
    {
        JFileChooser fc=new JFileChooser();
        if(fc.showSaveDialog(this)==JFileChooser.APPROVE_OPTION)
        {
            File plik=fc.getSelectedFile();
            try {
                PrintWriter pw = new PrintWriter(plik);
                Scanner sc = new Scanner(notatnik.getText());
                while(sc.hasNext())
                {
                    pw.println(sc.nextLine()+"\n");

                }
                pw.close();

            }
            catch(FileNotFoundException e2)
            {
                e2.printStackTrace();
            }

        }
    }
    if(z==mExit)
    {
        int odp=JOptionPane.showConfirmDialog(this, "Czy na pewno wyjść ?", "Pytanie", JOptionPane.YES_NO_OPTION);
       if(odp==JOptionPane.YES_OPTION)
        dispose();
       else if(odp==JOptionPane.NO_OPTION)
           JOptionPane.showMessageDialog(this,"Wiedziałem...");
       else if(odp==JOptionPane.CLOSED_OPTION)
           JOptionPane.showMessageDialog(this, "Tak nie robimy!", "Tytuł", JOptionPane.WARNING_MESSAGE);
    }
    if(z==chOp2)
    {
        if(chOp2.isSelected())
            mNarz1.setEnabled(true);
        else
            mNarz1.setEnabled(false);
    }
    if(z==mNarz2)
    {
        String sMetry=JOptionPane.showInputDialog(this,"Podaj długość w metrach");
        double metry=Double.parseDouble(sMetry);
        double stopy=metry/0.3048;
        String sStopy=String.format("%.2f", stopy);
        JOptionPane.showMessageDialog(this,sMetry + " metrów = "+sStopy+" stóp.");
    }
    if(z==mOProgramie)
        JOptionPane.showMessageDialog(null, "Program demonstruje wykorzystanie JMenuBar i JMenu \n Wersja 1.0", "Tytuł", JOptionPane.INFORMATION_MESSAGE);


    if(z==bSzukaj)
    {
        String text= notatnik.getText();
        String sz=tSzukany.getText();
        String wyst ="";
        int i=0;
        int index;
        int startindex=0;
        while((index=text.indexOf(sz, startindex)) !=-1) // = - czemu???
        {
            startindex=index+sz.length();
            i++;
            wyst=wyst+" "+index;
        }
        JOptionPane.showMessageDialog(this, sz+" wystąpiło "+i+" razy: "+ wyst);
    }

    if(z==bKolor)
    {
        Color wybranyKolor=JColorChooser.showDialog(this, "Wybór koloru", Color.BLUE);
        notatnik.setBackground(wybranyKolor);
    }

    if(z==mpCopy)
    {
        wybranyTekst=notatnik.getSelectedText();
    }
    if(z==mpPaste)
    {
        notatnik.insert(wybranyTekst, notatnik.getCaretPosition());
    }
    if(z==mpEnclose)
    {
        notatnik.append("\n"+wybranyTekst);
    }

    if(z==colorCombo)
    {
        String color=colorCombo.getSelectedItem().toString();

        if(color.equals("zielony"))
            notatnik.setForeground(Color.GREEN);
        if(color.equals("czarny"))
            notatnik.setForeground(Color.BLACK);
        if(color.equals("niebieski"))
            notatnik.setForeground(Color.BLUE);
        if(color.equals("różowy"))
            notatnik.setForeground(Color.PINK);
        if(color.equals("czerwony"))
            notatnik.setForeground(Color.RED);

    }

    if(z==mMetal)
    {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        }
        catch(Exception e1) {
        e1.printStackTrace();
        }

    }
    if(z==mNimbus)
    {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        }
        catch(Exception e1) {
            e1.printStackTrace();
        }

    }
    if(z==mWindows)
    {
        //Windows jest w innym miejscu, nie javax.swing tylko com.sun.java.swing
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        }
        catch(Exception e1) {
            e1.printStackTrace();
        }

    }

}
public static void main(String args[])
{
    JMenuTest appMenu=new JMenuTest();
    appMenu.setVisible(true);
}
}

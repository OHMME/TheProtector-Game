import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//ของจริง
public class GameGUI implements ActionListener, WindowListener {

    private JFrame frame;
    private CardLayout c1;
    private JPanel topPanel, cardPanel, textPanel, panel1, panel2, panel3, panel4, buttonPanel;
    private JLabel lb1, lb2, lb3, lb4;
    private JButton bt1, bt2, bt3, bt4;
    private JTextField tf1, tf2;
    private ImageIcon icon1, icon2, icon3, icon4;
    private CountTime time;

    public GameGUI() {
        try {
//อันนี้เรียกใช้จาก Library ของ java โดย Default //UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());

//อันนี้เป็นของแถมมากับเจ้า Library ของ java เช่นกัน
//UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");

//อันนี้เป็น theme ของระบบ
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e)  { }
        //SetJFrame
        frame = new JFrame("The Protecter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(2, 1));
        frame.setSize(1000, 850);

        //SetCardPanel
        c1 = new CardLayout();
        cardPanel = new JPanel();
        cardPanel.setLayout(c1);
        //SetTextPanel
        textPanel = new JPanel();
        textPanel.setLayout(new GridLayout(1, 2));
        //SetTopPanel
        topPanel = new JPanel(new BorderLayout());

        //TextField
        tf1 = new JTextField("Problems : ");
        tf2 = new JTextField("Answer : ");
        tf1.setEditable(false);
        tf2.setEditable(false);
        //addTextArea to TextPanel
        textPanel.add(tf1);
        textPanel.add(tf2);

        //Icon
        icon1 = new ImageIcon((getClass().getResource("kul.png")));
        icon2 = new ImageIcon((getClass().getResource("safi.png")));
        icon3 = new ImageIcon((getClass().getResource("ala.png")));
        icon4 = new ImageIcon((getClass().getResource("fata.png")));
        //Label
        lb1 = new JLabel(icon1);
        lb2 = new JLabel(icon2);
        lb3 = new JLabel(icon3);
        lb4 = new JLabel(icon4);
        //addLabel to Panel
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        panel1.add(lb1);
        panel2.add(lb2);
        panel3.add(lb3);
        panel4.add(lb4);
        //addPanel to CardPanel
        cardPanel.add(panel1, "1");
        cardPanel.add(panel2, "2");
        cardPanel.add(panel3, "3");
        cardPanel.add(panel4, "4");

        //ButtonPanel
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 2));
        //Button
        bt1 = new JButton("คำตอบ1");
        bt2 = new JButton("คำตอบ2");
        bt3 = new JButton("คำตอบ3");
        bt4 = new JButton("คำตอบ4");
        //addActionListener to Button
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        bt3.addActionListener(this);
        bt4.addActionListener(this);
        //addButton to ButtonPanel
        buttonPanel.add(bt1);
        buttonPanel.add(bt2);
        buttonPanel.add(bt3);
        buttonPanel.add(bt4);

        //SetTime
        time = new CountTime();
        //Thread
        Thread t = new Thread(time);
        t.start();

        //addCardPanel&TextPanel to TopPanel
        topPanel.add(time, BorderLayout.NORTH);
        topPanel.add(cardPanel, BorderLayout.CENTER);
        topPanel.add(textPanel, BorderLayout.SOUTH);
        //addCTopPanel&ButtonPanel to JFrame
        frame.add(topPanel);
        frame.add(buttonPanel);
        frame.addWindowListener(this);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent click) {
        if(click.getSource().equals(bt1)) {
            c1.first(cardPanel);
        }
        else if(click.getSource().equals(bt2)) {
            c1.show(cardPanel, "2");
        }
        else if(click.getSource().equals(bt3)) {
            c1.show(cardPanel, "3");
        }
        else if(click.getSource().equals(bt4)) {
            c1.last(cardPanel);
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    public static void main(String[] args) {
        new GameGUI();
    }




    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}

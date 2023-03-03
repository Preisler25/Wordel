import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainFrame extends JFrame{
    private JPanel JPmain;
    private JButton btnOk;
    private JTextField JtextW1;
    private JTextField JtextW2;
    private JTextField JtextW5;
    private JTextField JtextW3;
    private JTextField JtextW4;

    private ArrayList<JTextField> JtextW = new ArrayList<JTextField>();


    public MainFrame(){
        JtextW.add(JtextW1);
        JtextW.add(JtextW2);
        JtextW.add(JtextW3);
        JtextW.add(JtextW4);
        JtextW.add(JtextW5);

        setContentPane(JPmain);
        setTitle("Wordel");
        setSize(700, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String word = getWord();
                System.out.println("Hello " + word);
            }
        });
    }
    public String getWord(){
        String temp = "";
        for (JTextField jTextW : JtextW) {
            temp += jTextW.getText();
            jTextW.setText("");
        }
        return temp;
    }
}





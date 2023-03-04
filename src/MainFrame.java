import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
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


        JtextW1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String newValue = JtextW1.getText();
                if (newValue.length() > 1) {
                    System.out.println(newValue);
                    System.out.println("Too many characters");
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            JtextW1.setText("új tartalom");
                        }
                    });
                }
                JtextW2.requestFocus();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {

            }

            @Override
            public void changedUpdate(DocumentEvent e) {}
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





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
    private JPanel History;
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

        //This shit makes you jump from one to another one
        JtextW1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                JtextW2.requestFocus();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {}

            @Override
            public void changedUpdate(DocumentEvent e) {
                JtextW2.requestFocus();
            }
        });

        JtextW2.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                JtextW3.requestFocus();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                JtextW1.requestFocus();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                JtextW3.requestFocus();
            }
        });

        JtextW3.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                JtextW4.requestFocus();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                JtextW2.requestFocus();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                JtextW4.requestFocus();
            }
        });

        JtextW4.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                JtextW5.requestFocus();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                JtextW3.requestFocus();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                JtextW5.requestFocus();
            }
        });

        JtextW5.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                JtextW1.requestFocus();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                JtextW4.requestFocus();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                JtextW1.requestFocus();
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





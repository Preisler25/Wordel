import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.text.PlainDocument;


public class MainFrame extends JFrame{
    private JPanel JPmain;
    private JButton btnOk;
    private JTextField JtextW1;
    private JTextField JtextW2;
    private JTextField JtextW5;
    private JTextField JtextW3;
    private JTextField JtextW4;
    private JPanel History;
    private String word_of_the_day = "aaaaa";
    private ArrayList<JTextField> JtextW = new ArrayList<JTextField>();

    public class JTextFieldLimit extends PlainDocument {
        private int limit;
        JTextFieldLimit(int limit) {
            super();
            this.limit = limit;
        }

        JTextFieldLimit(int limit, boolean upper) {
            super();
            this.limit = limit;
        }

        public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
            if (str == null)
                return;

            if ((getLength() + str.length()) <= limit) {
                super.insertString(offset, str, attr);
            }
        }
    }

    public MainFrame(){
        //Limiting the textfield to 1 character
        JtextW1.setDocument(new JTextFieldLimit(1));
        JtextW2.setDocument(new JTextFieldLimit(1));
        JtextW3.setDocument(new JTextFieldLimit(1));
        JtextW4.setDocument(new JTextFieldLimit(1));
        JtextW5.setDocument(new JTextFieldLimit(1));


        //Adding the textfields to the arraylist for easier checking
        JtextW.add(JtextW1);
        JtextW.add(JtextW2);
        JtextW.add(JtextW3);
        JtextW.add(JtextW4);
        JtextW.add(JtextW5);


        //creating the main frame
        setContentPane(JPmain);
        setTitle("Wordel");
        setSize(700, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);



        //creating the actionlistener for the button
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
            public void insertUpdate(DocumentEvent e) {}

            @Override
            public void removeUpdate(DocumentEvent e) {
                JtextW4.requestFocus();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {}
        });
    JtextW5.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (checkEmpty()) {return;}
            String word = getWord();
            if (checkWord(word)) {
                System.out.println("You got it!");
            }
            System.out.println("Hello " + word);
        }
    });
    }


    public boolean checkWord(String word){
        if (word.equals(word_of_the_day)){
            return true;
        }
        else{
            checkSimilarity(word);
            return false;
        }
    }

    public void checkSimilarity(String word){
        ArrayList<Character> word_of_the_day_list = new ArrayList<Character>();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == word_of_the_day.charAt(i)){
                word_of_the_day_list.add(word.charAt(i));
            }
        }
        System.out.println("Similarity: " + word_of_the_day_list.size() + " out of " + word.length() + "letters" + word_of_the_day_list);
    }

    //This method checks if the textfields are empty
    public boolean checkEmpty(){
        for (JTextField jTextW : JtextW) {
            if (jTextW.getText().equals("")) {
                return true;
            }
        }
        return false;
    }

    //This method gets the word from the textfields
    public String getWord(){
        String temp = "";
        for (JTextField jTextW : JtextW) {
            temp += jTextW.getText();
            jTextW.setText("");
        }
        return temp;
    }
}





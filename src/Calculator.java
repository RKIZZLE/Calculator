import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.border.Border;


public class Calculator implements ActionListener {

    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel title_panel2 = new JPanel();
    JPanel title_panel3 = new JPanel();
    JPanel title_panel4 = new JPanel();
    JPanel title_panel5 = new JPanel();
    JPanel title_panel6 = new JPanel();
    JPanel title_panel7 = new JPanel();
    JPanel title_panel8 = new JPanel();
    JPanel title_panel9 = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JLabel textfield2 = new JLabel();
    JButton[] buttons = new JButton[16];

    int a = 0;
    int b = 0;
    int output = 0;
    int operationIndex = -1;
    Calculator() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 1000);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setVisible(true);

        textfield2.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
        frame.getContentPane().add(textfield, BorderLayout.CENTER);

        textfield.setBackground(new Color(255, 255, 255));
        textfield.setForeground(new Color(25, 255, 0));
        textfield.setFont(new Font("Digital-7", Font.BOLD, 80));
        textfield.setHorizontalAlignment(JLabel.LEFT);
        textfield.setVerticalAlignment(JLabel.CENTER);
        textfield.setText("0");
        textfield.setOpaque(true);

        Border blackline = BorderFactory.createLineBorder(Color.black,2);
        textfield.setBorder(blackline);
        Border blackline2 = BorderFactory.createLineBorder(Color.black);
        button_panel.setBorder(blackline2);

        title_panel.setLayout(new BorderLayout());
        title_panel.setPreferredSize(new Dimension(800,200));

        textfield2.setBackground(new Color(80, 80, 80));
        textfield2.setForeground(new Color(25, 255, 0));
        textfield2.setFont(new Font("Digital-7", Font.BOLD, 40));
        textfield2.setHorizontalAlignment(JLabel.CENTER);
        textfield2.setVerticalAlignment(JLabel.CENTER);
        textfield2.setText("Casio-Ferd-Booty-X200");
        textfield2.setOpaque(true);


        title_panel2.setLayout(new BorderLayout());
        title_panel2.setPreferredSize(new Dimension(800,50));

        title_panel3.setLayout(new BorderLayout());

        title_panel4.setLayout(new BorderLayout());
        title_panel4.setBackground(new Color(80, 80, 80));
        title_panel4.setPreferredSize(new Dimension(30,30));

        title_panel5.setLayout(new BorderLayout());
        title_panel5.setBackground(new Color(80, 80, 80));
        title_panel5.setPreferredSize(new Dimension(50,30));

        title_panel6.setLayout(new BorderLayout());
        title_panel6.setBackground(new Color(80, 80, 80));
        title_panel6.setPreferredSize(new Dimension(30,50));

        title_panel7.setLayout(new BorderLayout());
        title_panel7.setBackground(new Color(80, 80, 80));
        title_panel7.setPreferredSize(new Dimension(30,50));

        title_panel8.setLayout(new BorderLayout());
        title_panel8.setBackground(new Color(80, 80, 80));
        title_panel8.setPreferredSize(new Dimension(30,50));

        title_panel9.setLayout(new BorderLayout());
        title_panel9.setBackground(new Color(80, 80, 80));
        title_panel9.setPreferredSize(new Dimension(30,50));

        button_panel.setLayout(new GridLayout(4,4));
        button_panel.setBackground(new Color(0, 0, 0));

        for(int i=0;i<16;i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        title_panel.add(title_panel4,BorderLayout.NORTH);
        title_panel.add(title_panel6,BorderLayout.WEST);
        title_panel.add(title_panel7,BorderLayout.EAST);

        title_panel3.add(title_panel5,BorderLayout.SOUTH);
        title_panel3.add(title_panel8,BorderLayout.WEST);
        title_panel3.add(title_panel9,BorderLayout.EAST);

        title_panel2.add(textfield2);
        title_panel.add(textfield);
        title_panel3.add(title_panel2,BorderLayout.NORTH);
        title_panel3.add(button_panel,BorderLayout.CENTER);
        frame.add(title_panel,BorderLayout.NORTH);
        frame.add(title_panel3,BorderLayout.CENTER);

        setButtons();

    }


    public void add() {
        output = a + b;
        textfield.setText(String.valueOf(output));
    }
    public void subtract() {
        output = a - b;
        textfield.setText(String.valueOf(output));
    }
    public void muliply() {
        output = a * b;
        textfield.setText(String.valueOf(output));
    }
    public void divide() {
        output = a / b;
        textfield.setText(String.valueOf(output));

    }
    public void clear() {
        a=0;
        b=0;
        textfield.setText("");

    }



    @Override
    public void actionPerformed(ActionEvent e) {

        ArrayList<Integer> specifiedNumberIndices = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 13));

        for (int i = 0; i < 10; i++) {
            if (e.getSource() == buttons[specifiedNumberIndices.get(i)]) {
                if (textfield.getText().equals("0")) {
                    textfield.setText(buttons[specifiedNumberIndices.get(i)].getText());
                } else {
                    textfield.setText(textfield.getText() + buttons[specifiedNumberIndices.get(i)].getText());
                }
            }
        }

        ArrayList<Integer> specifiedButtonIndices = new ArrayList<>(Arrays.asList(3, 7, 11, 12, 14));

        for(int i=0; i<5; i++) {
            if(e.getSource() == buttons[specifiedButtonIndices.get(i)] && !textfield.getText().isEmpty()) {
                a = Integer.parseInt(textfield.getText());
                operationIndex = specifiedButtonIndices.get(i);
                textfield.setText("");
            }
        }
        if(e.getSource() == buttons[15] && operationIndex != -1) {
            b = Integer.parseInt(textfield.getText());
            if(operationIndex == 3) {
                add();
            } else if(operationIndex == 7) {
                subtract();
            } else if(operationIndex == 11) {
                muliply();
            } else if(operationIndex == 14) {
                divide();
            } else if(operationIndex == 12) {
                clear();
            }
            operationIndex = -1;
        }

    }




    public void setButtons() {
        buttons[0].setText("1");
        buttons[1].setText("2");
        buttons[2].setText("3");
        buttons[3].setText("+");
        buttons[4].setText("4");
        buttons[5].setText("5");
        buttons[6].setText("6");
        buttons[7].setText("-");
        buttons[8].setText("7");
        buttons[9].setText("8");
        buttons[10].setText("9");
        buttons[11].setText("*");
        buttons[12].setText("C");
        buttons[13].setText("0");
        buttons[14].setText("/");
        buttons[15].setText("=");
    }



}

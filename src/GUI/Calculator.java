package GUI;

import javax.swing.JApplet;

import javax.swing.JButton;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.LayoutManager;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.plaf.metal.MetalBorders;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Scanner;
import java.util.Stack;
import Evaluator.*;
import javax.swing.UIManager;
/**
 * Sample Calculator Applet not JFrame
 * @author thapaliya
 *
 */
public class Calculator extends JApplet implements ActionListener  {
	
    private JTextField screen = new JTextField(24);
    private JButton[] bt = new JButton[20];
    private static int flag=0;
    private String expr=null;
    private Evaluator evaluator = new Evaluator();
    
    
    public void init() {

        JPanel p1 = new JPanel(), p2 = new JPanel();
        LayoutManager layout = (LayoutManager) new GridLayout(5, 4);


        screen.setText("Can contain Text up here");
        intButtons();

        p1.add(screen);
        p1.setBorder(new MetalBorders.TextFieldBorder());

        for (int i = 0; i < bt.length; i++) {
            p2.add(bt[i]);
        }


        p1.setLayout(new FlowLayout());
        p2.setLayout(layout);

        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);
        this.setSize(280, 200);


    }

    public void intButtons() {
        bt[0] = new JButton("+");
        bt[1] = new JButton("-");
        bt[2] = new JButton("*");
        bt[3] = new JButton("/");
        bt[4] = new JButton("0");
        bt[5] = new JButton("1");
        bt[6] = new JButton("2");
        bt[7] = new JButton("3");
        bt[8] = new JButton("4");
        bt[9] = new JButton("5");
        bt[10] = new JButton("6");
        bt[11] = new JButton("7");
        bt[12] = new JButton("8");
        bt[13] = new JButton("9");
        bt[14] = new JButton(".");
        bt[15] = new JButton("=");
        bt[16] = new JButton("C");
        bt[17] = new JButton("CE");
        bt[18] = new JButton("(");
        bt[19] = new JButton(")");

        for (int i = 0; i < bt.length; i++) {
            bt[i].addActionListener(this);
        }


    }

    public void start() 
    {
        try
        {
           UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        } catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent event) {
        String txt;
        if (flag == 0) {
            screen.setText(null);
        }

        try {

            for (int i = 0; i < bt.length; i++) {
                if (event.getSource() == bt[i]) {

                    System.out.println(i);
                    if (bt[i].getText().equals("=")) {
                        equalsPressed();
                        break;
                    } else if (bt[i].getText().charAt(0) == 'C') {
                        clearPressed(bt[i]);
                        break;
                    }
                    System.out.println(i);
                    txt = screen.getText() + bt[i].getText();
                    screen.setText(txt);
                    break;
                }

            }
            flag = 1;

        } catch (Exception ex) {
            System.out.println("Exception : " + ex.getMessage());
        }

    }

    public void equalsPressed() {
        expr = screen.getText();
        screen.setText(Double.toString(evaluator.eval(expr)));

    }

    public void clearPressed(JButton bt) {
        String txt;

        if (bt.getText().equals("CE")) {
            screen.setText("");
            return;
        }

        txt = screen.getText();
        txt = txt.substring(0, txt.length() - 1);
        screen.setText(txt);

    }


}



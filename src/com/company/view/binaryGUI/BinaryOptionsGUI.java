package com.company.view.binaryGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BinaryOptionsGUI extends JFrame {

    JLabel lable;
    JButton ariOp, convBinToDec, convDecToBin;
    JPanel panel;

    public BinaryOptionsGUI() {
        initComponents();
    }

    private void initComponents() {
        setTitle("CLI Calculator");
        setSize(600, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel(new GridLayout(1,3));

        lable = new JLabel("Hexadecimal Functions: ");
        add(lable, BorderLayout.NORTH);

        ariOp = new JButton("Arithmetic Operations");
        ariOp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BinaryArithmeticGUI().setVisible(true);
                dispose();
            }
        });
        panel.add(ariOp);

        convDecToBin = new JButton("Convert Decimal to Binary");
        convDecToBin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DecToBinGUI().setVisible(true);
                dispose();
            }
        });
        panel.add(convDecToBin);

        convBinToDec = new JButton("Convert Binary to Decimal");
        convBinToDec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BinToDecGUI().setVisible(true);
                dispose();
            }
        });
        panel.add(convBinToDec);

        add(panel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BinaryOptionsGUI().setVisible(true);
            }
        });
    }
}

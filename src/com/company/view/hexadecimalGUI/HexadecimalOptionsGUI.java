package com.company.view.hexadecimalGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HexadecimalOptionsGUI extends JFrame {

    JLabel lable;
    JButton ariOp, convDecToHex, convHexToDec;
    JPanel panel;

    public HexadecimalOptionsGUI() {
        initComponents();
    }

    public void initComponents() {
        setTitle("CLI Calculator");
        setSize(800, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel(new GridLayout(1,3));

        lable = new JLabel("Hexadecimal Functions: ");
        add(lable, BorderLayout.NORTH);

        ariOp = new JButton("Arithmetic Operations");
        ariOp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HexArithmeticGUI().setVisible(true);
                dispose();
            }
        });
        panel.add(ariOp);

        convDecToHex = new JButton("Convert Decimal to Hexadecimal");
        convDecToHex.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DecToHexGUI().setVisible(true);
                dispose();
            }
        });
        panel.add(convDecToHex);

        convHexToDec = new JButton("Convert Hexadecimal to Decimal");
        convHexToDec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HexToDecGUI().setVisible(true);
                dispose();
            }
        });
        panel.add(convHexToDec);

        add(panel, BorderLayout.CENTER);

    }
}

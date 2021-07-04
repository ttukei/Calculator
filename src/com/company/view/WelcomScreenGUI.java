package com.company.view;

import com.company.view.bandwidthGUI.BandwidthOptionsGUI;
import com.company.view.bigIntegerGUI.BigIntegerGUI;
import com.company.view.binaryGUI.BinaryOptionsGUI;
import com.company.view.decimalGUI.DecimalGUI;
import com.company.view.hexadecimalGUI.HexadecimalOptionsGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomScreenGUI extends JFrame {

    JButton decCalc, bigItnCalc, binCalc, hexCalc, banCalc;
    JLabel label;
    JPanel panel;

    public WelcomScreenGUI() {
        setTitle("CLI Calculator");
        setSize(600, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label = new JLabel("Calculators: ");
        add(label, BorderLayout.NORTH);

        panel = new JPanel(new GridLayout(1, 5));

        decCalc = new JButton("Decimal");
        decCalc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DecimalGUI().setVisible(true);
                dispose();
            }
        });
        panel.add(decCalc);

        bigItnCalc = new JButton("Big Integer");
        bigItnCalc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BigIntegerGUI().setVisible(true);
                dispose();
            }
        });
        panel.add(bigItnCalc);

        binCalc = new JButton("Binary");
        binCalc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BinaryOptionsGUI().setVisible(true);
                dispose();
            }
        });
        panel.add(binCalc);

        hexCalc = new JButton("Hexadecimal");
        hexCalc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HexadecimalOptionsGUI().setVisible(true);
                dispose();
            }
        });
        panel.add(hexCalc);

        banCalc = new JButton("Bandwidth");
        banCalc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BandwidthOptionsGUI().setVisible(true);
                dispose();
            }
        });
        panel.add(banCalc);


        add(panel, BorderLayout.CENTER);
    }
    public static void main(String[] args) {
        new WelcomScreenGUI().setVisible(true);
    }

}

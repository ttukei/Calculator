package com.company.view.hexadecimalGUI;

import com.company.controller.BinaryCalculator;
import com.company.controller.HexadecimalCalculator;
import com.company.model.Binary;
import com.company.model.Decimal;
import com.company.model.Hexadecimal;
import com.company.view.WelcomScreenGUI;
import com.company.view.binaryGUI.BinToDecGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HexToDecGUI extends JFrame {

    JPanel panle, westOfpanel, eastOfPanel;
    JLabel binary, decimal;
    JButton convert, home;
    JTextField input, output;

    public HexToDecGUI() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Hexadecimal to Decimal Converter");
        setSize(900,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panle = new JPanel(new GridLayout(1,3));
        westOfpanel = new JPanel();
        eastOfPanel = new JPanel();

        binary = new JLabel("Hexadecimal: ");
        decimal = new JLabel("Decimal: ");
        input = new JTextField(15);
        output = new JTextField(15);
        output.setEditable(false);
        binary.setLabelFor(input);
        decimal.setLabelFor(output);

        convert = new JButton("Convert");
        convert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HexadecimalCalculator hexadecimalCalculator = new HexadecimalCalculator();
                Decimal result = new Decimal();
                result = hexadecimalCalculator.hexadecimalToDecimal(new Hexadecimal(input.getText()));
                output.setText(result.toString());
            }
        });

        home = new JButton("Home");
        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new WelcomScreenGUI().setVisible(true);
                dispose();
            }
        });

        westOfpanel.add(binary, BorderLayout.WEST);
        westOfpanel.add(input, BorderLayout.CENTER);
        panle.add(westOfpanel);
        panle.add(convert);
        eastOfPanel.add(decimal, BorderLayout.WEST);
        eastOfPanel.add(output, BorderLayout.CENTER);
        panle.add(eastOfPanel);

        add(home, BorderLayout.NORTH);
        add(panle, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HexToDecGUI().setVisible(true);
            }
        });
    }
}

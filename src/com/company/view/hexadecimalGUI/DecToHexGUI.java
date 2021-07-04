package com.company.view.hexadecimalGUI;

import com.company.controller.HexadecimalCalculator;
import com.company.model.Decimal;
import com.company.model.Hexadecimal;
import com.company.view.WelcomScreenGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DecToHexGUI extends JFrame {

    JPanel panle, westOfpanel, eastOfPanel;
    JLabel binary, decimal;
    JButton convert, home;
    JTextField input, output;

    public DecToHexGUI() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Decimal to Hexadecimal Converter");
        setSize(900,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panle = new JPanel(new GridLayout(1,3));
        westOfpanel = new JPanel();
        eastOfPanel = new JPanel();

        binary = new JLabel("Decimal: ");
        decimal = new JLabel("Hexadecimal: ");
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
                Hexadecimal result = new Hexadecimal();
                result = hexadecimalCalculator.decimalToHexadecimal(new Decimal(Double.parseDouble(input.getText())));
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
                new DecToHexGUI().setVisible(true);
            }
        });
    }
}

package com.company.view.bandwidthGUI;

import com.company.view.WelcomScreenGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HostBanGUI extends JFrame {

    JLabel monthlyUsage, bandwidth;
    JTextField monthlyUsageInput, bandwidthInput, output;
    JLabel isEqivTo;
    JButton calculate, home;
    JComboBox monthlyUsageUnits, bandwidthUnits;
    JPanel north, northNorth, northCenter, southNorth, southSouthNorth, center;

    public HostBanGUI() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Hosting Bandwidth Converter");
        setSize(400,250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        north = new JPanel(new GridLayout(4,1));

        northNorth = new JPanel(new GridLayout(1,3));
        monthlyUsage = new JLabel("Monthly Usage: ");
        monthlyUsageInput = new JTextField(10);
        monthlyUsageUnits = new JComboBox();
        northNorth.add(monthlyUsage);
        northNorth.add(monthlyUsageInput);
        // Add Units
        northNorth.add(monthlyUsageUnits);

        northCenter = new JPanel();
        isEqivTo = new JLabel("Is Equivalent To");
        northCenter.add(isEqivTo, BorderLayout.CENTER);

        southNorth = new JPanel(new GridLayout(1,3));
        bandwidth = new JLabel("Bandwidth: ");
        bandwidthInput = new JTextField(10);
        bandwidthUnits = new JComboBox();
        southNorth.add(bandwidth);
        southNorth.add(bandwidthInput);
        // Add units
        southNorth.add(bandwidthUnits);

        southSouthNorth = new JPanel();
        calculate = new JButton("Calculate");
        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        southSouthNorth.add(calculate, BorderLayout.CENTER);


        center = new JPanel();
        output = new JTextField(30);
        center.add(output, BorderLayout.CENTER);

        home = new JButton("Home");
        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new WelcomScreenGUI().setVisible(true);
                dispose();
            }
        });

        north.add(northNorth);
        north.add(northCenter);
        north.add(southNorth);
        north.add(southSouthNorth);

        add(north, BorderLayout.NORTH);
        add(center, BorderLayout.CENTER);
        add(home, BorderLayout.SOUTH);
    }

    public static void main(String... args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HostBanGUI().setVisible(true);
            }
        });
    }
}

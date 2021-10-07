package com.company.view.bandwidthGUI;

import com.company.controller.BandwidthCalculator;
import com.company.model.Bandwidth;
import com.company.model.Data;
import com.company.model.Unit;
import com.company.view.WelcomScreenGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class DataUnitConvGUI extends JFrame {

    JPanel centerPanel, northPanel, northNorthPanel, northSouthPanel;
    JTextField input;
    JTextArea output;
    JComboBox units;
    JButton convert, home;
    JScrollPane scrollPane;

    public DataUnitConvGUI() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Data Unit Converter");
        setSize(300,250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        centerPanel = new JPanel();
        northPanel = new JPanel(new GridLayout(2,1));
        northNorthPanel = new JPanel(new GridLayout(1,2));
        northSouthPanel = new JPanel();

        input = new JTextField("Enter data here",15);

        units = new JComboBox();
        Unit[] enumList = Unit.values();
        for (int i = 0; i < enumList.length; i++) {
            if (i < 4) {
                units.addItem(enumList[i].toString().toLowerCase());
            } else {
                String current = enumList[i].toString();
                units.addItem(current.charAt(0) + current.substring(1).toLowerCase());
            }
        }

        convert = new JButton("Convert");
        convert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Data data = new Data(Double.parseDouble(input.getText()));
                Unit unit = Unit.valueOf(units.getSelectedItem().toString().toUpperCase());
                BandwidthCalculator bandwidthCalculator = new BandwidthCalculator();
                Map<Data, Unit> result = bandwidthCalculator.dataUnitConverter(data, unit);
                StringBuilder out = new StringBuilder();
                for (Data key : result.keySet()) {
                    out.append(key.toString() + " " + result.get(key).toString() + "\n");
                }
                output.setText(out.toString());
            }
        });
        northSouthPanel.add(convert);

        home = new JButton("Home");
        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new WelcomScreenGUI().setVisible(true);
                dispose();
            }
        });

        output = new JTextArea(6,23);
        output.setEditable(false);

        scrollPane = new JScrollPane(output);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        northNorthPanel.add(input);
        northNorthPanel.add(units);
        northPanel.add(northNorthPanel);
        northPanel.add(northSouthPanel);
        centerPanel.add(scrollPane);

        add(northPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(home, BorderLayout.SOUTH);


    }
    public static void main(String[] arg) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DataUnitConvGUI().setVisible(true);
            }
        });

    }

    class comboBoxListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JComboBox cb = (JComboBox)e.getSource();
        }
    }
}

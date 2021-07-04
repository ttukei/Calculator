package com.company.view.bandwidthGUI;

import com.company.controller.BandwidthCalculator;
import com.company.model.Bandwidth;
import com.company.model.Data;
import com.company.model.DownloadUploadTime;
import com.company.model.Unit;
import com.company.view.WelcomScreenGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DownUpTimeGUI extends JFrame {

    JPanel northNorth, northSouth, north, center;
    JTextField fileSizeInput, bandwidthInput, output;
    JComboBox fileSizeUnits, bandwidthUnits;
    JLabel fileSize, bandwidth;
    JButton calculate, home;

    public DownUpTimeGUI() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Download & Upload Time Calculator");
        setSize(400,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        north = new JPanel(new GridLayout(2, 1));
        northNorth = new JPanel(new GridLayout(2,3));
        northSouth = new JPanel();
        center = new JPanel();
        fileSize = new JLabel("File size: ");
        bandwidth = new JLabel("Bandwidth: ");
        northNorth.add(fileSize);

        fileSizeInput = new JTextField(10);
        bandwidthInput = new JTextField(10);

        Unit[] enumList = Unit.values();

        fileSizeUnits = new JComboBox();
        for (int i = 5; i < enumList.length; i++) {
            String current = enumList[i].toString();
            fileSizeUnits.addItem(current.charAt(0) + current.substring(1).toLowerCase());
        }

        bandwidthUnits = new JComboBox();
        for (int i = 0; i < enumList.length -5 ; i++) {
            bandwidthUnits.addItem(enumList[i].toString().toLowerCase());
        }
        northNorth.add(fileSizeInput);
        northNorth.add(fileSizeUnits);
        northNorth.add(bandwidth);
        northNorth.add(bandwidthInput);
        northNorth.add(bandwidthUnits);


        calculate = new JButton("Calculate");
        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Bandwidth bandwidth = new Bandwidth();
                bandwidth.setUnit(Unit.valueOf(bandwidthUnits.getSelectedItem().toString().toUpperCase()));
                bandwidth.setData(new Data(Double.parseDouble(bandwidthInput.getText())));
                Unit fileSizeUnit = Unit.valueOf(fileSizeUnits.getSelectedItem().toString().toUpperCase());
                Data fileSize = new Data(Double.parseDouble(fileSizeInput.getText()));
                BandwidthCalculator bandwidthCalculator = new BandwidthCalculator();
                DownloadUploadTime time = new DownloadUploadTime();
                time = bandwidthCalculator.downloadUploadTime(fileSize, fileSizeUnit, bandwidth);
                output.setText(time.toString());
            }
        });

        northSouth.add(calculate, BorderLayout.CENTER);
        north.add(northNorth);
        north.add(northSouth);


        output = new JTextField(32);
        output.setEditable(false);
        center.add(output);

        home = new JButton("Home");
        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new WelcomScreenGUI().setVisible(true);
                dispose();
            }
        });

        add(north, BorderLayout.NORTH);
        add(center, BorderLayout.CENTER);
        add(home, BorderLayout.SOUTH);

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DownUpTimeGUI().setVisible(true);
            }
        });
    }
}

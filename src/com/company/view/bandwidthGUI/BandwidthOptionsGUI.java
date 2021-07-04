package com.company.view.bandwidthGUI;

import com.company.view.binaryGUI.BinToDecGUI;
import com.company.view.binaryGUI.BinaryArithmeticGUI;
import com.company.view.binaryGUI.BinaryOptionsGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BandwidthOptionsGUI extends JFrame {

    JLabel lable;
    JButton dataUnitConv, downUpTime, webBan, hostBan;
    JPanel panel;

    public BandwidthOptionsGUI() {
        initComponents();
    }

    private void initComponents() {
        setTitle("CLI Calculator");
        setSize(600, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel(new GridLayout(1,3));

        lable = new JLabel("Bandwidth Functions: ");
        add(lable, BorderLayout.NORTH);

        dataUnitConv = new JButton("Data Unit Converter");
        dataUnitConv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DataUnitConvGUI().setVisible(true);
                dispose();
            }
        });
        panel.add(dataUnitConv);

        downUpTime = new JButton("Download & Upload Time");
        downUpTime.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DownUpTimeGUI().setVisible(true);
                dispose();
            }
        });
        panel.add(downUpTime);

        webBan = new JButton("Website Bandwidth");
        webBan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new WebsiteBandwidthGUI().setVisible(true);
                dispose();
            }
        });
        panel.add(webBan);

        hostBan = new JButton("Hosting Bandwidth Converter");
        hostBan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HostBanGUI().setVisible(true);
                dispose();
            }
        });
        panel.add(hostBan);

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

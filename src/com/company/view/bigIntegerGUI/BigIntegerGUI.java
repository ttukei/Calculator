package com.company.view.bigIntegerGUI;

import com.company.controller.BigIntegerCalculator;
import com.company.model.BigIntNum;
import com.company.view.WelcomScreenGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.math.*;

public class BigIntegerGUI extends JFrame {

    JPanel northPanel, centerPanle, centerCenterPanel, eastCenterPanel;
    JTextArea inOut;
    JButton[] numberBtns = new JButton[10];
    JButton add, subtract, multiply, divide, equal, clear, back;
    JButton[] otherBtns = new JButton[5];
    ArrayList<String> input = new ArrayList<>();


    public BigIntegerGUI() {
        initComponents();

    }

    private void initComponents() {
        setTitle("Big Integer Calculator");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        northPanel = new JPanel(new BorderLayout());
        // TODO Set text insertion point to the bottom right
        // TODO Set width and height of text area to the full size of the north border
        back = new JButton("Back");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new WelcomScreenGUI().setVisible(true);
                dispose();
            }
        });
        northPanel.add(back, BorderLayout.NORTH);
        inOut = new JTextArea(8, 33);
        northPanel.add(inOut, BorderLayout.CENTER);

        centerPanle = new JPanel(new BorderLayout());
        centerCenterPanel = new JPanel(new GridLayout(4, 3));
        int number = 7;
        for (int i = 1; i < 10; i++) {
            if (number % 3 == 0) {
                centerCenterPanel.add(numberBtns[number] = new JButton("" + number));
                numberBtns[number].addActionListener(new BtnListener());
                number -= 6;
            } else {
                centerCenterPanel.add(numberBtns[number] = new JButton("" + number));
                numberBtns[number].addActionListener(new BtnListener());
            }
            number++;
        }
        numberBtns[0] = new JButton("" + 0);
        numberBtns[0].addActionListener(new BtnListener());
        centerCenterPanel.add(numberBtns[0]);
        centerCenterPanel.add(equal = new JButton("="));
        equal.addActionListener(new EqualBtnListener());

        eastCenterPanel = new JPanel(new GridLayout(5, 1));
        eastCenterPanel.add(clear = new JButton("AC"));
        clear.addActionListener(new BtnListener());

        otherBtns[0] = divide = new JButton("÷");
        otherBtns[1] = multiply = new JButton("×");
        otherBtns[2] = subtract = new JButton("−");
        otherBtns[3] = add = new JButton("+");
        for (int i = 0; i < 4; i++) {
            otherBtns[i].addActionListener(new BtnListener());
            eastCenterPanel.add(otherBtns[i]);
        }

        centerPanle.add(centerCenterPanel, BorderLayout.CENTER);
        centerPanle.add(eastCenterPanel, BorderLayout.EAST);

        add(northPanel, BorderLayout.NORTH);
        add(centerPanle, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BigIntegerGUI().setVisible(true);
            }
        });
    }

    class BtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object btnClicked = e.getSource();
            if (btnClicked == clear) {
                inOut.setText(null);
                input.clear();
            } else if (Arrays.asList(numberBtns).contains(btnClicked)) {
                for (int i = 0; i < 10; i++) {
                    if (btnClicked == numberBtns[i]) {
                        inOut.setText(inOut.getText() + numberBtns[i].getText());
                        input.add(numberBtns[i].getText());
                        return;
                    }
                }
            } else {
                ArrayList<String> operators = new ArrayList<>();
                operators.add("÷");
                operators.add("×");
                operators.add("−");
                operators.add("+");
                if (Arrays.asList(otherBtns).contains(btnClicked)) {
                    for (int i = 0; i < 5; i++) {
                        if (btnClicked == otherBtns[i] && inOut.getText().length() > 0) {
                            String lastEnty = input.get(input.size() - 1);
                            if (!(operators.contains(lastEnty))) {
                                inOut.setText(inOut.getText() + " " + otherBtns[i].getText() + " ");
                                input.add(otherBtns[i].getText());
                            }
                        }
                    }
                }
            }
        }
    }

    class EqualBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            ArrayList<String> operators = new ArrayList<>();
            operators.add("÷");
            operators.add("×");
            operators.add("−");
            operators.add("+");

            StringBuilder operand = new StringBuilder();

            ArrayList<String> toCalc = new ArrayList<>();
            for (int index = 0; index < input.size(); index++) {
                if (operators.contains(input.get(index))) {
                    toCalc.add(operand.toString());
                    toCalc.add(input.get(index));
                    operand = new StringBuilder();
                } else {
                    operand.append(input.get(index));
                    if (index == input.size() - 1) {
                        toCalc.add(operand.toString());
                    }
                }

            }
            if (operators.contains(toCalc.get(toCalc.size() - 1))) {
                toCalc.remove(toCalc.size() - 1);
            }

            BigIntegerCalculator bigIntegerCalculator = new BigIntegerCalculator();
            BigIntNum result = new BigIntNum(new BigInteger(toCalc.get(0)));
            BigIntNum next = new BigIntNum();
            for (int index = 1; index < toCalc.size(); index += 2) {
                next.setBigIntNum(new BigInteger(toCalc.get(index + 1)));
                switch (toCalc.get(index)) {
                    case "÷" -> result = bigIntegerCalculator.divide(result, next);
                    case "×" -> result = bigIntegerCalculator.multiply(result, next);
                    case "−" -> result = bigIntegerCalculator.subtract(result, next);
                    case "+" -> result = bigIntegerCalculator.add(result, next);
                }
            }
            inOut.setText(result.toString());
        }
    }
}

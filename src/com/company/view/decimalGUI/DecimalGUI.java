package com.company.view.decimalGUI;

import com.company.controller.DecimalCalculator;
import com.company.model.Decimal;
import com.company.view.WelcomScreenGUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;

public class DecimalGUI extends JFrame {

    JPanel northPanel, centerPanle, centerCenterPanel, eastCenterPanel;
    JTextArea inOut;
    JButton[] numberBtns = new JButton[10];
    JButton add, subtract, multiply, divide, equal, period, clear, back;
    JButton[] otherBtns = new JButton[5];
    ArrayList<String> input = new ArrayList<>();


    public DecimalGUI() {
        initComponents();

    }

    private void initComponents() {
        setTitle("Decimal Calculator");
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
        centerCenterPanel.add(period = new JButton("."));
        centerCenterPanel.add(equal = new JButton("="));
        equal.addActionListener(new EqualBtnListener());

        eastCenterPanel = new JPanel(new GridLayout(5, 1));
        eastCenterPanel.add(clear = new JButton("AC"));
        clear.addActionListener(new BtnListener());

        otherBtns[0] = divide = new JButton("÷");
        otherBtns[1] = multiply = new JButton("×");
        otherBtns[2] = subtract = new JButton("−");
        otherBtns[3] = add = new JButton("+");
        otherBtns[4] = period;
        otherBtns[4].addActionListener(new BtnListener());
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
                new DecimalGUI().setVisible(true);
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
                            if (otherBtns[i].getText().equals(".") && !operators.contains(input.get(input.size() -1))) {
                                if (!decimalEntered(operators)) {
                                    input.add(".");
                                    inOut.setText(inOut.getText() + ".");
                                }
                            } else {
                                String lastEnty = input.get(input.size() - 1);
                                if (!(operators.contains(lastEnty)) && !lastEnty.equals(".")) {
                                    inOut.setText(inOut.getText() + " " + otherBtns[i].getText() + " ");
                                    input.add(otherBtns[i].getText());
                                }
                            }
                        }
                    }
                }
            }
        }

        public boolean decimalEntered(ArrayList<String> operators) {
            int first, last;
            first = 0; last = input.size();
            for (int index = 0; index < input.size(); index++) {
                if (operators.contains(input.get(index))) {
                    first = index + 1;
                }
            }
            for (int index = first; index < last; index++) {
                if (input.get(index).equals(".")) {
                    return true;
                }
            }
            return false;
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
            if (operators.contains(toCalc.get(toCalc.size() -1 ))) {
                toCalc.remove(toCalc.size() -1);
            }

            DecimalCalculator decimalCalculator = new DecimalCalculator();
            Decimal result = new Decimal(Double.parseDouble(toCalc.get(0)));
            Decimal next = new Decimal();
            for (int index = 1; index < toCalc.size(); index +=2) {
                next.setDecimal(Double.parseDouble(toCalc.get(index + 1)));
                switch (toCalc.get(index)) {
                    case "÷" -> result = decimalCalculator.divide(result, next);
                    case "×" -> result = decimalCalculator.multiply(result, next);
                    case "−" -> result = decimalCalculator.subtract(result, next);
                    case "+" -> result = decimalCalculator.add(result, next);
                }
            }
            inOut.setText(result.toString());
        }
    }


}
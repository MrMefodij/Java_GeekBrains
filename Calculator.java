package Java_GeekBrains;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    private String command;
    public static void main(String[] args) {
        new Calculator();
    }

    public Calculator(){
        JFrame frame = new JFrame("Calculator");
        frame.setSize(640,1024);
        frame.setLocation(100,100);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        CalculatorUI(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    private void CalculatorUI(Container container){
        container.setLayout(new GridBagLayout());
        container.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridy = 0;
        constraints.gridwidth = 4;

        container.add(new JTextField(20), constraints);

        String letters[] = {"C", "+/-", "%", "/",
        "7", "8","9", "*",
        "4","5", "6", "-",
        "1","2", "3", "+",
        "0","x^n",",","="};

        for (int i = 0; i<letters.length; i++){
            constraints.gridy = (int)(i/4)+1;
            constraints.gridwidth = 1;
            JButton btn = new JButton(letters[i]);
            container.add(btn, constraints);
            btn.setActionCommand(letters[i]);
            btn.addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String command = button.getActionCommand();
        System.out.println(command);
        pushToTextLine(command);
        if (command == "="){
            System.out.println("Calculating result: ");
            double result = calculateResult();
        }
    }

    private void pushToTextLine(String arg){
        command+=arg;
    }

    private static double calculateResult(){
        double result=0;

        return result;
    }

}

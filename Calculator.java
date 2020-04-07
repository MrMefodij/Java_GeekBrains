package Java_GeekBrains;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    private static String textOutput="";
    private static double[] arguments ={0,0};
    private static int operation = 0;
    private static double result=0;

    JTextField outputCalc = new JTextField(textOutput,20);

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

        container.add(outputCalc, constraints);

        String letters[] = {"C", "+/-", "√", "/",
                            "7", "8","9", "*",
                            "4","5", "6", "-",
                            "1","2", "3", "+",
                            "0","x^n",".","="};

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
        commandOperation(command);
    }

    private void pushToTextLine(String arg){
        textOutput+=arg;
    }

    private double calculateResult(){
            switch (operation) {
                case 1:
                    result = Math.sqrt(arguments[0]);
                    break;
                case 2:
                    result = arguments[0] / arguments[1];
                    break;
                case 3:
                    result = arguments[0] * arguments[1];
                    break;
                case 4:
                    result = arguments[0] - arguments[1];
                    break;
                case 5:
                    result = arguments[0] + arguments[1];
                    break;
                case 6:
                    result = Math.pow(arguments[0], arguments[1]);
                    break;
                default:
                    displayError();
                    setToSmth("", 0, 0,0);
                    break;
            }
        System.out.println(arguments[0] + " " + arguments[1] + " " + operation + " " +result);
        return result;
    }

    private static boolean isValid(String text, int op) {
        boolean result = false;
        if (op > 0 && op <7 ){
            result = true;
        }
        return result;
    }

    private static boolean isNotConvertible(String s){
        boolean result = false;
        try {
            double d = Double.parseDouble(s);
        } catch (NumberFormatException e) {
            result = true;
        }
        return result;
    }

    private static void setToSmth(String a, double b, double c, int d){
        textOutput = a;
        arguments[0]=b;
        arguments[1]=c;
        operation = d;
    }

    private void displayError(){
        JFrame errorFrame = new JFrame("Error");
        JPanel ErrorContents = new JPanel(new FlowLayout());
        JOptionPane.showMessageDialog(ErrorContents,"<html><h2> Error! </h2><i> Something was incorrect! </i>", "Error",
                JOptionPane.ERROR_MESSAGE);
        errorFrame.setContentPane(ErrorContents);
        errorFrame.pack();
        errorFrame.setVisible(true);
    }


    private void commandOperation(String command){
        switch (command){
            case "C":
                setToSmth("", 0, 0,0);
                outputCalc.setText(textOutput);
                break;

            case "+/-":
                char ch = textOutput.charAt(0);
                if (ch != '-'){
                    textOutput = "-" + textOutput;
                } else {
                    textOutput = textOutput.substring(1, textOutput.length());
                }
                outputCalc.setText(textOutput);
                break;

            case "√":
                if (isNotConvertible(textOutput)){
                    //is error
                    displayError();
                    setToSmth("", 0, 0,0);
                } else{
                    setToSmth(textOutput, Double.parseDouble(textOutput),0,1);
                }
                break;
            case "/":
                if (isNotConvertible(textOutput)){
                    //is error
                    displayError();
                    setToSmth("", 0, 0,0);
                } else {
                    setToSmth("", Double.parseDouble(textOutput),0,2);
                }
                break;
            case "*":
                if (isNotConvertible(textOutput)){
                    //is error
                    displayError();
                    setToSmth("", 0, 0,0);
                } else {
                    setToSmth("", Double.parseDouble(textOutput),0,3);
                }
                break;
            case "-":
                if (isNotConvertible(textOutput)){
                    //is error
                    displayError();
                    setToSmth("", 0, 0,0);
                } else {
                    setToSmth("", Double.parseDouble(textOutput),0,4);
                }
                break;
            case "+":
                if (isNotConvertible(textOutput)){
                    //is error
                    displayError();
                    setToSmth("", 0, 0,0);
                } else {
                    setToSmth("",Double.parseDouble(textOutput),0,5);
                }
                break;

            case "x^n":
                if (isNotConvertible(textOutput)){
                    displayError();
                    setToSmth("", 0, 0,0);
                } else {
                    setToSmth("", Double.parseDouble(textOutput),0, 6);
                }
                break;

            case "=":
                if (isValid(textOutput , operation)) {
                    arguments[1] = Double.parseDouble(textOutput);
                } else{
                    arguments[1]=0;
                }
                calculateResult();
                setToSmth(Double.toString(result), result, 0,0);
                outputCalc.setText(textOutput);
                break;

            case ".":
            case "7":
            case "8":
            case "9":
            case "4":
            case "5":
            case "6":
            case "1":
            case "2":
            case "3":
            case "0":
                pushToTextLine(command);
                outputCalc.setText(textOutput);
                break;
            default:
                setToSmth("", 0, 0,0);
                displayError();
                break;
        }
    }
}

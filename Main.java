package com.viktoriiaalkhafaji;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    static Integer myNumber = ThreadLocalRandom.current().nextInt(1, 100 + 1);
    static Integer counter = 0;
    static JLabel text = new JLabel("Type a number between 0 and 100!");
    static JLabel textCounter = new JLabel("Tries: " + counter);
    static JTextField textField = new JTextField();
    static JButton button = new JButton ("Guess!");
    static JButton buttonPlayAgain = new JButton ("Play again!");
    static JFrame frame = new JFrame("Guess the number");
    public static void main(String[] args) {
        openUI();
    }

    public static void openUI () {
        JFrame frame = new JFrame("Guess the number");
        frame.setSize(400 , 300);
        frame.setLocation( 100, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setDefaultLookAndFeelDecorated(true);

        text.setBounds(50,50,350,30);
        textField.setBounds(50, 100, 200, 30);
        textCounter.setBounds(255, 100,50, 30);

        button.setBounds(100, 150, 100, 30);
        buttonPlayAgain.setBounds(205,150, 100,30);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String textFromTextField = textField.getText();
                    Integer number = Integer.parseInt(textFromTextField);
                    guess(number);
                } catch (Exception error) {
                    text.setText("Please type a number in!");
                }

            }
        });

        buttonPlayAgain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonPlayAgain.setVisible(false);
                button.setEnabled(true);
                counter = 0;
                textCounter.setText("Tries: " + counter);
                myNumber = ThreadLocalRandom.current().nextInt(1, 100 + 1);
                text.setText("Type a number between 0 and 100!");
            }
        });
        frame.add(text);
        frame.add(textField);
        frame.add(textCounter);
        frame.add(button);
        frame.add(buttonPlayAgain);
        buttonPlayAgain.setVisible(false);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    public static void guess (Integer number) {
        counter ++;
        textCounter.setText("Tries: "+ counter);
        if (number == myNumber){
            text.setText("You won! And made " + counter + " attempts.");
            textField.setText("");
            button.setEnabled(false);

            buttonPlayAgain.setVisible(true);
        } else {
            if (myNumber > number) {
                text.setText("Try again! Your number is too small");
            } else {
                text.setText("Try again! Your number is too big");
            }
        }
    }

}

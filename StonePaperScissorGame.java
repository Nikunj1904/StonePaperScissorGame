package com.technohacks;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class StonePaperScissorGame extends JFrame implements ActionListener {
    private JLabel userChoiceLabel, computerChoiceLabel, resultLabel;
    private JButton stoneButton, paperButton, scissorButton;

    public StonePaperScissorGame() {
        
        setTitle("Stone Paper Scissor Game");
        setSize(550, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        getContentPane().setBackground(Color.BLACK);
        
        userChoiceLabel = new JLabel("Your Choice: ");
        computerChoiceLabel = new JLabel("Computer's Choice: ");
        resultLabel = new JLabel("Result: ");
        
        styleLabel(userChoiceLabel);
        styleLabel(computerChoiceLabel);
        styleLabel(resultLabel);
        
        stoneButton = createStyledButton("Stone");
        paperButton = createStyledButton("Paper");
        scissorButton = createStyledButton("Scissor");

        stoneButton.addActionListener(this);
        paperButton.addActionListener(this);
        scissorButton.addActionListener(this);

        
        setLayout(new GridLayout(5, 5, 20, 10));
        add(userChoiceLabel);
        add(computerChoiceLabel);
        add(resultLabel);
        add(stoneButton);
        add(paperButton);
        add(scissorButton);
    }

    private void styleLabel(JLabel label) {
        label.setForeground(Color.WHITE);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 16));
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(Color.GRAY);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String[] choices = {"Stone", "Paper", "Scissor"};
        String userChoice = e.getActionCommand();
        String computerChoice = choices[new Random().nextInt(choices.length)];

        userChoiceLabel.setText("Your Choice: " + userChoice);
        computerChoiceLabel.setText("Computer's Choice: " + computerChoice);

        String result = determineWinner(userChoice, computerChoice);
        resultLabel.setText("Result: " + result);
    }

    private String determineWinner(String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) {
            return "Draw";
        } else if ((userChoice.equals("Stone") && computerChoice.equals("Scissor")) ||
                   (userChoice.equals("Paper") && computerChoice.equals("Stone")) ||
                   (userChoice.equals("Scissor") && computerChoice.equals("Paper"))) {
            return "You Win!";
        } else {
            return "Computer Wins!";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StonePaperScissorGame().setVisible(true);
            }
        });
    }
}

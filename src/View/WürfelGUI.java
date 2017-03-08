package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by 204g07 on 06.03.2017.
 */
public class WürfelGUI extends JFrame{
    private JPanel panel;
    private JTextArea textArea1;
    private JButton rollTheDiceButton;
    private JTextField targetTextField;
    private JButton setNumberButton;
    private JLabel label1;
    private JRadioButton radioButton1;
    private JButton restartGameButton;


    private int target;
    private int currentRoll;
    private boolean firstRollComplete;
    private int diceFaces[] = {1,2,3,4,5,6};

    public WürfelGUI(){
        setVisible(true);
        setSize(640,480);
        setContentPane(panel);
        setBackground(new Color(83,87,89));
        textArea1.setFont(new Font( Font.SERIF, Font.PLAIN, 25 ));
        firstRollComplete = false;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setNumberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!targetTextField.getText().isEmpty()) {
                    if(Integer.parseInt(targetTextField.getText()) > 6) {
                        target = Integer.parseInt(targetTextField.getText());
                        setNumberButton.setEnabled(false);
                        targetTextField.setEditable(false);
                        rollTheDiceButton.setEnabled(true);
                    }else {
                        JOptionPane.showMessageDialog(panel,
                                "Please set a target number above 6",
                                "Error",
                                JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });

        rollTheDiceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!firstRollComplete) {
                    firstRollComplete = true;
                    currentRoll = (int) (Math.random() * 6 + 1);
                    displayRoll(currentRoll);
                    rollTheDiceButton.setText("Tilt Dice" );
                    radioButton1.setText("1");
                }
            }
        });

        //Restart Game

        restartGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restartGame();
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    private void displayRoll(int i){
        switch(i){
            case 1:
                textArea1.setText("\n" + "       ●");
                break;
            case 2:
                textArea1.setText("●" + "\n" + "\n" + "             ●");
                break;
            case 3:
                textArea1.setText("●" + "\n" + "       ●" + "\n" + "             ●");
                break;
            case 4:
                textArea1.setText("●         ●" + "\n" + "\n" + "●         ●");
                break;
            case 5:
                textArea1.setText("●         ●" + "\n" + "       ●" + "\n" + "●         ●");
                break;
            case 6:
                textArea1.setText("●         ●" + "\n" + "●         ●" + "\n" + "●         ●");

        }
    }
    private void restartGame(){
        firstRollComplete = false;
        textArea1.setText("");
        targetTextField.setText("");
        targetTextField.setEditable(true);
        setNumberButton.setEnabled(true);
    }

    private void chooseButtonText(int r, int a[]){

    }

}

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
    private JButton button1;
    private JLabel label1;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;
    private JRadioButton radioButton4;
    private int target;
    private int firstRoll;
    private boolean firstRollComplete;

    public WürfelGUI(){
        setVisible(true);
        setSize(640,480);
        setContentPane(panel);
        setBackground(new Color(83,87,89));
        textArea1.setFont(new Font( Font.SERIF, Font.PLAIN, 25 ));
        firstRollComplete = false;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!targetTextField.getText().isEmpty()) {
                    if(Integer.parseInt(targetTextField.getText()) > 6) {
                        target = Integer.parseInt(targetTextField.getText());
                        button1.setEnabled(false);
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
                    firstRoll = (int) (Math.random() * 6 + 1);
                    displayRoll(firstRoll);
                    rollTheDiceButton.setText("Tilt Dice" );
                }
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
}

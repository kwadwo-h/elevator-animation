//Author: Kwadwo.h (Jeffrey Edward Osei-Hwedieh)
//21/06/20

import java.awt.*;
import javax.swing.*;

//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

public class ElevatorFrame extends JFrame {

    public BorderLayout layout = new BorderLayout();
    public ElevatorModel graphics = new ElevatorModel();
    public ElevatorPanel elevatorPanel = new ElevatorPanel();
    private JPanel panel01 = new JPanel(new FlowLayout());
    private JPanel panel02 = new JPanel(new FlowLayout());
  //private JPanel panel03 = new JPanel(new FlowLayout());
    private JPanel panel04 = new JPanel(new FlowLayout());

    public ElevatorFrame() {
        setLayout(layout);
        add(panel01, BorderLayout.PAGE_END);
        add(panel02, BorderLayout.PAGE_START);
        add(graphics);
        add(panel04, BorderLayout.EAST);
        // panel04.add(elevatorPanel);
    }

    // ELEVATOR DISPLAY FRAME
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(false);
        ElevatorFrame frame = new ElevatorFrame();
        frame.setTitle("Elevator");
        frame.setSize(1300, 650);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
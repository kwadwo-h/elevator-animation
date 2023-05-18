//Author: Kwadwo.h (Jeffrey Edward Osei-Hwedieh)
//21/06/20

import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ElevatorPanel extends JPanel implements ActionListener {
    // BUTTONS
    public JPanel pane = new JPanel();
    public JButton b1 = new JButton("1");
    public JButton b2 = new JButton("");
    public JButton b3 = new JButton("2");
    public JButton b4 = new JButton("");
    public JButton b5 = new JButton("3");
    public JButton b6 = new JButton("");
    public JButton b7 = new JButton("4");
    public JButton b8 = new JButton("");
    public JButton b9 = new JButton("GF");
    public JButton b10 = new JButton("");
    public JButton b11 = new JButton("Bell");
    public JButton b12 = new JButton("");
    public JButton b13 = new JButton("<||>");
    public JButton b14 = new JButton("");
    public JButton b15 = new JButton(">||<");
    public JButton b16 = new JButton("");
    // BUTTON DIMENSIONS
    public DimensionUIResource size = new DimensionUIResource(100, 85);
   // static int current_floor = 0;
    private GridLayout layout = new GridLayout(4, 10, 10, 50);

    public ElevatorPanel() {
        setBackground(Color.WHITE);
        setLayout(layout);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        add(b7);
        add(b8);
        add(b9);
        add(b10);
        add(b11);
        add(b12);
        add(b13);
        add(b14);
        add(b15);
        add(b16);

        b1.setEnabled(false);
        b3.setEnabled(false);
        b5.setEnabled(false);
        b7.setEnabled(false);
        b9.setEnabled(false);
        b11.setEnabled(false);
        b13.setEnabled(false);
        b15.setEnabled(false);
        b1.addActionListener(this);
        b3.addActionListener(this);
        b5.addActionListener(this);
        b7.addActionListener(this);
        b9.addActionListener(this);

        // b16.addActionListener();
        b1.setPreferredSize(size);
        b2.setPreferredSize(size);

        // pressedButtons
        b2.setEnabled(true);
        b4.setEnabled(true);
        b6.setEnabled(true);
        b8.setEnabled(true);
        b10.setEnabled(true);
        b12.setEnabled(true);
        b14.setEnabled(true);
        b16.setEnabled(true);
        b2.addActionListener(this);
        b4.addActionListener(this);
        b6.addActionListener(this);
        b8.addActionListener(this);
        b10.addActionListener(this);
        // b12.addActionListener(this);

       // System.out.println("Current floor " + current_floor);
       // System.out.println(" ");
    }

    public void actionPerformed(ActionEvent s) {
        /*
         * Object source = s.getSource(); int target_floor, floor;
         * 
         * if (source == b2) {
         * 
         * target_floor = 1; MoveElevator(target_floor);
         * 
         * } if (source == b4) { target_floor = 2; MoveElevator(target_floor); }
         * 
         * if (source == b6) { target_floor = 3; MoveElevator(target_floor);
         * 
         * } if (source == b8) { target_floor = 4; MoveElevator(target_floor); } if
         * (source == b10) { target_floor = 0; MoveElevator(target_floor); }
         * System.out.println("Currently on floor " + current_floor);
         * System.out.println(" "); }
         * 
         * public static void MoveElevator(int target_floor) { int direction; if
         * (target_floor > current_floor) { direction = 1;
         * System.out.println("Elevator moving up...");
         * 
         * } else { direction = -1; System.out.println("Elevator moving down..."); }
         * while (target_floor != current_floor) { current_floor += direction;
         * System.out.println("Floor:" + current_floor);
         * 
         * }
         */
    }

}
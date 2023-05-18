//Author: Kwadwo.h (Jeffrey Edward Osei-Hwedieh)
//21/06/20
import javax.swing.JPanel;


import java.awt.*;
import javax.swing.*;
//import java.awt.*;
//import javax.swing.*;


//import java.util.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ElevatorModel extends JPanel {
    public ElevatorPanel elevatorPanel = new ElevatorPanel();
    // Elevator buttons
    public JButton b1 = new JButton("G Floor");
    public JButton b2 = new JButton("1st Floor");
    public JButton b3 = new JButton("2nd Floor");
    public JButton b4 = new JButton("3rd Floor");
    public JButton b5 = new JButton("4th Floor");
    public JButton b6 = new JButton("<||>");
    public JButton b7 = new JButton(">||<");
    Icon icon1 = new ImageIcon("up.jpg");
    public JButton b8 = new JButton(icon1);
    Icon icon2 = new ImageIcon("down.png");
    public JButton b9 = new JButton(icon2);
    ImageIcon icon3 = new ImageIcon("red-dash.png");
    public JButton b10 = new JButton("Bell");
    
   
    
    boolean closed = true;
    boolean opened = true;
     //Timer tm = new Timer(200, this);
     //Timer tm2 = new Timer(200, this);
    public String floorString;
    public String doorString;
    public int x = 185, y = 295;
    public static int z = 457;
    public int current_floor = 0, target_floor;
    public int velX, velY, velZ;
    
    
    public ElevatorModel() {

        this.velX = 2;
        this.velY = 2;
        this.velZ = 2;
        
        this.floorString = "GROUND FLOOR";
        setBackground(Color.CYAN);
        setVisible(true);
        setLayout(null);



        b1.setSize(90,70); b1.setLocation(600,470);
        b2.setSize(90,70); b2.setLocation(600,200);
        b3.setSize(90,70); b3.setLocation(710,200);
        b4.setSize(90,70); b4.setLocation(600,290);
        b5.setSize(90,70); b5.setLocation(710,290);
        b6.setSize(90,70); b6.setLocation(600,380);
        b7.setSize(90,70); b7.setLocation(710,380);
        b8.setSize(50,50); b8.setLocation(430,260);
        b9.setSize(50,50); b9.setLocation(430,320);
        b10.setSize(90,70); b10.setLocation(710,470);
        
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        add(b7);
        add(b8); add(b9); add(b10);
        

        b1.addActionListener(new ButtonListener());
        b2.addActionListener(new ButtonListener());
        b3.addActionListener(new ButtonListener());
        b4.addActionListener(new ButtonListener());
        b5.addActionListener(new ButtonListener());
        b6.addActionListener(new ButtonListener());
        b7.addActionListener(new ButtonListener());
        b8.addActionListener(new ButtonListener());
        b9.addActionListener(new ButtonListener());

        
        b1.setEnabled(false);
        b2.setEnabled(false);
        b3.setEnabled(false);
        b4.setEnabled(false);
        b5.setEnabled(false);
        b9.setEnabled(false);


        
        System.out.println("Currently on floor " + current_floor);
        System.out.println(" ");

    }

    public void paintComponent(Graphics arg0) {
        super.paintComponent(arg0);
        // ELEVATOR GRAPHICS
        //TITLE
        arg0.setColor(Color.BLACK);
        arg0.setFont(new Font("TimesRoman", Font.BOLD, 40));
        arg0.drawString("ELEVATOR CONTROL SYSTEM", 360, 40);

        //INSIDE BUTTON PANEL
        arg0.setColor(Color.BLACK);
        arg0.setFont(new Font("Gotham", Font.BOLD, 15));
        arg0.drawString("INSIDE BUTTON PANEL ",610,180);


        // LEFT DOOR
        arg0.setColor(Color.DARK_GRAY);
        arg0.fillRect(x, 160, 110, 350);
         //tm.start();

        // RIGHT DOOR
        arg0.setColor(Color.DARK_GRAY);
        arg0.fillRect(y, 160, 110, 350);
         //tm2.start();

        // LEFT WALL STRUCTURE
        arg0.setColor(Color.GRAY);
        arg0.fillRoundRect(50, 110, 160, 400, 30, 30);

        // RIGHT WALL STRUCTURE
        arg0.setColor(Color.GRAY);
        arg0.fillRoundRect(380, 110, 160, 400, 30, 30);

        // TOP STRUCTURE
        arg0.setColor(Color.GRAY);
        arg0.fillRoundRect(175, 110, 240, 80, 30, 30);

        // FLOOR
        arg0.setColor(Color.WHITE);
        arg0.setFont(new Font("Gotham", Font.BOLD, 15));
        arg0.drawString(floorString, 70, 145);

         //ARROW DIRECTIONS
        icon3.paintIcon(this, arg0, 275, 144);


        // INDICATOR GRAPHICS
        // Full Body
        arg0.setColor(Color.DARK_GRAY);
        arg0.drawRect(850, 119, 363, 406);

        // Top Rectangle
        arg0.setColor(Color.DARK_GRAY);
        arg0.drawRect(851, 120, 361, 50);

        // Fourth Floor
        // left rect
        arg0.setColor(Color.BLACK);
        arg0.setFont(new Font("Gotham", Font.PLAIN, 20));
        arg0.drawString("Fourth Floor", 900, 205);
        arg0.setColor(Color.DARK_GRAY);
        arg0.drawRect(851, 171, 180, 70);
        // right rect
        arg0.setColor(Color.DARK_GRAY);
        arg0.drawRect(1031, 171, 180, 70);

        // Third Floor
        // left rect
        arg0.setColor(Color.BLACK);
        arg0.setFont(new Font("Gotham", Font.PLAIN, 20));
        arg0.drawString("Third Floor", 900, 275);
        arg0.setColor(Color.DARK_GRAY);
        arg0.drawRect(851, 242, 180, 70);
        // right rect
        arg0.setColor(Color.DARK_GRAY);
        arg0.drawRect(1031, 242, 180, 70);

        // Second Floor
        // left rect
        arg0.setColor(Color.BLACK);
        arg0.setFont(new Font("Gotham", Font.PLAIN, 20));
        arg0.drawString("Second Floor", 900, 345);
        arg0.setColor(Color.DARK_GRAY);
        arg0.drawRect(851, 313, 180, 70);
        // right rect
        arg0.setColor(Color.DARK_GRAY);
        arg0.drawRect(1031, 313, 180, 70);

        // First Floor
        // left rect
        arg0.setColor(Color.BLACK);
        arg0.setFont(new Font("Gotham", Font.PLAIN, 20));
        arg0.drawString("First Floor", 900, 415);
        arg0.setColor(Color.DARK_GRAY);
        arg0.drawRect(851, 384, 180, 70);
        // right rect
        arg0.setColor(Color.DARK_GRAY);
        arg0.drawRect(1031, 384, 180, 70);

        // Ground floor
        // left rect
        arg0.setColor(Color.BLACK);
        arg0.setFont(new Font("Gotham", Font.PLAIN, 20));
        arg0.drawString("Ground Floor", 900, 485);
        arg0.setColor(Color.DARK_GRAY);
        arg0.drawRect(851, 455, 180, 70);
        // right rect
        arg0.setColor(Color.DARK_GRAY);
        arg0.drawRect(1031, 455, 180, 70);
        // LevelIndicator
        arg0.setColor(Color.GREEN);
        for (int j = 0; j < 25; j++) {
            arg0.fill3DRect(1034, z, 175, 65, false);
            // tm2.start();
        }
    }

    public class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            final JButton action = (JButton) event.getSource();
            Thread thread = new Thread() {
                public void run() {
                    operation(action);
                }
            };
            thread.start();
        }


        public void operation(JButton action) {



            // GROUND FLOOR INDICATOR

            if (action == b1) {
                //close elevator
                closeDoor();
                b1pressed();
                //open elevator
                openDoor();
                
            }
            // FIRST FLOOR INDICATOR
            else if (action == b2) {
                closeDoor();
                b2pressed();
                openDoor();

            }
            // SECOND FLOOR INDICATOR
            else if (action == b3) {
                closeDoor();
                b3pressed();
                openDoor();
            }
            // THIRD FLOOR INDICATOR
            else if (action == b4) {
                closeDoor();
                b4pressed();
                //open elevator
                openDoor();
            }
            // FOURTH FLOOR INDICATOR
            else if (action == b5) {
                closeDoor();
                b5pressed();
                openDoor();

            }
            // OPENING ACTION
            else if (action == b6) {
               openDoor();
            }

            // CLOSING ACTION
            else if (action == b7) {
                closeDoor();
            }
            //UP BUTTON
            else if (action == b8){
                icon3 = new ImageIcon("red-up.png");
                openDoor();
                if(current_floor == 0)
                {
                    b2.setEnabled(true); b3.setEnabled(true); b4.setEnabled(true); b5.setEnabled(true);
                    b1.setEnabled(false);
                    if(action == b2){
                        closeDoor();
                        b2pressed();
                        openDoor();
                        
                    }
                    else if (action == b3) {
                        closeDoor();
                        b3pressed();
                        openDoor();

                    }
                    else if(action == b4){
                        closeDoor();
                        b4pressed();
                        //open elevator
                        openDoor();
   
                    }
                    else if(action == b5){
                        closeDoor();
                        b5pressed();
                        openDoor();   
                    }

                    try{
                        Thread.sleep(5000);
                        closeDoor();
                    }catch(Exception s){}
                

                }
                
                else if(current_floor == 1){
                    b3.setEnabled(true); b4.setEnabled(true); b5.setEnabled(true);
                    b2.setEnabled(false); b1.setEnabled(false);

                    if (action == b3) {
                        closeDoor();
                        b3pressed();
                        openDoor();
        
                    }
                    else if(action == b4){
                        closeDoor();
                        b4pressed();
                        //open elevator
                        openDoor();
                    }
                    else if(action == b5){
                        closeDoor();
                        b5pressed();
                        openDoor();
                        
                    }
                    try{
                        Thread.sleep(5000);
                        closeDoor();
                    }catch(Exception s){}
    
                }
                else if(current_floor == 2){
                    b4.setEnabled(true); b5.setEnabled(true);
                    b3.setEnabled(false); b2.setEnabled(false); b1.setEnabled(false);

                    if(action == b4){
                        closeDoor();
                        b4pressed();
                        //open elevator
                        openDoor();

                        
                    }
                    else if(action == b5){
                        closeDoor();
                        b5pressed();
                        openDoor();

                        
                    }
                    try{
                        Thread.sleep(5000);
                        closeDoor();
                    }catch(Exception s){}

                }
                else if(current_floor == 3){
                    b5.setEnabled(true);
                    b4.setEnabled(false); b3.setEnabled(false); b2.setEnabled(false); b1.setEnabled(false);

                    if(action == b5){
                        closeDoor();
                        b5pressed();
                        openDoor();

                        
                    }
                    try{
                        Thread.sleep(5000);
                        closeDoor();
                    }catch(Exception s){}

                }
                
            } 

            //DOWN BUTTON
            else if(action == b9){
                icon3 = new ImageIcon("red-down.png");
                openDoor();
                if(current_floor == 1){
                    b1.setEnabled(true);
                    b2.setEnabled(false); b3.setEnabled(false); b4.setEnabled(false); b5.setEnabled(false);

                    if (action == b1) {
                        //close elevator
                        closeDoor();
        
                        b1pressed();
                        //open elevator
                        openDoor();
        
                    }
                    try{
                        Thread.sleep(5000);
                        closeDoor();
                    }catch(Exception s){}
                }
                else if(current_floor == 2){
                    b1.setEnabled(true); b2.setEnabled(true); 
                    b3.setEnabled(false); b4.setEnabled(false); b5.setEnabled(false);

                    if (action == b1) {
                        //close elevator
                        closeDoor();
        
                       b1pressed();
                        //open elevator
                        openDoor();
        
                    }
                    // FIRST FLOOR INDICATOR
                    else if (action == b2) {
                        closeDoor();
                        b2pressed();
                        openDoor();
                    }
                    try{
                        Thread.sleep(5000);
                        closeDoor();
                    }catch(Exception s){}


                }
                else if(current_floor == 3){
                    b1.setEnabled(true); b2.setEnabled(true); b3.setEnabled(true);
                    b4.setEnabled(false); b5.setEnabled(false);

                    if (action == b1) {
                           //close elevator
                           closeDoor();
        
                           b1pressed();
                           //open elevator
                           openDoor();
           
                       }
                       // FIRST FLOOR INDICATOR
                       else if (action == b2) {
                           closeDoor();
                           b2pressed();
                           openDoor();
                       }
                    // SECOND FLOOR INDICATOR
                    else if (action == b3) {
                        closeDoor();
                        b3pressed();
                        openDoor();
                    }
                    try{
                        Thread.sleep(5000);
                        closeDoor();
                    }catch(Exception s){}
                    
                }
                else if(current_floor == 4){
                    b1.setEnabled(true); b2.setEnabled(true); b3.setEnabled(true); b4.setEnabled(true);
                    b5.setEnabled(false);

                    if (action == b1) {
                        //close elevator
                        closeDoor();
     
                        b1pressed();
                        //open elevator
                        openDoor();
        
                    }

                    // FIRST FLOOR INDICATOR
                    else if (action == b2) {
                        closeDoor();
                        b2pressed();
                        openDoor();
                    }
                 // SECOND FLOOR INDICATOR
                    else if (action == b3) {
                     closeDoor();
                     b3pressed();
                     openDoor();
                    }
                    // THIRD FLOOR INDICATOR
                    else if (action == b4) {
                        closeDoor();
                        b4pressed();
                        //open elevator
                        openDoor();
        
                    }
                    try{
                        Thread.sleep(5000);
                        closeDoor();
                    }catch(Exception s){}
                }   
            }
        }
    }
        
    

    public void MoveElevator(int target_floor) {
        int direction;
        if (target_floor > current_floor) {
            direction = 1;
            System.out.println(" ");
            System.out.println("Elevator moving up...");
            icon3 = new ImageIcon("red-up.png");


        } else {
            direction = -1;
            System.out.println(" ");
            System.out.println("Elevator moving down...");
            icon3 = new ImageIcon("red-down.png");
        }
        try{
            while (target_floor != current_floor) {
                Thread.sleep(1500);
                current_floor += direction;
                
                
                Thread.sleep(1500);
                //floorString = String.valueOf(current_floor);
                System.out.println("Floor:" + current_floor);
                if (direction == 1)
                {
                    z = z - 71;
                    repaint();
                }
                if (direction == -1)
                {
                    z = z + 71;
                    repaint();
                }
            }
            icon3 = new ImageIcon("red-dash.png");

        }catch(Exception e){

        }
    
        if(current_floor == 0){
            b9.setEnabled(false);
            b8.setEnabled(true);
        }
        else if(current_floor == 1 || current_floor == 3 || current_floor == 2){
            b9.setEnabled(true);
            b8.setEnabled(true);
        }
        else{
            b8.setEnabled(false);
            b9.setEnabled(true);
        }

    }

    public void openDoor(){
        try {
            while (x > 200 || y < 355) {
                Thread.sleep(50);
                x = x - velX;
                y = y + velY;
                repaint();
            }
        } catch (Exception e) {

        }
    }

    public void closeDoor(){
        try {
            while (x < 200 || y > 355) {
                Thread.sleep(50);
                x = x + velX;
                y = y - velY;
                repaint();
            }
        } catch (Exception e) {

        }
    }
    
    public void b1pressed(){
        if (x >= 185 || y <= 295) {
            //floorString = "GROUND FLOOR";
            target_floor = 0;
            MoveElevator(target_floor);
            //z = 457 - 0;
            repaint();
            floorString = "GROUND FLOOR";
        }
    }

    public void b2pressed(){
        if (x >= 185 || y <= 295) {
            //floorString = "FIRST FLOOR";
            target_floor = 1;
            MoveElevator(target_floor);
            //z = 386 - 0;
            repaint();
            floorString = "FIRST FLOOR";
        }
    }
    public void b3pressed(){
        if (x >= 185 || y <= 295) {
            //floorString = "SECOND FLOOR";
            target_floor = 2;
            MoveElevator(target_floor);
           // z = 315 - 0;
            repaint();
            floorString = "SECOND FLOOR";
        }
    }
    public void b4pressed(){
        if (x >= 185 || y <= 295) {
            //floorString = "THIRD FLOOR";
            target_floor = 3;
            MoveElevator(target_floor);
            //z = 244 - 0;
            repaint();
            floorString = "THIRD FLOOR";
        }
    }
    public void b5pressed(){
        if (x >= 185 || y <= 295) {
            //floorString = "FOURTH FLOOR";
            target_floor = 4;
            MoveElevator(target_floor);
           // z = 173 - 0;
            repaint();
            floorString = "FOURTH FLOOR";
            
        }
  
    }
  
}

    
   

    


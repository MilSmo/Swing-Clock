package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.time.LocalTime;

public class ClockWithGui extends JPanel {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Clock");
        frame.setContentPane(new ClockWithGui());
        frame.setSize(700, 700);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setVisible(true);

    }


    LocalTime time = LocalTime.now();







    public void paintComponent(Graphics g){
        ClockThread clockThread = new ClockThread();
        clockThread.start();
        Graphics2D g2d=(Graphics2D)g;
        g2d.translate(getWidth()/2,getHeight()/2);
        g2d.drawOval(-195,-205,400,400);
        g2d.fillOval(-195,-205,400,400);
        g2d.setColor(new Color(243,235,255));
        g2d.setFont(new Font("Arial", Font.BOLD, 20));




        for(int i=1;i<13;i++){

            AffineTransform at = new AffineTransform();
            int width = g2d.getFontMetrics().stringWidth(String.valueOf(i));
            at.rotate(2*Math.PI/12*i);
            Point2D src = new Point2D.Float(0,-190);
            Point2D trg = new Point2D.Float();
            at.transform(src,trg);
            g2d.drawString(Integer.toString(i),(int)trg.getX(),(int)trg.getY());
        }
        for(int i=1;i<61;i++){
            AffineTransform at = new AffineTransform();
            at.rotate(2*Math.PI/60*i);
            Point2D src = new Point2D.Float(0,-190);
            Point2D trg = new Point2D.Float();
            at.transform(src,trg);
            if (i%5==0){
                continue;
            }

            g2d.drawString(".",(int)trg.getX(),(int)trg.getY());

        }


        AffineTransform saveAT = g2d.getTransform();
        g2d.rotate(time.getHour()%12*2*Math.PI/12);
        g2d.drawLine(0,0,0,-100);

        g2d.setStroke(new BasicStroke(10,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));


        g2d.drawLine(0,0,0,-100);
        g2d.setTransform(saveAT);

        g2d.rotate(time.getMinute()%60*2*Math.PI/60);
        g2d.setStroke(new BasicStroke(5,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
        g2d.drawLine(0,0,0,-120);
        g2d.setTransform(saveAT);
        g2d.setColor(new Color(210,145,255));

        g2d.rotate(time.getSecond()%60*2*Math.PI/60);
        g2d.setStroke(new BasicStroke(2,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
        g2d.drawLine(0,0,0,-150);
g2d.setTransform(saveAT);





    }
    //make clock hands move

    class ClockThread extends Thread {
        public void run() {
            while (true) {
                // Update the current time
                time = LocalTime.now();
                // Repaint the clock
                repaint();
                try {
                    // Sleep for 1 second
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }




    }





package com.company;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Clock");
        frame.setContentPane(new ClockWithGui());
        frame.setSize(700, 700);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());
        frame.add(new ClockWithGui(), BorderLayout.CENTER);

    }}

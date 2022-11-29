package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelManagement extends JFrame implements ActionListener
{
    HotelManagement() {
//        setSize(1365,565);
//
//        setLocation(100,100);
        setBounds(100, 100, 1365, 565);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1365, 565);
        add(image);

        JLabel text = new JLabel("WELCOME TO HOTEL MANAGEMENT SYSTEM");
        text.setBounds(20, 470, 700, 30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif", Font.PLAIN, 30));
        image.add(text);

        JButton next = new JButton("NEXT");
        next.setBounds(1150, 470, 150, 40);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        next.setFont(new Font("serif", Font.PLAIN, 30));

        image.add(next);

        setVisible(true);

        while (true) {
            text.setVisible(false);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
            text.setVisible(true);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        new HotelManagement();


    }


    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Login();

    }
}
package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;

public class AddEmployee extends JFrame {
    AddEmployee(){
        setLayout(null);

        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(60,30,120,30);
        lblname.setFont(new Font("Tahoma", Font.PLAIN,17));
        add(lblname);

        JTextField tfname = new JTextField();
        tfname.setBounds(200,80,150,30);
        add(tfname);

        JLabel lblage = new JLabel("AGE");
        lblage.setBounds(60,80,120,30);
        lblage.setFont(new Font("Tahoma", Font.PLAIN,17));
        add(lblage);

        JTextField tfage = new JTextField();
        tfage.setBounds(200,30,150,30);
        add(tfage);


        getContentPane().setBackground(Color.WHITE);
        setBounds(350,200,850,450);
        setVisible(true);
    }

    public static void main(String[] args){
        new AddEmployee();
    }
}

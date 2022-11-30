package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame
{
    Dashboard() {
        setLayout(null);
        setBounds(0, 0, 1550, 1000);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1550, 1000);
        add(image);

        JLabel text = new JLabel("WELCOME TO OUR MANSION");
        text.setBounds(400, 80, 1000, 50);
        text.setFont(new Font("Tahoma", Font.PLAIN, 46));
        text.setForeground(Color.WHITE);
        image.add(text);

        JMenuBar nb = new JMenuBar();
        nb.setBounds(0, 0, 1550, 30);
        image.add(nb);

        JMenu hotel = new JMenu("HOTEL MANAGEMENT");
        hotel.setForeground(Color.RED);
        nb.add(hotel);

        JMenuItem reception = new JMenu("RECEPTION");
        hotel.add(reception);

        JMenu admin = new JMenu("ADMIN");
        admin.setForeground(Color.BLUE);
        nb.add(admin);

        JMenuItem addemployee = new JMenuItem("ADD EMPLOYEE");
        admin.add(addemployee);

        addemployee.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    setVisible(false);
                    new AddEmployee();

                }catch(Exception e){}
            }
        });


        JMenuItem addrooms = new JMenuItem("ADD ROOMS");
        admin.add(addrooms);

        JMenuItem adddriver = new JMenuItem("ADD DRIVER");
        admin.add(adddriver);







        setVisible(true);
    }



    public static void main(String[] args){
        new Dashboard();
    }
}

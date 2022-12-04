package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class AddCustomer extends JFrame implements ActionListener {
    JComboBox comboid;

    JTextField tfnumber, tfname, tfcountry, tfdeposit;
    JRadioButton rmale, rfemale, rothers;
    Choice croom;


    JButton add, back;


    AddCustomer(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);


        JLabel text = new JLabel("NEW CUSTOMER FORM");
        text.setBounds(100, 20, 300, 30);
        text.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(text);

        JLabel lblid = new JLabel("ID");
        lblid.setBounds(35, 80, 100, 20);
        lblid.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lblid);

        String options[] = {"Aadhar Card", "Driving License", "Passport", "Voter's ID", "Ration card"};
        comboid = new JComboBox(options);
        comboid.setBounds(205, 80, 150, 25);
        comboid.setBackground(Color.WHITE);
        add(comboid);

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(35, 120, 100, 20);
        lblnumber.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lblnumber);

        tfnumber = new JTextField();
        tfnumber.setBounds(205, 120, 150, 25);
        add(tfnumber);


        JLabel lblname = new JLabel("Name");
        lblname.setBounds(35, 160, 100, 20);
        lblname.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(205, 160, 150, 25);
        add(tfname);

        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(35, 200, 100, 20);
        lblgender.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lblgender);

        rmale = new JRadioButton("Male");
        rmale.setBackground(Color.WHITE);
        rmale.setBounds(205, 200, 60, 25);
        add(rmale);

        rfemale = new JRadioButton("Female");
        rfemale.setBackground(Color.WHITE);
        rfemale.setBounds(270, 200, 100, 25);
        add(rfemale);

        rothers = new JRadioButton("Others");
        rothers.setBackground(Color.WHITE);
        rothers.setBounds(370, 200, 140, 30);
        add(rothers);

        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(35, 240, 100, 20);
        lblcountry.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lblcountry);

        tfcountry = new JTextField();
        tfcountry.setBounds(205, 240, 150, 25);
        add(tfcountry);

        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(35, 280, 170, 20);
        lblroom.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lblroom);

        croom = new Choice();
        try{
            Conn connection = new Conn();
            String query = "Select * from room where availability= 'Available'";
            ResultSet rs = connection.statement.executeQuery(query);
            while(rs.next()){
                croom.add(rs.getString("roomnumber"));

            }

        }catch (Exception e){
            e.printStackTrace();
        }
        croom.setBounds(205,280,150,25);
        add(croom);

        JLabel lbldeposit = new JLabel("Deposit");
        lbldeposit.setBounds(35, 320, 100, 20);
        lbldeposit.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lbldeposit);

        tfdeposit = new JTextField();
        tfdeposit.setBounds(205, 320, 150, 25);
        add(tfdeposit);

        add = new JButton("Add");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.addActionListener(this);
        add.setBounds(50,410,120,30);
        add(add);

        back = new JButton("Back");
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        back.setBounds(205,410,120,30);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2 = i1.getImage().getScaledInstance(300,400,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,300,400);
        add(image);





        setBounds(350,200,800,550);
        setVisible(true);
    }


    public static void main (String[] args){
        new AddCustomer();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==add) {
            String id = (String) comboid.getSelectedItem();
            String number = tfnumber.getText();
            String name = tfname.getText();
            String gender = null;
            if (rmale.isSelected()) {
                gender = "Male";
            } else if (rfemale.isSelected()) {
                gender = "Female";
            }else{
                gender="Others";
            }
            String country = tfcountry.getText();
            String room = croom.getSelectedItem();
            String deposit = tfdeposit.getText();

            try{
                String query = "insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+deposit+"')";
                String query2 = "update room set availability= 'Occupied'where roomnumber ='"+room+"' ";
                Conn connection = new Conn();
                connection.statement.executeUpdate(query);
                connection.statement.executeUpdate(query2);

                JOptionPane.showMessageDialog(null,"New Customer Added Successfully");

                setVisible(false);
                new Reception();

            }catch(Exception e){
                e.printStackTrace();
            }


        }else if (ae.getSource()==back){
            setVisible(false);
            new Reception();
        }
    }

}


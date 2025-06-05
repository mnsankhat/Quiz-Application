package quiz.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Certificate  extends JFrame  implements ActionListener {


    static String name;
    JButton DOW;
    Certificate( String name){
        this.name = name;
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);





        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icon/cer.jpg"));
//        Image i = i1.getImage().getScaledInstance(200,200,Image.);
//        ImageIcon i2 = new ImageIcon(i);
        JLabel image = new JLabel(i1);
        image.setBounds(30,50,300,200);
        add(image);


        JLabel heading = new JLabel("CERTIFICATE");
        heading.setBounds(350,100,700,50);
        heading.setFont(new Font("Viner Read ITC",Font.BOLD,55));
        heading.setForeground(new Color(12, 12, 12));
        add(heading);



        JLabel dis = new JLabel();
        dis.setBounds(70,150,700,350);
        dis.setFont(new Font("Tahoma",Font.BOLD,28));
        dis.setForeground(new Color(19, 18, 18));
        dis.setText(
                "<html>"+"Join "+"<b>"+name+"<b>"+" Quiz challenge! test your knowledge and win a certificate of achievement." +
                        "show off your skills and earn recognition_ are you ready to tack the challenge?"

                        +"<html>"
        );
        add(dis);


        DOW = new JButton("DOWNLOAD");
        DOW.setBounds(450,500,150,30);
        DOW.setBackground(new Color(22,99,54));
        DOW.setForeground(Color.WHITE);
        DOW.addActionListener(this);
        add(DOW);

        ImageIcon i2 =new ImageIcon(ClassLoader.getSystemResource("icon/back.jpg"));
        Image i = i2.getImage().getScaledInstance(800,650,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i);
        JLabel images = new JLabel(i2);
        images.setBounds(0,0,800,650);
        add(images);



        setSize(800,650);
        setLocation(250,50);
        setBackground(Color.WHITE);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==DOW){
            System.exit(50);
        }
    }

    public static void main(String[] args) {
        new Certificate(name);
    }
}

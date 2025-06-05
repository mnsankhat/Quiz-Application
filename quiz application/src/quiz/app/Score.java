package quiz.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

public class Score extends JFrame implements ActionListener {

    int score ;
    String name;
    JButton cer;
    Score(String name,int Score){
        this.score = Score;
        this.name = name;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/score.jpg"));
        Image i = i1.getImage().getScaledInstance(200,150,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i);
        JLabel image = new JLabel(i2);
        image.setBounds(60,200,200,150);
        add(image);


        JLabel headingname = new JLabel("Thank you"+ name + "for playing QUIZ test");
        headingname.setBounds(100,80,700,30);
        headingname.setFont( new Font("Tahoma",Font.BOLD,26));

        add(headingname);

        JLabel Scores = new JLabel("your score is "+ score);
        Scores.setBounds(350,200,300,30);
        Scores.setFont( new Font("Tahoma",Font.BOLD,26));

        add(Scores);

        JButton exit = new JButton("EXIT");
        exit.setBounds(380,270,120,30);
        exit.setBackground(new Color(22,99,54));
        exit.setForeground(Color.WHITE);
        add(exit);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                setVisible(false);
                new Login();
            }
        });

         cer = new JButton("Certificate");
        cer.setBounds(520,270,120,30);
        cer.setBackground(new Color(22,99,54));
        cer.setForeground(Color.WHITE);
        cer.addActionListener(this);
        add(cer);


        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("icon/back.jpg"));
        Image i4 = i3.getImage().getScaledInstance(750,550,Image.SCALE_DEFAULT);
        ImageIcon i5 = new ImageIcon(i4);
        JLabel image2 = new JLabel(i5);
        image2.setBounds(0,0,750,550);
        add(image2);






        setSize(750,550);
        setLocation(400,150);
        setUndecorated(true);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==cer){
            setVisible(false);
            new Certificate(name);
        }
    }

    public static void main(String[] args) {
        new Score("user",0 );
    }
}

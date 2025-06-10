import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Firstman implements ActionListener {

    JTextField text;
    JPanel a1;
   static Box vertical =Box.createVerticalBox();
    static JFrame frame = new JFrame();
     static DataOutputStream dout;
   Firstman(){
      frame.setLayout(null);
       JPanel p1 = new JPanel();
       p1.setBackground(new Color(7,94,87));
       p1.setBounds(0,0,480,70);
       p1.setLayout(null);
      frame.add(p1);

       ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/arrow.png"));
       Image i2= i1.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel back = new JLabel(i3);
       back.setBounds(5,20,25,25);
      p1.add(back);

      back.addMouseListener(new MouseAdapter() {
          @Override
          public void mouseClicked(MouseEvent e) {
              System.exit(0);

          }
      });

       ImageIcon i4= new ImageIcon(ClassLoader.getSystemResource("icons/motu.jpeg"));
       Image i5= i4.getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT);
       ImageIcon i6=new ImageIcon(i5);
       JLabel profile = new JLabel(i6);
       profile.setBounds(35,9,50,50);
       p1.add(profile);



       ImageIcon i7= new ImageIcon(ClassLoader.getSystemResource("icons/videocall.png"));
       Image i8= i7.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT);
       ImageIcon i9=new ImageIcon(i8);
       JLabel video = new JLabel(i9);
       video.setBounds(300,20,30,30);
       p1.add(video);

       ImageIcon i10= new ImageIcon(ClassLoader.getSystemResource("icons/call.png"));
       Image i11= i10.getImage().getScaledInstance(35,30,Image.SCALE_DEFAULT);
       ImageIcon i12=new ImageIcon(i11);
       JLabel call = new JLabel(i12);
       call.setBounds(360,9,50,50);
       p1.add(call);

       ImageIcon i13= new ImageIcon(ClassLoader.getSystemResource("icons/threedots.png"));
       Image i14= i13.getImage().getScaledInstance(10,25,Image.SCALE_DEFAULT);
       ImageIcon i15=new ImageIcon(i14);
       JLabel morevert = new JLabel(i15);
       morevert.setBounds(420,15,50,50);
       p1.add(morevert);

       JLabel name = new JLabel("Motu");
       name.setBounds(110,15,100,25);
       name.setForeground(Color.white);
       name.setFont(new Font("SAN_SERIF",Font.BOLD,18));
       p1.add(name);

       JLabel status = new JLabel("Active now...");
       status.setBounds(110,35,100,25);
       status.setForeground(Color.white);
       status.setFont(new Font("SAN_SERIF",Font.BOLD,14));
       p1.add(status);

        a1 = new JPanel();
       a1.setBounds(5,75,475,570);
      frame.add(a1);

        text = new JTextField();
       text.setBounds(5,640,310,40);
       text.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
       frame.add(text);

       JButton send = new JButton("Send");
       send.setBounds(320,640,123,40);
       send.setBackground(new Color(7,94,84));
       send.setForeground(Color.white);
       send.addActionListener(this);
       send.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
       frame.add(send);

       frame.setSize(480,700);
       frame.setLocation(200,00);
       frame.setUndecorated(true);
      frame.getContentPane().setBackground(Color.white);
       frame.setVisible(true);
   }



    @Override
    public void actionPerformed(ActionEvent e) {
        try
            {

                String out = text.getText();

                JPanel p2 = formatLabel(out);

                a1.setLayout(new BorderLayout());
                JPanel right = new JPanel(new BorderLayout());
                right.add(p2, BorderLayout.LINE_END);
                vertical.add(right);
                vertical.add(Box.createVerticalStrut(15));

                a1.add(vertical, BorderLayout.PAGE_START);
                dout.writeUTF(out);

                text.setText("");
                frame.repaint();
                frame.invalidate();
                frame.validate();

            } catch (Exception ex) {
           ex.printStackTrace();

        }


    }
    public static JPanel formatLabel(String out){
       JPanel panel = new JPanel();
       panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
       JLabel output = new JLabel("<html><p style =\" width:150px\">"+out+"</p></html>");
       output.setFont(new Font("TAHOMA",Font.PLAIN,16));
       output.setBackground(new Color(37,211,102));
       output.setOpaque(true);
       output.setBorder( new EmptyBorder(15,15,15,20));

       panel.add(output);
        Calendar cal = Calendar.getInstance() ;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:MM");

        JLabel time = new JLabel();
        time.setText(sdf.format(cal.getTime()));
        panel.add(time);

       return panel;
    }

    public static void main(String[] args) {
        new Firstman();

        try {

            ServerSocket skd = new ServerSocket(6001);
            while (true){
                 Socket s=skd.accept();
                DataInputStream din = new DataInputStream(s.getInputStream());
                 dout = new DataOutputStream(s.getOutputStream());

                while (true){
                    String msg = din.readUTF();
                    JPanel panel = formatLabel(msg);
                    JPanel left = new JPanel( new BorderLayout());
                    left.add( panel,BorderLayout.LINE_START);
                    vertical.add(left);
                    frame.validate();

                }

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

import java.awt.BorderLayout;import java.awt.Canvas;import java.awt.Color;import java.awt.Dimension;import java.awt.Graphics;
import javax.swing.JFrame;import java.awt.image.BufferStrategy;import java.awt.image.BufferedImage;import java.awt.image.DataBufferInt;
import java.io.OutputStreamWriter;import java.io.PrintWriter;import java.net.Socket;import java.io.BufferedReader;
import java.io.InputStreamReader;import java.net.ServerSocket;import java.net.ConnectException;import java.net.BindException;
import java.io.IOException;import javax.swing.*;import java.awt.*;import java.awt.event.*;class Games2 extends Canvas implements Runnable{
private int tickCount=0;private BufferedImage image=new BufferedImage(160,120,BufferedImage.TYPE_INT_RGB);
private int[] pixels=((DataBufferInt) image.getRaster().getDataBuffer()).getData();public Games2(){setMinimumSize(new Dimension(480,360));
setMaximumSize(new Dimension(480,360));setPreferredSize(new Dimension(480,360));}public void run(){long lastTime=System.nanoTime();
double nsPerTick=1000000000D/60D;//change in nspertick speeds the animation
double delta=0;while(true){long now=System.nanoTime();//now not deleted as nextline becomes long
delta+=(now-lastTime)/nsPerTick;lastTime=now;while(delta>=1){tick();delta-=1;}render();}}public void tick(){tickCount++;
for(int i=0;i<pixels.length;i++){pixels[i]=i+tickCount;}}public void render(){BufferStrategy bs=getBufferStrategy();
if(bs==null){createBufferStrategy(3);return;}Graphics g=bs.getDrawGraphics();g.drawImage(image,0,0,getWidth(),getHeight(),null);g.dispose();
bs.show();}}public class Games extends JFrame implements ActionListener{public JButton all0,all1,all2,all3,all4;
public JTextField textField0,textField1,textField2,textField3;public JLabel lblNewLabel0,lblNewLabel1,lblNewLabel2,lblNewLabel3;
public JLabel title;public Games(){setBounds(100, 100, 480, 360);setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);setLayout(null);//frame.pack();
setResizable(false);setUndecorated(false);setLocationRelativeTo(null);all0 = new JButton("WEATHER");all0.setBounds(10, 30,210, 30);
all0.setFont(new Font("eras bold itc", Font.BOLD, 30)); all0.setBorderPainted(false);all0.setFocusPainted(false);all0.addActionListener(this);  
add(all0);all1 = new JButton("GALLERY");all1.setBounds(230, 30,191, 30);all1.setFont(new Font("eras bold itc", Font.BOLD, 30)); 
all1.setBorderPainted(false);all1.setFocusPainted(false);all1.addActionListener(this);  add(all1);all2 = new JButton("AIBOT");
all2.setBounds(10, 70,144, 30);all2.setFont(new Font("eras bold itc", Font.BOLD, 30)); all2.setBorderPainted(false);all2.setFocusPainted(false);
all2.addActionListener(this);  add(all2);all3 = new JButton("MESSENGER");all3.setBounds(164, 70,243, 30);
all3.setFont(new Font("eras bold itc", Font.BOLD, 30)); all3.setBorderPainted(false);all3.setFocusPainted(false);all3.addActionListener(this);  
add(all3);all4 = new JButton("ATTENDANCE");all4.setBounds(10, 110,273, 30);all4.setFont(new Font("eras bold itc", Font.BOLD, 30)); 
all4.setBorderPainted(false);all4.setFocusPainted(false);all4.addActionListener(this);  add(all4);lblNewLabel0 = new JLabel();
lblNewLabel0.setText("WHY=MADE LIKE WHATS");lblNewLabel0.setFont(new Font("eras bold itc", Font.BOLD, 30));
lblNewLabel0.setBounds(10, 150, 440, 30);add(lblNewLabel0);lblNewLabel1 = new JLabel();lblNewLabel1.setText("APP FOR HACKATHONS");
lblNewLabel1.setFont(new Font("eras bold itc", Font.BOLD, 30));lblNewLabel1.setBounds(10, 190, 440, 30);add(lblNewLabel1);
lblNewLabel2 = new JLabel();lblNewLabel2.setText("HOW=USE BASIC FUNDA");lblNewLabel2.setFont(new Font("eras bold itc", Font.BOLD, 30));
lblNewLabel2.setBounds(10, 230, 440, 30);add(lblNewLabel2);lblNewLabel3 = new JLabel();lblNewLabel3.setText("MENTAL OF JQUERY INJS");
lblNewLabel3.setFont(new Font("eras bold itc", Font.BOLD, 30));lblNewLabel3.setBounds(10, 270, 440, 30);add(lblNewLabel3);
JPanel back=new JPanel();back.setBounds(0,0, 480, 360);Games2 animate=new Games2();back.add(animate);add(back);setVisible(true);
new Thread(animate).start();}public void actionPerformed(ActionEvent e){if(e.getSource() == all3) {lblNewLabel0.setText("WHY=MADE AFTER GATH");
lblNewLabel1.setText("ERING IDEA FROM EXPO");lblNewLabel2.setText("HOW=USE MYVIDEOS SH");lblNewLabel3.setText("ARED ONTHE YOUTUBE");}
else if(e.getSource() == all2) {lblNewLabel0.setText("WHY=MADE FOR HAPPY");lblNewLabel1.setText("BHAAYI AUTO CHATBOT");
lblNewLabel2.setText("HOW=USEPYTHON CHAT");lblNewLabel3.setText("BOT YOUTUBE WEBINAR");}else if(e.getSource() == all4) {
lblNewLabel0.setText("WHY=MADE FOR PROJE");lblNewLabel1.setText("CT SAIDBY KANIKAMAM");lblNewLabel2.setText("HOW=USE PHONE GALLE");
lblNewLabel3.setText("RY FOR SHOOTED VIDEO");}else if(e.getSource() == all0) {lblNewLabel0.setText("WHY=MADE LIKE WHATS");
lblNewLabel1.setText("APP FOR HACKATHONS");lblNewLabel2.setText("HOW=USE BASIC FUNDA");lblNewLabel3.setText("MENTAL OF JQUERY INJS");}
else if(e.getSource() == all1) {lblNewLabel0.setText("WHY=MADE FOR HAND");lblNewLabel1.setText("MADE COMIC MAKING");
lblNewLabel2.setText("HOW=USE PROPS NAVIG");lblNewLabel3.setText("ATION GETPARAM FORIT");}}public static void main(String[] args){new Games();}}
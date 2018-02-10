import java.awt.*;
import java.awt.event.*;
import java.applet.*;

class mainmenu extends Frame implements ActionListener
{
private Closer Handler;
Label l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
Font f;
Button next;
public mainmenu()
{
super("Project");
}
public void init()
{
}
public void setup()
{
//Handler=new Closer();
//addWindowListener(Handler); 
setLayout(null);
resize(1700,2000);
next= new Button("Next");
add(next);
next.addActionListener(this);

l1=new Label ("WELCOME");
l2=new Label ("TO");
l3=new Label ("DEPARTMENT");
l4=new Label ("NOTICE &"); 
l5=new Label ("MANAGEMENT SYSTEM");
l6=new Label ("SUBMITTED BY:");
l7=new Label ("Paras bhardwaj");
l8=new Label ("R. NO. 6310057");
l11=new Label("CSE-2,7th semester");
l9=new Label ("Guru Nanak Institute");
l10=new Label ("Mullana");
l1.setBounds(100,100,150,50);
l2.setBounds(200,150,100,50);
l3.setBounds(300,200,250,50);
l4.setBounds(400,250,300,50);
l5.setBounds(500,300,300,50);
l6.setBounds(25,400,400,50);
l7.setBounds(25,440,400,50);
l8.setBounds(25,480,400,50);
l11.setBounds(25,520,400,50);
l9.setBounds(25,560,500,50);
l10.setBounds(25,600,500,50);

next.setBounds(600,400,100,50);
f=new Font("Comic Sans MS",Font.BOLD,21);
l1.setFont(f);
f=new Font("Comic Sans MS",Font.BOLD,21);
l2.setFont(f);
f=new Font("Comic Sans MS",Font.BOLD,21);
l3.setFont(f);
f=new Font("Comic Sans MS",Font.BOLD,21);
l4.setFont(f);
f=new Font("Comic Sans MS",Font.BOLD,21);
l5.setFont(f); 
f=new Font("Comic Sans MS",Font.ITALIC,14);
l6.setFont(f);
l7.setFont(f); 
l8.setFont(f); 
l9.setFont(f); 
l10.setFont(f); 
 
l1.setForeground(Color.black);
l2.setForeground(Color.black);
l3.setForeground(Color.black);
l4.setForeground(Color.black);
l5.setForeground(Color.black);
l6.setForeground(Color.black);
l7.setForeground(Color.black);
l8.setForeground(Color.black);
l9.setForeground(Color.black);
l10.setForeground(Color.black);
l11.setForeground(Color.black);

add(l1);
add(l2);
add(l3);
add(l4);
add(l5);
add(l6);
add(l7);
add(l8);
add(l9);
add(l10);
add(l11);
show();
}
public void actionPerformed(ActionEvent ae)
{
String str=ae.getActionCommand();
if(str.equals("Next"))
{
setVisible(false);
Password x=new Password();


}
repaint();
}
public void paint(Graphics g)
{

Color c1=new Color(111,111,111);
g.setColor(c1);
setBackground(c1);
l1.setBackground(c1);
l2.setBackground(c1);
l3.setBackground(c1);
l4.setBackground(Color.red);
l5.setBackground(c1);
l6.setBackground(c1);
l7.setBackground(c1);
l8.setBackground(c1);
l9.setBackground(c1);
l10.setBackground(c1);
l11.setBackground(c1);

Image pic=Toolkit.getDefaultToolkit().getImage("1.jpg");
if(pic!=null)
g.drawImage(pic,800,300,this);
}
public static void main(String args[])
{
mainmenu A=new mainmenu();
A.setup();
}
}
class Closer extends WindowAdapter
{
public void windowClosing(WindowEvent we)
{
System.exit(0);
}
} 
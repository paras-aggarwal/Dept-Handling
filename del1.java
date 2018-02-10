import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.HttpURLConnection;  

import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.sql.*;
import java.io.*;
import java.util.Calendar;
import javax.swing.*;
public class del1 extends Frame implements ActionListener
{
String s1,s2,s3,s4,s5,s6,s9,s7,s8;
int f=0;
int i;
private Closer Handler;
Button Submit,Reset,ba,sh;
Label l1;
TextField t1;
public del1()
{
super("DELETING OF DATA");
}
public void setup()
{
//Handler=new Closer();
//addWindowListener(Handler); 

Font f1=new Font ("TimesRoman",Font.BOLD,24);
setFont (f1);
l1=new Label(" Notice No :");
t1=new TextField(50);
l1.setBounds(100,100,150,50);
t1.setBounds(300,100,100,40);
add(t1);
add(l1);
resize(1500,800);
setLayout(null);
Color c1=new Color(184,190,192);
setBackground(c1);
Color c2=new Color(25,22,178);
setForeground(c2);
Submit=new Button("DELETE");
Reset=new Button("Show");
ba=new Button("Back");
add(ba);
add(Submit);
ba.setBounds(700,650,250,30);

add(Reset);
Submit.setBounds(100,650,250,30);
Reset.setBounds(400,650,250,30);
Submit.addActionListener(this);
ba.addActionListener(this);
Submit.setVisible(false);
Reset.addActionListener(this);
show();
}
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==ba)

{
setVisible(false);
return;
}

if(ae.getSource()==Submit)

{
////////
final String fileName = "C://java//dept//report.mdb";
//final String fileName = "it.accdb";
Connection con = null;

try {
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
String url = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+fileName;
 con = DriverManager.getConnection(url,"","");
s9=t1.getText();
Statement st=con.createStatement();
st.executeUpdate("Delete from table1 where notice_no='"+s9+"'");
s1="";
s2="";
s3="";
s4="";
s5="";
s6="";
s7="";
s8="";
s9="";
t1.setText("");
repaint();
}

catch(Exception e)
{
System.out.println(e+"1");
}
}

if(ae.getSource()==Reset)

{
////////
s1="";
s2="";
s3="";
s4="";
s5="";
s6="";
s7="";
s8="";
s9="";
s2=t1.getText();
if(s2.length()<3)
{
JOptionPane.showMessageDialog(null,"Enter Notice No.");
return;
}

final String fileName = "C://java//dept//report.mdb";
//final String fileName = "it.accdb";
Connection con = null;

try {
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
String url = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+fileName;
 con = DriverManager.getConnection(url,"","");
s9=t1.getText();
Statement st=con.createStatement();

ResultSet rs=st.executeQuery("select * from table1 where notice_no='"+s9+"'");
i=0;
while(rs.next())
{
s1=rs.getString(1);
s2=rs.getString(2);
s3=rs.getString(3);
s4=rs.getString(4);
s5=rs.getString(5);
s6=rs.getString(6);

i=1;
}
if(i==0)
{
Submit.setVisible(false);
repaint();
JOptionPane.showMessageDialog(null,"No Data Exsits");
t1.setText("");
return;
}
Submit.setVisible(true);
repaint();
}

catch(Exception e)
{
System.out.println(e+"1");
}
}

}
public void paint(Graphics g)
{
if(i==1)
{
g.drawString("Notice No               : "+s1,200,200);
g.drawString("Subject                    :"+s2,200,250);
g.drawString("Notice Date             :"+s3,200,300);
g.drawString("Notice For               : "+s4,200,350);
g.drawString("Notice                     :"+s5,200,400);
g.drawString("Issued By                 :"+s6,200,450);
}
}
public static void main(String args[])
{
del1 r1=new del1();
r1.setup();
}
}


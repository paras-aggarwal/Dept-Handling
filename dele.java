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
public class dele extends Frame implements ActionListener,ItemListener
{
String s1,s2,s3,s4,s5,s6,s9,s7,s8;
int f=0;
private Closer Handler;
Button Submit,Reset,ba;
Label l1;
Choice dept;
public dele()
{
super("DELETING OF DATA");
}
public void setup()
{
//Handler=new Closer();
//addWindowListener(Handler); 

Font f1=new Font ("TimesRoman",Font.BOLD,24);
setFont (f1);
l1=new Label("Choose Emailid :");
resize(1500,800);
setLayout(null);
Color c1=new Color(184,190,192);
setBackground(c1);
Color c2=new Color(25,22,178);
setForeground(c2);
final String fileName = "C://java//dept//master.mdb";
//final String fileName = "it.accdb";
Connection con = null;

dept=new Choice();

try {
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
String url = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+fileName;
 con = DriverManager.getConnection(url,"","");

Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select emailid from table1");
int i=0;
while(rs.next())
{
f=1;
dept.add(rs.getString(1));
i=1;
}
if(i==0)
{
JOptionPane.showMessageDialog(null,"No Data Exsits");
return;

}
rs.close();
}
catch(Exception e)
{
System.out.println(e+"1");
}
add(dept);
add(l1);
l1.setBounds(100,100,400,50);
dept.setBounds(600,100,300,50);
Submit=new Button("DELETE");
Reset=new Button("Reset");
ba=new Button("Back");
add(ba);
add(Submit);
ba.setBounds(700,650,250,30);

//add(Reset);
Submit.setBounds(100,650,250,30);
//Reset.setBounds(400,650,250,30);
Submit.addActionListener(this);
ba.addActionListener(this);

Reset.addActionListener(this);
dept.addItemListener(this);
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
s9=dept.getSelectedItem();
////////
final String fileName = "C://java//dept//master.mdb";
//final String fileName = "it.accdb";
Connection con = null;

try {
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
String url = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+fileName;
 con = DriverManager.getConnection(url,"","");

Statement st=con.createStatement();
st.executeUpdate("Delete from table1 where emailid='"+s9+"'");
s1="";
s2="";
s3="";
s4="";
s5="";
s6="";
s7="";
s8="";
s9="";
repaint();
}

catch(Exception e)
{
System.out.println(e+"1");
}
}
}
public void itemStateChanged(ItemEvent ie)
{

s1="";
s2="";
s3="";
s4="";
s5="";
s6="";
s7="";
s8="";
s9="";
f=1;
s9=dept.getSelectedItem();
////////
final String fileName = "C://java//dept//master.mdb";
//final String fileName = "it.accdb";
Connection con = null;

try {
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
String url = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+fileName;
 con = DriverManager.getConnection(url,"","");

Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select * from table1 where emailid='"+s9+"'");
int i=0;
while(rs.next())
{
s2=rs.getString(1);
s7=rs.getString(2);
s1=rs.getString(3);
s4=rs.getString(4);
//s5=rs.getString(5);
//s6=rs.getString(6);
s3=rs.getString(5);
s8=rs.getString(6);
s9=rs.getString(7);

i=1;
}
if(i==0)
{
JOptionPane.showMessageDialog(null,"No Data Exsits");
return;

}
rs.close();
}
catch(Exception e)
{
System.out.println(e+"1");
}

/////
repaint();
}
public void paint(Graphics g)
{
if((f==1)&&(s1.length()>0))
{

g.drawString("Name of Employee : "+s2,200,200);
g.drawString("Phone No                :"+s1,200,250);
g.drawString("Sex                          :"+s7,200,300);
g.drawString("Department              : "+s9,200,350);
g.drawString("Age Group               :"+s8,200,400);
g.drawString("Password                 :"+s3,200,450);
g.drawString("Emailid                   : "+s4,200,500);
//g.drawString("Current Date           : "+s5,200,550);
//g.drawString("First Checkup Date : "+s6,200,600);
}


}
public static void main(String args[])
{
dele r1=new dele();
r1.setup();
}
}


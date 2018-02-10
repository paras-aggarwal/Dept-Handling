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
import java.util.Calendar;
public class user extends Frame implements ActionListener,ItemListener
{
//private Closer Handler;
int bt,i;
Button ba,v1,v2,v3;
String s1,s2,s3,s4,s5,s6,s9,s7,s8,na;
Choice c1,c2,c3;
public user(String ss, String sss, String ssss)
{
super("Notices");
s1=ss;
s2=sss;
s3=ssss;
bt=0;
}
public void setup()
{
Font f1=new Font ("TimesRoman",Font.BOLD,24);
setFont (f1);
resize(1500,800);
setLayout(null);
Color cc1=new Color(184,190,192);
setBackground(cc1);

Color cc2=new Color(25,22,178);
setForeground(cc2);
ba=new Button("Back");
v1=new Button("Date-wise");
v2=new Button("Subject-wise");
v3=new Button("Notice No-wise");

add(ba);
add(v1);
add(v2);
add(v3);
v1.setBounds(100,150,150,30);
v2.setBounds(300,150,150,30);
v3.setBounds(500,150,180,30);
ba.setBounds(700,150,150,30);

 v1.addActionListener(this);
 v2.addActionListener(this);
v3.addActionListener(this);
ba.addActionListener(this);
c1=new Choice();
c2=new Choice();
c3=new Choice();
c1.addItemListener(this);
c2.addItemListener(this);
c3.addItemListener(this);
c1.setBounds(100,250,150,30);
c2.setBounds(300,250,150,30);
c3.setBounds(500,250,180,30);
add(c1);
add(c2);
add(c3);
c1.setVisible(false);
c2.setVisible(false);
c3.setVisible(false);
final String fileName = "C://java//dept//REPORT.mdb";
Connection con = null;

try {
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
String url = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+fileName;
 con = DriverManager.getConnection(url,"","");

Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select * from table1 where for_dept='"+s3+"' or for_dept='ALL'");
int i=0;
while(rs.next())
{
c3.add(rs.getString(1));
c2.add(rs.getString(2));
//c1.add(rs.getString(3));

i=1;
}
ResultSet rss=st.executeQuery("select distinct notice_date from table1 where for_dept='"+s3+"' or for_dept='ALL'");

while(rss.next())
{
c1.add(rss.getString(1));
//c2.add(rs.getString(2));
//c1.add(rs.getString(3));

//i=1;
}

c1.setVisible(false);
c2.setVisible(false);
c3.setVisible(false);

if(i==0)
{
JOptionPane.showMessageDialog(null,"No Notice exits Exsits");
return;

}
rs.close();
rss.close();
}
catch(Exception e)
{
System.out.println(e+"1");
}

show();
}
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==ba)

{
setVisible(false);

}

/////////////////////////////
if(ae.getSource()==v1)

{
c1.setVisible(true);
c2.setVisible(false);
c3.setVisible(false);
bt=1;
}
if(ae.getSource()==v1)

{
c1.setVisible(true);
c2.setVisible(false);
c3.setVisible(false);
bt=1;
}

if(ae.getSource()==v2)

{
c2.setVisible(true);
c1.setVisible(false);
c3.setVisible(false);
bt=2;
}
if(ae.getSource()==v3)

{
c3.setVisible(true);
c2.setVisible(false);
c1.setVisible(false);
bt=3;
}

////////////////////////////
}
public void itemStateChanged(ItemEvent ie)
{
if(bt==1)
na=c1.getSelectedItem();
if(bt==2)
na=c2.getSelectedItem();
if(bt==3)
na=c3.getSelectedItem();
final String fileName = "C://java//dept//REPORT.mdb";
Connection con = null;
if(bt==1)
{
c1.setVisible(false);
try {
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
String url = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+fileName;
 con = DriverManager.getConnection(url,"","");

Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select * from table1 where notice_date ='"+na+"'");


i=0;
while(rs.next())
{
s1=rs.getString(1);
s2=rs.getString(2);
s3=rs.getString(3);
s4=rs.getString(4);
s5=rs.getString(5);
i=1;
repaint();
JOptionPane.showMessageDialog(null,"Press any key");

}
if(i==0)
{
JOptionPane.showMessageDialog(null,"No Data Exsits");
return;

}
rs.close();
i=0;
repaint();
}
catch(Exception e)
{
//System.out.println(e+"1");
}
}
/////
if(bt==2)
{
c2.setVisible(false);
try {
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
String url = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+fileName;
 con = DriverManager.getConnection(url,"","");

Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select * from table1 where subject ='"+na+"'");


i=0;
while(rs.next())
{
s1=rs.getString(1);
s2=rs.getString(2);
s3=rs.getString(3);
s4=rs.getString(4);
s5=rs.getString(5);
i=1;
repaint();
JOptionPane.showMessageDialog(null,"Press any key");

}
if(i==0)
{
JOptionPane.showMessageDialog(null,"No Data Exsits");
return;

}
rs.close();
i=0;
repaint();
}
catch(Exception e)
{
//System.out.println(e+"1");
}
}
if(bt==3)
{
c3.setVisible(false);
try {
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
String url = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+fileName;
 con = DriverManager.getConnection(url,"","");

Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select * from table1 where notice_no ='"+na+"'");


i=0;
while(rs.next())
{
s1=rs.getString(1);
s2=rs.getString(2);
s3=rs.getString(3);
s4=rs.getString(4);
s5=rs.getString(5);
i=1;
repaint();
JOptionPane.showMessageDialog(null,"Press any key");

}
if(i==0)
{
JOptionPane.showMessageDialog(null,"No Data Exsits");
return;

}
rs.close();
i=0;
repaint();
}
catch(Exception e)
{
//System.out.println(e+"1");
}
}

}
public void paint(Graphics g)
{
if((i==1)&&(s1.length()>0))
{

g.drawString("Notice No   : "+s1,200,300);
g.drawString("Subject        :"+s2,200,350);
g.drawString("Notice Date :"+s3,200,400);
g.drawString("Notice For   : "+s4,200,450);
g.drawString("Notice          :"+s5,200,500);
}
else
{
//g.fillRect(200,300,400,400);
}
}
}
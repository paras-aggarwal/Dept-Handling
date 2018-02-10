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
public class indx extends Frame implements ActionListener,ItemListener
{
//private Closer Handler;

Button Submit,Reset,vi,ba,da;
String s1,s2,s3,s4,s5,s6,s9,s7,s8,na;
Choice dept;
TextField t1,t2,t3,t5,t6;
TextArea t4;
Label l1,l2,l3,l4,l5,l6,l7;
String k[] = {"Jan", "Feb", "Mar", "Apr","May","Jun","July","Aug","Sep","Oct","Nov","Dec"};
Calendar kp=Calendar.getInstance();

public indx()
{
super("INDEX CHART");
}
public void setup()
{

Font f1=new Font ("TimesRoman",Font.BOLD,24);
setFont (f1);
l6=new Label("Notice To ");
resize(1500,800);
setLayout(null);
Color c1=new Color(184,190,192);
setBackground(c1);

Color c2=new Color(25,22,178);
setForeground(c2);
dept=new Choice();
dept.add("All");
dept.add("Sale");
dept.add("Marketing");
dept.add("Finance");
dept.add("Production");
dept.add("Personnel");
dept.add("R & D");

add(dept);
add(l6);
l6.setBounds(200,450,250,50);
dept.setBounds(500,450,300,50);
Submit=new Button("Save");
Reset=new Button("Reset");
vi=new Button("View");
ba=new Button("Back");
da=new Button("Delete");
add(Submit);
add(Reset);
add(vi);
add(ba);
add(da);
Submit.setBounds(100,650,150,30);
Reset.setBounds(250,650,150,30);
vi.setBounds(400,650,150,30);
da.setBounds(550,650,150,30);
ba.setBounds(700,650,150,30);

Submit.addActionListener(this);
Reset.addActionListener(this);
vi.addActionListener(this);
ba.addActionListener(this);
da.addActionListener(this);

dept.addItemListener(this);
l1=new Label("");
l1.setText("Notice No : ");
l1.setBounds(200,200,250,50);
add(l1);
l2=new Label("Subject ");
l2.setBounds(200,250,250,50);
l3=new Label("Date ");
l3.setBounds(200,300,250,50);
l4=new Label("Notice Description ");
l4.setBounds(200,350,250,50);
l5=new Label("Signed By ");
l5.setBounds(200,500,250,50);
add(l2);
add(l3);
add(l4);
add(l5);
t1=new TextField(50);
t2=new TextField(50);
t3=new TextField(50);
t4=new TextArea();
t5=new TextField(50);

add(t1);
add(t2);
add(t3);
add(t4);
add(t5);
t1.setBounds(500,200,200,40);
t2.setBounds(500,250,200,40);
t3.setBounds(500,300,200,40);
t4.setBounds(500,350,200,100);
t5.setBounds(500,500,200,40);
add(l2);
String p0,p3;
int p2,p11;
p0=k[kp.get(Calendar.MONTH)];
p11= kp.get(Calendar.DATE);
p2=kp.get(Calendar.YEAR);
p3=p0+"/"+p11+"/"+p2;
t3.setText(p3);
t3.setEditable(false);
show();
}
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==Submit)

{
String s1,s2,s3,s4,s5,s6,s9,s7,s8,s99,s88,s77;
s1=t1.getText();
s3=t3.getText();
int tt=0;
s9=dept.getSelectedItem();
if(s1.length()<3)
{
JOptionPane.showMessageDialog(null,"Please Enter Notice No");
return;
}

s2=t2.getText();
if(s2.length()<3)
{
JOptionPane.showMessageDialog(null,"Enter The Subject");
return;
}
s4=t4.getText();
if(s4.length()<3)
{
JOptionPane.showMessageDialog(null,"Enter the Notice Description");
return;
}
s5=t5.getText();
if(s5.length()<3)
{
JOptionPane.showMessageDialog(null,"Enter the Authorised Person Name");
return;
}
final String fileName = "C://java//dept//REPORT.mdb";
Connection con = null;

try {
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
String url = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+fileName;
 con = DriverManager.getConnection(url,"","");

Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select *from table1 where notice_no='"+s1+"'");
int i=0;
while(rs.next())
{
i=1;
}
if(i==1)
{
JOptionPane.showMessageDialog(null,"Notice No Already Exsits");
return;

}
rs.close();
}
catch(Exception e)
{
//System.out.println(e+"1");
}



try {
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
String url = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+fileName;
 con = DriverManager.getConnection(url,"","");

Statement st=con.createStatement();

st.executeUpdate("insert into table1(notice_no,subject,notice_date,for_dept,texts,issuedby) values				('"+s1+"','"+s2+"','"+s3+"','"+s9+"','"+s4+"','"+s5+"')");

JOptionPane.showMessageDialog(null,"Date Submited Successfully  " );
Submit.setVisible(false);

	st.close();
 


}
catch(Exception e)
{
//System.out.println(e+"1");
}



}


if(ae.getSource()==Reset)

{
t1.setText("");
t2.setText("");
//t3.setText("");
t4.setText("");
t5.setText("");
Submit.setVisible(true);

}
if(ae.getSource()==vi)

{

view1 v1=new view1();
v1.setup();
}
if(ae.getSource()==da)

{

del1 v1=new del1();
v1.setup();
}

if(ae.getSource()==ba)

{
setVisible(false);
}
}
public void itemStateChanged(ItemEvent ie)
{

s1=" ";
s2="";
s3="";
s4="";
s5="";
s6="";
s7="";
s8="";
s9="";

s9=dept.getSelectedItem();
////////
/////

 
}
public void paint(Graphics g)
{
}
public static void main(String args[])
{
indx r1=new indx();
r1.setup();
}
}


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
public class registration extends Frame implements ActionListener,ItemListener
{
private Closer2 Handler;

Button Submit,Reset,ba;
TextField  name,phoneno,emailid,pass;
Label lname,lphone,lemail,ldept,lpass,age,n1,lsex,lage;
Checkbox male,female,age1,age2,age3;
CheckboxGroup cbg,cbg2;


Choice dept;
public registration()
{
super("REGISTRATION OF DATA");
}
public void setup()
{
//Handler=new Closer2();
//addWindowListener(Handler); 

Font f1=new Font ("TimesRoman",Font.BOLD,24);
setFont (f1);

resize(1500,1000);
setLayout(null);
Color c1=new Color(184,190,192);
setBackground(c1);
Color c2=new Color(25,22,178);
setForeground(c2);
cbg=new CheckboxGroup();
cbg2=new CheckboxGroup();

male=new Checkbox("Male",cbg,true);
female=new Checkbox("Female",cbg,false);
age1=new Checkbox("20-30",cbg2,true);
age2=new Checkbox("31-50",cbg2,false);
age3=new Checkbox("51-60",cbg2,false);
n1=new Label("New Employee Entry");
dept=new Choice();
lname=new Label("Name");
lphone=new Label("PhoneNo.");
lemail=new Label("Email ID");
lpass=new Label("Password");
lsex=new Label("Sex");
lage=new Label("Age");
ldept=new Label("Department");
dept.add("Sale");
dept.add("Marketing");
dept.add("Finance");
dept.add("Production");
dept.add("Personnel");
dept.add("R & D");
name=new TextField(20);
phoneno=new TextField(20);
emailid=new TextField(20);
pass=new TextField(20);
pass.setEchoChar('*');
add(name);
add(phoneno);
add(emailid);
add(pass);
add(n1);
add(lphone);
add(lemail);
add(lpass);
add(lname);
add(lsex);
add(lage);
add(dept);
add(ldept);
n1.setBounds(400,100,250,30);
lname.setBounds(100,150,250,30);
lsex.setBounds(100,200,50,30);
lphone.setBounds(100,250,250,30);
lemail.setBounds(100,300,250,30);
lpass.setBounds(100,350,250,30);
lage.setBounds(100,400,250,30);
ldept.setBounds(100,450,250,30);
dept.setBounds(400,450,250,50);
name.setBounds(400,150,250,30);
male.setBounds(400,200,150,30);
female.setBounds(600,200,250,30);
phoneno.setBounds(400,250,250,30);
emailid.setBounds(400,300,250,30);
pass.setBounds(400,350,250,30);
age1.setBounds(400,400,200,30);
age2.setBounds(600,400,200,30);
age3.setBounds(800,400,200,30);
add(male);
add(female);
add(age1);
add(age2);
add(age3);
Submit=new Button("Save");
Reset=new Button("Reset");
ba=new Button("Back");
add(Submit);
add(Reset);
add(ba);
Submit.setBounds(100,650,250,30);
Reset.setBounds(400,650,250,30);
ba.setBounds(700,650,250,30);

Submit.addActionListener(this);
Reset.addActionListener(this);
ba.addActionListener(this);

show();
}
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==ba)

{
setVisible(false);
return;
}
if(ae.getSource()==Reset)

{
name.setText("");
phoneno.setText("");
pass.setText("");
emailid.setText("");
//cdate.setText("");
//ndate.setText("");
Submit.setVisible(true);

}

if(ae.getSource()==Submit)

{
String s1,s2,s3,s4,s5,s6,s9,s7,s8;
s9=dept.getSelectedItem();
s7=cbg.getSelectedCheckbox().getLabel();
s8=cbg2.getSelectedCheckbox().getLabel();
long s11;
s2=name.getText();
if(s2.length()<3)
{
JOptionPane.showMessageDialog(null,"Enter the Employee Name");
return;
}
s3=pass.getText();
if(s3.length()<3)
{
JOptionPane.showMessageDialog(null,"Enter the Password");
return;
}
s4=emailid.getText();
if(s4.length()<3)
{
JOptionPane.showMessageDialog(null,"Enter the Employee Emailid");
return;
}
int p1,p2,p3,p4;
p1=s4.indexOf("@");
p2=s4.indexOf(".");
if((p1==-1)||(p2==-1))
{
JOptionPane.showMessageDialog(null,"Enter the Correct Employee Emailid");
return;
}
p3=s4.lastIndexOf("@");
p4=s4.lastIndexOf(".");
if((p1!=p3)||(p2!=p4))
{
JOptionPane.showMessageDialog(null,"Enter the Correct Employee Emailid");
return;
}


s1=phoneno.getText();
if(s1.length()<6)
{
JOptionPane.showMessageDialog(null,"Enter the Phone No");
return;
}
try
{
s11=Integer.parseInt(s1);
}
catch(Exception e1)
{
JOptionPane.showMessageDialog(null,"Enter the Phone No in digits");
phoneno.setText("");

return;
}
///////////
final String fileName = "C://java//dept//master.mdb";
//final String fileName = "it.accdb";
Connection con = null;



try {
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
String url = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+fileName;
 con = DriverManager.getConnection(url,"","");

Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select *from table1 where emailid='"+s4+"'");
int i=0;
while(rs.next())
{
i=1;
}
if(i==1)
{
JOptionPane.showMessageDialog(null,"Emailid Already Exsits");
return;

}
rs.close();
st.executeUpdate("insert into table1(ename,phoneno,pass,emailid,sex,agegroup,dept) values				('"+s2+"','"+s1+"','"+s3+"','"+s4+"','"+s7+"','"+s8+"','"+s9+"')");
JOptionPane.showMessageDialog(null,"Date Submited Successfully");
Submit.setVisible(false);

	st.close();
 


}
catch(Exception e)
{
System.out.println(e+"1");
}


//////
}

}
public void itemStateChanged(ItemEvent ie)
{ 
}
public void paint(Graphics g)
{
}
public static void main(String args[])
{
registration r1=new registration();
r1.setup();
}
}


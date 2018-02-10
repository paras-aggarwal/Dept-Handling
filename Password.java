import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.HttpURLConnection;  
import java.io.*;

import javax.swing.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.*;

public class Password  extends JFrame implements ActionListener
{

String s1,s2,s3,s4,s5,s6,s9,s7,s8,nvm;
int i;
	JPasswordField password;
	JTextField Text1;

	JLabel login,pass,hea1,j1;
	JButton ok,cancel;
	final String log = "sql";
	final String passW = "sql";
	JFrame fpass;

	Password()
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
nvm="";
	 	fpass = new JFrame("Login");


	    fpass.getContentPane().setLayout(null);
ImageIcon ii = new ImageIcon("3.jpg");
j1 = new JLabel("", ii, JLabel.CENTER);
		hea1 = new JLabel("LOG IN SCREEN");
		login = new JLabel("USER-ID");
		Text1 = new JTextField(10);
		pass = new JLabel("PASSWORD");
		password = new JPasswordField(10);
		ok = new JButton("OK");
		cancel = new JButton("CANCEL");


		hea1.setBounds(130,10,100,50);
		login.setBounds(70,40,70,50);
		Text1.setBounds(157,55,125,20);
		pass.setBounds(70,70,70,50);
		password.setBounds(158,83,125,20);
		ok.setBounds(80,130,90,20);
		cancel.setBounds(180,130,110,20);
                                     j1.setBounds(200,250,500,500);

		fpass.getContentPane().add(hea1);
		fpass.getContentPane().add(login);
		fpass.getContentPane().add(Text1);
		fpass.getContentPane().add(pass);
		fpass.getContentPane().add(password);
		fpass.getContentPane().add(ok);
		fpass.getContentPane().add(cancel);
		fpass.getContentPane().add(j1);
		
		ok.addActionListener(this);
		cancel.addActionListener(this);

		fpass.setSize(1000,1000);
        fpass.setVisible(true);

	 }

	 public void actionPerformed(ActionEvent e)
	 {
		 String s = e.getActionCommand();
		 if(s.equals("OK"))
		 {
			String str1;
			str1=Text1.getText();

			String str2= new String (password.getPassword());
///
final String fileName = "C://java//dept//master.mdb";
//final String fileName = "it.accdb";
Connection con = null;
	 i=0;


try {
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
String url = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+fileName;
 con = DriverManager.getConnection(url,"","");

Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select * from table1 where emailid='"+str1+"' and pass='"+str2+"'");
while(rs.next())
{
i=1;
s2=rs.getString(1);
s7=rs.getString(7);
user u1=new user(str1,str2,s7);
u1.setup();
}
rs.close();

}
catch(Exception ee)
{
System.out.println(ee+"1");
}


////
			if(str1.equals("admin") && str2.equals("admin"))
			{
			       fpass.setVisible(false);
         	       main1 sen=new main1();
	sen.setup();
i=1;
return;
			}

if(i==0)
{			  JOptionPane.showMessageDialog(null,"Invalid User-ID/Password","Error",1);
			  Text1.setText("");
			  password.setText("");
return;
			}

		 }
		else if(s.equals("CANCEL"))
		 {
			System.exit(0);
		 }



	 }
	 public static void main(String ar[])
	 {
		Password ps = new Password();
		ps.addWindowListener( new WindowAdapter()
			{
			 public void windowClosing(WindowEvent e)
			 {
			   System.exit(0);
			 }
			}
	                        ); //addWindowListener

	 }//main method
}

import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.*;
import java.util.*;
import javax.swing.JFrame;


class view1 extends Frame implements ActionListener
{
	Button b1,b2;
Vector columnNames = new Vector(); // used for student
Vector data = new Vector();
javax.swing.JTable text;
	public view1()
	{
		super("Welcome");
	}
	public void init()
	{
			
}

	public void setup()
	{
b1=new Button("Exit");
		b1.setBounds(100,100,125,50);
		b1.addActionListener(this);
b2=new Button("Show");
		b2.setBounds(300,100,125,50);
		b2.addActionListener(this);

		setLayout(null);
		resize(1200,1200);
add(b1);
add(b2);
show();		}
		public void paint(Graphics g)
	{
		Color c1=new Color(149,149,149);
		setBackground(c1);
		Image pic=Toolkit.getDefaultToolkit().getImage("b.jpg");
if(pic!=null)
g.drawImage(pic,0,350,this);

	}
public void actionPerformed(ActionEvent ae)
	{
		String str=ae.getActionCommand();
		if(str.equals("Exit"))
		{
	setVisible(false);
}
		if(str.equals("Show"))
		{

		final String fileName = "C://java//dept//report.mdb";
//final String fileName = "it.accdb";
Connection con = null;



try {
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
String url = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+fileName;
 con = DriverManager.getConnection(url,"","");
	
			String sql = "Select * from table1";
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery( sql );
			ResultSetMetaData md = rs.getMetaData();
			int columns = md.getColumnCount();
			for (int i = 1; i <= columns; i++) 
			{
				columnNames.addElement( md.getColumnName(i) );
			}
			while (rs.next())
			 {
				Vector row = new Vector(columns);
				for (int i = 1; i <= columns; i++)
				{
					row.addElement( rs.getObject(i) );
				}
				data.addElement( row );
			}
			

			rs.close();
			stat.close();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		 text = new  javax.swing.JTable(data, columnNames);
		text.setBounds(100,400,1000,500);
		TableColumn col;
		for (int i = 0; i < text.getColumnCount(); i++)
		 {
			col = text.getColumnModel().getColumn(i);
			col.setMaxWidth(250);
		}
	javax.swing.JScrollPane scrollPane = new javax.swing.JScrollPane( text);
	add(scrollPane);
	scrollPane.setBounds(100,400,1000,500);
}
}
	public void windowClosing(WindowEvent we)
	{
		setVisible(false);
	}
		
	public static void main(String args[])
	{
		view1 v=new view1();
		v.setup();
	}
}


import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;

class main1 extends Frame implements ActionListener
{
private Closer Handler;
	Label title,t2;
	Button add,exitbt,del,vi,ed,ind;
	Font f;
	
	public main1()
	{
		super("Welcome");
	}
	public void init()
	{
	}
	public void setup()
	{
 
		setLayout(null);                           
		resize(800,800);
		title=new Label("MAIN MENU");
		title.setBounds(300,50,250,30);
		add=new Button("Employee Information");
		add.setBounds(300,100,150,30);
		add.addActionListener(this);
		vi=new Button("View Information");
		vi.setBounds(300,150,150,30);
		vi.addActionListener(this);
del=new Button("Delete Information");
		del.setBounds(300,200,150,30);
		del.addActionListener(this);
ed=new Button("Edit Information");
		ed.setBounds(300,250,150,30);
		ed.addActionListener(this);
ind=new Button("Notice Detail");
		ind.setBounds(300,300,150,30);
		ind.addActionListener(this);
add(ind);
exitbt=new Button("Exit");
		exitbt.setBounds(300,350,150,30);
		exitbt.addActionListener(this);
		
		f=new Font("Times New Roman",Font.BOLD,29);
		title.setFont(f);
                                       add(del);
                                       add(vi);
		add(title);
		add(add);
		add(vi);
		add(ed);
		add(exitbt);
		show();
	}
	public void actionPerformed(ActionEvent ae)
	{
		String str=ae.getActionCommand();

		if(str.equals("Exit"))
		{
			System.exit(0);
		}

		if(str.equals("Employee Information"))
		{
		
                                    registration e1=new registration();
e1.setup();
	}
		if(str.equals("View Information"))
		{
                                     view e11=new view();
e11.setup();


				}

if(str.equals("Notice Detail"))
		{
                                     indx e11=new indx();
e11.setup();


				}
		if(str.equals("Delete Information"))
		{

 dele e1=new dele();
e1.setup();
				}

if(str.equals("Edit Information"))
		{

 upd e1=new upd();
e1.setup();
				}


		repaint();
	}
	
	public void paint(Graphics g)
	{
		
		Color c1=new Color(179,179,179);
		
		setBackground(c1);
		title.setBackground(c1);

		Image pic=Toolkit.getDefaultToolkit().getImage("COLG.jpg");
		if(pic!=null)
			g.drawImage(pic,40,400,this);

	}

	public static void main(String args[])
	{
		main1 m=new main1();
		m.setup();
	}
}

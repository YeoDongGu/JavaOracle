package login;

import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Signup extends WindowAdapter implements ActionListener{
	private Frame f;
	private Panel p;
	
	private Label lname;
	private Label lresi;
	private Label lid;
	private Label lpwd;
	
	
	private TextField name;
	private TextField resi;
	private TextField id;
	private TextField pwd;
	
	private Button signup;
	
	private Font font1;
	private Font font2;
	
	
	public Signup() {
		font1 = new Font("f", Font.BOLD,20);
		font2 = new Font("f", Font.BOLD,13);
		
		f= new Frame("Sign up");
		p = new Panel();
		p.setLayout(new GridLayout(4,2));
		
		lname = new Label("name : " , Label.CENTER);
		lresi = new Label("residentid : ", Label.CENTER );
		lid = new Label("id : ", Label.CENTER);
		lpwd = new Label("password : ", Label.CENTER);
		
		name = new TextField(20);
		name.setFont(font1);
		resi = new TextField(20);
		resi.setFont(font1);
		id = new TextField(20);
		id.setFont(font1);
		pwd = new TextField(20);
		pwd.setFont(font1);
		
		signup = new Button("회원가입");
		signup.setFont(font2);
		
	}
	
	public void startframe() {
		f.setSize(200,200);
		f.add(p,"Center");
		f.add(signup,"South");
		f.add("North", new Label());
		
		p.add(lname);
		p.add(name);
		p.add(lresi);
		p.add(resi);
		p.add(lid);
		p.add(id);
		p.add(lpwd);
		p.add(pwd);
		
		f.setVisible(true);
		
	}
	
	public void windowClosing(WindowEvent e) {
		System.exit(0);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("회원가입")) {
			
		}
		
	}

}

package login;

import java.awt.Button;
import java.awt.Color;
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
import java.util.ArrayList;

public class Signup extends WindowAdapter implements ActionListener {
	private Frame f;
	private Panel p;

	private Label lname;
	private Label lresi;
	private Label lid;
	private Label lpwd;
	private Label title;

	private TextField name;
	private TextField resi;
	private TextField id;
	private TextField pwd;

	private Button signup;

	private Font font1;
	private Font font2;

	public Signup() {
		font1 = new Font("f", Font.BOLD, 13);
		font2 = new Font("f", Font.BOLD, 17);

		f = new Frame("Sign up");
		p = new Panel();
		p.setLayout(new GridLayout(8, 0));

		title = new Label("계정 만들기");
		title.setFont(font2);

		lname = new Label("이름 : ", Label.LEFT);
		lname.setFont(font1);
		lresi = new Label("주민번호 : ", Label.LEFT);
		lresi.setFont(font1);
		lid = new Label("아이디 : ", Label.LEFT);
		lid.setFont(font1);
		lpwd = new Label("비밀번호 : ", Label.LEFT);
		lpwd.setFont(font1);

		name = new TextField(20);
		name.setFont(font2);
		resi = new TextField(20);
		resi.setFont(font2);
		id = new TextField(20);
		id.setFont(font2);
		pwd = new TextField(20);
		pwd.setFont(font2);

		signup = new Button("가입하기");
		signup.setFont(font2);
		signup.setBackground(Color.lightGray);

	}

	public void startframe() {
		f.setSize(300, 300);
		f.add(p, "Center");
		f.add(signup, "South");
		f.add(title, "North");

		p.add(lid);
		p.add(id);
		p.add(lpwd);
		p.add(pwd);
		p.add(lname);
		p.add(name);
		p.add(lresi);
		p.add(resi);

		f.setVisible(true);

		f.addWindowListener(this);
		signup.addActionListener(this);

	}

	public void windowClosing(WindowEvent e) {
		System.exit(0);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("가입하기")) {
			SignupDAO dao = new SignupDAO();
			ArrayList<SignupVo> list = dao.list(id.getText(), pwd.getText(), resi.getText(), name.getText());

		}

	}

}

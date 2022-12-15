package login;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class LoginMain extends WindowAdapter implements ActionListener {
	private Frame f;
	private Label lid;
	private Label lpwd;
	private Panel p;

	private TextField id;
	private TextField pwd;
	private TextField result;
	private Button log;
	private Button signup;
	private String myid;
	private String mypwd;

	private Font font1;

	public LoginMain() {

		font1 = new Font("f", Font.BOLD, 17);
		f = new Frame("Login");
		f.setBackground(Color.cyan);

		p = new Panel();
		lid = new Label("아이디 : ", Label.CENTER);
		lid.setFont(font1);
		lpwd = new Label("암   호 : ", Label.CENTER);
		lpwd.setFont(font1);

		id = new TextField(20);
		pwd = new TextField(20);
		result = new TextField(40);
		log = new Button("로그인");
		result.setEditable(false);
		result.setFocusable(false);
		signup = new Button("회원가입");
	}

	public void startframe() {
		f.setSize(300, 180);
		f.add(result, "North");
		f.add(p, "Center");
		f.addWindowListener(this);
		log.addActionListener(this);
		signup.addActionListener(this);
		pwd.setEchoChar('*');

		p.add(lid);
		p.add(id);
		p.add(lpwd);
		p.add(pwd);
		p.add(log);
		p.add(signup);
		f.setVisible(true);
	}

	public void windowClosing(WindowEvent e) {
		System.exit(0);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("로그인")) {
			LoginDAO dao = new LoginDAO();
			ArrayList<LoginVo> list = dao.list(id.getText(), pwd.getText());
			for (int i = 0; i < list.size(); i++) {
				LoginVo data = (LoginVo) list.get(i);
				myid = data.getId();
				mypwd = data.getPwd();
			}
			System.out.println(myid);
			System.out.println(mypwd);
			if (id.getText().equals(myid) && pwd.getText().equals(mypwd)) {
				result.setText("로그인에 성공하였습니다.");
			} else {
				result.setText("로그인에 실패하였습니다.");
			}
		}

		if (e.getActionCommand().equals("회원가입")) {
			Signup sg = new Signup();
			sg.startframe();
			f.setVisible(false);
		}

	}

	public static void main(String[] args) {
		LoginMain lg = new LoginMain();
		lg.startframe();

	}

}

package login;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
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

	private TextField id;
	private TextField pwd;
	private TextField result;
	private Button log;
	private Button signup;
	private String myid;
	private String mypwd;

	public LoginMain() {
		f = new Frame("Login");
		f.setBackground(Color.cyan);
		lid = new Label("id : ", Label.CENTER);
		lpwd = new Label("password : ", Label.CENTER);

		id = new TextField(10);
		pwd = new TextField(10);
		result = new TextField(40);
		log = new Button("로그인");
		result.setEditable(false);
		result.setFocusable(false);
		signup = new Button("회원가입");
	}

	public void startframe() {
		f.setSize(400, 100);
		f.setLayout(new FlowLayout());
		f.addWindowListener(this);
		log.addActionListener(this);
		signup.addActionListener(this);
		pwd.setEchoChar('*');

		f.add(lid);
		f.add(id);
		f.add(lpwd);
		f.add(pwd);
		f.add(log);
		f.add(result);
		f.add(signup);
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

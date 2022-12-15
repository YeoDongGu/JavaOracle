package login;

public class SignupVo {
	private String id;
	private String pwd;
	private String resi;
	private String name;

	public SignupVo() {

	}

	public SignupVo(String id, String pwd, String resi, String name) {
		this.id = id;
		this.pwd = pwd;
		this.resi = resi;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getPwd() {
		return pwd;
	}

	public String getResi() {
		return resi;
	}

	public String getName() {
		return name;
	}
	
	
}

package login;

public class SignupVo {
	private String name;
	private String resi;
	private String id;
	private String pwd;

	public SignupVo() {

	}

	public SignupVo(String name, String resi, String id, String pwd) {
		this.name = name;
		this.resi = resi;
		this.id = id;
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public String getResi() {
		return resi;
	}

	public String getId() {
		return id;
	}

	public String getPwd() {
		return pwd;
	}

}

package spring.mvc.basic_1team.dto;

public class CustomerDTO {
	
	// 멤버변수
	private String user_id;         // 아이디
    private String user_pwd;        // 비밀번호
    private String user_name;       // 이름
    private String user_hp;         // 폰번호
    private String user_email;      // 이메일
    private String user_address;    // 받는사람주소
    
    // 시큐리티를 위한 추가
    private String key; 
    private String authority;
    private String enabled;
	
    
    // 디폴트 생성자
	public CustomerDTO() {
		super();
	}


	// 매개변수 생성자
	public CustomerDTO(String user_id, String user_pwd, String user_name, String user_hp, String user_email,
			String user_address, String key, String authority, String enabled) {
		super();
		this.user_id = user_id;
		this.user_pwd = user_pwd;
		this.user_name = user_name;
		this.user_hp = user_hp;
		this.user_email = user_email;
		this.user_address = user_address;
		this.key = key;
		this.authority = authority;
		this.enabled = enabled;
	}


	//getter setter
	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public String getUser_pwd() {
		return user_pwd;
	}


	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
	


	public String getUser_name() {
		return user_name;
	}


	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


	public String getUser_hp() {
		return user_hp;
	}


	public void setUser_hp(String user_hp) {
		this.user_hp = user_hp;
	}


	public String getUser_email() {
		return user_email;
	}


	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}


	public String getUser_address() {
		return user_address;
	}


	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}


	public String getKey() {
		return key;
	}


	public void setKey(String key) {
		this.key = key;
	}


	public String getAuthority() {
		return authority;
	}


	public void setAuthority(String authority) {
		this.authority = authority;
	}


	public String getEnabled() {
		return enabled;
	}


	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}


	//to string
	@Override
	public String toString() {
		return "CustomerDTO [user_id=" + user_id + ", user_pwd=" + user_pwd + ", user_name=" + user_name + ", user_hp="
				+ user_hp + ", user_email=" + user_email + ", user_address=" + user_address + ", key=" + key
				+ ", authority=" + authority + ", enabled=" + enabled + "]";
	}


	
	

}

package spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "userlogin")
public class Userlogin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userid;
	private String name;
	@Column(unique = true)
	private String email;
	private String password;
	private String userrole;
	private String is_currently_logged_in;
	private String last_logged_in;
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserrole() {
		return userrole;
	}
	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}
	public String getIs_currently_logged_in() {
		return is_currently_logged_in;
	}
	public void setIs_currently_logged_in(String is_currently_logged_in) {
		this.is_currently_logged_in = is_currently_logged_in;
	}
	public String getLast_logged_in() {
		return last_logged_in;
	}
	public void setLast_logged_in(String last_logged_in) {
		this.last_logged_in = last_logged_in;
	}


	
}

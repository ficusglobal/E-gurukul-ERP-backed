package spring.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Userrole")
public class User_role {
	@Id
	private String Rolename;

	public String getRolename() {
		return Rolename;
	}

	public void setRolename(String rolename) {
		Rolename = rolename;
	}
	
}

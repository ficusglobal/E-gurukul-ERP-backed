package spring.LoginService;

import java.util.List;

import spring.model.User_role;
import spring.model.Userlogin;

public interface Login_service {
	String save(Userlogin userlogin);
	String role(User_role user_role);
	Boolean checkuser(String email, String password);
	 
	   Userlogin get(long userid);
	   List<Userlogin> list();
	   void update(long userid, Userlogin book);
	   void delete(long userid);

}

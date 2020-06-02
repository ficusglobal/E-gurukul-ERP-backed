package spring.dao;

import java.util.List;

import spring.model.Userlogin;

;

public interface UserloginDao {
	String save(Userlogin userlogin);
	List<Userlogin> list();
	Userlogin get(long userid);
	void update(long userid, Userlogin book);
	void delete(long userid);
	Userlogin checkuser(String email);
	

}

package spring.LoginService;

import java.util.List;

import spring.model.ClassName;
import spring.model.RegistrationRequest;
import spring.model.Section;
import spring.model.User_role;
import spring.model.Userlogin;

public interface Login_service {
	String save(Userlogin userlogin);

	String role(User_role user_role);

	Userlogin checkuser(String email, String password);

	Userlogin get(long userid);

	List<Userlogin> list();

	void update(long userid, Userlogin book);

	void delete(long userid);

	List<ClassName> showclass();

	List<?> showsection();

	String deleteclass(long id);

	String deletesection(long id);

	ClassName addClass(ClassName className);

	Section addSection(Section section);

	void updateclass(long classid, ClassName className);

	void updatesection(long sectionid, Section section);
	
	String createUser(RegistrationRequest registrationRequest);
	
	List<?> showstudents(long pagenumber,long pagesize,String searchval);
	
	long totalrecord();
	long filterrecord(String searchtxt);
	long drawpage();
	
	String importexcel(List<RegistrationRequest> list);

}

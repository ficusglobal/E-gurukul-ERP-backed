package spring.dao;

import java.util.List;

import spring.model.ClassName;
import spring.model.RegistrationRequest;
import spring.model.Section;
import spring.model.StudentAddress;
import spring.model.StudentApplicationDetail;
import spring.model.StudentBasicDetail;
import spring.model.StudentParent;
import spring.model.Studentmedicalinfo;
import spring.model.Userlogin;

;

public interface UserloginDao {
	String save(Userlogin userlogin);

	List<Userlogin> list();

	Userlogin get(long userid);

	void update(long userid, Userlogin book);

	void delete(long userid);

	Userlogin checkuser(String email);

	List<ClassName> showclass();

	List<?> showsection();

	String deleteclass(long classid);

	String deletesection(long sectionid);

	ClassName addClass(ClassName className);
	
	void updateclass(long classid,ClassName className);
	void updatesection(long sectionid,Section section);
	Section addSection(Section section);

	String createUser(StudentBasicDetail studentBasicDetail, StudentApplicationDetail studentApplicationDetail, StudentAddress studentAddress, String[] interests,Studentmedicalinfo studentmedicalinfo,StudentParent mother,StudentParent father,StudentParent guardian);
	
	List<?> showstudents(long pagenumber,long pagesize,String searchval);
	
	long totalrecord();
	long filterrecord(String searchtxt);
	long drawpage();
	
	String importexcel(List<RegistrationRequest> registrationRequest);
}

package spring.LoginService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.dao.UserloginDao;
import spring.model.ClassName;
import spring.model.RegistrationRequest;
import spring.model.Section;
import spring.model.StudentAddress;
import spring.model.StudentApplicationDetail;
import spring.model.StudentBasicDetail;
import spring.model.StudentParent;
import spring.model.Studentmedicalinfo;
import spring.model.User_role;
import spring.model.Userlogin;

@Service
@Transactional(readOnly = true)
public class Login_serviceImp implements Login_service {

	@Autowired
	private UserloginDao userloginDao;

	@Transactional
	@Override
	public String save(Userlogin userlogin) {

		String em = "null";
		try {
			em = userloginDao.save(userlogin);
		} catch (Exception e) {
			em = e.getMessage().toString();
		}
		return em;

	}

	@Override
	public String role(User_role user_role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public Userlogin checkuser(String email, String password) {

		Userlogin userlogin = null;

		userlogin = userloginDao.checkuser(email);

		if (userlogin != null && userlogin.getPassword().equals(password)) {
			return userlogin;
		} else {
			return null;
		}

	}

	@Transactional
	@Override
	public Userlogin get(long userid) {
		return userloginDao.get(userid);
	}

	@Override
	public List<Userlogin> list() {
		return userloginDao.list();
	}

	@Transactional
	@Override
	public void update(long userid, Userlogin userlogin) {
		userloginDao.update(userid, userlogin);

	}

	@Transactional
	@Override
	public void delete(long userid) {
		userloginDao.delete(userid);

	}

	@Transactional
	@Override
	public ClassName addClass(ClassName className) {
		return userloginDao.addClass(className);
	}

	@Transactional
	@Override
	public Section addSection(Section section) {
		return userloginDao.addSection(section);
	}

	@Transactional
	@Override
	public List<ClassName> showclass() {
		// TODO Auto-generated method stub
		return userloginDao.showclass();
	}

	@Transactional
	@Override
	public List<?> showsection() {
		// TODO Auto-generated method stub
		return userloginDao.showsection();
	}

	@Transactional
	@Override
	public String deleteclass(long id) {
//		// TODO Auto-generated method stub
//		try {
		return userloginDao.deleteclass(id);
//		} catch (Exception e) {
		// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.print(e.getMessage());
//		}

	}

	@Transactional
	@Override
	public String deletesection(long id) {
		// TODO Auto-generated method stub
		return userloginDao.deletesection(id);
	}

	@Transactional
	@Override
	public void updateclass(long classid, ClassName className) {
		userloginDao.updateclass(classid, className);

	}

	@Transactional
	@Override
	public void updatesection(long sectionid, Section section) {
		userloginDao.updatesection(sectionid, section);

	}

	@Transactional
	@Override
	public String createUser(RegistrationRequest registrationRequest) {
		StudentBasicDetail studentBasicDetail = new StudentBasicDetail();
		StudentAddress studentAddress = new StudentAddress();
		StudentApplicationDetail studentApplicationDetail = new StudentApplicationDetail();
		// StudentParent studentParent = new StudentParent();
		String[] interests = registrationRequest.getStudentinterest();

//	studentInterest.setInterest_name(interest);
		String name = registrationRequest.getStudent_first_name() + " " + registrationRequest.getStudent_middle_name()
				+ " " + registrationRequest.getStudent_last_name();

		studentBasicDetail.setStudent_name(name);
		studentBasicDetail.setStudent_birthplace(registrationRequest.getBirth_place());
		studentBasicDetail.setStudent_dob(registrationRequest.getDate_of_birth());
		studentBasicDetail.setStudent_gender(registrationRequest.getStudent_gender());
		studentBasicDetail.setStudent_livingwith(registrationRequest.getLive_with_radio());
		studentBasicDetail.setStudent_mobile(registrationRequest.getStudent_mobile_number());
		studentBasicDetail.setStudent_email(registrationRequest.getStudent_email());
		studentBasicDetail.setStudent_mothertongue(registrationRequest.getStudent_mother_tongue());
		studentBasicDetail.setStudent_religion(registrationRequest.getStudent_religious());
		studentBasicDetail.setStudent_nationality(registrationRequest.getStudent_country());

		studentApplicationDetail.setApplication_num(registrationRequest.getApplication_number());
		studentApplicationDetail.setApplication_academic_year(registrationRequest.getAcademic_year());
		studentApplicationDetail.setApplication_class(registrationRequest.getAddmission_class());
		studentApplicationDetail.setApplication_section(registrationRequest.getAddmission_section());
		studentApplicationDetail.setApplication_issuedate(registrationRequest.getAddmission_date());

		studentAddress.setAddressline1(registrationRequest.getPresentaddline1());
		studentAddress.setAddressline2(registrationRequest.getPresentaddline2());
		studentAddress.setCity(registrationRequest.getPresentaddcity());
		studentAddress.setAddress_phonenumber(registrationRequest.getPresentaddmobno());
		studentAddress.setState(registrationRequest.getPresentaddregion());
		studentAddress.setAddress_email(registrationRequest.getPresentaddemail());
		studentAddress.setSms_phone_number(registrationRequest.getPresentaddsmsmob());
		studentAddress.setPostal(registrationRequest.getPresentaddpostal());

		Studentmedicalinfo studentmedicalinfo = new Studentmedicalinfo();
		try {
			studentmedicalinfo = new Studentmedicalinfo();
			studentmedicalinfo.setBloodgroup(registrationRequest.getStudent_blood_group());
			studentmedicalinfo.setHeight(registrationRequest.getStudent_height());
			studentmedicalinfo.setWeight(registrationRequest.getStudent_weight());
			studentmedicalinfo.setHeath_condition(registrationRequest.getStudent_disease());
			studentmedicalinfo.setMedical_condition(registrationRequest.getStudent_condition());
			studentmedicalinfo.setVisual_difficulty(registrationRequest.getVisual_difficulty());
			studentmedicalinfo.setMedication(registrationRequest.getStudent_medication());
			String alergy = registrationRequest.getStudent_alergy();
			studentmedicalinfo.setAlergy(registrationRequest.getStudent_alergy());
			if (alergy.equals("yes")) {
				studentmedicalinfo.setAlergy_cause(registrationRequest.getStudent_alergy_cause());
				studentmedicalinfo.setAlergy_reaction(registrationRequest.getStudent_alergy_reaction());
				studentmedicalinfo.setAlergy_treatment(registrationRequest.getStudent_alergy_treatment());

			}
			studentmedicalinfo.setDoctor_name(registrationRequest.getDoctor_name());
			studentmedicalinfo.setDoctor_phone(registrationRequest.getDoctor_phone());
			studentmedicalinfo.setDoctor_address(registrationRequest.getDoctor_address());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		StudentParent father = new StudentParent();
		StudentParent mother = new StudentParent();
		StudentParent guardian = new StudentParent();

		mother.setParent_type("mother");
		mother.setParent_name(registrationRequest.getMother_name());

		mother.setParent_phone(registrationRequest.getMother_phone());
		mother.setParent_email(registrationRequest.getMother_email());
		mother.setParent_profession(registrationRequest.getMother_profession());
		mother.setParent_qualification(registrationRequest.getMother_qualification());

		father.setParent_type("father");
		father.setParent_name(registrationRequest.getFather_name());
		father.setParent_phone(registrationRequest.getFather_phone());
		father.setParent_email(registrationRequest.getFather_email());
		father.setParent_profession(registrationRequest.getFather_profession());
		father.setParent_qualification(registrationRequest.getFather_qualification());
		System.out.println("ok2");

		try {
			if (registrationRequest.getGuardian().equals("yes")) {
				guardian.setParent_name(registrationRequest.getGuardian_name());
				guardian.setParent_phone(registrationRequest.getGuardian_phone());
				guardian.setParent_email(registrationRequest.getGuardian_email());
				guardian.setParent_profession(registrationRequest.getGuardian_profession());
				guardian.setParent_qualification(registrationRequest.getGuardian_qualification());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return userloginDao.createUser(studentBasicDetail, studentApplicationDetail, studentAddress, interests,
				studentmedicalinfo, mother, father, guardian);
	}

	@Override
	public List<?> showstudents(long pagenumber, long pagesize, String searchval) {
		// TODO Auto-generated method stub
		return userloginDao.showstudents(pagenumber, pagesize, searchval);
	}

	@Override
	public long totalrecord() {
		// TODO Auto-generated method stub
		return userloginDao.totalrecord();
	}

	@Override
	public long filterrecord(String searchtxt) {
		// TODO Auto-generated method stub
		return userloginDao.filterrecord(searchtxt);
	}

	@Override
	public long drawpage() {
		// TODO Auto-generated method stub
		return userloginDao.drawpage();
	}

	@Transactional
	@Override
	public String importexcel(List<RegistrationRequest> list) {
	
		return userloginDao.importexcel(list);
	}

}

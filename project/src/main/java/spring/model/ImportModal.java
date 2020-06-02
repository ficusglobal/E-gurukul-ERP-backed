package spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "importmodal")
public class ImportModal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String addmissionnumber;
	private String session;
	private String name;
	private String classname;
	private String secctionname;
	private String fathersname;
	private String mothername;
	private String state;
	private String hometown;
	private String address;
	private String pincode;
	private String dob;
	private String gender;
	private String fathersphone;
	private String fathersemail;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAddmissionnumber() {
		return addmissionnumber;
	}
	public void setAddmissionnumber(String addmissionnumber) {
		this.addmissionnumber = addmissionnumber;
	}
	public String getSession() {
		return session;
	}
	public void setSession(String session) {
		this.session = session;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public String getSecctionname() {
		return secctionname;
	}
	public void setSecctionname(String secctionname) {
		this.secctionname = secctionname;
	}
	public String getFathersname() {
		return fathersname;
	}
	public void setFathersname(String fathersname) {
		this.fathersname = fathersname;
	}
	public String getMothername() {
		return mothername;
	}
	public void setMothername(String mothername) {
		this.mothername = mothername;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getHometown() {
		return hometown;
	}
	public void setHometown(String hometown) {
		this.hometown = hometown;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getFathersphone() {
		return fathersphone;
	}
	public void setFathersphone(String fathersphone) {
		this.fathersphone = fathersphone;
	}
	public String getFathersemail() {
		return fathersemail;
	}
	public void setFathersemail(String fathersemail) {
		this.fathersemail = fathersemail;
	}
	
	
	

}

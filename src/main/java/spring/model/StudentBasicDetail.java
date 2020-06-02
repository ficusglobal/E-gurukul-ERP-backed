package spring.model;

import java.util.SortedSet;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name = "student_basic_detail")
public class StudentBasicDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long student_id;
	@Column(nullable = false)
	private String student_name;
	private String student_dob;
	private String student_gender;
	private String student_birthplace;
	private String student_nationality;
	private String student_livingwith;
	private String student_mothertongue;
	private String student_religion;
	private String student_email;
	private String student_mobile;
//	@JsonManagedReference
//	@Fetch(FetchMode.JOIN)
	@OneToOne(targetEntity = StudentApplicationDetail.class, cascade = CascadeType.PERSIST,mappedBy = "studentBasicDetail")
	private StudentApplicationDetail studentApplicationDetail;
	@JsonManagedReference
	@Fetch(FetchMode.JOIN)
//	@JsonIgnore
	@OrderBy
	@OneToMany(targetEntity = StudentAddress.class,cascade = CascadeType.PERSIST,mappedBy = "studentBasicDetail")
	private SortedSet<StudentAddress> studentAddresses=new TreeSet<StudentAddress>();
	@JsonManagedReference
	@Fetch(FetchMode.JOIN)
	@OrderBy
	@OneToMany(targetEntity = StudentInterest.class,cascade = CascadeType.PERSIST,mappedBy = "studentBasicDetail")
	private SortedSet<StudentInterest> studentInterests= new TreeSet<StudentInterest>();;
	@JsonManagedReference
	@Fetch(FetchMode.JOIN)
//	@JsonIgnore
	@OrderBy
	@OneToMany(targetEntity = StudentParent.class,cascade = CascadeType.PERSIST,mappedBy = "studentBasicDetail")
	private SortedSet<StudentParent> studentParent=new TreeSet<StudentParent>();
//	@JsonManagedReference
//	@Fetch(FetchMode.JOIN)
	@OneToOne(targetEntity = Studentmedicalinfo.class,cascade = CascadeType.PERSIST,mappedBy = "studentBasicDetail")
	private Studentmedicalinfo studentmedicalinfo;
	
	
	
	
	
	
	
	public long getStudent_id() {
		return student_id;
	}
	public void setStudent_id(long student_id) {
		this.student_id = student_id;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public String getStudent_dob() {
		return student_dob;
	}
	public void setStudent_dob(String student_dob) {
		this.student_dob = student_dob;
	}
	public String getStudent_gender() {
		return student_gender;
	}
	public void setStudent_gender(String student_gender) {
		this.student_gender = student_gender;
	}
	public String getStudent_birthplace() {
		return student_birthplace;
	}
	public void setStudent_birthplace(String student_birthplace) {
		this.student_birthplace = student_birthplace;
	}
	public String getStudent_nationality() {
		return student_nationality;
	}
	public void setStudent_nationality(String student_nationality) {
		this.student_nationality = student_nationality;
	}
	public String getStudent_livingwith() {
		return student_livingwith;
	}
	public void setStudent_livingwith(String student_livingwith) {
		this.student_livingwith = student_livingwith;
	}
	public String getStudent_mothertongue() {
		return student_mothertongue;
	}
	public void setStudent_mothertongue(String student_mothertongue) {
		this.student_mothertongue = student_mothertongue;
	}
	public String getStudent_religion() {
		return student_religion;
	}
	public void setStudent_religion(String student_religion) {
		this.student_religion = student_religion;
	}
	public String getStudent_email() {
		return student_email;
	}
	public void setStudent_email(String student_email) {
		this.student_email = student_email;
	}
	public String getStudent_mobile() {
		return student_mobile;
	}
	public void setStudent_mobile(String student_mobile) {
		this.student_mobile = student_mobile;
	}
	public StudentApplicationDetail getStudentApplicationDetail() {
		return studentApplicationDetail;
	}
	public void setStudentApplicationDetail(StudentApplicationDetail studentApplicationDetail) {
		this.studentApplicationDetail = studentApplicationDetail;
	}


	public SortedSet<StudentAddress> getStudentAddresses() {
		return studentAddresses;
	}
	public void setStudentAddresses(SortedSet<StudentAddress> studentAddresses) {
		this.studentAddresses = studentAddresses;
	}
	public SortedSet<StudentInterest> getStudentInterests() {
		return studentInterests;
	}
	public void setStudentInterests(SortedSet<StudentInterest> studentInterests) {
		this.studentInterests = studentInterests;
	}

	public SortedSet<StudentParent> getStudentParent() {
		return studentParent;
	}
	public void setStudentParent(SortedSet<StudentParent> studentParent) {
		this.studentParent = studentParent;
	}
	public Studentmedicalinfo getStudentmedicalinfo() {
		return studentmedicalinfo;
	}
	public void setStudentmedicalinfo(Studentmedicalinfo studentmedicalinfo) {
		this.studentmedicalinfo = studentmedicalinfo;
	}
	
	


}

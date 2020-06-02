package spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name = "student_parent")
public class StudentParent implements Comparable<StudentParent>{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long parent_id;
	private String parent_name;
	private String parent_qualification;
	private String parent_profession;
	private String parent_phone;
	private String parent_email;
	private String parent_type;
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "student_id")
	private StudentBasicDetail studentBasicDetail;
	
	
	
	public String getParent_type() {
		return parent_type;
	}
	public void setParent_type(String parent_type) {
		this.parent_type = parent_type;
	}
	public long getParent_id() {
		return parent_id;
	}
	public void setParent_id(long parent_id) {
		this.parent_id = parent_id;
	}
	public String getParent_name() {
		return parent_name;
	}
	public void setParent_name(String parent_name) {
		this.parent_name = parent_name;
	}
	public String getParent_qualification() {
		return parent_qualification;
	}
	public void setParent_qualification(String parent_qualification) {
		this.parent_qualification = parent_qualification;
	}
	public String getParent_profession() {
		return parent_profession;
	}
	public void setParent_profession(String parent_profession) {
		this.parent_profession = parent_profession;
	}
	public String getParent_phone() {
		return parent_phone;
	}
	public void setParent_phone(String parent_phone) {
		this.parent_phone = parent_phone;
	}
	public String getParent_email() {
		return parent_email;
	}
	public void setParent_email(String parent_email) {
		this.parent_email = parent_email;
	}
	public StudentBasicDetail getStudentBasicDetail() {
		return studentBasicDetail;
	}
	public void setStudentBasicDetail(StudentBasicDetail studentBasicDetail) {
		this.studentBasicDetail = studentBasicDetail;
	}
	@Override
	public int compareTo(StudentParent o) {
		// TODO Auto-generated method stub
		return Double.compare(parent_id, o.getParent_id());
	}
	

}

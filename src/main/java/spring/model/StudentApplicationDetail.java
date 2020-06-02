package spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name = "student_application_detail")
public class StudentApplicationDetail {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long application_id;
private String application_num;
private String application_academic_year;
private String application_class;
private String application_section;
private String application_issuedate;
@OneToOne
@JsonBackReference
@JoinColumn(name="student_id")
private StudentBasicDetail studentBasicDetail;
public long getApplication_id() {
	return application_id;
}
public void setApplication_id(long application_id) {
	this.application_id = application_id;
}
public String getApplication_num() {
	return application_num;
}
public void setApplication_num(String application_num) {
	this.application_num = application_num;
}
public String getApplication_academic_year() {
	return application_academic_year;
}
public void setApplication_academic_year(String application_academic_year) {
	this.application_academic_year = application_academic_year;
}

public String getApplication_class() {
	return application_class;
}
public void setApplication_class(String application_class) {
	this.application_class = application_class;
}
public String getApplication_section() {
	return application_section;
}
public void setApplication_section(String application_section) {
	this.application_section = application_section;
}
public String getApplication_issuedate() {
	return application_issuedate;
}
public void setApplication_issuedate(String application_issuedate) {
	this.application_issuedate = application_issuedate;
}
public StudentBasicDetail getStudentBasicDetail() {
	return studentBasicDetail;
}
public void setStudentBasicDetail(StudentBasicDetail studentBasicDetail) {
	this.studentBasicDetail = studentBasicDetail;
}




}



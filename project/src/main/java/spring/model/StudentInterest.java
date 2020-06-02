package spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name = "student_interest")
public class StudentInterest implements Comparable<StudentInterest>{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long interest_id;
	@Column(nullable = false)
	private String interest_name;
	@ManyToOne
	@JsonBackReference
	//@JsonIgnore
	//@JsonIgnoreProperties("studentInterests") 
	@JoinColumn(name = "student_id")
	private StudentBasicDetail studentBasicDetail;
	public long getInterest_id() {
		return interest_id;
	}
	public void setInterest_id(long interest_id) {
		this.interest_id = interest_id;
	}
	public String getInterest_name() {
		return interest_name;
	}
	public void setInterest_name(String interest_name) {
		this.interest_name = interest_name;
	}
	public StudentBasicDetail getStudentBasicDetail() {
		return studentBasicDetail;
	}
	public void setStudentBasicDetail(StudentBasicDetail studentBasicDetail) {
		this.studentBasicDetail = studentBasicDetail;
	}
	@Override
	public int compareTo(StudentInterest o) {
		// TODO Auto-generated method stub
		return interest_name.compareTo(o.getInterest_name());
	}

	
	
}

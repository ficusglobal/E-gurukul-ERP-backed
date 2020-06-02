package spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name = "student_address")
public class StudentAddress implements Comparable<StudentAddress> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long address_id;
	private String addressline1;
	private String addressline2;
	private String city;
	private String state;
	private String postal;
	private String address_phonenumber;
	private String sms_phone_number;
	private String address_email;
	private String address_type;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "student_id")
	private StudentBasicDetail studentBasicDetail;
	
	
	public long getAddress_id() {
		return address_id;
	}
	public void setAddress_id(long address_id) {
		this.address_id = address_id;
	}
	public String getAddressline1() {
		return addressline1;
	}
	public void setAddressline1(String addressline1) {
		this.addressline1 = addressline1;
	}
	public String getAddressline2() {
		return addressline2;
	}
	public void setAddressline2(String addressline2) {
		this.addressline2 = addressline2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPostal() {
		return postal;
	}
	public void setPostal(String postal) {
		this.postal = postal;
	}
	public String getAddress_phonenumber() {
		return address_phonenumber;
	}
	public void setAddress_phonenumber(String address_phonenumber) {
		this.address_phonenumber = address_phonenumber;
	}
	public String getSms_phone_number() {
		return sms_phone_number;
	}
	public void setSms_phone_number(String sms_phone_number) {
		this.sms_phone_number = sms_phone_number;
	}
	public String getAddress_email() {
		return address_email;
	}
	public void setAddress_email(String address_email) {
		this.address_email = address_email;
	}
	public String getAddress_type() {
		return address_type;
	}
	public void setAddress_type(String address_type) {
		this.address_type = address_type;
	}
	public StudentBasicDetail getStudentBasicDetail() {
		return studentBasicDetail;
	}
	public void setStudentBasicDetail(StudentBasicDetail studentBasicDetail) {
		this.studentBasicDetail = studentBasicDetail;
	}
	@Override
	public int compareTo(StudentAddress o) {
		// TODO Auto-generated method stub
		return city.compareTo(o.getCity());
	}

	

}

package spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name="student_medicalinfo")
public class Studentmedicalinfo {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long medicalinto_id;
	private String bloodgroup;
	private String height;
	private String weight;
	private String alergy;
	private String alergy_cause;
	private String alergy_reaction;
	private String alergy_treatment;
	private String visual_difficulty;
	private String heath_condition;
	private String medication;
	private String medical_condition;
	private String doctor_name;
	private String doctor_phone;
	private String doctor_address;
	
	@OneToOne
	@JsonBackReference
	@JoinColumn(name = "student_id")
	StudentBasicDetail studentBasicDetail;
	
	
	
	public StudentBasicDetail getStudentBasicDetail() {
		return studentBasicDetail;
	}
	public void setStudentBasicDetail(StudentBasicDetail studentBasicDetail) {
		this.studentBasicDetail = studentBasicDetail;
	}
	public long getMedicalinto_id() {
		return medicalinto_id;
	}
	public void setMedicalinto_id(long medicalinto_id) {
		this.medicalinto_id = medicalinto_id;
	}
	public String getBloodgroup() {
		return bloodgroup;
	}
	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getAlergy() {
		return alergy;
	}
	public void setAlergy(String alergy) {
		this.alergy = alergy;
	}
	public String getAlergy_cause() {
		return alergy_cause;
	}
	public void setAlergy_cause(String alergy_cause) {
		this.alergy_cause = alergy_cause;
	}
	public String getAlergy_reaction() {
		return alergy_reaction;
	}
	public void setAlergy_reaction(String alergy_reaction) {
		this.alergy_reaction = alergy_reaction;
	}
	public String getAlergy_treatment() {
		return alergy_treatment;
	}
	public void setAlergy_treatment(String alergy_treatment) {
		this.alergy_treatment = alergy_treatment;
	}
	public String getVisual_difficulty() {
		return visual_difficulty;
	}
	public void setVisual_difficulty(String visual_difficulty) {
		this.visual_difficulty = visual_difficulty;
	}
	public String getHeath_condition() {
		return heath_condition;
	}
	public void setHeath_condition(String heath_condition) {
		this.heath_condition = heath_condition;
	}
	public String getMedication() {
		return medication;
	}
	public void setMedication(String medication) {
		this.medication = medication;
	}
	public String getMedical_condition() {
		return medical_condition;
	}
	public void setMedical_condition(String medical_condition) {
		this.medical_condition = medical_condition;
	}
	public String getDoctor_name() {
		return doctor_name;
	}
	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}
	public String getDoctor_phone() {
		return doctor_phone;
	}
	public void setDoctor_phone(String doctor_phone) {
		this.doctor_phone = doctor_phone;
	}
	public String getDoctor_address() {
		return doctor_address;
	}
	public void setDoctor_address(String doctor_address) {
		this.doctor_address = doctor_address;
	}
	
	
	
	
	
	
}

package spring.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name = "classname")
public class ClassName implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4582118614898649551L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "classid")
	private long classid;
	@Column(unique = true, nullable = false)
	private String class_name;
	@Column(unique = true, nullable = false)
	private long class_sequence;
	@OneToMany(fetch = FetchType.LAZY, targetEntity = Section.class, cascade = CascadeType.PERSIST, mappedBy = "classname")
	@JsonManagedReference
	@Fetch(FetchMode.JOIN)
	private Set<Section> sections;

	public long getClassid() {
		return classid;
	}

	public void setClassid(long classid) {
		this.classid = classid;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public Set<Section> getSections() {
		return sections;
	}

	public void setSections(Set<Section> sections) {
		this.sections = sections;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "timestamp", nullable = false, columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
	private Date timestamp = new Date();

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

	public long getClass_sequence() {
		return class_sequence;
	}

	public void setClass_sequence(long class_sequence) {
		this.class_sequence = class_sequence;
	}

}

package com.yenrof.mhvi.model;

import java.io.Serializable;


import java.util.Date;

//import javax.persistence.CascadeType;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
//import javax.xml.bind.annotation.XmlRootElement;


import org.codehaus.jackson.annotate.JsonBackReference;

@Entity
@Table(name = "ContactPhone")
public class ContactPhone implements Serializable {
	/** Default value included to remove warning. Remove or modify at will. **/
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	@Size(min = 1, max = 1, message = "1 letters to define phone type")
	@Pattern(regexp = "[A-Za-z ]*", message = "Only letters")
	private String type;

	@NotNull
	@Size(min = 10, max = 10, message = "10  Numbers")
	@Digits(fraction = 0, integer = 10, message = "Not valid")
	private String info;

	@OneToOne
	@JoinColumn(name = "patientId")
	@JsonBackReference
	private Patient patient;
	
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdateDate;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public void setParent(Patient patient) {
		this.patient = patient;
	}

}

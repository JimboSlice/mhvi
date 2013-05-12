package com.yenrof.mhvi.model;

import java.io.Serializable;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@XmlRootElement
@Table(name = "Address")
public class Address implements Serializable {
	/** Default value included to remove warning. Remove or modify at will. **/
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	@NotEmpty
	@Size(min = 1, max = 20, message = "1-20 letters and spaces")
	@Pattern(regexp = "[A-Za-z ]*", message = "Only letters and spaces")
	private String address1;

	@NotNull
	@NotEmpty
	@Size(min = 1, max = 20, message = "1-20 letters and spaces")
	@Pattern(regexp = "[A-Za-z ]*", message = "Only letters and spaces")
	private String address2;

	@Size(min = 0, max = 30, message = "1-30 letters and spaces")
	@Pattern(regexp = "[A-Za-z ]*", message = "Only letters and spaces")
	private String city;

	@NotNull
	@Size(min = 2, max = 2, message = "2 letters ")
	@Pattern(regexp = "[A-Za-z ]*", message = "Only letters and spaces")
	private String state;

	@NotNull
	@Size(min = 5, max = 5, message = "5 Numbers")
	@Digits(fraction = 0, integer = 8, message = "Not valid")
	@Column(name = "zip1")
	private String zip1;

	@NotNull
	@Size(min = 0, max = 4, message = "4 Numbers")
	@Digits(fraction = 0, integer = 4, message = "Not valid")
	@Column(name = "zip2")
	private String zip2;

	@OneToOne
	@JoinColumn(name = "patientId")
	private Patient patient;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
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

	public String getZip1() {
		return zip1;
	}

	public void setZip1(String zip1) {
		this.zip1 = zip1;
	}

	public String getZip2() {
		return zip2;
	}

	public void setZip2(String zip2) {
		this.zip2 = zip2;
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

	public void setAssociatedPatient(Patient patient) {
		this.patient = patient;
	}

}

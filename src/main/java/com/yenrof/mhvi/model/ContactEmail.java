package com.yenrof.mhvi.model;
import java.io.Serializable;


import javax.persistence.CascadeType;
//import javax.persistence.CascadeType;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@XmlRootElement
@Table(name = "ContactEmail")

public class ContactEmail implements Serializable {
	   /** Default value included to remove warning. Remove or modify at will. **/
	   private static final long serialVersionUID = 1L;
	   
	   @Id
	   @GeneratedValue(strategy=GenerationType.IDENTITY)
	   private long id;
	
	   @NotNull
	   @Size(min = 1, max = 1, message = "1 letters to define email type")
	   @Pattern(regexp = "[A-Za-z ]*", message = "Only letters")
	   private String type;

	   @NotNull
	   @NotEmpty
	   @Email(message = "Invalid format")
	   private String info;
	   
	   @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	   @JoinColumn(name = "patientId" )	    
	   private Patient patient;
	   

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
	
	public void setAssociatedPatient(Patient patient) {
		this.patient = patient;
	}

	
}


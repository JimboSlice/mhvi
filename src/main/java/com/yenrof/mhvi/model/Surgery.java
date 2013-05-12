package com.yenrof.mhvi.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.Date;


/**
 * The persistent class for the Surgeries database table.
 * 
 */
@Entity
@XmlRootElement
@Table(name="Surgery")
@NamedQuery(name="Surgery.findAll", query="SELECT s FROM Surgery s")
public class Surgery implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	 
	private long id;

	private int age;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdateDate;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "medsurgeryhistoryId" )	    	
    	private MedicationSurgeryHistory medicationSurgeryHistory;

	
	
	
	public MedicationSurgeryHistory getMedicationSurgeryHistory() {
		return medicationSurgeryHistory;
	}

	public void setMedicationSurgeryHistory(
			MedicationSurgeryHistory medicationSurgeryHistory) {
		this.medicationSurgeryHistory = medicationSurgeryHistory;
	}

	public Surgery() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getLastUpdateDate() {
		return this.lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}

package com.yenrof.mhvi.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonBackReference;

import java.util.Date;


/**
 * The persistent class for the Medications database table.
 * 
 */
@Entity
@XmlRootElement
@Table(name="Medication")
@NamedQuery(name="Medication.findAll", query="SELECT m FROM Medication m")
public class Medication implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	private int dose;

	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdateDate;

	private String type;

	private String unit;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "medsurgeryhistoryId" )
	@JsonBackReference
	private MedicationSurgeryHistory medicationSurgeryHistory;
	

	public MedicationSurgeryHistory getMedicationSurgeryHistory() {
		return medicationSurgeryHistory;
	}

	public void setMedicationSurgeryHistory(
			MedicationSurgeryHistory medicationSurgeryHistory) {
		this.medicationSurgeryHistory = medicationSurgeryHistory;
	}
	

	public Medication() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getDose() {
		return this.dose;
	}

	public void setDose(int dose) {
		this.dose = dose;
	}

	public Date getLastUpdateDate() {
		return this.lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

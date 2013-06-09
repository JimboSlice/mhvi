package com.yenrof.mhvi.model;

import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the MedicationSurgeryHistory database table.
 * 
 */
@Entity
@Table(name = "MedicationSurgeryHistory")
@NamedQuery(name = "MedicationSurgeryHistory.findAll", query = "SELECT m FROM MedicationSurgeryHistory m")
public class MedicationSurgeryHistory implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private boolean allergies;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	private boolean familyCancer;

	private boolean familyDiabetes;

	private boolean familyHeartDisease;

	private boolean familyHypertension;

	private boolean familyProstateCancer;

	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdateDate;

	@OneToOne
	@JsonBackReference
	@JoinColumn(name = "patientId")
	private Patient patient;

	// one-to-many association to surgeries
	@OneToMany(mappedBy = "medicationSurgeryHistory",fetch=FetchType.EAGER)
	@JsonManagedReference
	private List<Surgery> surgeries;

	// one-to-many association to meds
	@OneToMany(mappedBy = "medicationSurgeryHistory",fetch=FetchType.LAZY)
	@JsonManagedReference
	private List<Medication> medications;

	public MedicationSurgeryHistory() {
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setSurgery(List<Surgery> surgeries) {
		this.surgeries = surgeries;
	}

	public void setMedication(List<Medication> medications) {
		this.medications = medications;
	}

	public long getId() {
		return this.id;
	}

	public boolean getAllergies() {
		return this.allergies;
	}

	public void setAllergies(boolean allergies) {
		this.allergies = allergies;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public boolean getFamilyCancer() {
		return this.familyCancer;
	}

	public void setFamilyCancer(boolean familyCancer) {
		this.familyCancer = familyCancer;
	}

	public boolean getFamilyDiabetes() {
		return this.familyDiabetes;
	}

	public void setFamilyDiabetes(boolean familyDiabetes) {
		this.familyDiabetes = familyDiabetes;
	}

	public boolean getFamilyHeartDisease() {
		return this.familyHeartDisease;
	}

	public void setFamilyHeartDisease(boolean familyHeartDisease) {
		this.familyHeartDisease = familyHeartDisease;
	}

	public boolean getFamilyHypertension() {
		return this.familyHypertension;
	}

	public void setFamilyHypertension(boolean familyHypertension) {
		this.familyHypertension = familyHypertension;
	}

	public boolean getFamilyProstateCancer() {
		return this.familyProstateCancer;
	}

	public void setFamilyProstateCancer(boolean familyProstateCancer) {
		this.familyProstateCancer = familyProstateCancer;
	}

	public Date getLastUpdateDate() {
		return this.lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public List<Surgery> getSurgery() {
		return surgeries;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setParent(Patient patient) {
		this.patient = patient;
	}

	public List<Surgery> getSurgeries() {
		return surgeries;
	}

	public void setSurgeries(List<Surgery> surgeries) {
		this.surgeries = surgeries;
	}

	public List<Medication> getMedications() {
		return medications;
	}

	public void setMedications(List<Medication> medications) {
		this.medications = medications;
	}

}

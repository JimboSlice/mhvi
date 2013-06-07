package com.yenrof.mhvi.model;

import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonBackReference;

import java.util.Date;


/**
 * The persistent class for the PreviousTreatment database table.
 * 
 */
@Entity
@Table(name="PreviousTreatment")
@NamedQuery(name="PreviousTreatment.findAll", query="SELECT p FROM PreviousTreatment p")
public class PreviousTreatment implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private long id;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date createDate;

	@Column(nullable=false)
	private boolean erMedsEffective;

	@Column(nullable=false)
	private boolean injectionEffective;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date lastUpdateDate;

	@Column(nullable=false)
	private boolean likeInjections;

	@Column(nullable=false)
	private boolean likeVacumn;

	@Column(nullable=false)
	private boolean museEffective;

	@Column(nullable=false)
	private boolean triedERMeds;

	@Column(nullable=false)
	private boolean triedInjection;

	@Column(nullable=false)
	private boolean triedMuse;

	@Column(nullable=false)
	private boolean triedOtherTreatment;

	@Column(nullable=false)
	private boolean triedVacumn;

	@Column(nullable=false)
	private boolean vacumnEffective;
	
	@OneToOne
	@JoinColumn(name="patientId")
	@JsonBackReference
	private Patient patient;
	

	public PreviousTreatment() {
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

	public boolean getErMedsEffective() {
		return this.erMedsEffective;
	}

	public void setErMedsEffective(boolean erMedsEffective) {
		this.erMedsEffective = erMedsEffective;
	}

	public boolean getInjectionEffective() {
		return this.injectionEffective;
	}

	public void setInjectionEffective(boolean injectionEffective) {
		this.injectionEffective = injectionEffective;
	}

	public Date getLastUpdateDate() {
		return this.lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public boolean getLikeInjections() {
		return this.likeInjections;
	}

	public void setLikeInjections(boolean likeInjections) {
		this.likeInjections = likeInjections;
	}

	public boolean getLikeVacumn() {
		return this.likeVacumn;
	}

	public void setLikeVacumn(boolean likeVacumn) {
		this.likeVacumn = likeVacumn;
	}

	public boolean getMuseEffective() {
		return this.museEffective;
	}

	public void setMuseEffective(boolean museEffective) {
		this.museEffective = museEffective;
	}

	public boolean getTriedERMeds() {
		return this.triedERMeds;
	}

	public void setTriedERMeds(boolean triedERMeds) {
		this.triedERMeds = triedERMeds;
	}

	public boolean getTriedInjection() {
		return this.triedInjection;
	}

	public void setTriedInjection(boolean triedInjection) {
		this.triedInjection = triedInjection;
	}

	public boolean getTriedMuse() {
		return this.triedMuse;
	}

	public void setTriedMuse(boolean triedMuse) {
		this.triedMuse = triedMuse;
	}

	public boolean getTriedOtherTreatment() {
		return this.triedOtherTreatment;
	}

	public void setTriedOtherTreatment(boolean triedOtherTreatment) {
		this.triedOtherTreatment = triedOtherTreatment;
	}

	public boolean getTriedVacumn() {
		return this.triedVacumn;
	}

	public void setTriedVacumn(boolean triedVacumn) {
		this.triedVacumn = triedVacumn;
	}

	public boolean getVacumnEffective() {
		return this.vacumnEffective;
	}

	public void setVacumnEffective(boolean vacumnEffective) {
		this.vacumnEffective = vacumnEffective;
	}
	
	public void setParent(Patient patient) {
		this.patient = patient;
	}
	
	

}

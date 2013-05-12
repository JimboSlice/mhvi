package com.yenrof.mhvi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;



/**
 * The persistent class for the MedicalHistory database table.
 * 
 */
@Entity
@XmlRootElement
@Table(name = "MedicalHistory")
@NamedQuery(name="MedicalHistory.findAll", query="SELECT m FROM MedicalHistory m")
public class MedicalHistory implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private boolean anxiety;

	private boolean backProblems;

	private boolean blockedLegArteries;

	private boolean chestPain;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	private boolean currentSmoker;

	private boolean depression;

	private boolean diabetes;

	private boolean everSmoked;

	private boolean heartAttack;

	private boolean highCholestrol;

	private boolean hypertension;

	private boolean hypothyroidism;

	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdateDate;

	private boolean lowTestostrone;

	private boolean prostateCancer;

	private boolean prostateCancerEnlargement;

	private boolean prostateCancerRadiation;

	private boolean prostateCancerSurgery;

	private boolean prostateCancerTreatment;

	private boolean stroke;

	@OneToOne
    	@JoinColumn(name="patientId")
    	private Patient patient;

	public MedicalHistory() {
	}
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long long1) {
		this.id = long1;
	}

	public boolean getAnxiety() {
		return this.anxiety;
	}

	public void setAnxiety(boolean anxiety) {
		this.anxiety = anxiety;
	}

	public boolean getBackProblems() {
		return this.backProblems;
	}

	public void setBackProblems(boolean backProblems) {
		this.backProblems = backProblems;
	}

	public boolean getBlockedLegArteries() {
		return this.blockedLegArteries;
	}

	public void setBlockedLegArteries(boolean blockedLegArteries) {
		this.blockedLegArteries = blockedLegArteries;
	}

	public boolean getChestPain() {
		return this.chestPain;
	}

	public void setChestPain(boolean chestPain) {
		this.chestPain = chestPain;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public boolean getCurrentSmoker() {
		return this.currentSmoker;
	}

	public void setCurrentSmoker(boolean currentSmoker) {
		this.currentSmoker = currentSmoker;
	}

	public boolean getDepression() {
		return this.depression;
	}

	public void setDepression(boolean depression) {
		this.depression = depression;
	}

	public boolean getDiabetes() {
		return this.diabetes;
	}

	public void setDiabetes(boolean diabetes) {
		this.diabetes = diabetes;
	}

	public boolean getEverSmoked() {
		return this.everSmoked;
	}

	public void setEverSmoked(boolean everSmoked) {
		this.everSmoked = everSmoked;
	}

	public boolean getHeartAttack() {
		return this.heartAttack;
	}

	public void setHeartAttack(boolean heartAttack) {
		this.heartAttack = heartAttack;
	}

	public boolean getHighCholestrol() {
		return this.highCholestrol;
	}

	public void setHighCholestrol(boolean highCholestrol) {
		this.highCholestrol = highCholestrol;
	}

	public boolean getHypertension() {
		return this.hypertension;
	}

	public void setHypertension(boolean hypertension) {
		this.hypertension = hypertension;
	}

	public boolean getHypothyroidism() {
		return this.hypothyroidism;
	}

	public void setHypothyroidism(boolean hypothyroidism) {
		this.hypothyroidism = hypothyroidism;
	}

	public Date getLastUpdateDate() {
		return this.lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public boolean getLowTestostrone() {
		return this.lowTestostrone;
	}

	public void setLowTestostrone(boolean lowTestostrone) {
		this.lowTestostrone = lowTestostrone;
	}

	public boolean getProstateCancer() {
		return this.prostateCancer;
	}

	public void setProstateCancer(boolean prostateCancer) {
		this.prostateCancer = prostateCancer;
	}

	public boolean getProstateCancerEnlargement() {
		return this.prostateCancerEnlargement;
	}

	public void setProstateCancerEnlargement(boolean prostateCancerEnlargement) {
		this.prostateCancerEnlargement = prostateCancerEnlargement;
	}

	public boolean getProstateCancerRadiation() {
		return this.prostateCancerRadiation;
	}

	public void setProstateCancerRadiation(boolean prostateCancerRadiation) {
		this.prostateCancerRadiation = prostateCancerRadiation;
	}

	public boolean getProstateCancerSurgery() {
		return this.prostateCancerSurgery;
	}

	public void setProstateCancerSurgery(boolean prostateCancerSurgery) {
		this.prostateCancerSurgery = prostateCancerSurgery;
	}

	public boolean getProstateCancerTreatment() {
		return this.prostateCancerTreatment;
	}

	public void setProstateCancerTreatment(boolean prostateCancerTreatment) {
		this.prostateCancerTreatment = prostateCancerTreatment;
	}

	public boolean getStroke() {
		return this.stroke;
	}

	public void setStroke(boolean stroke) {
		this.stroke = stroke;
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

	public void setId(long id) {
		this.id = id;
	}

}

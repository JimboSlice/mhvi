package com.yenrof.mhvi.model;


import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonBackReference;

import java.util.Date;


/**
 * The persistent class for the RiskFactors database table.
 * 
 */
@Entity
@Table(name="RiskFactors")
@NamedQuery(name="RiskFactor.findAll", query="SELECT r FROM RiskFactor r")
public class RiskFactor implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private long id;

	@Column(nullable=false)
	private boolean alcoholIssue;

	@Column(nullable=false)
	private boolean bentPenis;

	@Column(nullable=false)
	private boolean bikeRegularly;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date createDate;

	@Column(nullable=false)
	private boolean currentSmoker;

	@Column(nullable=false)
	private boolean haveSmoked;

	@Column(nullable=false)
	private boolean injuredPenis;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date lastUpdateDate;

	@Column(nullable=false)
	private boolean prostateCancerRadiation;

	@Column(nullable=false)
	private boolean prostateRemovedCancer;

	@Column(nullable=false)
	private boolean spinalCordInjury;

	@Column(nullable=false)
	private boolean straddleInjury;

	@Column(nullable=false)
	private boolean turp;
	
	@OneToOne
	@JoinColumn(name="patientId")
	@JsonBackReference
	private Patient patient;
	

	public RiskFactor() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean getAlcoholIssue() {
		return this.alcoholIssue;
	}

	public void setAlcoholIssue(boolean alcoholIssue) {
		this.alcoholIssue = alcoholIssue;
	}

	public boolean getBentPenis() {
		return this.bentPenis;
	}

	public void setBentPenis(boolean bentPenis) {
		this.bentPenis = bentPenis;
	}

	public boolean getBikeRegularly() {
		return this.bikeRegularly;
	}

	public void setBikeRegularly(boolean bikeRegularly) {
		this.bikeRegularly = bikeRegularly;
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

	public boolean getHaveSmoked() {
		return this.haveSmoked;
	}

	public void setHaveSmoked(boolean haveSmoked) {
		this.haveSmoked = haveSmoked;
	}

	public boolean getInjuredPenis() {
		return this.injuredPenis;
	}

	public void setInjuredPenis(boolean injuredPenis) {
		this.injuredPenis = injuredPenis;
	}

	public Date getLastUpdateDate() {
		return this.lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public boolean getProstateCancerRadiation() {
		return this.prostateCancerRadiation;
	}

	public void setProstateCancerRadiation(boolean prostateCancerRadiation) {
		this.prostateCancerRadiation = prostateCancerRadiation;
	}

	public boolean getProstateRemovedCancer() {
		return this.prostateRemovedCancer;
	}

	public void setProstateRemovedCancer(boolean prostateRemovedCancer) {
		this.prostateRemovedCancer = prostateRemovedCancer;
	}

	public boolean getSpinalCordInjury() {
		return this.spinalCordInjury;
	}

	public void setSpinalCordInjury(boolean spinalCordInjury) {
		this.spinalCordInjury = spinalCordInjury;
	}

	public boolean getStraddleInjury() {
		return this.straddleInjury;
	}

	public void setStraddleInjury(boolean straddleInjury) {
		this.straddleInjury = straddleInjury;
	}

	public boolean getTurp() {
		return this.turp;
	}

	public void setTurp(boolean turp) {
		this.turp = turp;
	}
	
	public void setAssociatedPatient(Patient patient) {
		this.patient = patient;
	}

}
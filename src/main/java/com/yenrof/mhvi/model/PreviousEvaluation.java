package com.yenrof.mhvi.model;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the PreviousEvaluation database table.
 * 
 */
@Entity
@Table(name="PreviousEvaluation")
@NamedQuery(name="PreviousEvaluation.findAll", query="SELECT p FROM PreviousEvaluation p")
public class PreviousEvaluation implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private long id;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date createDate;

	@Column(nullable=false)
	private boolean erSleepTest;

	@Column(nullable=false, length=1)
	private String estResult;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date lastUpdateDate;

	@Column(nullable=false)
	private boolean penileInjection;

	@Column(nullable=false, length=1)
	private String piResult;

	@Column(nullable=false)
	private boolean testosteroneMeasured;

	@Column(nullable=false, length=1)
	private String tlmResult;
	
	@OneToOne
	@JoinColumn(name="patientId")
	 private Patient patient;
	   
	

	public PreviousEvaluation() {
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

	public boolean getErSleepTest() {
		return this.erSleepTest;
	}

	public void setErSleepTest(boolean erSleepTest) {
		this.erSleepTest = erSleepTest;
	}

	public String getEstResult() {
		return this.estResult;
	}

	public void setEstResult(String estResult) {
		this.estResult = estResult;
	}

	public Date getLastUpdateDate() {
		return this.lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public boolean getPenileInjection() {
		return this.penileInjection;
	}

	public void setPenileInjection(boolean penileInjection) {
		this.penileInjection = penileInjection;
	}

	public String getPiResult() {
		return this.piResult;
	}

	public void setPiResult(String piResult) {
		this.piResult = piResult;
	}

	public boolean getTestosteroneMeasured() {
		return this.testosteroneMeasured;
	}

	public void setTestosteroneMeasured(boolean testosteroneMeasured) {
		this.testosteroneMeasured = testosteroneMeasured;
	}

	public String getTlmResult() {
		return this.tlmResult;
	}

	public void setTlmResult(String tlmResult) {
		this.tlmResult = tlmResult;
	}
	
	public void setAssociatedPatient(Patient patient) {	
		this.patient = patient;
	}
	

}
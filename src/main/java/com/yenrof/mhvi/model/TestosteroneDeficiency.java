package com.yenrof.mhvi.model;

import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonBackReference;

import java.util.Date;


/**
 * The persistent class for the TestosteroneDeficiency database table.
 * 
 */
@Entity
@Table(name="TestosteroneDeficiency")
@NamedQuery(name="TestosteroneDeficiency.findAll", query="SELECT t FROM TestosteroneDeficiency t")
public class TestosteroneDeficiency implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private long id;

	@Column(nullable=false)
	private boolean bikeRegularly;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date createDate;

	@Column(nullable=false)
	private boolean currentReplacementTheraphy;

	@Column(nullable=false)
	private boolean decreasedLibido;

	@Column(nullable=false)
	private boolean grumpy;

	@Column(nullable=false)
	private boolean lackOfEnergy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date lastUpdateDate;

	@Column(nullable=false)
	private boolean lessLifeEnjoyment;

	@Column(nullable=false)
	private boolean lostWeight;

	@Column(nullable=false)
	private boolean lowEndurance;

	@Column(nullable=false)
	private boolean poorWorkPerformance;

	@Column(nullable=false)
	private boolean previousReplacementTheraphy;

	@Column(nullable=false)
	private boolean sleepyAfterDinner;

	@Column(nullable=false)
	private boolean sportsActive;

	@Column(nullable=false)
	private boolean weakErections;

	@Column(nullable=false)
	private int weightLossAmt;
	
	@OneToOne
	@JoinColumn(name="patientId")
	@JsonBackReference
	 private Patient patient;
	

	public TestosteroneDeficiency() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
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

	public boolean getCurrentReplacementTheraphy() {
		return this.currentReplacementTheraphy;
	}

	public void setCurrentReplacementTheraphy(boolean currentReplacementTheraphy) {
		this.currentReplacementTheraphy = currentReplacementTheraphy;
	}

	public boolean getDecreasedLibido() {
		return this.decreasedLibido;
	}

	public void setDecreasedLibido(boolean decreasedLibido) {
		this.decreasedLibido = decreasedLibido;
	}

	public boolean getGrumpy() {
		return this.grumpy;
	}

	public void setGrumpy(boolean grumpy) {
		this.grumpy = grumpy;
	}

	public boolean getLackOfEnergy() {
		return this.lackOfEnergy;
	}

	public void setLackOfEnergy(boolean lackOfEnergy) {
		this.lackOfEnergy = lackOfEnergy;
	}

	public Date getLastUpdateDate() {
		return this.lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public boolean getLessLifeEnjoyment() {
		return this.lessLifeEnjoyment;
	}

	public void setLessLifeEnjoyment(boolean lessLifeEnjoyment) {
		this.lessLifeEnjoyment = lessLifeEnjoyment;
	}

	public boolean getLostWeight() {
		return this.lostWeight;
	}

	public void setLostWeight(boolean lostWeight) {
		this.lostWeight = lostWeight;
	}

	public boolean getLowEndurance() {
		return this.lowEndurance;
	}

	public void setLowEndurance(boolean lowEndurance) {
		this.lowEndurance = lowEndurance;
	}

	public boolean getPoorWorkPerformance() {
		return this.poorWorkPerformance;
	}

	public void setPoorWorkPerformance(boolean poorWorkPerformance) {
		this.poorWorkPerformance = poorWorkPerformance;
	}

	public boolean getPreviousReplacementTheraphy() {
		return this.previousReplacementTheraphy;
	}

	public void setPreviousReplacementTheraphy(boolean previousReplacementTheraphy) {
		this.previousReplacementTheraphy = previousReplacementTheraphy;
	}

	public boolean getSleepyAfterDinner() {
		return this.sleepyAfterDinner;
	}

	public void setSleepyAfterDinner(boolean sleepyAfterDinner) {
		this.sleepyAfterDinner = sleepyAfterDinner;
	}

	public boolean getSportsActive() {
		return this.sportsActive;
	}

	public void setSportsActive(boolean sportsActive) {
		this.sportsActive = sportsActive;
	}

	public boolean getWeakErections() {
		return this.weakErections;
	}

	public void setWeakErections(boolean weakErections) {
		this.weakErections = weakErections;
	}

	public int getWeightLossAmt() {
		return this.weightLossAmt;
	}

	public void setWeightLossAmt(int weightLossAmt) {
		this.weightLossAmt = weightLossAmt;
	}
	
	public void setAssociatedPatient(Patient patient) {
		this.patient = patient;
	}

}
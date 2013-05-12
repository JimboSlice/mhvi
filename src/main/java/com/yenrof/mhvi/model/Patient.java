package com.yenrof.mhvi.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//import javax.persistence.CascadeType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@XmlRootElement
@Table(name = "Patient", uniqueConstraints = @UniqueConstraint(columnNames = "ssn"))
public class Patient implements Serializable {
	/** Default value included to remove warning. Remove or modify at will. **/
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	@NotEmpty
	@Size(min = 1, max = 30, message = "Last Name must be 1-30 letters and spaces")
	@Pattern(regexp = "[A-Za-z ]*", message = "Last Name can contain only letters and spaces")
	private String lastName;

	@NotNull
	@NotEmpty
	@Size(min = 1, max = 20, message = "First Name must be 1-20 letters and spaces")
	@Pattern(regexp = "[A-Za-z ]*", message = "First Name can contain only letters and spaces")
	private String firstName;

	@Size(min = 0, max = 1, message = "Middle Name can be 0-1 letters and spaces")
	@Pattern(regexp = "[A-Za-z ]*", message = "Only letters and spaces")
	private String middleName;

	@NotNull
	@Size(min = 9, max = 9, message = "SSN must be 9 Numbers")
	@Digits(integer = 9, fraction = 0, message = "Not a valid SSN ")
	@Column(name = "ssn")
	private String ssn;

	private int bmi;

	private int bpDiastolic;

	private int bpSystolic;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	@Temporal(TemporalType.DATE)
	private Date dob;

	private int heightFeet;

	private int heightInches;

	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdateDate;

	private String primaryPhysicianName;

	private String race;

	private String referringPhysicianName;

	private String referringPhysicianSpecialty;

	// bi-directional one-to-one association to MedicalHistory
	@OneToOne(mappedBy = "patient", cascade=CascadeType.ALL)
	private MedicalHistory medicalHistory;

	// bi-directional one-to-one association to MedicationSurgeryHistory
	@OneToOne(mappedBy = "patient", cascade=CascadeType.ALL)
	private MedicationSurgeryHistory medicationSurgeryHistory;

	// bi-directional one-to-one association to SexualHistory
	@OneToOne(mappedBy = "patient", cascade=CascadeType.ALL)
	private SexualHistory sexualHistory;

	// bi-directional one-to-one association to Address
	@OneToOne(mappedBy = "patient", cascade=CascadeType.ALL)
	private Address address;

	// bi-directional one-to-one association to PreviousTreatment
	@OneToOne(mappedBy = "patient", cascade=CascadeType.ALL)
	private PreviousTreatment previousTreatment;

	// bi-directional one-to-one association to PreviousEvaluation
	@OneToOne(mappedBy = "patient", cascade=CascadeType.ALL)
	private PreviousEvaluation previousEvaluation;

	// bi-directional one-to-one association to RiskFactor
	@OneToOne(mappedBy = "patient", cascade=CascadeType.ALL)
	private RiskFactor riskFactor;

	// bi-directional one-to-one association to TestosteroneDeficiency
	@OneToOne(mappedBy = "patient", cascade=CascadeType.ALL)
	private TestosteroneDeficiency testosteroneDeficiency;

	@OneToMany(mappedBy = "patient", cascade=CascadeType.ALL)
	// we need to duplicate the physical information
	private List<ContactEmail> contactEmails = new ArrayList<ContactEmail>(); // bi-directional
																				// one-to-many
																				// association
																				// to
																				// ContactEmail

	@OneToMany(mappedBy = "patient", cascade=CascadeType.ALL)
	// we need to duplicate the physical information
	private List<ContactPhone> contactPhones = new ArrayList<ContactPhone>();// bi-directional
																				// one-to-many
																				// association
																				// to
																				// ContactPhone

	public int getBmi() {
		return bmi;
	}

	public void setBmi(int bmi) {
		this.bmi = bmi;
	}

	public int getBpDiastolic() {
		return bpDiastolic;
	}

	public void setBpDiastolic(int bpDiastolic) {
		this.bpDiastolic = bpDiastolic;
	}

	public int getBpSystolic() {
		return bpSystolic;
	}

	public void setBpSystolic(int bpSystolic) {
		this.bpSystolic = bpSystolic;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public int getHeightFeet() {
		return heightFeet;
	}

	public void setHeightFeet(int heightFeet) {
		this.heightFeet = heightFeet;
	}

	public int getHeightInches() {
		return heightInches;
	}

	public void setHeightInches(int heightInches) {
		this.heightInches = heightInches;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getPrimaryPhysicianName() {
		return primaryPhysicianName;
	}

	public void setPrimaryPhysicianName(String primaryPhysicianName) {
		this.primaryPhysicianName = primaryPhysicianName;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getReferringPhysicianName() {
		return referringPhysicianName;
	}

	public void setReferringPhysicianName(String referringPhysicianName) {
		this.referringPhysicianName = referringPhysicianName;
	}

	public String getReferringPhysicianSpecialty() {
		return referringPhysicianSpecialty;
	}

	public void setReferringPhysicianSpecialty(
			String referringPhysicianSpecialty) {
		this.referringPhysicianSpecialty = referringPhysicianSpecialty;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	private int weight;

	public MedicalHistory getMedicalHistory() {
		return medicalHistory;
	}

	public void setMedicalHistory(MedicalHistory medicalHistory) {
		this.medicalHistory = medicalHistory;
	}

	public MedicationSurgeryHistory getMedicationSurgeryHistory() {
		return medicationSurgeryHistory;
	}

	public void setMedicationSurgeryHistory(
			MedicationSurgeryHistory medicationSurgeryHistory) {
		this.medicationSurgeryHistory = medicationSurgeryHistory;
	}

	public SexualHistory getSexualHistory() {
		return sexualHistory;
	}

	public void setSexualHistory(SexualHistory sexualHistory) {
		this.sexualHistory = sexualHistory;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<ContactEmail> getContactEmail() {
		return contactEmails;
	}

	public List<ContactPhone> getContactPhone() {
		return contactPhones;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void addContactPhone(ContactPhone contactPhone) {
		contactPhone.setAssociatedPatient(this);
		this.contactPhones.add(contactPhone);
	}

	public void addContactEmail(ContactEmail contactEmail) {
		contactEmail.setAssociatedPatient(this);
		this.contactEmails.add(contactEmail);
	}

	public void addAddress(Address address) {
		address.setAssociatedPatient(this);
		// this.addresses.add(address);
		this.address = address;
	}

	public PreviousTreatment getPreviousTreatment() {
		return previousTreatment;
	}

	public void setPreviousTreatment(PreviousTreatment previousTreatment) {
		previousTreatment.setAssociatedPatient(this);
		this.previousTreatment = previousTreatment;
	}

	public PreviousEvaluation getPreviousEvaluation() {
		return previousEvaluation;
	}

	public void setPreviousEvaluation(PreviousEvaluation previousEvaluation) {
		previousEvaluation.setAssociatedPatient(this);
		this.previousEvaluation = previousEvaluation;
	}

	public RiskFactor getRiskFactor() {
		return riskFactor;
	}

	public void setRiskFactor(RiskFactor riskFactor) {
		riskFactor.setAssociatedPatient(this);
		this.riskFactor = riskFactor;
	}

	public TestosteroneDeficiency getTestosteroneDeficiency() {
		return testosteroneDeficiency;
	}

	public void setTestosteroneDeficiency(
			TestosteroneDeficiency testosteroneDeficiency) {
		testosteroneDeficiency.setAssociatedPatient(this);
		this.testosteroneDeficiency = testosteroneDeficiency;
	}

	public List<ContactEmail> getContactEmails() {
		return contactEmails;
	}

	public void setContactEmails(List<ContactEmail> contactEmails) {
		this.contactEmails = contactEmails;
	}

	public List<ContactPhone> getContactPhones() {
		return contactPhones;
	}

	public void setContactPhones(List<ContactPhone> contactPhones) {
		this.contactPhones = contactPhones;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}

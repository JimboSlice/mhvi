package com.yenrof.mhvi.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonBackReference;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the SexualHistory database table.
 * 
 */
@Entity
@XmlRootElement
@Table(name = "SexualHistory")
@NamedQuery(name="SexualHistory.findAll", query="SELECT s FROM SexualHistory s")
public class SexualHistory implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	private boolean depression;

	private boolean erectileDysfunction;

	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdateDate;

	private boolean lowTestostrone;

	private boolean malfunctionProsthesis;

	private boolean normalEjaculation;

	private boolean orgasm;

	private boolean pain;

	private boolean penileCurvature;

	private boolean prematureEjaculation;

	private boolean sleepy;

	private boolean snore;
	
	@OneToOne
    	@JoinColumn(name="patientId")
	@JsonBackReference
    	private Patient patient;

	//one-to-many association to sixmonthhistory
    	@OneToMany(mappedBy="sexualHistory")
   	private List<SixMonthHistory> sixMonthHistories;

	public SexualHistory() {
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

	public boolean getDepression() {
		return this.depression;
	}

	public void setDepression(boolean depression) {
		this.depression = depression;
	}

	public boolean getErectileDysfunction() {
		return this.erectileDysfunction;
	}

	public void setErectileDysfunction(boolean erectileDysfunction) {
		this.erectileDysfunction = erectileDysfunction;
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

	public boolean getMalfunctionProsthesis() {
		return this.malfunctionProsthesis;
	}

	public void setMalfunctionProsthesis(boolean malfunctionProsthesis) {
		this.malfunctionProsthesis = malfunctionProsthesis;
	}

	public boolean getNormalEjaculation() {
		return this.normalEjaculation;
	}

	public void setNormalEjaculation(boolean normalEjaculation) {
		this.normalEjaculation = normalEjaculation;
	}

	public boolean getOrgasm() {
		return this.orgasm;
	}

	public void setOrgasm(boolean orgasm) {
		this.orgasm = orgasm;
	}

	public boolean getPain() {
		return this.pain;
	}

	public void setPain(boolean pain) {
		this.pain = pain;
	}

	public boolean getPenileCurvature() {
		return this.penileCurvature;
	}

	public void setPenileCurvature(boolean penileCurvature) {
		this.penileCurvature = penileCurvature;
	}

	public boolean getPrematureEjaculation() {
		return this.prematureEjaculation;
	}

	public void setPrematureEjaculation(boolean prematureEjaculation) {
		this.prematureEjaculation = prematureEjaculation;
	}

	public boolean getSleepy() {
		return this.sleepy;
	}

	public void setSleepy(boolean sleepy) {
		this.sleepy = sleepy;
	}

	public boolean getSnore() {
		return this.snore;
	}

	public void setSnore(boolean snore) {
		this.snore = snore;
	}

	public List<SixMonthHistory> getSixMonthHistories() {
		return this.sixMonthHistories;
	}

	public void setSixMonthHistories(List<SixMonthHistory> sixMonthHistories) {
		this.sixMonthHistories = sixMonthHistories;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}

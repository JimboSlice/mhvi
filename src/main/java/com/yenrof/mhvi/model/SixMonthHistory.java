package com.yenrof.mhvi.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonBackReference;

import java.util.Date;


/**
 * The persistent class for the SixMonthHistory database table.
 * 
 */
@Entity
@XmlRootElement
@Table(name="SixMonthHistory")
@NamedQuery(name="SixMonthHistory.findAll", query="SELECT s FROM SixMonthHistory s")
public class SixMonthHistory implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	private int difficulty;

	private int effectiveErection;

	private int erectionConfidence;

	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdateDate;

	private int maintainErection;

	private int satisfaction;
	
	public SexualHistory getSexualHistory() {
		return sexualHistory;
	}

	public void setSexualHistory(SexualHistory sexualHistory) {
		this.sexualHistory = sexualHistory;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "sexualHistoryId" )
	@JsonBackReference
    private SexualHistory sexualHistory;


	public SixMonthHistory() {
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

	public int getDifficulty() {
		return this.difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public int getEffectiveErection() {
		return this.effectiveErection;
	}

	public void setEffectiveErection(int effectiveErection) {
		this.effectiveErection = effectiveErection;
	}

	public int getErectionConfidence() {
		return this.erectionConfidence;
	}

	public void setErectionConfidence(int erectionConfidence) {
		this.erectionConfidence = erectionConfidence;
	}

	public Date getLastUpdateDate() {
		return this.lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public int getMaintainErection() {
		return this.maintainErection;
	}

	public void setMaintainErection(int maintainErection) {
		this.maintainErection = maintainErection;
	}

	public int getSatisfaction() {
		return this.satisfaction;
	}

	public void setSatisfaction(int satisfaction) {
		this.satisfaction = satisfaction;
	}
	
	public void setParent(SexualHistory sexualHistory) {
		this.sexualHistory = sexualHistory;
	}

	

}

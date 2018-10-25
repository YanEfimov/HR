package com.mycom.entity;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class Interview {
	public static final String TABLE_NAME = "interview";
	public static final String ID_COLUMN = "id";
	public static final String FACTDATE_COLUMN = "factDate";
	public static final String PLANDATE_COLUMN = "planDate";
	public static final String IDVACANCY_COLUMN = "idVacancy";
	public static final String IDCANDIDATE_COLUMN = "idCandidate";
	public static final String NAME_CLOUMN = "name";
	
	
	private long id;
	@NotNull @Past
	private Date factDate;
	@NotNull @Past
	private Date planDate;
	private long idVacancy;
	private long idCandidate;
	@Size(min=8)
	private String name;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getIdVacancy() {
		return idVacancy;
	}
	public void setIdVacancy(long idVacancy) {
		this.idVacancy = idVacancy;
	}
	public long getIdCandidate() {
		return idCandidate;
	}
	public void setIdCandidate(long idCandidate) {
		this.idCandidate = idCandidate;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getFactDate() {
		return factDate;
	}
	public void setFactDate(Date factDate) {
		this.factDate = factDate;
	}
	public Date getPlanDate() {
		return planDate;
	}
	public void setPlanDate(Date planDate) {
		this.planDate = planDate;
	}
	
	
}

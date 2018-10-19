package com.mycom.entity;

public class Vacancy {
	public static final String TABLE_NAME = "vacancy";
	public static final String ID_COLUMN = "id";
	public static final String SALARYTO_COLUMN = "salaryto";
	public static final String SALARYFROM_COLUMN = "salaryfrom";
	public static final String EXPERIENCEYEARREQUIRE_COLUMN = "experienceYearRequire";
	public static final String POSITION_COLUMN = "position";
	public static final String IDDEVELOPER = "idDeveloper";
	
	private long id;
	private double salaryto;
	private double salaryfrom;
	private double experienceYearRequire;
	private String position;
	private long idDeveloper;
	
	
	public long getIdDeveloper() {
		return idDeveloper;
	}
	public void setIdDeveloper(long idDeveloper) {
		this.idDeveloper = idDeveloper;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getSalaryto() {
		return salaryto;
	}
	public void setSalaryto(double salaryto) {
		this.salaryto = salaryto;
	}
	public double getSalaryfrom() {
		return salaryfrom;
	}
	public void setSalaryfrom(double salaryfrom) {
		this.salaryfrom = salaryfrom;
	}
	public double getExperienceYearRequire() {
		return experienceYearRequire;
	}
	public void setExperienceYearRequire(double experienceYearRequire) {
		this.experienceYearRequire = experienceYearRequire;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
}

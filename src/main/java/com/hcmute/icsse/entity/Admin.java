package com.hcmute.icsse.entity;

import java.io.File;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.hcmute.icsse.CloudStorageOwner;


@Entity
@Table(name="admins")
public class Admin implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="admid")
	private int admId;
	@Column(name="admname")
	private String admName;
	@Column(name="admphone")
	private String admPhone;
	@Column(name="admwork")
	private String admWork;
	@Column(name="admjob")
	private String admJob;
	@Column(name="admimg")
	private String admImg;
	@Column(name="admimgname")
	private String admImgName;
	@Column(name="admaccount")
	private String admAccount;
	@Column(name="admpass")
	private String admPass;
	@OneToMany(mappedBy="admin", cascade=CascadeType.ALL)
	private Set<News> newsSet;
	
	public Admin() {
		
	}

	public int getAdmId() {
		return admId;
	}

	public void setAdmId(int admId) {
		this.admId = admId;
	}

	public String getAdmName() {
		return admName;
	}

	public void setAdmName(String admName) {
		this.admName = admName;
	}

	public String getAdmPhone() {
		return admPhone;
	}

	public void setAdmPhone(String admPhone) {
		this.admPhone = admPhone;
	}

	public String getAdmWork() {
		return admWork;
	}

	public void setAdmWork(String admWork) {
		this.admWork = admWork;
	}

	public String getAdmJob() {
		return admJob;
	}

	public void setAdmJob(String admJob) {
		this.admJob = admJob;
	}
	
	public String getAdmImg() {
		return admImg;
	}

	public void setAdmImg(String admImg) {
		this.admImg = admImg;
	}

	public String getAdmImgName() {
		return admImgName;
	}

	public void setAdmImgName(String admImgName) {
		this.admImgName = admImgName;
	}

	public String getAdmAccount() {
		return admAccount;
	}

	public void setAdmAccount(String admAccount) {
		this.admAccount = admAccount;
	}

	public String getAdmPass() {
		return admPass;
	}

	public void setAdmPass(String admPass) {
		this.admPass = admPass;
	}

	public Set<News> getNewsSet() {
		return newsSet;
	}

	public void setNewsSet(Set<News> newsSet) {
		this.newsSet = newsSet;
	}	
}

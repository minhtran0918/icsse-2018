package com.hcmute.icsse.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.hcmute.icsse.ApplicationConfig;

@Entity
@Table(name="news")
public class News implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="newsid")
	private int newsId;
	@Column(name="newstitle")
	private String newsTitle;
	@Column(name="newscontent")
	private String newsContent;
	@Column(name="newstime")
	private Date newsTime;
	@Column(name="newsfolderid")
	private String newsFolderId;
	@ManyToOne
	@JoinColumn(name="admid")
	private Admin admin;
	
	public News() {
		
	}

	public int getNewsId() {
		return newsId;
	}

	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}
	
	public String getNewsContent() {
		return newsContent;
	}

	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}
	
	public Date getNewsTime() {
		return newsTime;
	}

	public void setNewsTime(Date newsTime) {
		this.newsTime = newsTime;
	}
	
	public String getDateString() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		return formatter.format(newsTime);
	}

	public String getNewsFolderId() {
		return newsFolderId;
	}

	public void setNewsFolderId(String newsFolderId) {
		this.newsFolderId = newsFolderId;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	public String getLink() {
		return ApplicationConfig.NEWS_ROOT_URL + this.newsFolderId;
	}
}

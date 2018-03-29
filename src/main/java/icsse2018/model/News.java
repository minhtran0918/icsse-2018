package icsse2018.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="news")
public class News {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String content;
	private String image;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	private int groupnewsid;
	public News() {}
	public News(int id, String name, String content, String image, Date date, int groupnewsid) {
		super();
		this.id = id;
		this.name = name;
		this.content = content;
		this.image = image;
		this.date = date;
		this.groupnewsid = groupnewsid;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getGroupnewsid() {
		return groupnewsid;
	}
	public void setGroupnewsid(int groupnewsid) {
		this.groupnewsid = groupnewsid;
	}

	@Override
	public String toString() {
		return "News [id=" + id + ", name=" + name + ", content=" + content + ", image=" + image + ", date=" + date
				+ ", groupnewsid=" + groupnewsid + "]";
	}

	
}

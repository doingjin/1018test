package model.post;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class PostVO {
	/*
	 PNUM INT PRIMARY KEY,			
	TITLE VARCHAR(30),
	MID VARCHAR(10),
	CONTENT VARCHAR(1000),
	PDATE DATE DEFAULT SYSDATE 
	 */
	private int pnum;
	private String title;
	private String mid;
	private String content;
	private Date pdate;
	private MultipartFile img;
	private String imgname;
	
	public String getImgname() {
		return imgname;
	}
	public void setImgname(String imgname) {
		this.imgname = imgname;
	}
	public MultipartFile getImg() {
		return img;
	}
	public void setImg(MultipartFile img) {
		this.img = img;
	}
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getPdate() {
		return pdate;
	}
	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}
	@Override
	public String toString() {
		return "PostVO [" + pnum + ". title: " + title + ", mid: " + mid + ", content: " + content + ", pdate: "
				+ pdate + "]";
	}
	
	
	
}

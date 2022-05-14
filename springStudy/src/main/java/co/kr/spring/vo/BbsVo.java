package co.kr.spring.vo;

public class BbsVo {
	private int seq=0;
	private String title="";
	private String contents="";
	private String writer="";
	private String regDate="";
	//댓글
	private int comSeq=0;
	private String comWriter="";
	private String comContents="";
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public int getComSeq() {
		return comSeq;
	}
	public void setComSeq(int comSeq) {
		this.comSeq = comSeq;
	}
	public String getComWriter() {
		return comWriter;
	}
	public void setComWriter(String comWriter) {
		this.comWriter = comWriter;
	}
	public String getComContents() {
		return comContents;
	}
	public void setComContents(String comContent) {
		this.comContents = comContent;
	}
	
	
}

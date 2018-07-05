package com.prac.boardprac.basic3board;

import com.prac.boardprac.common.commonUtil;

public class Board3VO {
	private String brdno;
	private String brdtitle;
	private String brdwriter;
	private String brdmemo;
	private String brddate;
	private String brdhit;
	private String brddeleteflag;
	
	public Board3VO() {
		
	}

	public Board3VO(String brdno, String brdtitle, String brdwriter, String brdmemo, String brddate, String brdhit,
			String brddeleteflag) {
		super();
		this.brdno = brdno;
		this.brdtitle = brdtitle;
		this.brdwriter = brdwriter;
		this.brdmemo = brdmemo;
		this.brddate = brddate;
		this.brdhit = brdhit;
		this.brddeleteflag = brddeleteflag;
	}
	
	public String getShortTitle(Integer len) {
		return commonUtil.getShortString(brdtitle, len);
	}
	
	public String getBrdno() {
		return brdno;
	}

	public void setBrdno(String brdno) {
		this.brdno = brdno;
	}

	public String getBrdtitle() {
		return brdtitle;
	}

	public void setBrdtitle(String brdtitle) {
		this.brdtitle = brdtitle;
	}

	public String getBrdwriter() {
		return brdwriter;
	}

	public void setBrdwriter(String brdwriter) {
		this.brdwriter = brdwriter;
	}

	public String getBrdmemo() {
		return brdmemo;
	}

	public void setBrdmemo(String brdmemo) {
		this.brdmemo = brdmemo;
	}

	public String getBrddate() {
		return brddate;
	}

	public void setBrddate(String brddate) {
		this.brddate = brddate;
	}

	public String getBrdhit() {
		return brdhit;
	}

	public void setBrdhit(String brdhit) {
		this.brdhit = brdhit;
	}

	public String getBrddeleteflag() {
		return brddeleteflag;
	}

	public void setBrddeleteflag(String brddeleteflag) {
		this.brddeleteflag = brddeleteflag;
	}
	
	
}

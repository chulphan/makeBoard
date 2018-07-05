package com.prac.boardprac.common;

public class SearchVO extends PageVO {
	private String bgno;
	private String searchKeyword = "";
	private String searchType = "";
	private String[] searchTypeArr;
	
	public SearchVO() {
		
	}

	public SearchVO(String bgno, String searchKeyword, String searchType, String[] searchTypeArr) {
		super();
		this.bgno = bgno;
		this.searchKeyword = searchKeyword;
		this.searchType = searchType;
		this.searchTypeArr = searchTypeArr;
	}

	public String getBgno() {
		return bgno;
	}

	public void setBgno(String bgno) {
		this.bgno = bgno;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String[] getSearchTypeArr() {
		return searchType.split(",");
	}

	public void setSearchTypeArr(String[] searchTypeArr) {
		this.searchTypeArr = searchTypeArr;
	}
	
	
}

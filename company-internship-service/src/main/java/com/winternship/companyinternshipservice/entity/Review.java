package com.winternship.companyinternshipservice.entity;

public class Review {

	private long id;
	private long companyId;
	private String goodReview;
	private String badReview;
	private String recentReview;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}
	public String getGoodReview() {
		return goodReview;
	}
	public void setGoodReview(String goodReview) {
		this.goodReview = goodReview;
	}
	public String getBadReview() {
		return badReview;
	}
	public void setBadReview(String badReview) {
		this.badReview = badReview;
	}
	public String getRecentReview() {
		return recentReview;
	}
	public void setRecentReview(String recentReview) {
		this.recentReview = recentReview;
	}
	
}

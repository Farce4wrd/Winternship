package com.winternship.companyreviewservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table
public class Review {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="REVIEW_ID")
	private long id;
	@Column(name="COMPANY_ID")
	private long companyId;
	@Column(name="GOOD_REVIEW")
	@Lob
	private String goodReview;
	@Column(name="BAD_REVIEW")
	@Lob
	private String badReview;
	@Column(name="RECENT_REVIEW")
	@Lob
	private String recentReview;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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

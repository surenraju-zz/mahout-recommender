package org.apache.mahout.examples.recommendation;

import java.util.Date;

public class Promotion {


	private String id;

	private Integer promotionPkey;

	private Integer addressPkey;

	private String promotionType;

	private String promotionCategory;

	private String feedType;

	private String promotionMessage;

	private String externalPromotionID;

	private String street;

	private String city;

	private String state;

	private String country;

	private String postalCode;

	private String phoneNumber;

	private Date startDate;

	private Date endDate;

	private String promoterName;

	private Double latitude;

	private Double longitude;

	public String getPromotionType() {
		return promotionType;
	}

	public void setPromotionType(String promotionType) {
		this.promotionType = promotionType;
	}

	public String getPromotionCategory() {
		return promotionCategory;
	}

	public void setPromotionCategory(String promotionCategory) {
		this.promotionCategory = promotionCategory;
	}

	public String getFeedType() {
		return feedType;
	}

	public void setFeedType(String feedType) {
		this.feedType = feedType;
	}

	public String getPromotionMessage() {
		return promotionMessage;
	}

	public void setPromotionMessage(String promotionMessage) {
		this.promotionMessage = promotionMessage;
	}

	public String getExternalPromotionID() {
		return externalPromotionID;
	}

	public void setExternalPromotionID(String externalPromotionID) {
		this.externalPromotionID = externalPromotionID;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getPromotionPkey() {
		return promotionPkey;
	}

	public void setPromotionPkey(Integer promotionPkey) {
		this.promotionPkey = promotionPkey;
	}

	public Integer getAddressPkey() {
		return addressPkey;
	}

	public void setAddressPkey(Integer addressPkey) {
		this.addressPkey = addressPkey;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getPromoterName() {
		return promoterName;
	}

	public void setPromoterName(String promoterName) {
		this.promoterName = promoterName;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
}

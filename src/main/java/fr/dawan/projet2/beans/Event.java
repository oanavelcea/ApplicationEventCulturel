package fr.dawan.projet2.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Event implements Serializable{

	private double latitude;
	private double longitude;
	private String lang;
	private String city;
	private int uid;
	private String placename;
	private String pricingInfo;
	private String image;
	private Date dateStart;
	private Date updatedAt;
	private String spaceTimeInfo;
	private String department;
	private String link;
	private String title;
	private String address;
	private List<String> timeTable;
	private String imageThumb;
	private String region;
	private Date dateEnd;
	private List<String> tags;
	private String description;
	
	public Event() {
		tags = new ArrayList<String>();
		timeTable = new ArrayList<String>();
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getPlacename() {
		return placename;
	}

	public void setPlacename(String placename) {
		this.placename = placename;
	}

	public String getPricingInfo() {
		return pricingInfo;
	}

	public void setPricingInfo(String pricingInfo) {
		this.pricingInfo = pricingInfo;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<String> getTimeTable() {
		return timeTable;
	}

	public void setTimeTable(List<String> timetable) {
		this.timeTable = timetable;
	}

	
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSpaceTimeInfo() {
		return spaceTimeInfo;
	}

	public void setSpaceTimeInfo(String spaceTimeInfo) {
		this.spaceTimeInfo = spaceTimeInfo;
	}

	public String getImageThumb() {
		return imageThumb;
	}

	public void setImageThumb(String imageThumb) {
		this.imageThumb = imageThumb;
	}
	
	
	
	
}

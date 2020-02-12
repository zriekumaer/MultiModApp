package com.ust.invoice.entity;
import javax.persistence.*;

import com.ust.common.entity.CommonEntity;

@Entity
@Table(name = "clients")
public class Client extends CommonEntity {

	@Column(name = "name", nullable = false)
    private String name;
	@Column(name = "street", nullable = false)
    private String street;
	@Column(name = "postcode", nullable = false)
    private String postcode;
	@Column(name = "city", nullable = false)
    private String city;
	@Column(name = "nip", nullable = false)
    private String nip;
	@Column(name = "phone", nullable = false)
    private String phone;
	@Column(name = "email", nullable = false)
    private String email;
	@Column(name = "website", nullable = false)
    private String website;
	@Column(name = "comment", nullable = false)
    private String comment;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getNip() {
		return nip;
	}
	public void setNip(String nip) {
		this.nip = nip;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}
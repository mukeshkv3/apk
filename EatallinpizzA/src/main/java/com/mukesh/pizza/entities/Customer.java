package com.mukesh.pizza.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.mukesh.pizza.util.StringPrefixedSequenceIdGenerator;

@Entity
@DynamicUpdate
@DynamicInsert
@Table(name="customer")
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "cu_seq")
	@GenericGenerator(name = "cu_seq", 
	        strategy = "com.mukesh.pizza.util.StringPrefixedSequenceIdGenerator", 
	        parameters = {
	        		@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
	        		 @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "CU_"),
	        		 @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d")})

	@Column(length=20)
	private String cuid;
	@Column (length=10, nullable=false,unique=true)
	private String cname;
	@Column(length=10, nullable=false)
	private String pass;
	@Column(length=10,unique=true)
	private long mobile;
	@Column(length=25,unique=true)
	private String email;
	@Column(length=20)
	private String address;
	private int pincode;
	@Column (length=10, columnDefinition="varchar(10) default 'India'", updatable=false, insertable=false)
	private String country;
	@Column (length=16, nullable=false,unique=true)
	private String creditcard;
	public String getCuid() {
		return cuid;
	}
	public void setCuid(String cuid) {
		this.cuid = cuid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCreditcard() {
		return creditcard;
	}
	public void setCreditcard(String creditcard) {
		this.creditcard = creditcard;
	}
	
	
	
}


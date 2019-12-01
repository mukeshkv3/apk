package com.mukesh.pizza.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.mukesh.pizza.util.StringPrefixedSequenceIdGenerator;


@Entity
@Table(name="addon")
public class AddOn {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "use_seq")
	@GenericGenerator(name = "use_seq", 
	        strategy = "com.mukesh.pizza.util.StringPrefixedSequenceIdGenerator", 
	        parameters = {
	        		@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
	        		 @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "TO_"),
	        		 @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d")})

	@Column(length=20)
	private String adid;
		
	@Column (length=15, nullable=false)
	private String adname;
	
	@Column (length=10, nullable=false)
	private String adOnType;
	
	private int cost;
	
	private int quantity;
	
	@ManyToOne
	@JoinColumn(name="fid")
	private Food food;

	public String getAdid() {
		return adid;
	}

	public void setAdid(String adid) {
		this.adid = adid;
	}

	public String getAdname() {
		return adname;
	}

	public void setAdname(String adname) {
		this.adname = adname;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public String getAdOnType() {
		return adOnType;
	}

	public void setAdOnType(String adOnType) {
		this.adOnType = adOnType;
	}

	
	
	
}

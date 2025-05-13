package com.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@Data
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = ("Cus_id"))
	@SequenceGenerator(name="Cus_id",initialValue =1,allocationSize = 1 )
	 private int cus_id;
	private String Cus_name;
	private long contact;
	private LocalDate pickupDate;
	private LocalDate receivedDate;
	
	@OneToOne
	
	private Car cid;

	public int getCus_id() {
		return cus_id;
	}

	public void setCus_id(int cus_id) {
		this.cus_id = cus_id;
	}

	public String getCus_name() {
		return Cus_name;
	}

	public void setCus_name(String cus_name) {
		Cus_name = cus_name;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public LocalDate getPickupDate() {
		return pickupDate;
	}

	public void setPickupDate(LocalDate pickupDate) {
		this.pickupDate = pickupDate;
	}

	public LocalDate getReceivedDate() {
		return receivedDate;
	}

	public void setReceivedDate(LocalDate receivedDate) {
		this.receivedDate = receivedDate;
	}

	public Car getCid() {
		return cid;
	}

	public void setCid(Car cid) {
		this.cid = cid;
	}

	@Override
	public String toString() {
		return "Customer [cus_id=" + cus_id + ", Cus_name=" + Cus_name + ", contact=" + contact + ", pickupDate="
				+ pickupDate + ", receivedDate=" + receivedDate + ", cid=" + cid + "]";
	}
	
	
}

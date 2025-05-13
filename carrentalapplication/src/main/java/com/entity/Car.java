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
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = ("Car_id"))
	@SequenceGenerator(name="Car_id",initialValue =100,allocationSize = 1 )
	private int id;
	private String brand;
	private String model;
	private String status;
	private double priceperday;
	private LocalDate registerDate;
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getPriceperday() {
		return priceperday;
	}
	public void setPriceperday(double priceperday) {
		this.priceperday = priceperday;
	}
	@OneToOne
	private Engine e;
	
	public Engine getE() {
		return e;
	}
	public void setE(Engine e) {
		this.e = e;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public LocalDate getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(LocalDate registerDate) {
		this.registerDate = registerDate;
	}
	@Override
	public String toString() {
		return "Car [id=" + id + ", brand=" + brand + ", model=" + model + ", status=" + status + ", priceperday="
				+ priceperday + ", registerDate=" + registerDate + ", e=" + e + "]";
	}
	
	
	
	
}

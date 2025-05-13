package com.view;


import java.time.LocalDate;
import java.util.Scanner;

import com.Dao.CarDao;
import com.Dao.CustomerDao;
import com.Dao.EngineDao;
import com.entity.Car;
import com.entity.Customer;
import com.entity.Engine;

public class CarRentalManagement {

	public static void main(String[] args) {
		System.out.println("*********Welcome To Car Rental Application**************");


		Scanner scan=new Scanner(System.in);
		System.out.println("Enter your Choice");
		System.out.println("Enter A for Managing Car Details ");
		System.out.println("Enter B for  Managing Engine Details");
		System.out.println("Enter C for  Managing Customer Details");
		
		
		char choice=scan.next().charAt(0);
		switch (choice) {
		case 'A': {


			
			System.out.println("Enter your Choice");
			System.out.println("Enter 1 for Add Car Details");
			System.out.println("Enter 2 for FindAll Car Details");
			System.out.println("Enter 3 for Delete Car Details By Id");
			System.out.println("Enter 4 for Find Car Details By Registerd Date ");
			System.out.println("Enter 5 for Update Register Date ");
			System.out.println("Enter 6 for Update Allocate Engine ");
			System.out.println("Enter 7 for Update De Allocate Engine ");
			
			int choice1=scan.nextInt();
			switch (choice1) {
			case 1: {
				
				 Car c=new Car();
				  c.setBrand("BMW");
				  c.setModel("Thar");
				  c.setPriceperday(1300);
				  c.setStatus("Available");
				  c.setRegisterDate(LocalDate.now());
				  c.setE(null);
				  
				CarDao.addCardetails(c);
				break;
			}
			case 2: {
				
				CarDao.findAllCar();
				break;
			}
			case 3: {
				
				CarDao.deleteCarById();
				break;
			}
			case 4: {
				
				CarDao.findByDate();
				break;
			}
			case 5: {
			
				CarDao.updateRegisterDate(102);
				break;
			}
			case 6: {
				
				CarDao.allocateEngine(1, 102);
				break;
			}
			case 7: {
				
				CarDao.deallocateEngine(101);
				break;
			}
			
			
			default:
				System.out.println("Invalid Choice");
			}
		
			break;
		}
		case 'B': {
			
			System.out.println("Enter your Choice");
			System.out.println("Enter 1 for Add Engine Details");
			System.out.println("Enter 2 for FindAll Engine Details");
			System.out.println("Enter 3 for Delete Engine Details By Id");
	
			
			int choice3=scan.nextInt();
			switch (choice3) {
			case 1: {
				Engine e=new Engine();
				e.setType("petrol");
				e.setCc(1400);
				
				EngineDao.addEnginedetails(e);
				break;
			}
			case 2: {
				
				EngineDao.findAllEngine();
				break;
			}
			case 3: {
				
				EngineDao.deleteEngineById(2);
				break;
			}
			
			
			default:
				System.out.println("Invalid Choice");
			}
		
			break;
		}
		case 'C': {
			
			System.out.println("Enter your Choice");
			System.out.println("Enter 1 for Add Customer Details");
			System.out.println("Enter 2 for FindAll Customer Details");
			System.out.println("Enter 3 for Delete Customer Details By Id");
			System.out.println("Enter 4 for Allocate Car for Customer");
	
			
			int choice3=scan.nextInt();
			switch (choice3) {
			case 1: {
				Customer cus=new Customer();
				cus.setCus_name("B");
				cus.setContact(9737576483L);
				cus.setPickupDate(LocalDate.now());
				cus.setReceivedDate(LocalDate.of(25, 04, 16));
				
				CustomerDao.addCustomerdetails(cus);
				break;
			}
			case 2: {
				
				CustomerDao.findAllCustomers();
				break;
			}
			case 3: {
				
				CustomerDao.deleteCustomerById();
				break;
			}
			case 4: {
				
				CustomerDao.AllocateCar(103,1);
				break;
			}
			
			
			default:
				System.out.println("Invalid Choice");
			}
		
			break;
		}
		
		default:
			System.out.println("Invalid Choice");
		}	
		
	}
}

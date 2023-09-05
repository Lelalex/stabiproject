//package Booking;
//
//
//public class Head {
//	
//	private String name;
//	private Address address;
//	private String email;
//	
//	public Head() {
//		
//	}
//	
////	public Head getHead() {
////		return this;
////	}
//	
//	public void printHead () {
//		System.out.println(this.name);
//		address.printAddress();
//		System.out.println(this.email);
//	}
//	
//	public void setHead (String name, Address address, String email) {
//		this.name = name;
//		this.address = address;
//		this.email = email;
//	}
//
//}


package Booking;

import Person.Address;

public class Head {
    
    private String name;
    private Address address;
    private String email;
    
    public Head() {
        
    }
    
    public void printHead() {
        System.out.println("Name: " + name);
        System.out.println("Address: ");
        address.printAddress();
        System.out.println("Email: " + email);
    }
    
    public void setHead(String name, Address address, String email) {
        this.name = name;
        this.address = address;
        this.email = email;
    }
    
    public String getName() {
        return name;
    }
    
    public Address getAddress() {
        return address;
    }
    
    public String getEmail() {
        return email;
    }
}


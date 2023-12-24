
	import java.util.Scanner;
	import java.util.ArrayList;
	import java.util.List;


	public class Building {
	     private String userName="admin";
	     private String password;
	     private int booking;
	     private boolean available;
	     private String flatNumber;
	    
	    
	 
	     void login(String username)
	     {
	    	 if (username.equalsIgnoreCase(userName))
	    	 {
	    		 System.out.println("Login succesfull");
	    	 }
	    	 else 
	    	 {
	    		 System.out.println("wrong email / password");
	    	 }
	     }
	     
	     Flat[] flats = new Flat[5];
	     void rent() {
	        

	         flats[0] = new Flat(1, "CAR" , 1, 430000, true);
	         flats[1] = new Flat(2, "MERCEDES", 2, 30000000, false);
	         flats[2] = new Flat(3, "ANCIENT JEWELLARY", 1, 2800000, true);
	         flats[3] = new Flat(4, "PAINTING", 5, 25000, false);
	         flats[4] = new Flat(5, "HOUSE", 1, 400000000, true);

	         // Accessing flat information
	         for (int i = 0; i < flats.length; i++) {
	             System.out.println("Item Number: " + flats[i].getitemNumber());
	             System.out.println("Item Name: " + flats[i].getitemName());
	             System.out.println("No of Items: " + flats[i].getnoOfItem());
	             System.out.println("expected Bid Price: " + flats[i].getRent());
	             System.out.println("Availability: " + (flats[i].isAvailable() ? "Available" : "Sold"));
	             System.out.println("---------------------------------------");
	         }   
	     }
	     
	     Tenant[] residents = new Tenant[5];
	     Flat[] empty = new Flat[5];
	     public void showResidents() {
	         System.out.println(" ~~~~~~~~~~~ Our Residents ~~~~~~~~~~~\n\n");
	         residents[0] = new Tenant("Ali", 30, true);
	         residents[1] = null;
	         residents[2] = new Tenant("Chacha Raheem", 45, true);
	         residents[3] = null;
	         residents[4] = new Tenant("Tution wali baaji", 35, true);

	         String[] empty = new String[flats.length];
	         int index = 0;

	         for (int i = 0; i < residents.length; i++) {
	             if (residents[i] == null) {
	                 empty[index] = "Flat " + (i + 1);
	                 index++;
	             } else {
	                 residents[i].tanentInfo();
	             }
	         }

	         if (index > 0) {
	             System.out.println("Empty Flats:");
	             for (int i = 0; i < index; i++) {
	                 System.out.println(empty[i]);
	             }
	         }
	     }
	     public void availableFlats() {

	         System.out.println("\t\t\t\n\n ((((((((((( AVAILABLE ITEMS IN AUCTION )))))))))))");
	         flats[0] = new Flat(1, "CAR" , 1, 430000, false);
	         flats[1] = new Flat(2, "MERCEDES", 1, 300000, true);
	         flats[2] = new Flat(3, "ANCIENT JEWELLARY", 1, 2800000, false);
	         flats[3] = new Flat(4, "PAINTING", 1, 25000, true);
	         flats[4] = new Flat(5, "HOUSE", 1, 400000000, false);

	         residents[0] = new Tenant("Ali", 30, true);
	         residents[1] = null;
	         residents[2] = new Tenant("Chacha Raheem", 45, true);
	         residents[3] = null;
	         residents[4] = new Tenant("Tution wali baaji", 35, true);
	         for (int i = 0; i < flats.length; i++) {
	             if(residents[i] == null) {
	                 System.out.println("Item Number: " + flats[i].getitemNumber());
	                 System.out.println("Item Name: " + flats[i].getitemName());
	                 System.out.println("No of Item: " + flats[i].getnoOfItem());
	                 System.out.println("Expected Bid Price: " + flats[i].getRent());
	                 System.out.println("Availability: " + (flats[i].isAvailable() ? "Listed in Auction" : "Sold"));
	                 System.out.println("---------------------------------------");
	             }
	         }
	     }}





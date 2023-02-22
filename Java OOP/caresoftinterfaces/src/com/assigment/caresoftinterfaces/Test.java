package com.assigment.caresoftinterfaces;

public class Test {

	// .. Main method set up ... //
	public static void main(String[] args) {
		
    Physician doctor10 = new Physician(10);
    AdminUser roseTyler = new AdminUser(2);   //, "Companion"
    AdminUser donnaNoble = new AdminUser(3); //, "Companion"
    
    
    // Physician Implementation Tests
    System.out.println("\n========== Physician Tests ==========\n");
    String pinTest1 = doctor10.assignPin(4242)? "PASS" : "FAIL";   //was 42
    System.out.printf("Physician pin assign test 1: %s\n", pinTest1);
    
    String pinTest2 = doctor10.assignPin(4000)? "PASS" : "FAIL";
    System.out.printf("Physician pin assign test 2: %s\n", pinTest2);
    
    String authTest1 = doctor10.accessAuthorized(10)? "PASS" : "FAIL";  //was 1234
    System.out.printf("Physician auth test 1: %s\n", authTest1);
    
    String authTest2 = doctor10.accessAuthorized(10)? "PASS" : "FAIL";
    System.out.printf("Physician auth test 2: %s\n", authTest2);
    
    // AdminUser Implementation Tests
    System.out.println("\n========== AdminUser Tests ==========\n");
    String pinTest3 = roseTyler.assignPin(4200)? "PASS" : "FAIL"; // was 42
    System.out.printf("Admin pin assign test 1: %s\n", pinTest3);
    
    String pinTest4 = roseTyler.assignPin(4242)? "PASS" : "FAIL";
    System.out.printf("Admin pin assign test 2: %s\n", pinTest4);
    
    String authTest3 = roseTyler.accessAuthorized(2)? "PASS" : "FAIL";  // was 1234
    System.out.printf("Admin auth test 1: %s\n", authTest3);
    
    String authTest4 = donnaNoble.accessAuthorized(3)? "PASS" : "FAIL";
    System.out.printf("Admin auth test 1: %s\n", authTest4);
    
    String authTest5 = roseTyler.accessAuthorized(2)? "PASS" : "FAIL";
    System.out.printf("Admin auth test 2: %s\n\n", authTest5);
//    
    donnaNoble.accessAuthorized(42);
    donnaNoble.accessAuthorized(4321);
    donnaNoble.accessAuthorized(7);
    donnaNoble.accessAuthorized(28);
    
    System.out.println(donnaNoble.getSecurityIncidents());
    
	
	}
	
}

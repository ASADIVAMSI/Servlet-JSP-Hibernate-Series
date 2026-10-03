package com.codegnan.app.javaapp12052026;


import java.util.List;

import com.codegnan.app.javaapp12052026.entity.Citizen;
import com.codegnan.app.javaapp12052026.entity.Passport;
import com.codegnan.app.javaapp12052026.service.passportService;

public class App {
    public static void main(String[] args) {
    		passportService passportService = new passportService();
    		
    		//INSERT
//    		Citizen citizen = new Citizen();
//    		
//    		citizen.setFirstName("Vijay");
//    		citizen.setLastName("Krishna");
//    		citizen.setDateOfBirth("2005-07-18");
//    		citizen.setGender("M");
//    		
//    		Passport passport = new Passport();
//    		
//    		passport.setNumber("C1234567");
//    		passport.setType("p");
//    		passport.setIssueDate("2026-05-13");
//    		passport.setExpityDate("2027-05-13");
//    		
//    		passport.setCitizen(citizen);
//    		citizen.setPassport(passport);
//    		
//    		boolean isNewPassportGenerated  = passportService.generateNewPassport(passport);
//    		if(isNewPassportGenerated) {
//    			System.out.println("New passport successfully generated");
//    		}else {
//    			System.out.println("Issue generating new passport.Please check the console for detail.");
//    		}
    		
    	
    		
    		    
    		
    		//UPDATE
//    		System.out.println();
//    		boolean isDateOfBirthUpdated = passportService.modifyDateOfBirth(1001, "2001-11-29");
//    		if (isDateOfBirthUpdated) {
//    			System.out.println("Date of birth successfully updated.");
//    		} else {
//    			System.out.println("Citizen not found with the given citizen id OR error updating date of birth.");
//    		}
    		
    		
    		    
    		    
    		    
    		//DELETE
//    		System.out.println();
//    		boolean isRegistrationCancelled = passportService.cancelRegistration(1001);
//    		if (isRegistrationCancelled) {
//    			System.out.println("cancelled passport Registration successfully.");
//    		} else {
//    			System.out.println("citizen not found with the given citizen id OR error cancelling registration.");
//    		}
    		
    		
    		
    		//SELECT ALL
		    List<Citizen> citizenList = passportService.getCitizens();
		    System.out.println();
		    for(Citizen citizen: citizenList ) {
		    		System.out.println(citizen);
		    }
    		
    		
    }
}
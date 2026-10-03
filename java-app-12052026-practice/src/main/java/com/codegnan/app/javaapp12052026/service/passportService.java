package com.codegnan.app.javaapp12052026.service;


import java.util.List;

import com.codegnan.app.javaapp12052026.dao.PassportDao;
import com.codegnan.app.javaapp12052026.entity.Citizen;
import com.codegnan.app.javaapp12052026.entity.Passport;

public class passportService {
	PassportDao passportDao = new PassportDao();
	
	public boolean generateNewPassport(Passport passport) {
		return passportDao.save(passport);
	}
	
	public List<Citizen> getCitizens(){
		return passportDao.findCitizens();
	}
	
	public boolean modifyDateOfBirth(int passportId, String dateOfBirth) {
		return passportDao.updateDateOfBirth(passportId, dateOfBirth);
	}
	
	public boolean cancelRegistration(int passportId) {
		return passportDao.remove(passportId);
	}
	
}
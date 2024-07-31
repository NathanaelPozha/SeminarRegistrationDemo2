package com.example.seminar_registration_demo2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.seminar_registration_demo2.model.RegistrationData;
import com.example.seminar_registration_demo2.service.SeminarRegistrationService;

@Controller
public class SeminarRegistrationController {

	private final SeminarRegistrationService seminarRegistrationService;
	
	@Autowired
	public SeminarRegistrationController(SeminarRegistrationService seminarRegistrationService) {
		this.seminarRegistrationService = seminarRegistrationService;
	}
	
	@GetMapping("/view")
	public String getAllRegistrationData(Model model){
		Iterable<RegistrationData> registrationData = seminarRegistrationService.getAllRegistrationData();
		model.addAttribute("registrationdata", registrationData);
		return "view.html";
	}
	
	@PostMapping("/save")
	public String updateRegistrationData(@ModelAttribute("registrationdata") RegistrationData r) {
		seminarRegistrationService.updateRegistrationData(
				r.getId(), 
				r.getNama(), 
				r.getNim(), 
				r.getEmail(),
				r.getNomorTelepon(),
				r.getIdLine(),
				r.getJurusan(),
				r.getFakultas(),
				r.getAngkatan(),
				r.getNomorKursi());
		return "redirect:/view";
	}
	
}

package com.example.seminar_registration_demo2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

import com.example.seminar_registration_demo2.model.RegistrationData;
import com.example.seminar_registration_demo2.registrationdatadto.RegistrationDataDTO;
import com.example.seminar_registration_demo2.service.SeminarRegistrationService;

@Controller
public class SeminarRegistrationController {

	@Autowired
	private SeminarRegistrationService seminarRegistrationService;
	
	@GetMapping("/view")
	public String viewRegistrationData(Model model) {
		return "redirect:/view/0/10";
	}
	
	@PostMapping("/save")
	public String updateRegistrationData(@ModelAttribute("registrationdata") RegistrationData r, @RequestParam("id") long id) {
		seminarRegistrationService.updateRegistrationData(
				id,
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
	
	@GetMapping("/view/findOne")
	@ResponseBody
	public RegistrationData findOne(@RequestParam("id") long id){
		return seminarRegistrationService.findOneById(id);
	}
	
	@GetMapping("/view/{offset}/{pageSize}")
	public String viewPageWithPagination(@PathVariable int offset, @PathVariable int pageSize, Model model) {
		
		if (offset < 0) {
			offset = 0;
		}
		
		Page<RegistrationDataDTO> dataWithPagination = seminarRegistrationService.findDataWithPagination(offset, pageSize);
		int totalPages = dataWithPagination.getTotalPages();
		
		if (offset >= totalPages) {
			offset = totalPages;
			dataWithPagination = seminarRegistrationService.findDataWithPagination(totalPages - 1, pageSize);
		}
		
		model.addAttribute("currentPage", offset);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("registrationdata", dataWithPagination.getContent());
		
		return "view.html";
	}
}

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

import com.example.seminar_registration_demo2.model.ParticipantData;
import com.example.seminar_registration_demo2.registrationdatadto.ParticipantDataDTO;
import com.example.seminar_registration_demo2.service.ParticipantDataService;

@Controller
public class ParticipantController {

	@Autowired
	private ParticipantDataService participantDataService;
	
	@GetMapping("/view")
	public String viewParticipantData(Model model) {
		return "redirect:/viewParticipant/0/10";
	}
	
	@PostMapping("/save")
	public String updateRegistrationData(@ModelAttribute("participantdata") ParticipantData r, @RequestParam("id") long id) {
		participantDataService.updateParticipantData(
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
	
	@GetMapping("/viewParticipant/findParticipant")
	@ResponseBody
	public ParticipantData findOneParticipant(@RequestParam("id") long id){
		return participantDataService.findOneById(id);
	}
	
	@GetMapping("/viewParticipant/{offset}/{pageSize}")
	public String viewPageWithPagination(@PathVariable int offset, @PathVariable int pageSize, Model model) {
		
		if (offset < 0) {
			offset = 0;
		}
		
		Page<ParticipantDataDTO> dataWithPagination = participantDataService.findDataWithPagination(offset, pageSize);
		int totalPages = dataWithPagination.getTotalPages();
		
		if (offset >= totalPages) {
			offset = totalPages;
			dataWithPagination = participantDataService.findDataWithPagination(totalPages - 1, pageSize);
		}
		
		model.addAttribute("currentPage", offset);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("participantdata", dataWithPagination.getContent());
		
		return "view.html";
	}
}

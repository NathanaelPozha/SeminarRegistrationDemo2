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

	private ParticipantDataService participantDataService;

	@Autowired
	public ParticipantController(ParticipantDataService participantDataService) {
		this.participantDataService = participantDataService;
	}
	
	@GetMapping("/viewParticipant")
	public String viewParticipantData(Model model) {
		return "redirect:/viewParticipant/0/10";
	}
	
	@PostMapping("/updateParticipant")
	public String updateRegistrationData(@ModelAttribute("participantdata") ParticipantData r, @RequestParam("id") long id) {
		
		ParticipantDataDTO participantDataDTO = new ParticipantDataDTO(
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
		
		participantDataService.updateParticipantData(participantDataDTO);
		return "redirect:/viewParticipant";
	}	
	
	@GetMapping("/findOneParticipant/{id}")
	@ResponseBody
	public ParticipantDataDTO findOneParticipant(@PathVariable long id){
		return participantDataService.findOneById(id);
	}
	
	@GetMapping("/viewParticipant/{offset}/{pageSize}")
	public String viewPageWithPagination(@PathVariable int offset, @PathVariable int pageSize, Model model) {
		
		Page<ParticipantDataDTO> dataWithPagination = participantDataService.findDataWithPagination(offset, pageSize);
		int totalPages = dataWithPagination.getTotalPages();
		
		model.addAttribute("currentPage", offset);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("participantdata", dataWithPagination.getContent());
		
		return "view.html";
	}
}

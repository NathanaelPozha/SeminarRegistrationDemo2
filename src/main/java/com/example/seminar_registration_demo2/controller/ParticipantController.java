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
import com.example.seminar_registration_demo2.registrationdatadto.ParticipantDataResponse;
import com.example.seminar_registration_demo2.service.ParticipantDataService;

@Controller
public class ParticipantController {

	private ParticipantDataService participantDataService;

	@Autowired
	public ParticipantController(ParticipantDataService participantDataService) {
		this.participantDataService = participantDataService;
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
	
	@GetMapping("/viewParticipant")
	public String getParticipantData(
			@RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
			@RequestParam(value = "sortField", defaultValue = "id", required = false) String sortField,
			@RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir,
			Model model){
		ParticipantDataResponse content = participantDataService.getAllParticipant(pageNo, pageSize, sortField, sortDir);
		
		model.addAttribute("participants", content.getParticipantContent());
		model.addAttribute("pageNo", content.getPageNo());
		model.addAttribute("pageSize", content.getPageSize());
		model.addAttribute("totalPage", content.getTotalPages());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" :  "asc");
		
		return "view.html";
	}
}
